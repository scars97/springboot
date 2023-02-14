package mysite.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mysite.shop.Member;

@RestController
public class ShopController {

	@GetMapping("/shop")
	@ResponseBody
	public String Shop() {
		return "Hello! SHOP!!!";
	}
	
	@GetMapping("/member")
	public Member memberInfo() {
		Member member = new Member();
		member.setAge(27);
		member.setName("박성현");
		member.setPhone("010-2186-9698");
		
		return member;
	}
}
