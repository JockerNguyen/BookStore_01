package app.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class BookController {
    @RequestMapping(value = "/author",method = RequestMethod.GET)
    public String author(){
        return "/admin/authors";
    }
}
