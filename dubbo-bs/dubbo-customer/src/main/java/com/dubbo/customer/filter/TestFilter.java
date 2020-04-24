package com.dubbo.customer.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.rpc.*;
import org.springframework.stereotype.Component;


import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.Logger;

//@Component
//@WebFilter(urlPatterns = "/*",filterName = "TestFilter")
@Activate( group = Constants.PROVIDER , order = 20000)
public class TestFilter implements Filter {


//        long start = System.currentTimeMillis();
//        System.out.println("filter1");
//        chain.doFilter(req, resp);
//        System.out.println("Execute cost="+(System.currentTimeMillis()-start));




    /* (non-Javadoc)
     * @see com.alibaba.dubbo.rpc.Filter#invoke(com.alibaba.dubbo.rpc.Invoker, com.alibaba.dubbo.rpc.Invocation)
     */
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("filter1111");
        return  invoker.invoke(invocation);
    }

}