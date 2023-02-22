package mysite.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mysite.shop.constant.Role;
import mysite.shop.dto.MemberFormDto;

@Entity
@Getter
@Setter
@Table(name = "member")
@ToString
public class Member {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "member_id")
	private Long id;
	
	private String name;
	
	@Column(unique = true)//중복안되게 고유값으로.
	private String email;
	
	private String password;
	
	private String address;
	
	@Enumerated(EnumType.STRING)//Enum클래스의 데이터가 '문자열'로 들어감.
	private Role role;
	
	public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		
		Member member = new Member();
		member.setName(memberFormDto.getName());
		member.setEmail(memberFormDto.getEmail());
		member.setAddress(memberFormDto.getAddress());
		
		//비밀번호 암호화 필요 passwordEncoder에 패스워드값을 인자로 줌
		String password = passwordEncoder.encode(memberFormDto.getPassword());
		member.setPassword(password);
		
//		member.setRole(Role.USER);
		member.setRole(Role.ADMIN);
		return member;
	}
}
