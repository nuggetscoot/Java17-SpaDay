package org.launchcode.controllers;


import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
    @RequestMapping("user")
public class UserController {
@GetMapping
        public String displayAddUserForm() {
            return "user/add";
        }
@PostMapping
        public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
    if (user.getPassword() != null && user.getPassword().equals(verify)) {
        // Passwords match, render the user/index.html view template with a welcome message
        model.addAttribute("username", user.getUsername());
        return "user/index";
            } else {
                model.addAttribute("error", "Passwords do not match");
                return "user/add";
            }

        }
    }

