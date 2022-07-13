package Assignment_Canhnhph17851.controllers;

import java.util.ArrayList;
import java.util.Date;
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

import Assignment_Canhnhph17851.beans.CategoryModel;
import Assignment_Canhnhph17851.beans.ProductModel;
import Assignment_Canhnhph17851.entities.Categories;
import Assignment_Canhnhph17851.entities.Products;
import Assignment_Canhnhph17851.repositories.CategoryRepository;
import Assignment_Canhnhph17851.repositories.ProductRepository;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
	@Autowired
	private ProductRepository proRepo;
	@Autowired
	private CategoryRepository cateRepo;
	//public List<Products> listPro = new ArrayList();
	
	@GetMapping("index")

	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {

		Pageable pageble = PageRequest.of(page, size);
		Page<Products> p = this.proRepo.findAll(pageble);
		model.addAttribute("data", p);
		return "admin/products/index";
	}
	
	@GetMapping("create")
	public String create(@ModelAttribute("pro") ProductModel pro,Model model) {
		List<Categories> listCate = this.cateRepo.findAll();
		model.addAttribute("listCate",listCate);
		return "admin/products/create";
	}

	@PostMapping("store")
	public String store(ProductModel model) {
		Products pro = new Products();
		Categories cate = this.cateRepo.getById(model.getCategory());
		pro.setName(model.getName());
		pro.setImage(model.getImage());
		pro.setPrice(model.getPrice());
		Date date = new Date();
		System.out.println(date);
		pro.setCreatedDate(date);
		pro.setAvailable(model.getAvailable());
		pro.setCategory(cate);
		this.proRepo.save(pro);
		return "redirect:/admin/products/index";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Products pro, Model model) {
		model.addAttribute("pro", pro);
		List<Categories> listCate = this.cateRepo.findAll();
		model.addAttribute("listCate",listCate);
		return "admin/products/edit";
	}

	@PostMapping("update/{id}")
	public String update(@PathVariable("id") Integer id, ProductModel oldPro) {
		Products newPro = this.proRepo.getById(id);
		Categories cate = this.cateRepo.getById(oldPro.getCategory());		
		newPro.setName(oldPro.getName());
		newPro.setName(oldPro.getName());
		newPro.setImage(oldPro.getImage());
		newPro.setPrice(oldPro.getPrice());
		Date date = new Date();
		newPro.setCreatedDate(date);
		newPro.setAvailable(oldPro.getAvailable());
		newPro.setCategory(cate);
		this.proRepo.save(newPro);
		return "redirect:/admin/products/index";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Products pro) {
		this.proRepo.delete(pro);
		return "redirect:/admin/products/index";
	}
}
