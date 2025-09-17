package vn.iotstar.baitap6.controllers.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.iotstar.baitap6.entity.Category;
import vn.iotstar.baitap6.service.CategoryService;
import vn.iotstar.baitap6.service.impl.CategoryServiceImpl;

import java.util.List;

@Controller
public class CategoryController {
    @GetMapping("admin/category")
    public String viewCategory(RedirectAttributes ra)
    {
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> categories = categoryService.findAll();
        ra.addFlashAttribute("categories", categories);
        return "admin/categories/list";
    }

    @PostMapping("admin/category")
    public String viewCategory()
    {
        return "admin/category";
    }
}
