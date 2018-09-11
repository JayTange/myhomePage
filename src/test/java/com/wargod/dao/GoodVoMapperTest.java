package com.wargod.dao;

import com.wargod.domain.vo.GoodVo;
import com.wargod.domain.vo.GoodVoExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodVoMapperTest {

    @Autowired
    GoodVoMapper goodVoMapper;

    @Test
    public void testInsert(){
        GoodVo goodVo = new GoodVo();
        goodVo.setGoodsName("篮球");
        goodVo.setGoodsPrice(new BigDecimal(130.5));
        goodVo.setGoodsSeckillEndtime(new Date());

        goodVoMapper.insert(goodVo);
    }

    @Test
    public void testSelect(){
        GoodVoExample example = new GoodVoExample();
        List<GoodVo> goodVoList = goodVoMapper.selectByExample(null);
        System.out.println(goodVoList);
    }

}
