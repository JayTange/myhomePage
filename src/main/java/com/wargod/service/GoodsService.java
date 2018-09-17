package com.wargod.service;

import com.wargod.constant.SeckillStatEnum;
import com.wargod.constant.WebConstant;
import com.wargod.dao.GoodsVoMapper;
import com.wargod.dao.OrderInfoVoMapper;
import com.wargod.domain.dto.Exposer;
import com.wargod.domain.dto.SeckillExcution;
import com.wargod.domain.vo.GoodsVo;
import com.wargod.domain.vo.OrderInfoVo;
import com.wargod.domain.vo.OrderInfoVoExample;
import com.wargod.exception.RepeatKillException;
import com.wargod.exception.SeckillCloseException;
import com.wargod.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class GoodsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    GoodsVoMapper goodsVoMapper;

    @Autowired
    OrderInfoVoMapper orderInfoVoMapper;


    /**
     * 获取所有的商品记录
     *
     * @return
     */
    public List<GoodsVo> getGoodsList() {
        // 查出所有的记录
        List<GoodsVo> goodVoList = goodsVoMapper.selectByExample(null);
        return goodVoList;
    }

    /**
     * 查询
     *
     * @param gid
     * @return
     */
    public GoodsVo getGoodsById(Integer gid) {
        GoodsVo goodVo = goodsVoMapper.selectByPrimaryKey(gid);
        return goodVo;
    }

    /**
     * 暴露秒杀地址
     *
     * @param goodsId
     * @return
     */
    public Exposer exportSeckillUrl(int goodsId) {
        GoodsVo goodsVo = goodsVoMapper.selectByPrimaryKey(goodsId);
        Date startTime = goodsVo.getGoodsSeckillBegintime();
        Date endTime = goodsVo.getGoodsSeckillEndtime();

        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, goodsId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }

        String digestStr = digestAct(goodsId);
        return new Exposer(true, digestStr, goodsId);
    }

    /**
     * 执行秒杀
     *
     * 使用事务
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     * @throws SeckillException
     */
    @Transactional
    public SeckillExcution executeSeckill(int seckillId, long userPhone, String md5) throws SeckillException {
        // 防止重复秒杀
        String orderNum = WebConstant.DIGEST_SALT + userPhone;
        if (md5 == null || !md5.equals(digestAct(seckillId))) {
            throw new SeckillException("秒杀数据出错");
        }
        Date nowTime = new Date();
        try {

            int updateCount = goodsVoMapper.reduceNumber(seckillId, nowTime);
            if (updateCount < 0) {
                throw new SeckillCloseException("秒杀结束");

            } else {
                OrderInfoVo orderInfoVo = new OrderInfoVo();
                orderInfoVo.setOrderNum(orderNum);
                OrderInfoVoExample orderInfoVoExample = new OrderInfoVoExample();
                orderInfoVoExample.createCriteria().andOrderNumEqualTo(orderNum);
                long count = orderInfoVoMapper.countByExample(orderInfoVoExample);
                if (count > 0) {
                    throw new RepeatKillException("重复秒杀");
                } else {
                    orderInfoVo.setGoodsId(seckillId);
                    orderInfoVo.setGoodsCount(1);
                    orderInfoVoMapper.insert(orderInfoVo);
                    return new SeckillExcution(seckillId, SeckillStatEnum.SUCCESS, orderInfoVo);
                }
            }

        } catch (SeckillCloseException e1) {
            throw e1;
        } catch (RepeatKillException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error("系统内部错误" + e.getMessage());
            throw new SeckillException("sec" + e.getMessage());
        }
    }

    /**
     * 对ID进行摘要
     *
     * @param seckillId
     * @return
     */
    private String digestAct(int seckillId) {
        String toDigest = seckillId + "/" + WebConstant.DIGEST_SALT;
        String digestStr = DigestUtils.md5DigestAsHex(toDigest.getBytes());
        return digestStr;
    }


}
