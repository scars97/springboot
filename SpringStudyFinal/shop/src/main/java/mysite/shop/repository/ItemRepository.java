package mysite.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mysite.shop.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	List<Item> findByItemNum(String itemNum);

	List<Item> findByPrice(int price);

	List<Item> findByItemNumOrItemDetail(String itemNum, String itemDetail);

	List<Item> findByPriceLessThan(Integer price);

	List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);
}
