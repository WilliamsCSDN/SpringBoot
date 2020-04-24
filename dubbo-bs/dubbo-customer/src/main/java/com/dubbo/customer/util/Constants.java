package com.dubbo.customer.util;

import com.dubbo.api.model.User;
import com.dubbo.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Constants {

    public static final String SESSION_SECURITY_CODE = "sessionSecCode";
    public static String SESSION_USER = "sessionUser";

    public static final String TRAJECTORY_PREFIX="trajectory_prefix_";

    public static final int ACCESS_RECORD_COUNT=5;



}
