package mysite.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mysite.sbb.UserDTO;

@RestController //controller와 responsebody가 결합
//@Controller
public class MainController {
	
	@GetMapping("/sbb")
	@ResponseBody //이거 생략하면 값을 템플릿파일에서 찾게 됨.
	public String index() {
		return "안녕 sbb에 온 걸 환영해.";
	}
	
	@GetMapping("/userdto")
//	@ResponseBody //RestController가 없다면 꼭 필요
	public UserDTO ud() {
		UserDTO userDto = new UserDTO();
		userDto.setAge(20);
		userDto.setName("홍길동");
		return userDto; //객체의 필드를 전부 json으로 화면에 출력
	}
}
