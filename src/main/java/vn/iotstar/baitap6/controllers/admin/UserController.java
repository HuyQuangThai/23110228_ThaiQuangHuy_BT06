package vn.iotstar.baitap6.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.iotstar.baitap6.entity.Category;
import vn.iotstar.baitap6.entity.User;
import vn.iotstar.baitap6.model.UserModel;
import vn.iotstar.baitap6.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController
{
    @Autowired
    private UserService userService;

    public void setDefaultAttribute(Model model) {
        model.addAttribute("home","home");
        model.addAttribute("category","/admin/category");
        model.addAttribute("user","user");
        model.addAttribute("video","/admin/video");

        model.addAttribute("active_home","");
        model.addAttribute("active_category","");
        model.addAttribute("active_user","active");
        model.addAttribute("active_video","");
    }

    @GetMapping("admin/user")
    public String viewUser(Model model) {
        setDefaultAttribute(model);
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "admin/users/list";
    }

    @GetMapping("admin/user/add")
    public String addUser(Model model) {
        setDefaultAttribute(model);
        model.addAttribute("action", "add");
        model.addAttribute("user",new User());
        return "admin/users/edit";
    }

    @PostMapping("admin/user/add")
    public String addUser(@ModelAttribute UserModel user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String phone = user.getPhone();
        String fullName = user.getFullName();
        String images = user.getImages();
        Integer role = user.getRole();

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        if (!email.isEmpty()) newUser.setEmail(email);
        if (!phone.isEmpty()) newUser.setPhone(phone);
        if (!fullName.isEmpty()) newUser.setFullName(fullName);
        if (!images.isEmpty()) newUser.setImages(images);
        newUser.setRole(role);
        userService.save(newUser);
        return "redirect:/admin/user";
    }

    @GetMapping("admin/user/edit")
    public String editUser(@RequestParam Integer id, Model model) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user",user.get());
            model.addAttribute("action", "edit");
            return "admin/users/edit";
        }
        else return "forward:/admin/user";
    }

    @PostMapping("admin/user/edit")
    public String editUser(@ModelAttribute UserModel user) {
        Integer id = user.getId();
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String phone = user.getPhone();
        String fullName = user.getFullName();
        String images = user.getImages();
        Integer role = user.getRole();

        Optional<User> editUser = userService.findById(id);
        if (editUser.isPresent()) {
            User userEdited = editUser.get();
            userEdited.setUsername(username);
            userEdited.setPassword(password);
            if (!email.isEmpty()) userEdited.setEmail(email);
            if (!phone.isEmpty()) userEdited.setPhone(phone);
            if (!fullName.isEmpty()) userEdited.setFullName(fullName);
            if (!images.isEmpty()) userEdited.setImages(images);
            userEdited.setRole(role);
            userService.save(userEdited);
            return "redirect:/admin/user";
        }
        return "forward:/admin/user";
    }

    @GetMapping("admin/user/delete")
    public String deleteUser(@RequestParam Integer id)
    {
        userService.deleteById(id);
        return "redirect:/admin/user";
    }

    @GetMapping("admin/user/search")
    public String searchUser(@RequestParam String keyword,Model model)
    {
        setDefaultAttribute(model);
        List<User> uses = null;
        if (keyword.isEmpty())  {
            uses = userService.findAll();
        } else uses = userService.findByUsernameContaining(keyword);
        model.addAttribute("users",uses);
        return "admin/users/list";
    }
}
