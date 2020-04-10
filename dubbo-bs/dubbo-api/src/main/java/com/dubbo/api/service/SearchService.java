package com.dubbo.api.service;


import com.dubbo.api.model.Search;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchService {

    public List<Search> findAll(String a, String start, String num);
    public List<Search> findById(String id,String author);
    public Boolean updateimg(Search search);
    public void insertlesson(Search search);
    public void deletelesson(String id);
    public List<Search> getHotsearch();
    public Object search1(String a,String b);
    public Object search2(String a,String b);
    public List<Search> search2(int url);
    public int selectBestId();
    public int selectBestId1();
    public Object findAll1(String start,String num);

}
