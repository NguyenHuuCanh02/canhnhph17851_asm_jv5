package Assignment_Canhnhph17851.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Assignment_Canhnhph17851.entities.Categories;
import Assignment_Canhnhph17851.entities.Products;
import Assignment_Canhnhph17851.repositories.CategoryRepository;
import Assignment_Canhnhph17851.repositories.ProductRepository;

@Controller	
@RequestMapping("/index")
public class IndexController{
	@Autowired
	private ProductRepository proRepo;
	@Autowired
	private CategoryRepository cateRepo;
	@GetMapping
	public String index(Model model) {
		List<Products> p = this.proRepo.findAll();
		model.addAttribute("listPro",p);
		List<Categories> c = this.cateRepo.findAll();
		model.addAttribute("listCate",c);
		return "users/loadProducts";
	}
}
