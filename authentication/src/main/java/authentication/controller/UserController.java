package authentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import authentication.domain.Users;
import authentication.repository.UserRepository;

@RestController
public class UserController {


    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public String add(@ModelAttribute("user") Users user) {
        userRepository.add(user);
        return "redirect:/";
    }
 
   
    @RequestMapping(value="/users/{id}", method= RequestMethod.DELETE)
    public String delete(@PathVariable(name = "id") int id) {
        userRepository.delete(id);
        return "redirect:/";
    }

    //return users list
    @GetMapping("/users")
    public List<String> get(){
        return userRepository.list();
    }

     //return users list
     @GetMapping("/users/{id}")
     public String get(@PathVariable(name = "id") int id){
         return userRepository.get(id);
     }
}
