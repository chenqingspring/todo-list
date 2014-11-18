package tw.ymxing.services;

import org.springframework.ui.ModelMap;

public interface AccountService {
    void addAccount(String username, String passwordfirst, String passwordsecond, ModelMap model);
    boolean varifyLogin(String username, String password, ModelMap model);
}
