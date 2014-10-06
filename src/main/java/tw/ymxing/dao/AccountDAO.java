package tw.ymxing.dao;

import tw.ymxing.model.Account;

public interface AccountDAO {
    public void addNewAccount(Account account);
    public boolean hasAccount(String username);
    public String itsPassword(String username);
}
