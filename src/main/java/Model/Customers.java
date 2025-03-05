package Model;

import lombok.Data;

@Data
public class Customers {

	private String fullName;
	private String email;
	private String phone;
	private Boolean gender;
	private Double product_price;
	private String city;
	private Integer pincode;
	private String state;
	private String country;

}
