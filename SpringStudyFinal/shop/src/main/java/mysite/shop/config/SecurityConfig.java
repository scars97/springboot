package mysite.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import mysite.shop.service.MemberService;

@Configuration //외부 라이브러리를 빈으로 등록할 때 사용.
				//component 하위 어노테이션으로 클래스를 자동으로 찾아서 빈에 등록.
@EnableWebSecurity //웹보안 활성화를 위한 어노테이션
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	MemberService memberService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage("/members/login")//로그인 페이지를 url로 설정한 것
			.defaultSuccessUrl("/")//로그인 페이지 연결이 됐을때 이동할 url
			.usernameParameter("email")//로그인 시 사용할 email을 지정.
			.failureUrl("/members/login/error")//로그인 실패시 이동할 url
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))//로그아웃 url을 설정할 것임.
			.logoutSuccessUrl("/");//로그아웃 성공 시 이동할 url
		
		http.authorizeRequests()
			.mvcMatchers("/","/members/**",
						"/item/**","/images/**").permitAll()//권한 필요없음
			.mvcMatchers("/admin/**").hasRole("ADMIN")//admin 권한을 가진 사람만 들어갈 수 있음
			.anyRequest().authenticated();//그 외 나머지는 권한 필요
		
		http.exceptionHandling() //권한 없는 사람이 접근하려할때 수행되는 로직. 예외터지게.
			.authenticationEntryPoint(new CustomAuthenticationEntryPoint());
	}
	
	//스프링 시큐리티 인증메소드(권한 부여)
	//userdetailservice를 구현하고 있는 객체로 memberservice를 지정해 주며 비밀번호 암호화를 위해 
	//passwordencoder를 지정해 줌
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(memberService)
			.passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		//비밀번호 암호화 기법
		return new BCryptPasswordEncoder();
	}
	
	

}
