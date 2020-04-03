package com.dubbo.api.service;
import com.dubbo.api.model.Content;
import com.dubbo.api.model.Header1;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Header1Service {

    public List<Header1> findAll();
    public List<Content> findByName(String name);

}
