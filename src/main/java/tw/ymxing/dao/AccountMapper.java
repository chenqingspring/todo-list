package tw.ymxing.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tw.ymxing.model.Account;

public interface AccountMapper {
    @Select("select * from accounts where username=#{username}")
    @Results(value = {
            @Result(property="username", column="username"),
            @Result(property="password", column="password")
    })
    public Account getAccount(String username);
    @Insert("INSERT INTO accounts(username,password) VALUES(#{username},#{password})")
    public void addAccount(Account account);
}
