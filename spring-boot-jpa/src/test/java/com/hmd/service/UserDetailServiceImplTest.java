package com.hmd.service;

import com.hmd.model.UserDetail;
import com.hmd.param.UserDetailParam;
import com.hmd.repository.UserDetailRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author: <a href="mailto:nonamelnl@126.com">NoNamelnl</a>
 * @version: 1.0
 * @create: 2018/6/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailServiceImplTest {

    @Autowired
    private UserDetailService userDetailService;

    @Test
    public void findByCondition() {
        int page = 0, size =10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        UserDetailParam userDetailParam = new UserDetailParam();
        userDetailParam.setRealName("Steve%");
        userDetailParam.setMaxAge(100);

        Page<UserDetail> userDetails = userDetailService.findByCondition(userDetailParam, pageable);
        for (UserDetail userDetail : userDetails) {
            System.out.println("userDetail-->" + userDetail.toString());
        }
    }
}