package com.wargod.service;

import com.wargod.dao.GoodsVoMapper;
import com.wargod.domain.dto.Exposer;
import com.wargod.domain.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsVoMapper goodVoMapper;

    /**
     * 获取所有的商品记录
     *
     * @return
     */
    public List<GoodsVo> getGoodsList() {
        // 查出所有的记录
        List<GoodsVo> goodVoList = goodVoMapper.selectByExample(null);
        return goodVoList;
    }

    /**
     * 查询
     *
     * @param gid
     * @return
     */
    public GoodsVo getGoodsById(Integer gid){
        GoodsVo goodVo = goodVoMapper.selectByPrimaryKey(gid);
        return goodVo;
    }

    public Exposer exportSeckillUrl(int seckillId){
        GoodsVo

    }

}
