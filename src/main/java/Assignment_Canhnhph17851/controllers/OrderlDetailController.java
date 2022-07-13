package Assignment_Canhnhph17851.controllers;

import java.util.List;

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

import Assignment_Canhnhph17851.beans.OrderDetailModel;
import Assignment_Canhnhph17851.entities.OrderDetails;
import Assignment_Canhnhph17851.entities.Orders;
import Assignment_Canhnhph17851.entities.Products;
import Assignment_Canhnhph17851.repositories.OrderDetailRepository;
import Assignment_Canhnhph17851.repositories.OrderRepository;
import Assignment_Canhnhph17851.repositories.ProductRepository;

@Controller
@RequestMapping("/admin/orderDetails")
public class OrderlDetailController {
	@Autowired
	ProductRepository proRepo;
	@Autowired
	OrderDetailRepository orderDetailRepo;
	@Autowired
	OrderRepository oderRepo;

	@GetMapping("createe")
	public String create(@ModelAttribute("tai") OrderDetailModel tai, Model model) {
		List<Products> listPro = this.proRepo.findAll();
		List<Orders> listOder = this.oderRepo.findAll();
		model.addAttribute("pro", listPro);
		model.addAttribute("oder", listOder);
		return "admin/orderDetails/create";
	}
	@GetMapping("create/{id}")
	public String createID(@PathVariable("id") Orders od,@ModelAttribute("tai") OrderDetailModel tai, Model model) {
		List<Products> listPro = this.proRepo.findAll();
		model.addAttribute("pro", listPro);
		model.addAttribute("oder", od);
		return "admin/orderDetails/create";
	}
	@PostMapping("store")
	public String store( OrderDetailModel tai) {
		System.out.println(tai.getOrder());
		OrderDetails odertails = new OrderDetails();
		odertails.setOrder(this.oderRepo.getOne(tai.getOrder()));
		odertails.setProduct(this.proRepo.getOne(tai.getProduct()));
		odertails.setPrice(tai.getPrice());
		odertails.setQuantity(tai.getQuantity());
		System.out.println(odertails.getQuantity());
		this.orderDetailRepo.save(odertails);
		return "redirect:/admin/orderDetails/index";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") OrderDetails odertai, Model model
			) {
		model.addAttribute("orderDetail", odertai);
		List<Products> listPro = this.proRepo.findAll();
		model.addAttribute("pro", listPro);
		return "admin/orderDetails/edit";
	}

	@PostMapping("update/{id}")
	public String update(@PathVariable("id") int id, OrderDetailModel taiModel) {

		OrderDetails tai = this.orderDetailRepo.getOne(id);
		tai.setOrder(this.oderRepo.getOne(taiModel.getOrder()));
		tai.setProduct(this.proRepo.getOne(taiModel.getProduct()));
		tai.setPrice(taiModel.getPrice());
		tai.setQuantity(taiModel.getQuantity());
		this.orderDetailRepo.save(tai);
		return "redirect:/admin/orderDetails/index";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") OrderDetails odertails) {
		// System.out.println(account.getEmail());
		this.orderDetailRepo.delete(odertails);
		return "redirect:/admin/orderDetails/index";
	}

	@GetMapping("index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		Pageable pageable = (Pageable) PageRequest.of(page, size);
		Page<OrderDetails> p = this.orderDetailRepo.findAll(pageable);
		model.addAttribute("tai", p);
		return "admin/orderDetails/index";
	}
}