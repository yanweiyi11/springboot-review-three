package com.springboot.service.impl;

import com.springboot.domain.SystemUser;
import com.springboot.mapper.SystemUserMapper;
import com.springboot.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public SystemUser login(SystemUser systemUser) {
        return systemUserMapper.login(systemUser);
    }
}
