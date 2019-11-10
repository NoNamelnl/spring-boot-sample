package com.hmd.service;

import com.hmd.param.UserDetailParam;
import com.hmd.model.UserDetail;
import com.hmd.repository.UserDetailRepository;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: <a href="mailto:nonamelnl@126.com">NoNamelnl</a>
 * @version: 1.0
 * @create: 2018/6/24
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public Page<UserDetail> findByCondition(UserDetailParam userDetailParam, Pageable pageable) {

        return userDetailRepository.findAll((root, query, cb) -> {
            List<Predicate> predicateList = new ArrayList<>();
            // equal
            if (!StringUtils.isNullOrEmpty(userDetailParam.getCity())) {
                predicateList.add(cb.equal(root.get("introduction"), userDetailParam.getCity()));
            }
            // like
            if (!StringUtils.isNullOrEmpty(userDetailParam.getRealName())) {
                predicateList.add(cb.like(root.get("realName"), userDetailParam.getRealName()));
            }
            // between
            if (userDetailParam.getMaxAge() != null && userDetailParam.getMinAge() != null) {
                predicateList.add(cb.between(root.get("age"), userDetailParam.getMinAge(), userDetailParam.getMaxAge()));
            }
            // greaterThan
            if (userDetailParam.getMinAge() != null) {
                predicateList.add(cb.ge(root.get("age"), userDetailParam.getMinAge()));
            }
            // lessThan
            if (userDetailParam.getMinAge() != null) {
                predicateList.add(cb.le(root.get("age"), userDetailParam.getMinAge()));
            }
            return query.where(predicateList.toArray(new Predicate[predicateList.size()])).getRestriction();
        }, pageable);
    }
}
