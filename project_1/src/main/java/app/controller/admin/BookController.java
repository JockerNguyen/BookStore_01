package app.controller.admin;


import app.model.Author;
import app.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class BookController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/author",method = RequestMethod.GET)
    public String author(Model model){
        model.addAttribute("listAuthor",authorService.findAll());
        return "/admin/authors";
    }

    @RequestMapping(value = "/author/delete")
    public ResponseEntity.BodyBuilder deleteAuthor(@RequestBody(required = false) Author author){
        try {
            authorService.delete(author);
            return ResponseEntity.status(HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
