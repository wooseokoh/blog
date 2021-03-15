package com.wsoh.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsoh.blog.model.RoleType;
import com.wsoh.blog.model.User;
import com.wsoh.blog.repository.UserRepository;


@RestController
public class DummyControllerTest {

	@Autowired // 의존성 주입
	private UserRepository userRepository;
	// http://localhost:8000/blog/dummy/join (요청)
	// http의 body에 username, password, email 데이터를 가지고 (요청)
	@PostMapping("/dummy/join")
	public String join(User user) {
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	}

}
