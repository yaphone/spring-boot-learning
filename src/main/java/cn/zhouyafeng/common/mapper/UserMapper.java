package cn.zhouyafeng.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.zhouyafeng.common.model.UserEntity;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM USER WHERE username = #{userName}")
	@Results({ @Result(property = "username", column = "usernname", javaType = String.class),
			@Result(property = "password", column = "password") })
	public UserEntity getUserEntityByUserName(String userName);

}
