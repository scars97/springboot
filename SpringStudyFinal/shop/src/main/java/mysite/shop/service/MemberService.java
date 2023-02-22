package mysite.shop.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import mysite.shop.entity.Member;
import mysite.shop.repository.MemberRepository;

@Service //빈에 자동으로 등록 component 하위 어노테이션
@Transactional //오류발생하면 로직 수행하기 이전 상태로 돌림.
@RequiredArgsConstructor //final,NonNull이 붙은 필드의 생성자를 자동으로 생성
public class MemberService implements UserDetailsService{

	//@Autowired//객체가 하나일때는 Autowired 안해줘도 됨.
	private final MemberRepository memberRepository;
	
	public Member saveMember(Member member) {
		validateDuplicationMember(member); //중복회원 검사
		return memberRepository.save(member);
	}
	
	private void validateDuplicationMember(Member member) {
		Member findMember = memberRepository.findByEmail(member.getEmail());
		if(findMember != null) {//중복되는 값이 있다면 
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		Member member = memberRepository.findByEmail(email);
		//이메일 조회해서 데이터가 없을때 예외 발생시킴
		if(member == null) {
			throw new UsernameNotFoundException(email);
		}
		//데이터가 있을때 실행되는 로직
		return User.builder()
					.username(member.getEmail())
					.password(member.getPassword())
					.roles(member.getRole().toString())
					.build();
	}
}
