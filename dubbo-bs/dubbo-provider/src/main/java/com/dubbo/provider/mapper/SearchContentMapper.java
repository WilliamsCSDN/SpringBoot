package com.dubbo.provider.mapper;


import com.dubbo.api.model.SearchContent;
import com.dubbo.api.model.SearchContent1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SearchContentMapper {
    public List<SearchContent> findAll(@Param("id") String id);
    public void insertzj(@Param("iid") String iid, @Param("zj") String zj, @Param("title") String title);
    public void insertzj1(@Param("searchcontent1") SearchContent1 searchContent1);
    public void updatezj(@Param("id") String id, @Param("title") String title);
    public void updatezj1(@Param("id") String id, @Param("title") String title, @Param("url") String url);
    public void deletezj1(@Param("id") String id);
    public void deletesearchcontent(@Param("iid") String iid, @Param("zj") String zj);
    public void updatesearchcontent(@Param("id") String id, @Param("zj") String zj);
    public void updatesearchcontent1(@Param("id") String id, @Param("zj") String zj, @Param("zjj") String zjj);

}
