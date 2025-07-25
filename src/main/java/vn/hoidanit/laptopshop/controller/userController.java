package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @RequestMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("eric", "test");
        model.addAttribute("hoidanthanhtung", "from controller with model");
        return "hello";
    }

    // show all user
    @RequestMapping("/admin/user")
    public String showInfUser(Model model) {
        List<User> users = this.userService.getAllUser();
        System.out.println(">> check out: " + users);
        model.addAttribute("users", users);
        return "information/showdata";
    }

    // create User
    @RequestMapping("/admin/user/create")
    public String getUserPage(Model model) {
        // List<User> arrayUser = this.userService.getAllUserByEmail("trinhtung20040403@gmail.com");
        // System.out.println("arrayUser"+ arrayUser);
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    // detail user
    @RequestMapping("/admin/user/{id}")
    public String getUserDetail(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        return "admin/user/detail";
    }

    // update user
    @RequestMapping("/admin/user/update/{id}")
    public String getUserUpdate(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("currentUser", user);
        return "admin/user/update";
    }

    // Back user show
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User saveData) {
        this.userService.handleSaveUser(saveData);
        return "redirect:/admin/user";
    }
    // @RequestMapping(value = "/admin/user/update", method= RequestMethod.POST)
    // public String updateUser(Model model, @ModelAttribute("currentUser") User updateUser) {
    //     this.userService.handleSaveUser(updateUser);
    //     return "redirect:/admin/user";
    // }

    @PostMapping("/admin/user/update")
    public String updateUserPage(Model model, @ModelAttribute("currentUser") User updateTrue) {
        User currentUser = this.userService.getUserById(updateTrue.getId());
        if (currentUser != null) {
            currentUser.setFullName(updateTrue.getFullName());
            currentUser.setAddress(updateTrue.getAddress());
            currentUser.setPhoneNumber(updateTrue.getPhoneNumber());
            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    // @RequestMapping(value = "/admin/user/delete/{id}", method = RequestMethod.GET)
    // public String deleteUserById(@PathVariable long id) {
    //     this.userService.deleteUserById(id);
    //     return "redirect:/admin/user";
    // }

    // Delete Item
    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUser(Model model, @PathVariable long id) {
        model.addAttribute(id);
        User user = new User();
        user.setId(id);
        model.addAttribute("deleteUser", user);
        return "admin/user/delete";
    }
    @PostMapping("/admin/user/delete")
    public String postDeleteUser(Model model, @ModelAttribute("deleteUser") User deleteUser) {
        this.userService.deleteUserById(deleteUser.getId());
        return "redirect:/admin/user" ;
    }
 
}