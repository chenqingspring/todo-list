package tw.ymxing.dao;

import tw.ymxing.model.Account;

public interface AccountDAO {
    public boolean hasAccount(String username);
    public String itsPassword(String username);
    public void addAccount(Account account);
}
