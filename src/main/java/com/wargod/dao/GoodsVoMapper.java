package com.wargod.dao;

import com.wargod.domain.vo.GoodsVo;
import com.wargod.domain.vo.GoodsVoExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface GoodsVoMapper {
    long countByExample(GoodsVoExample example);

    int deleteByExample(GoodsVoExample example);

    int deleteByPrimaryKey(Integer gid);

    int insert(GoodsVo record);

    int insertSelective(GoodsVo record);

    List<GoodsVo> selectByExampleWithBLOBs(GoodsVoExample example);

    List<GoodsVo> selectByExample(GoodsVoExample example);

    GoodsVo selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(@Param("record") GoodsVo record, @Param("example") GoodsVoExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsVo record, @Param("example") GoodsVoExample example);

    int updateByExample(@Param("record") GoodsVo record, @Param("example") GoodsVoExample example);

    int updateByPrimaryKeySelective(GoodsVo record);

    int updateByPrimaryKeyWithBLOBs(GoodsVo record);

    int updateByPrimaryKey(GoodsVo record);
}