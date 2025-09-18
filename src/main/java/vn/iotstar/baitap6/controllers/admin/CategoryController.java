package vn.iotstar.baitap6.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.iotstar.baitap6.entity.Category;
import vn.iotstar.baitap6.model.CategoryModel;
import vn.iotstar.baitap6.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    public void setDefaultAttribute(Model model) {
        model.addAttribute("home","home");
        model.addAttribute("category","category");
        model.addAttribute("user","user");
        model.addAttribute("video","video");

        model.addAttribute("active_home","");
        model.addAttribute("active_category","active");
        model.addAttribute("active_user","");
        model.addAttribute("active_video","");
    }

    @GetMapping("admin/category")
    public String viewCategory(Model model)
    {
        setDefaultAttribute(model);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/categories/list";
    }

    @PostMapping("admin/category")
    public String viewCategory()
    {
        return "admin/category";
    }

    @GetMapping("admin/category/add")
    public String addCategory(Model model)
    {
        model.addAttribute("action", "add");
        return "admin/categories/add";
    }

    @PostMapping("admin/category/add")
    public String addCategory(@ModelAttribute CategoryModel category)
    {
           String name = category.getCategoryName();
           String images = category.getImages();
           Category newCate = new Category();
           newCate.setCategoryName(name);
           newCate.setImages(images);
           categoryService.save(newCate);
           return "redirect:/admin/category";
    }

    @GetMapping("admin/category/delete")
    public String deleteCategory(@ModelAttribute  CategoryModel category)
    {
        Integer id = category.getId();
        categoryService.deleteById(id);
        return "forward:/admin/category";
    }

    @GetMapping("admin/category/edit")
    public String editCategory(@RequestParam Integer id, Model model)
    {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            model.addAttribute("action", "edit");
            model.addAttribute("category", category.get());
            return "admin/categories/add";
        }
        else {
            return "redirect:/admin/category";
        }

    }

    @PostMapping("admin/category/edit")
    public String editCategory(@ModelAttribute CategoryModel category)
    {
        Integer id = category.getId();
        String images = category.getImages();
        String name = category.getCategoryName();

        Category editCate = new Category(id, name, images);
        categoryService.save(editCate);
        return "redirect:/admin/category";
    }

    @GetMapping("admin/category/search")
    public String searchCategory(@RequestParam String keyword, Model model)
    {
        setDefaultAttribute(model);
        List<Category> categories = null;
        if (keyword.isEmpty()) {
            categories = categoryService.findAll();

        }
        else categories = categoryService.findByCategoryNameContaining(keyword);
        model.addAttribute("categories", categories);
        return "admin/categories/list";
    }
}
