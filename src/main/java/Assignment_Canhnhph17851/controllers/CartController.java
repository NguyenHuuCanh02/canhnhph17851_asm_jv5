package Assignment_Canhnhph17851.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import Assignment_Canhnhph17851.beans.OrderModel;
import Assignment_Canhnhph17851.entities.Accounts;
import Assignment_Canhnhph17851.entities.Carts;
import Assignment_Canhnhph17851.entities.Products;
import Assignment_Canhnhph17851.repositories.AccountRepository;
import Assignment_Canhnhph17851.repositories.CartRepository;
import Assignment_Canhnhph17851.repositories.ProductRepository;

@Controller
@RequestMapping("/carts")
public class CartController {
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private ProductRepository proRepo;
	
	@Autowired
	private AccountRepository accRepo;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@GetMapping()
	public String index(
		Model model,@ModelAttribute("order") OrderModel orderModel,
		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "10") int size
	) {
		Pageable pageable = PageRequest.of(page, size); 
		Page<Carts> c = this.cartRepo.findAll(pageable);
		model.addAttribute("listCart",c);
		model.addAttribute("pageData", c);
		List<Products> p = this.proRepo.findAll();
		model.addAttribute("listPro",p);
		
		return "users/carts/index";
	}
	@GetMapping("/cart_user")
	public String cart_id(
		Model model,
		@RequestParam("productId") int productId
	) {
		Accounts account = (Accounts) this.request.getSession().getAttribute("user");
		Carts c = this.cartRepo.findByAccountIdAndProductId(account.getId(), productId);
		model.addAttribute("listCart",c);
		List<Products> p = this.proRepo.findAll();
		model.addAttribute("listPro",p);
		
		return "users/carts/index";
	}
	@PostMapping("/store")
	public String store(
			@RequestParam("productId") int productId,
			@ModelAttribute("order") OrderModel orderModel
	) {
		
		Accounts account = (Accounts) this.request.getSession().getAttribute("user");
		
		Products product  = this.proRepo.getById(productId);

			Carts cart = new Carts();	
			cart.setAccount(account);
			cart.setProduct(product);
			cart.setQuantity(1);
			this.cartRepo.save(cart);	
		return "cart_user";
	}
	@GetMapping("/orderDetail")
	public String orderDetail(
			@RequestParam("productId") int productId) {
		
		return "";
	}
	
}
