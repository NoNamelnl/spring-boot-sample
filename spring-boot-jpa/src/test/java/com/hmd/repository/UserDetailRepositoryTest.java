package com.hmd.repository;

import com.hmd.model.UserDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: <a href="mailto:nonamelnl@126.com">NoNamelnl</a>
 * @version: 1.0
 * @create: 2018/6/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailRepositoryTest {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Test
    @Transactional
    public void save() {
        List<UserDetail> list = new ArrayList<>();
        list.add(new UserDetail(1L, 33, "Tony Stark", "", "Research", "Iron Man", null));
        list.add(new UserDetail(3L, 100, "Steve Rogers", "", "Fitness", "Captain America", null));
        userDetailRepository.saveAll(list);
    }

    @Test
    public void findByHobby() {
        assertEquals("Tony Stark", userDetailRepository.findByHobby("Research").getRealName());
    }

    @Test
    public void findUserInfo() {
        assertEquals("Captain America", userDetailRepository.findUserInfo("Fitness").get(0).getUserName());
    }
}