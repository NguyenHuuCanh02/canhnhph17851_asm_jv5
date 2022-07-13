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
public class AccountModel {
	private String fullname;
	private String email;
	private String username;
	private String password;
	private String photo;
	private int admin;
}
