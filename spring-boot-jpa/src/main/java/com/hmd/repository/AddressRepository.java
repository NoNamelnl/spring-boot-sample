package com.hmd.repository;

import com.hmd.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: <a href="mailto:nonamelnl@126.com">NoNamelnl</a>
 * @version: 1.0
 * @create: 2018/6/24
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}
