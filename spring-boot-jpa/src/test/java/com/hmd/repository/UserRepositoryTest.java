package com.hmd.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @author: <a href="mailto:nonamelnl@126.com">NoNamelnl</a>
 * @version: 1.0
 * @create: 2018/6/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUserName() {
        assertEquals("Tony", userRepository.findByUserName("Iron Man").getNickName());
    }

    @Test
    public void findByUserNameLike() {
        assertEquals("Tony", userRepository.findByUserNameLike("Iron%").get(0).getNickName());
    }

    @Test
    public void findByUserNameStartingWith() {
        assertEquals("Tony", userRepository.findByUserNameStartingWith("Iron").get(0).getNickName());
    }

    @Test
    @Transactional
    public void modifyById() {
        assertTrue(userRepository.modifyById("Tony Stark", 1L) > 0);
    }

    @Test
    @Transactional
    public void deleteByUserName() {
        userRepository.deleteByUserName("Black Widow");
        assertNull(userRepository.findByUserName("Black Widow"));
    }

    @Test
    public void findByEmail() {
        assertEquals("Natasha", userRepository.findByEmail("natasha@163.com").getNickName());
    }

    @Test
    public void findAllPageable() {
        assertNotNull(userRepository.findAllPageable(PageRequest.of(0, 10, new Sort(Sort.Direction.DESC, "id"))));
    }

    @Test
    public void findByNickName() {
        assertNotNull(userRepository.findByNickName("Steve",
                PageRequest.of(0, 10, new Sort(Sort.Direction.DESC, "id"))));
    }

    @Test
    public void findByNickNameAndEmail() {
        assertNotNull(userRepository.findByNickNameAndEmail("Steve", "steve@163.com",
                PageRequest.of(0, 10, new Sort(Sort.Direction.DESC, "id"))));
    }
}