package vn.iotstar.baitap6.controllers.web;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.iotstar.baitap6.entity.User;
import vn.iotstar.baitap6.model.UserModel;
import vn.iotstar.baitap6.service.UserService;

import java.util.Optional;


@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String begin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "web/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, HttpSession session, RedirectAttributes ra, HttpServletResponse response, @RequestParam String remember) {
        if (userModel.getUsername() == null || userModel.getPassword() == null) {
            ra.addFlashAttribute("alert","Vui lòng nhập đầy đủ thông tin");
        }

        Optional<User> optionalUser = userService.findByUsernameAndPassword(userModel.getUsername(), userModel.getPassword());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            session.setAttribute("account", user);

            if ("on".equals(remember)) {
                rememberMe(response,userModel.getUsername());
            }

            if (user.getRole() == 1) {
                return "redirect:/user/home";
            }

            if (user.getRole() == 2) {
                return "redirect:/admin/home";
            }
        } else {
            ra.addFlashAttribute("alert","Tài khoản không tồn tại");
            return "redirect:/";
        }
        return "redirect:/";
    }

    private void rememberMe(HttpServletResponse response, String username) {
        Cookie cookie = new Cookie("username", username);
        cookie.setPath("");
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
    }
}
