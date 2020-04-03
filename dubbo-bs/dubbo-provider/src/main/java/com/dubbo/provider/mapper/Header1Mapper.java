package com.dubbo.provider.mapper;


import com.dubbo.api.model.Content;
import com.dubbo.api.model.Header1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Header1Mapper {
    List<Header1> findAll();
    List<Content> findByName(@Param("name") String name);
}
