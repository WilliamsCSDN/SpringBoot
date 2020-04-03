package com.dubbo.api.service;

import com.dubbo.api.model.SearchContent;
import com.dubbo.api.model.SearchContent1;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchContentService {

    public List<SearchContent> findAll(String id);
    public void insertzj(String iid,String zj,String title);
    public void insertzj1(SearchContent1 searchContent1);
    public void updatezj(String id,String title);
    public void updatezj1(String id,String title,String url);
    public void deletezj1(String id,String iid,int zj);
    public void deletesearchcontent(String iid,String zj);
    public void updatesearchcontent(String id,String zj);
    public void updatesearchcontent1(String id,String zj,String zjj);

}
