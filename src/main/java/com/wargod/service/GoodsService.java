package com.wargod.service;

import com.wargod.dao.GoodVoMapper;
import com.wargod.domain.vo.GoodVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodVoMapper goodVoMapper;


    /**
     * 获取所有的商品记录
     *
     * @return
     */
    public List<GoodVo> getGoodsList() {
        // 查出所有的记录
        List<GoodVo> goodVoList = goodVoMapper.selectByExample(null);
        return goodVoList;
    }

    /**
     * 查询
     *
     * @param gid
     * @return
     */
    public GoodVo getGoodsById(Integer gid){
        GoodVo goodVo = goodVoMapper.selectByPrimaryKey(gid);
        return goodVo;
    }

}
