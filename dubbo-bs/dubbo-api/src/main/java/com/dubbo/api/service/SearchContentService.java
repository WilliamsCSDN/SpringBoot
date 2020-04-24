package com.dubbo.api.service;

import com.dubbo.api.model.SearchContent;
import com.dubbo.api.model.SearchContent1;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchContentService {

    public List<SearchContent> findAll(String id);
    public int insertzj(String iid,String zj,String title);
    public int insertzj1(SearchContent1 searchContent1);
    public int updatezj(String id,String title);
    public int updatezj1(String id,String title,String url);
    public int deletezj1(String id,String iid,int zj);
    public int deletesearchcontent(String iid,String zj);
    public int updatesearchcontent(String id,String zj);
    public int updatesearchcontent1(String id,String zj,String zjj);

}
