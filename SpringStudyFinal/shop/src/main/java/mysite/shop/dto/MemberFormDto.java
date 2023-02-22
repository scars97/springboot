package mysite.shop.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto {//회원가입

	@NotBlank(message = "이름은 필수 입력값입니다.")
	private String name;
	
	@NotEmpty(message = "이메일 필수 입력값입니다.")
	@Email(message = "이메일 형식으로 입력해 주세요.")
	private String email;
	
	@NotEmpty(message = "비밀번호는 필수 입력값입니다.")
	@Length(min=2,max=8, message="비밀호는 2자 이상, 8자 이하로 해주세요.")
	private String password;
	
	@NotEmpty(message="주소는 필수 입력값입니다.")
	private String address;
}
