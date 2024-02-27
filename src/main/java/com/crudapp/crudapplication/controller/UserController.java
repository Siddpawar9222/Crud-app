package com.crudapp.crudapplication.controller;


import com.crudapp.crudapplication.model.User;
import com.crudapp.crudapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService ;

    @GetMapping("/")
    public String welcome(){
      return "thymeleaf/welcome";
    }

    @GetMapping("/app")
    public ModelAndView getAllUser(){
        return retriveAllUser() ;
    }

    @GetMapping ("/deleteUser")
    public ModelAndView deleteUser(@RequestParam("id") Integer id){
        userService.deleteUser(id);
        return retriveAllUser() ;
    }


    @PostMapping("/add")
    public ModelAndView saveUser(@RequestParam(value = "id") String id, @RequestParam("name") String name, @RequestParam("education") String education,@RequestParam("post") String post){
        if(id.equals("null")){
            User user = new User(name,education,post);
            userService.saveUser(user);
        }else{
            User user = new User(Integer.parseInt(id),name,education,post);
            userService.updateUser(user);
        }
        return retriveAllUser();
    }

    @GetMapping("/getUser")
    public ModelAndView updateUser(@RequestParam("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("user",userService.getUser(id));
        return modelAndView ;
    }

    public ModelAndView retriveAllUser(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users",userService.getAllUser());
        return modelAndView ;
    }

    @GetMapping("/getAddPage")
    public ModelAndView getAddPage(){
        return new ModelAndView("add");
    }
}
