package com.wsoh.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TempControllerTest {
	
	// http://localhost:8000/blog/test/home
	@GetMapping("/test/home")
	public String tempHome() {
		System.out.println("찾지못함");
		// 파일리턴 기본경로 : src/main/resources/static
		// 리턴명 : /home.html
		// 풀경로 : src/main/resources/static/home.html
		return "/home.html";
	}
	
	@GetMapping("/temp/img")
	public String tempImg() {
		return "/img1.jpg";
	}
	
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		return "/test";
	}
}
