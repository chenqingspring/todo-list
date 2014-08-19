package tw.ymxing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tw.ymxing.model.Item;

@Controller
public class ToDoListController {

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public String addToDoItem(Model model){

        Item items=new Item();
        items.setItem("Do homework");
        model.addAttribute("newItem",items.getItem());
        return "todo";
        }
    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringWeb")Item newitem,
                             ModelMap model) {
        model.addAttribute("newItems",newitem.getItem());
        return "todo";
    }
}

