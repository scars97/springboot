package mysite.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mysite.shop.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	Member findByEmail(String email); //이메일로 회원정보 찾기
}
