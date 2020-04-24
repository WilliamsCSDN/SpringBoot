package com.dubbo.provider.mapper;


import com.dubbo.api.model.SearchContent;
import com.dubbo.api.model.SearchContent1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SearchContentMapper {
    public List<SearchContent> findAll(@Param("id") String id);
    public int insertzj(@Param("iid") String iid, @Param("zj") String zj, @Param("title") String title);
    public int insertzj1(@Param("searchcontent1") SearchContent1 searchContent1);
    public int updatezj(@Param("id") String id, @Param("title") String title);
    public int updatezj1(@Param("id") String id, @Param("title") String title, @Param("url") String url);
    public int deletezj1(@Param("id") String id);
    public int deletesearchcontent(@Param("iid") String iid, @Param("zj") String zj);
    public int updatesearchcontent(@Param("id") String id, @Param("zj") String zj);
    public int updatesearchcontent1(@Param("id") String id, @Param("zj") String zj, @Param("zjj") String zjj);

}
