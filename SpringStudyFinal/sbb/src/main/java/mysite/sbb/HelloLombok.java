package mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor //final만 적용, 값 변경되지 못하게 함
@Getter
//@Setter
public class HelloLombok {

	private final String name;
	private final String nickname;
	
//	생성자를 만들었다면 RequiredArgsConstructor과 Setter는 필요없음
//	public HelloLombok(String name, String nickname) {
//		this.name = name;
//		this.nickname= nickname;
//	}
	
	public static void main(String[] args) {
		
		HelloLombok hello = new HelloLombok("sss","qqq");

		System.out.println(hello.getName());
		System.out.println(hello.getNickname());
	}

}
