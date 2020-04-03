package com.dubbo.provider.mapper;


import com.dubbo.api.model.LearnContent;
import com.dubbo.api.model.LearnRouter1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LearnContentMapper {
    public List<LearnContent> selectAll(@Param("id") String id, @Param("start") String start, @Param("num") String num);
    public List<LearnContent> selectHot(@Param("id") String id);
    public List<LearnRouter1> getrouterbyid(@Param("id") String id);
    public List<LearnContent> getlearncontent(@Param("id") String id, @Param("author") String author);
    public void deletelearncontent(@Param("id") String id);
    public void insertlearncontent(@Param("lc") LearnContent learnContent);
    public void updatelearncontent(@Param("lc") LearnContent learnContent);

    public void insertlearnrouter(@Param("lr") LearnRouter1 learnRouter1);
    public void deletelearnrouter(@Param("id") String id);
    public void updatelearnrouter(@Param("lr") LearnRouter1 learnRouter1);
    public void updatelearnrouter1(@Param("lr") LearnRouter1 learnRouter1);
}
