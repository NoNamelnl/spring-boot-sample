package com.hmd.repository;

import com.hmd.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: <a href="mailto:nonamelnl@126.com">NoNamelnl</a>
 * @version: 1.0
 * @create: 2018/6/24
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    List<User> findByUserNameLike(String userNameLike);

    List<User> findByUserNameStartingWith(String userNameStart);

    @Transactional(timeout = 6)
    @Modifying
    @Query("update User set userName = ?1 where id = ?2")
    int modifyById(String userName, Long id);

    @Transactional
    @Modifying
    @Query("delete from User where userName = ?1")
    void deleteByUserName(String userName);

    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);

    @Query("select u.id, u.userName, u.nickName, u.email, u.regTime from User u")
    Page<User> findAllPageable(Pageable pageable);

    Page<User> findByNickName(String nickName, Pageable pageable);

    Slice<User> findByNickNameAndEmail(String nickName, String email, Pageable pageable);
}
