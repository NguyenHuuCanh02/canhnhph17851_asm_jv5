package Assignment_Canhnhph17851.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import Assignment_Canhnhph17851.beans.CategoryModel;
import Assignment_Canhnhph17851.beans.OrderModel;
import Assignment_Canhnhph17851.entities.Accounts;
import Assignment_Canhnhph17851.entities.Categories;
import Assignment_Canhnhph17851.entities.Orders;
import Assignment_Canhnhph17851.entities.Products;
import Assignment_Canhnhph17851.repositories.AccountRepository;
import Assignment_Canhnhph17851.repositories.OrderRepository;
import Assignment_Canhnhph17851.repositories.ProductRepository;

@Controller
@RequestMapping(value = "/admin/orders")
public class OrderController {
	@Autowired
	private ProductRepository proRepo;

	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private AccountRepository accRepo;
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {

		Pageable pageble = PageRequest.of(page, size);
		Page<Orders> o = this.orderRepo.findAll(pageble);
		model.addAttribute("data", o);
		return "admin/orders/index";
	}

	@GetMapping("/create")
	public String loadCreate(@ModelAttribute("order") OrderModel orderModel) {
		return "/admin/orders/create";
	}

	@PostMapping("/store")
	public String create(OrderModel orderModel) {
		Orders order = new Orders();
		order.setAddress(orderModel.getAddress());
		System.out.println(orderModel.getAddress());
		Date date = new Date();
		order.setCreatedDate(date);
		System.out.println(date);
		Accounts account = (Accounts) this.request.getSession().getAttribute("user");
		order.setUser(account);
		this.orderRepo.save(order);
		return "redirect:/admin/orders/index";
	}
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Orders od, Model model) {
		model.addAttribute("order", od);
		return "admin/orders/edit";
	}

	
	
	@GetMapping("/build/{id}")
	public String build(@PathVariable("id") Orders od,Model model) {
		model.addAttribute("order", od);
		System.out.println(od.getId());
		List<Products> p = this.proRepo.findAll();
		model.addAttribute("listPro", p);
		return "admin/orderDetails/create";
	}
	
	@PostMapping("update/{id}")
	public String update(@PathVariable("id") Integer id, OrderModel oldO) {
		System.out.print("acc");
		Orders newOrder = this.orderRepo.getById(id);
		newOrder.setAddress(oldO.getAddress());

		this.orderRepo.save(newOrder);
		return "redirect:/admin/orders/index";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Orders od) {
		this.orderRepo.delete(od);
		return "redirect:/admin/orders/index";
	}
}
