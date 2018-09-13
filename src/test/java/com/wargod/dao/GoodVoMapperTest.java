package com.wargod.dao;

import com.wargod.domain.vo.GoodsVo;
import com.wargod.domain.vo.GoodsVoExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodVoMapperTest {

    @Autowired
    GoodsVoMapper goodVoMapper;

    @Test
    public void testInsert(){
        GoodsVo goodVo = new GoodsVo();
        goodVo.setGoodsName("篮球");
        goodVo.setGoodsPrice(new BigDecimal(130.5));
        goodVo.setGoodsSeckillEndtime(new Date());

        goodVoMapper.insert(goodVo);
    }

    @Test
    public void testSelect(){
        GoodsVoExample example = new GoodsVoExample();
        List<GoodsVo> goodVoList = goodVoMapper.selectByExample(null);
        System.out.println(goodVoList);
    }

}
