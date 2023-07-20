package com.mylb.spring.ex.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mylb.spring.ex.jsp.domain.User;

public interface NewUserRepository {

	public List<User> selectUserList();
	
	public int insertUser(
			@Param("name") String name
			, @Param("birthday") String birthday
			, @Param("email") String email
			, @Param("introduce") String introduce);
	
	// 전달된 email이 몇개인지 조회
	public int selectCountEmail(@Param("email") String email);
	
}
