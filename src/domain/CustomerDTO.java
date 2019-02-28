package domain;

import lombok.Data;

public @Data class CustomerDTO {
	private String  customerID, customerName, password, ssn, phone,
					photo, city, address, postalcode, count ;

}
