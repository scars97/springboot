package mysite.shop.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {

	private Long id;
	private String itemNum;
	private Integer price;
	private String itemDetail;
	private String itemStatus;
	private LocalDateTime regTime;
	private LocalDateTime updateTime;
}
