package mysite.shop.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import mysite.shop.dto.MemberFormDto;
import mysite.shop.entity.Member;
import mysite.shop.service.MemberService;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class MemberControllerTest {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
//	public Member createMember() {
//		MemberFormDto memberFormDto = new MemberFormDto();
//		memberFormDto.setEmail("test2@email.com");
//		memberFormDto.setName("홍길동");
//		memberFormDto.setAddress("서울시");
//		memberFormDto.setPassword("1234");
//		Member member = Member.createMember(memberFormDto, passwordEncoder);
//		return memberService.saveMember(member);
//	}
	
	@Test
	public void 로그인_성공_테스트() throws Exception{

		String email = "qktjd97@naver.com";
		String password = "12345";
		
		mockMvc.perform(formLogin().userParameter("email")
				.loginProcessingUrl("/members/login")
		        .user(email).password(password))
		        .andExpect(SecurityMockMvcResultMatchers.authenticated());
		
	
	}
	
}
