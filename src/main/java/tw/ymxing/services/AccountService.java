package tw.ymxing.services;

import org.springframework.ui.ModelMap;
import tw.ymxing.dao.AccountDAOImp;
import tw.ymxing.dao.ItemDAOImp;

public interface AccountService {
    void addAccount(String username, String passwordfirst, String passwordsecond, ModelMap model);
    boolean varifyLogin(String username, String password, ModelMap model);
}
