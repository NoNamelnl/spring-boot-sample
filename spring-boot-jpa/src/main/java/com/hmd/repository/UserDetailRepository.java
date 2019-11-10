package com.hmd.repository;

import com.hmd.model.UserDetail;
import com.hmd.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author: <a href="mailto:nonamelnl@126.com">NoNamelnl</a>
 * @version: 1.0
 * @create: 2018/6/24
 */
public interface UserDetailRepository extends JpaSpecificationExecutor<UserDetail>, JpaRepository<UserDetail, Long> {

    UserDetail findByHobby(String hobby);

    @Query("select u.userName as userName, u.email as email, ud.hobby as hobby, ud.introduction as introduction " +
            "from User u, UserDetail ud where u.id = ud.userId and ud.hobby = ?1")
    List<UserInfo> findUserInfo(String hobby);
}
