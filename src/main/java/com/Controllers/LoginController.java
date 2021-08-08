package com.Controllers;


import com.Entities.Note;
import com.Entities.User;
import com.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "status", required = false) String status, Model model) {

        if (status != null) {
            if (status.equals("ok")) {
                model.addAttribute("status", "Registration Successful !!!");
                model.addAttribute("alertType", "primary");
            }else {
                model.addAttribute("status", "Error, please repeat again !!!");
                model.addAttribute("alertType", "danger");
            }
        }
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@RequestParam(value = "status", required = false) String status, Model model) {

        if(status!=null){
            if (status.equals("checkMail") ) {
                model.addAttribute("status", " Successful ! <br> Please check your e-mail.");
                model.addAttribute("alertType", "primary ");
            }
        }
        return "register";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().setAttribute("user", null);
        return "redirect:/login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/loginUser")
    public ResponseEntity<String> loginUser(@RequestBody User user, HttpServletRequest request) {

        User loggedInUser = userService.findByUsernameAndPass(user);
        if (loggedInUser != null) {
            request.getSession().setAttribute("user", loggedInUser);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }
        return new ResponseEntity<>("ERROR", HttpStatus.OK);

    }


    @RequestMapping(value = "/reg/{key}", method = RequestMethod.GET)
    public String regOk(@PathVariable("key") String key, Model model) {

        if (userService.findByKey(key))
            return "redirect:/login?status=ok";

        return "redirect:/login?status=error";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user, HttpServletRequest request) {

        if (controlUser(user)) {
            return new ResponseEntity<>("Passwords not match", HttpStatus.OK);
        }
        if (userService.insert(user).equals(1L)) {
            return new ResponseEntity<>("OK", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("ERROR", HttpStatus.CREATED);
    }


    private boolean controlUser(User user) {
        return !user.getPass().equals(user.getPass2());
    }


}
