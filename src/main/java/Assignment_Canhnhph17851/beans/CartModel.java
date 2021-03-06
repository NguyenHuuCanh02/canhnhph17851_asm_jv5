package Assignment_Canhnhph17851.beans;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CartModel {

	private Integer id;
	
	@NotNull
	private Integer accountId;
	
	@NotNull
	private Integer productId;
	
	private Integer quantity;
}