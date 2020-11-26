package com.dyf.myblog.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.dyf.myblog.entity.UserInfo;

@Mapper
public interface UserInfoDao {
	 @Select("SELECT * FROM USER_INFO WHERE username = #{username}")
	    UserInfo getUsername(String username);
}
