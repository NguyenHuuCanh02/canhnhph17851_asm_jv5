package Assignment_Canhnhph17851.beans;

import Assignment_Canhnhph17851.entities.Categories;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	private String name;
	private String image;
	private double price;
	private int available;
	private int category;
	
}
