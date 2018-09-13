package com.wargod.service;

import com.wargod.constant.WebConstant;
import com.wargod.dao.GoodsVoMapper;
import com.wargod.domain.dto.Exposer;
import com.wargod.domain.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsVoMapper goodsVoMapper;

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
