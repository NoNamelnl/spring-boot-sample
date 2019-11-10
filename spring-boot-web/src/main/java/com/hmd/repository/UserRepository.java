package com.hmd.repository;

import com.hmd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: <a href="mailto:nonamelnl@126.com">NoNamelnl</a>
 * @version: 1.0
 * @create: 2018/6/20
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    List<User> findByUserNameLike(String userNameLike);

    List<User> findByUserNameStartingWith(String userNameStart);
}
