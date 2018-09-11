package com.wargod.dao;

import com.wargod.domain.vo.OrderInfoVo;
import com.wargod.domain.vo.OrderInfoVoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface OrderInfoVoMapper {
    long countByExample(OrderInfoVoExample example);

    int deleteByExample(OrderInfoVoExample example);

    int deleteByPrimaryKey(Integer oid);

    int insert(OrderInfoVo record);

    int insertSelective(OrderInfoVo record);

    List<OrderInfoVo> selectByExample(OrderInfoVoExample example);

    OrderInfoVo selectByPrimaryKey(Integer oid);

    int updateByExampleSelective(@Param("record") OrderInfoVo record, @Param("example") OrderInfoVoExample example);

    int updateByExample(@Param("record") OrderInfoVo record, @Param("example") OrderInfoVoExample example);

    int updateByPrimaryKeySelective(OrderInfoVo record);

    int updateByPrimaryKey(OrderInfoVo record);
}