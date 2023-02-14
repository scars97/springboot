package mysite.shop.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mysite.shop.constant.ItemSellStatus;

@Entity
@Table(name = "item")
@Getter
@Setter
@ToString
public class Item {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private Long id; //상품 코드
	
	@Column(nullable = false, length = 50)
	private String itemNum; //상품명
	
	@Column(name = "price", nullable= false)
	private int price; //상품 가격
	
	@Column(nullable = false)
	private int stockNum; // 재고 수량
	
	@Lob @Column(nullable = false)
	private String itemDetail; // 상품 상세설명
	
	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemStatus; // 상품 판매 상태
	
	private LocalDateTime redTime; //상품 등록 시간
	private LocalDateTime updateTime; // 상품 수정 시간

}
