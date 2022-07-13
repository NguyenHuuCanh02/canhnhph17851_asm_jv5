package Assignment_Canhnhph17851.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import Assignment_Canhnhph17851.beans.AccountModel;
import Assignment_Canhnhph17851.entities.Accounts;
import Assignment_Canhnhph17851.repositories.AccountRepository;
import Assignment_Canhnhph17851.utiliti.EncryptUtil;

@Controller
@RequestMapping("/admin/accounts")
public class AccountController {
	@Autowired
	private AccountRepository accountRepo;

	@GetMapping("index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		Pageable pageble = PageRequest.of(page, size);
		Page<Accounts> p = this.accountRepo.findAll(pageble);
		model.addAttribute("data", p);
		return "admin/accounts/index";
	}
	@GetMapping("create")
	public String create(@ModelAttribute("account") AccountModel account) {
		return "admin/accounts/create";
	}

	@PostMapping("store")
	public String store(AccountModel model) {
		Accounts acc = new Accounts();
		acc.setFullname(model.getFullname());
		acc.setUsername(model.getUsername());
		acc.setEmail(model.getEmail());
		String password = EncryptUtil.encrypt(model.getPassword());
		acc.setPassword(password);
		acc.setPhoto(model.getPhoto());
		acc.setAdmin(model.getAdmin());
		this.accountRepo.save(acc);
		return "redirect:/admin/accounts/index";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Accounts account, Model model) {
		model.addAttribute("account", account);
		return "admin/accounts/edit";
	}

	@PostMapping("update/{id}")
	public String update(@PathVariable("id") Integer id, AccountModel oldAcc) {
		System.out.print("acc");
		Accounts newAcc = this.accountRepo.getById(id);
		newAcc.setFullname(oldAcc.getFullname());
		newAcc.setUsername(oldAcc.getUsername());
		newAcc.setEmail(oldAcc.getEmail());
		String password = EncryptUtil.encrypt(oldAcc.getPassword());
		newAcc.setPassword(password);
		newAcc.setPhoto(oldAcc.getPhoto());
		newAcc.setAdmin(oldAcc.getAdmin());
		this.accountRepo.save(newAcc);
		return "redirect:/admin/accounts/index";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Accounts account) {
		this.accountRepo.delete(account);
		return "redirect:/admin/accounts/index";
	}


}