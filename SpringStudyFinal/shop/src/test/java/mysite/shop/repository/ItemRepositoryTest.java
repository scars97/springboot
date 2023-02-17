package mysite.shop.repository;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import mysite.shop.constant.ItemSellStatus;
import mysite.shop.entity.Item;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@Transactional //DB에 반영안됨
@Rollback(false) //반영됐는지 확인이 필요할때.
class ItemRepositoryTest {

	@Autowired 
	ItemRepository itemRepository;
	
	@Test
	@DisplayName("상품 전체 저장")
	public void createItemList() {
		for (int i = 1; i <= 10; i++) {
		Item item = new Item();
		item.setItemNum("테스트 상품" + i);
		item.setPrice(10000);
		item.setItemDetail("테스트 상품 상세 설명" + i);
		item.setItemStatus(ItemSellStatus.SELL);
		item.setStockNum(100);
		item.setRegTime(LocalDateTime.now());
		item.setUpdateTime(LocalDateTime.now());
		itemRepository.save(item);
	
		}
	}
	
	@Test
	@DisplayName("상품조회")
	public void findByItemNumTest() {
		List<Item> itemList = itemRepository.findByItemNum("테스트 상품10");
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
	@Test
	@DisplayName("상품 한개 저장")
	public void createItemTest() {
		//given
		Item item = new Item();
		item.setItemNum("테스트 상품");
		item.setPrice(10000);
		item.setItemDetail("테스트 상품 상세 설명");
		item.setItemStatus(ItemSellStatus.SELL);
		item.setStockNum(100);
		item.setRegTime(LocalDateTime.now());
		item.setUpdateTime(LocalDateTime.now());
		
		//when
		Item savedItem = itemRepository.save(item);
		//then
		System.out.println(savedItem.toString());
	}
	
	@Test
	public void 상품_가격_조회() {
		List<Item> itemList = itemRepository.findByPrice(10000);
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
	@Test
	public void 상품명_상품상세설명() {
		List<Item> itemList = 
					itemRepository.findByItemNumOrItemDetail("테스트 상품1", "테스트 상품 상세 설명5");
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
}
