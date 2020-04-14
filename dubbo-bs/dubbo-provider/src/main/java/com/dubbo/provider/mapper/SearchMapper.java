package com.dubbo.provider.mapper;


import com.dubbo.api.model.Search;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SearchMapper {
    public List<Search> findAll(@Param("a") String a, @Param("start") String start, @Param("num") String num);
    public List<Search> findById(@Param("id") String id, @Param("author") String author);
    public int updateimg(@Param("search") Search search);
    public int insertlesson(@Param("search") Search search);
    public int deletelesson(@Param("id") String id);
    public List<Search> getHotsearch();
    public List<Search> search2(@Param("url") int url);
    public int selectBestId();
    public int selectBestId1();
    public List<Search> findAll1(@Param("start") String start,@Param("num") String num);

}
