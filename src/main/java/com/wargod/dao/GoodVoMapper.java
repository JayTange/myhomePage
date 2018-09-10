package com.wargod.dao;

import com.wargod.domain.vo.GoodVo;
import com.wargod.domain.vo.GoodVoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface GoodVoMapper {
    long countByExample(GoodVoExample example);

    int deleteByExample(GoodVoExample example);

    int deleteByPrimaryKey(Integer gid);

    int insert(GoodVo record);

    int insertSelective(GoodVo record);

    List<GoodVo> selectByExampleWithBLOBs(GoodVoExample example);

    List<GoodVo> selectByExample(GoodVoExample example);

    GoodVo selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(@Param("record") GoodVo record, @Param("example") GoodVoExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodVo record, @Param("example") GoodVoExample example);

    int updateByExample(@Param("record") GoodVo record, @Param("example") GoodVoExample example);

    int updateByPrimaryKeySelective(GoodVo record);

    int updateByPrimaryKeyWithBLOBs(GoodVo record);

    int updateByPrimaryKey(GoodVo record);
}