package tw.ymxing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ymxing on 7/31/14.
 */
@Controller
@RequestMapping("/todo")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC!");
        return "helloworld";
    }
}
