package Assignment_Canhnhph17851.beans;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class OrderDetailModel {
	private int order;
	private int product;
	private double price;
	private int quantity;
}
