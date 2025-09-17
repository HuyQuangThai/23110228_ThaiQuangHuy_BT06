package vn.iotstar.baitap6.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    public void setDefaultAttribute(Model model) {
        model.addAttribute("home","home");
        model.addAttribute("category","category");
        model.addAttribute("user","user");
        model.addAttribute("video","video");

        model.addAttribute("active_home","active");
        model.addAttribute("active_category","");
        model.addAttribute("active_user","");
        model.addAttribute("active_video","");
    }

    @GetMapping("/admin/home")
    public String home(Model model) {
        setDefaultAttribute(model);
        return "admin/home";
    }
}
