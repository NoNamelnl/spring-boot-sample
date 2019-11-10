package com.hmd.repository;

import com.hmd.model.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void save(){
        List<Address> list = new ArrayList<>();
        list.add(new Address(1L, "上海市", "黄埔区", "南京东路"));
        list.add(new Address(2L, "上海市", "浦东新区", "祖冲之路"));
        addressRepository.saveAll(list);
    }

}