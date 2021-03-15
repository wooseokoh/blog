package com.wsoh.blog.test;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsoh.blog.model.RoleType;
import com.wsoh.blog.model.User;
import com.wsoh.blog.repository.UserRepository;

// html 파일이 아니라 data를 리턴해주는 controller = @RestController
@RestController 
public class DummyControllerTest {

	@Autowired // 의존성 주입
	private UserRepository userRepository;
	
	// {id} 주소로 파라미터를 전달 받을 수 있음.
	// http://localhost:8000/blog/dummy/user/3"
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
		// 람다식
//		User user = userRepository.findById(id).orElseThrow(()->{
//				return new IllegalArgumentException("해당 유저는 없습니다. id" +id);
//		});
		
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저는 없습니다. id" +id);
			}
		});
		// 요청 : 웹브라우저
		// user 객체 = 자바 오브젝트
		// 변환 ( 웹브라우저가 이해할 수 있는 데이터) -> json(Gson 라이브러리)
		// 스프링부트 = MessageConverter라는 애가 응답시 자동 작동
		// 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
		// user 오브제그를 json으로 변환해서 브라우저에 전달
		return user;
	}
	
	
	// http://localhost:8000/blog/dummy/join (요청)
	// http의 body에 username, password, email 데이터를 가지고 (요청)
	@PostMapping("/dummy/join")
	public String join(User user) {
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	}

}
