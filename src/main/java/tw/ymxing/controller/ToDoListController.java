package tw.ymxing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tw.ymxing.services.AccountService;
import tw.ymxing.services.ItemService;

@Controller
public class ToDoListController {

    private final ItemService itemService;
    private final AccountService accountService;
    @Autowired
    public ToDoListController(ItemService itemService,AccountService accountService)
    {
        this.itemService=itemService;
        this.accountService=accountService;
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public String addToDoItem(@RequestParam("description") String inputItem,@RequestParam("username")String username,
                              ModelMap model) {

        itemService.addItem(inputItem, username, model);
        return "index";
    }

    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public String homePage() {
        return "login";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,ModelMap model) {
        if (accountService.varifyLogin(username, password, model)) return "index";
        return "error";
    }

    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public String addAnAccount(@RequestParam("username") String username,
                               @RequestParam("pwfirst") String passwordfirst,
                               @RequestParam("pwsecond") String passwordsecond,ModelMap model) {
        accountService.addAccount(username, passwordfirst, passwordsecond, model);
        return "index";
    }
}

