package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.upload.UploadService;
import vn.hoidanit.laptopshop.service.userService;

@Controller
public class userController {
    private final userService userService;
    private final UploadService uploadService;
    private final PasswordEncoder passwordEncoder;

    public userController(
            userService userService,
            UploadService uploadService,
            PasswordEncoder passwordEncoder
        ) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
    }
    // show all user
    @RequestMapping("/admin/user")
    public String showInfUser(Model model) {
        List<User> users = this.userService.getAllUser();
        System.out.println(">> check out: " + users);
        model.addAttribute("users", users);
        return "admin/user/user_show";
    }

    // create User
    @GetMapping("/admin/user/create")
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
    @PostMapping("/admin/user/create")
    public String createUserPage(
            Model model,
            @ModelAttribute("newUser") User saveData,
            @RequestParam("fileImg") MultipartFile file
    ) {
        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        System.out.println("avatar: " + avatar);
        String hashPassword = this.passwordEncoder.encode(saveData.getPassword());
        saveData.setPassword(hashPassword);
        saveData.setAvatar(avatar);
        saveData.setRole(this.userService.getRoleByName(saveData.getRole().getName()));

        // save role
        this.userService.handleSaveUser(saveData);
        return "redirect:/admin/user";
    }

    @PostMapping("/admin/user/update")
    public String updateUserPage(
            Model model,
            @ModelAttribute("currentUser") User updateTrue,
            @RequestParam("fileImg") MultipartFile file,
            RedirectAttributes redirectAttributes
        ) {
        User currentUser = this.userService.getUserById(updateTrue.getId());
        if (currentUser != null) {
            String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
            redirectAttributes.addFlashAttribute("avatar" + file.getOriginalFilename());
            currentUser.setFullName(updateTrue.getFullName());
            currentUser.setAddress(updateTrue.getAddress());
            currentUser.setPhoneNumber(updateTrue.getPhoneNumber());
            currentUser.setRole(updateTrue.getRole());
            currentUser.setAvatar(avatar);
            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

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
 

    @RequestMapping("/admin/order")
    public String showOrder(Model model) {
        return "admin/order/show_order";
    }

    @RequestMapping("/admin/product")
    public String showProduct(Model model) {
        return "admin/product/show_product";
    }

    @RequestMapping("/admim")
    public String showDashboard(Model model) {
        return "admin/dashboard/shows";
    }
    
}