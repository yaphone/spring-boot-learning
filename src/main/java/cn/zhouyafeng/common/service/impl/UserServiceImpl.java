package cn.zhouyafeng.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhouyafeng.common.mapper.UserMapper;
import cn.zhouyafeng.common.model.UserEntity;
import cn.zhouyafeng.common.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public UserEntity getUserEntityByUsername(String username) {
		return userMapper.getUserEntityByUserName(username);
	}

}
