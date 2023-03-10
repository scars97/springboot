package mysite.shop.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mysite.shop.dto.ItemDto;

@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafExController {

	@GetMapping(value = "/ex01")
	public String thymeleafEx01(Model model) {
		model.addAttribute("data","ooo");
		return "thymeleafEx/thymeleafEx01";
	}

	@GetMapping(value = "/ex02")
	public String thymeleafEx02(Model model) {
		ItemDto itemDto = new ItemDto();
		itemDto.setItemDetail("상세상품");
		itemDto.setItemNum("테스트 상품1");
		itemDto.setRegTime(LocalDateTime.now());
		
		model.addAttribute("itemDto",itemDto);
		return "thymeleafEx/thymeleafEx02";
	}
	
	@GetMapping(value = "/ex03")
	public String thymeleafEx03(Model model) {
		
		List<ItemDto> itemDtoList = new ArrayList<>();
		
		for(int i=1; i<=10; i++) {
			ItemDto itemDto = new ItemDto();
			itemDto.setItemDetail("상품 상세 설명" + i);
			itemDto.setItemNum("테스트 상품" + i);
			itemDto.setPrice(1000*i);
			itemDto.setRegTime(LocalDateTime.now());
			
			itemDtoList.add(itemDto);
		}
		
		model.addAttribute("itemDtoList", itemDtoList);
		return "thymeleafEx/thymeleafEx03";
	}
}
