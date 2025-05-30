package com.robgro.inventory_app.brand;

import com.robgro.inventory_app.category.Category;
import com.robgro.inventory_app.category.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BrandController {

    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public BrandController(BrandRepository brandRepository, CategoryRepository categoryRepository) {
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/brands/new")
    public String showCreateNewBrandForm(Model model) {
        List<Category> listCategories = categoryRepository.findAll();
        model.addAttribute("listCategories", listCategories);
        model.addAttribute("brand", new Brand());
        return "brand_form";
    }

    @PostMapping("/brands/save")
    public String saveBrand(Brand brand) {
        brandRepository.save(brand);
        return "redirect:/brands";
    }

    @GetMapping("/brands")
    public String listBrands(Model model) {
        List<Brand> brandList = brandRepository.findAll();
        model.addAttribute("brandList", brandList);
        return "brands";
    }

    @GetMapping("/brands/edit/{id}")
    public String showEditBrandsForm (@PathVariable("id") Integer id, Model model) {
        List<Category> listCategories = categoryRepository.findAll();

        Brand brand = brandRepository.findById(id).get();
        model.addAttribute("listCategories", listCategories);
        model.addAttribute("brand", brand);

        return "brand_form";
    }
}
