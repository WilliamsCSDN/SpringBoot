package com.dubbo.provider.service;


import com.dubbo.api.model.SearchContent;
import com.dubbo.api.model.SearchContent1;
import com.dubbo.api.service.CommentService;
import com.dubbo.api.service.SearchContentService;
import com.dubbo.provider.mapper.SearchContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SearchContentServiceImpl implements SearchContentService {
    @Resource
    SearchContentMapper searchContentMapper;
    public List<SearchContent> findAll(String id){
        return searchContentMapper.findAll(id);
    }
    public void insertzj(String iid,String zj,String title){
        if(iid  != null && zj != null && title != null)
            searchContentMapper.insertzj(iid,zj,title);
    }
    public void insertzj1(SearchContent1 searchContent1){
        if(searchContent1 != null)
           searchContentMapper.insertzj1(searchContent1);
    }
    public void updatezj(String id,String title){
        if(id != null && title != null)
           searchContentMapper.updatezj(id,title);
    }
    public void updatezj1(String id,String title,String url){
        if(id != null && title != null && url != null)
           searchContentMapper.updatezj1(id,title,url);
    }

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public void deletezj1(String id,String iid,int zj){
        if(id != null && iid != null && (Integer)zj !=null) {
            searchContentMapper.deletezj1(id);
            for (SearchContent a : findAll(iid)) {
                if ((a.zj == zj) && (a.searchContent1.size() == 0)) {
                    deletesearchcontent(iid, String.valueOf(zj));
                    int i = 0;
                    for (SearchContent c : findAll(iid)) {
                        updatesearchcontent(String.valueOf(c.id), String.valueOf(i + 1));
                        int j = 0;
                        for (SearchContent1 d : c.searchContent1) {
                            updatesearchcontent1(String.valueOf(d.id), String.valueOf(i + 1), String.valueOf(i + 1) + "-" + (j + 1));
                            j++;
                        }
                        i++;
                    }
                }
            }
        }
    }
    public void deletesearchcontent(String iid,String zj){
        if(iid != null && zj != null)
           searchContentMapper.deletesearchcontent(iid,zj);
    }
    public void updatesearchcontent(String id,String zj){
        if(id != null && zj != null)
           searchContentMapper.updatesearchcontent(id,zj);
    }
    public void updatesearchcontent1(String id,String zj,String zjj){
        if(id != null && zj != null && zjj != null)
           searchContentMapper.updatesearchcontent1(id,zj,zjj);
    }

}
