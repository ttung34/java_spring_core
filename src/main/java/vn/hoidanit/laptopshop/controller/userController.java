package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.userService;


@Controller
public class userController {
    private final userService userService;

    public userController(userService userService) { 
        this.userService = userService;
    }

    // @GetMapping("")
    // public String getHomePage() {
    //     return this.userService.handleHello();
    // // }
    @RequestMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("eric", "test");
        model.addAttribute("hoidanthanhtung", "from controller with model");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> arrayUser = this.userService.getAllUserByEmail("trinhtung20040403@gmail.com");
        System.out.println("arrayUser"+ arrayUser);
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User saveData) {
        this.userService.handleSaveUser(saveData);
        System.out.println("run here" + saveData);
        return "hello";
    }
    
    

}
