package tw.ymxing.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import tw.ymxing.dao.AccountDAOImp;
import tw.ymxing.dao.ItemDAOImp;
import tw.ymxing.model.Account;
import tw.ymxing.services.AccountService;
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountDAOImp accountDAOImp;
    @Autowired
    private ItemDAOImp itemDAOImp;

    public void setAccountDAOImp(AccountDAOImp accountDAOImp) {
        this.accountDAOImp = accountDAOImp;
    }

    public void setItemDAOImp(ItemDAOImp itemDAOImp) {
        this.itemDAOImp = itemDAOImp;
    }

    @Override
    public void addAccount(String username, String passwordfirst, String passwordsecond, ModelMap model) {
        model.addAttribute("username",username);
        if(passwordfirst.equals(passwordsecond)){
            Account account=new Account();
            account.setUsername(username);
            account.setPassword(passwordfirst);
            accountDAOImp.addAccount(account);
        }
        model.addAttribute("Items",null);
    }

    @Override
    public boolean varifyLogin(String username, String password, ModelMap model) {
        if(varify(username,password)){
            model.addAttribute("username",username);
            model.addAttribute("Items",itemDAOImp.getAllItem(username));
            return true;
        }
        return false;
    }


    private boolean varify(String username, String password) {
        if(accountDAOImp.hasAccount(username)){
            if(password.equals(accountDAOImp.itsPassword(username))) return true;
        }
        return false;
    }
}
