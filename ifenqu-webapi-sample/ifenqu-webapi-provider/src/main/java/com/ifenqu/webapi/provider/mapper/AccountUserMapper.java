package com.ifenqu.webapi.provider.mapper;

import com.ifenqu.webapi.provider.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountUserMapper {
    User get(int id);
}
