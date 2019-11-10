package com.hmd.service;

import com.hmd.param.UserDetailParam;
import com.hmd.model.UserDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author: <a href="mailto:nonamelnl@126.com">NoNamelnl</a>
 * @version: 1.0
 * @create: 2018/6/24
 */
public interface UserDetailService {

    Page<UserDetail> findByCondition(UserDetailParam userDetailParam, Pageable pageable);
}
