package Assignment_Canhnhph17851.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



import Assignment_Canhnhph17851.beans.Login;
import Assignment_Canhnhph17851.entities.Accounts;
import Assignment_Canhnhph17851.repositories.AccountRepository;
import Assignment_Canhnhph17851.utiliti.EncryptUtil;

@Controller
public class LoginController {

	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private HttpServletRequest request;

	@GetMapping("/login")
	public String loginForm(@ModelAttribute("user") Login user) {

		return "login";
	}

	@PostMapping("/login")
	public String login(Login login) {
		HttpSession session = this.request.getSession();
		Accounts acc = this.accountRepo.findByEmail(login.getEmail());

		if (acc == null) {

			return "redirect:/login";
		} else {
			boolean check = EncryptUtil.check(login.getPassword(), acc.getPassword());
			if (check==true) {
				session.setAttribute("user", acc);
				return "redirect:/index";
			} else {

				return "redirect:/login";
			}
		}

	}

	@GetMapping("/logout")
	public String logout() {
		return "redirect:/login";
	}
}
