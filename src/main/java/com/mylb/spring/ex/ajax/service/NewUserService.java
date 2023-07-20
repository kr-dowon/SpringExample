package com.mylb.spring.ex.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mylb.spring.ex.ajax.repository.NewUserRepository;
import com.mylb.spring.ex.jsp.domain.User;

@Service
public class NewUserService {
	
	@Autowired
	private NewUserRepository userRepository;
	
	public List<User> getUserList() {
		List<User> userList = userRepository.selectUserList();
		
		return userList;
	}
	
	public int addUser(
			String name
			, String birthday
			, String email
			, String introduce) {
		
		int count = userRepository.insertUser(name, birthday, email, introduce);
		
		return count;
	}
	
	// 전달된 email이 이미 있는지 확인하는 메소드
	public boolean isDuplicateEmail(String email) {
		
		int count = userRepository.selectCountEmail(email);
		
		if(count == 0) {
			// 중복 안됨
			return false;
		} else {
			return true;
		}
	}

}
