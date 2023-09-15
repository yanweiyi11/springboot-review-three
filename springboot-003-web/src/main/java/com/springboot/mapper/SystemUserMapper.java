package com.springboot.mapper;

import com.springboot.domain.SystemUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemUserMapper {
    SystemUser login(SystemUser systemUser);
}
