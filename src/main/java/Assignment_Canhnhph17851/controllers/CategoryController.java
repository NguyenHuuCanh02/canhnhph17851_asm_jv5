package Assignment_Canhnhph17851.controllers;

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
import Assignment_Canhnhph17851.entities.Categories;
import Assignment_Canhnhph17851.repositories.CategoryRepository;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
	@Autowired
	private CategoryRepository cateRepo;

	@GetMapping("index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {

		Pageable pageble = PageRequest.of(page, size);
		Page<Categories> p = this.cateRepo.findAll(pageble);
		model.addAttribute("data", p);
		return "admin/categories/index";
	}

	@GetMapping("create")
	public String create(@ModelAttribute("cate") CategoryModel cate) {
		return "admin/categories/create";
	}

	@PostMapping("store")
	public String store(CategoryModel model) {
		Categories cate = new Categories();
		cate.setName(model.getName());
		this.cateRepo.save(cate);
		return "redirect:/admin/categories/index";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Categories cate, Model model) {
		model.addAttribute("cate", cate);
		return "admin/categories/edit";
	}

	@PostMapping("update/{id}")
	public String update(@PathVariable("id") Integer id, CategoryModel oldCate) {
		System.out.print("acc");
		Categories newCate = this.cateRepo.getById(id);
		newCate.setName(oldCate.getName());

		this.cateRepo.save(newCate);
		return "redirect:/admin/categories/index";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Categories cate) {
		this.cateRepo.delete(cate);
		return "redirect:/admin/categories/index";
	}
}
