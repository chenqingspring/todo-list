package tw.ymxing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tw.ymxing.dao.ItemDAOImp;
import tw.ymxing.model.Item;

@Controller
public class ToDoListController {

    private ItemDAOImp itemDAOImp;

    @Autowired
    public ToDoListController(ItemDAOImp itemDAOImp){
        this.itemDAOImp=itemDAOImp;
    }

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public String showList(ModelMap model){
        Item item=new Item();
        item.setDescription("Pay bills");
        itemDAOImp.addNewItem(item);
        model.addAttribute("Items",itemDAOImp.getAllItem());
        return "index";
        }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public String addToDoItem(@RequestParam("description") String inputItem,ModelMap model) {
        Item item=new Item();
        item.setDescription(inputItem);
        itemDAOImp.addNewItem(item);
        model.addAttribute("Items",itemDAOImp.getAllItem());
        return "index";
    }
}

