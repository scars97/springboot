package mysite.shop.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {

	@Autowired MockMvc mockMvc;
	
	@Test
	@WithMockUser(username = "admin", roles = "ADMIN")
	public void 상품등록권한테스트() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/item/new"))
				.andDo(print())
				.andExpect(status().isOk());
	}
}
