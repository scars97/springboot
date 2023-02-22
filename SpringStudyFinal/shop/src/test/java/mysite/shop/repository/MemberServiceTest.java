package mysite.shop.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import mysite.shop.dto.MemberFormDto;
import mysite.shop.entity.Member;
import mysite.shop.service.MemberService;

@SpringBootTest
@Transactional
@TestPropertySource(locations="classpath:application.properties")
public class MemberServiceTest {

	@Autowired
	MemberService memberService;
	
	@Autowired//등록된 Bean객체 가져오기
	PasswordEncoder passwordEncoder;
	
	//샘플데이터 입력
	public Member createMember() {
		MemberFormDto memberFormDto = new MemberFormDto();
		memberFormDto.setEmail("test@email.com");
		memberFormDto.setName("홍길동");
		memberFormDto.setAddress("서울시 마포구 합정동");
		memberFormDto.setPassword("1234");
		return Member.createMember(memberFormDto, passwordEncoder);
	}
	
//	@Test
//	public void 회원가입테스트() {
		//given
//		Member member = createMember();//테스트용 데이터
	
		//when
//		Member saveMember = memberService.saveMember(member);//실제 입력될 데이터
		
		//then
//		assertEquals(member.getEmail(), saveMember.getEmail());
//		assertEquals(member.getName(), saveMember.getName());
//		assertEquals(member.getAddress(), saveMember.getAddress());
//		assertEquals(member.getPassword(), saveMember.getPassword());
//		assertEquals(member.getRole(), saveMember.getRole());
//	}
	
	@Test
	public void 중복_회원_테스트() {
		//given
		Member member1 = createMember();
		Member member2 = createMember();
		
		//when
		memberService.saveMember(member1);
//		Throwable e = assertThrows(IllegalStateException.class, () ->{
//			memberService.saveMember(member2);});		
		try {
			memberService.saveMember(member2);
		}catch(IllegalStateException e) {
			assertEquals("이미 가입된 회원입니다.",e.getMessage());
		}
		
		//then
//		assertEquals("이미 가입된 회원입니다.",e.getMessage());
	}
}
