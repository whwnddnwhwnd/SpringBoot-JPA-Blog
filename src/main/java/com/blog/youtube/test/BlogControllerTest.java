package com.blog.youtube.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //com.cos.youtube 패키지 이하의 모든 패키지를 스캔해서 특정 어노테이션이 붙어있는 클래스파일들을 스프링 컨테이너에서 관리.
public class BlogControllerTest {
	
	@GetMapping("/test/hello")
	public String hello() {
		return "<h1>hello</h1>";
	}
}
