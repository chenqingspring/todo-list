package tw.ymxing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tw.ymxing.dao.AccountDAOImp;
import tw.ymxing.dao.ItemDAOImp;
import tw.ymxing.model.Item;

@Controller
public class ToDoListController {

    private ItemDAOImp itemDAOImp;
    private AccountDAOImp accountDAOImp;
    @Autowired
    public ToDoListController(ItemDAOImp itemDAOImp,AccountDAOImp accountDAOImp)
    {
        this.itemDAOImp = itemDAOImp;
        this.accountDAOImp = accountDAOImp;
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public String addToDoItem(@RequestParam("description") String inputItem,@RequestParam("username")String username,
                              ModelMap model) {

        Item item=new Item();
        item.setDescription(inputItem);
        item.setUsername(username);
        itemDAOImp.addNewItem(item);
        model.addAttribute("Items",itemDAOImp.getAllItem(username));
        return "index";
    }

    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public String homePage() {
        return "login";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String Login(@RequestParam("username") String username,
                        @RequestParam("password") String password,ModelMap model) {
        if(varify(username,password)){
            model.addAttribute("username",username);
            model.addAttribute("Items",itemDAOImp.getAllItem(username));
            return "index";
        }
        return "error";
    }

    private boolean varify(String username, String password) {
        if(accountDAOImp.hasAccount(username)){
            if(password.equals(accountDAOImp.itsPassword(username))) return true;
        }
        return false;
    }

    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String Register() {

        return "register";
    }
}

