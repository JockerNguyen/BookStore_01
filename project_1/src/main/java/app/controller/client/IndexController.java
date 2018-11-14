package app.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "clientController")
public class IndexController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/client/index";

    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "/client/about";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact() {
        return "/client/contact";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart() {
        return "/client/cart";
    }

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public String shop() {
        return "/client/shop";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String checkout() {
        return "/client/checkout";
    }
}
