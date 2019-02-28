package domain;

import lombok.Data;

public  @Data class OrderDetailDTO {
	private String orderDetailID, orderId, productId,
	quantity;

}
