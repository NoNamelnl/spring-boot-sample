package com.hmd.repository;

import com.hmd.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.*;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author: <a href="mailto:nonamelnl@126.com">NoNamelnl</a>
 * @version: 1.0
 * @create: 2018/6/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    // @Before
    public void setUp() throws Exception {

        LocalDateTime now = LocalDateTime.now();

        userRepository.save(new User("Iron Man", "111111", "tony@163.com", "Tony", now));
        userRepository.save(new User("Black Widow", "111111", "natasha@163.com", "Natasha", now));
        userRepository.save(new User("Captain America", "111111", "steve@163.com", "Steve", now));
        userRepository.save(new User("Hawkeye", "111111", "clinton@163.com", "Clinton", now));
        userRepository.save(new User("Hulk", "111111", "banner@163.com", "Banner", now));
    }

    @Test
    public void findByUserName() {

        assertEquals("Tony", userRepository.findByUserName("Iron Man").getNickName());
    }

    @Test
    public void findByUserNameStartsWith() {

        assertNotNull(userRepository.findByUserNameLike("Haw%"));

        assertTrue(userRepository.findByUserNameStartingWith("H").size() == 2);
    }
}