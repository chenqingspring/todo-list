package tw.ymxing.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;
import tw.ymxing.model.Account;

import java.io.IOException;
import java.io.Reader;
@Repository
public class AccountDAOImp {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static {
        try {
            reader = Resources.getResourceAsReader("SqlMapConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSessionFactory.getConfiguration().addMapper(AccountMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addAccount(Account account){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            accountMapper.addAccount(account);
            session.commit();
        } finally {
            session.close();
        }
    }
    public boolean hasAccount(String username) {
        SqlSession session = sqlSessionFactory.openSession();
        try{
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            Account account=accountMapper.getAccount(username);
            if(account!=null)return true;
        }finally {
            session.close();
        }
        return false;
    }

    public String itsPassword(String username) {
        SqlSession session = sqlSessionFactory.openSession();
        try{
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            Account account=accountMapper.getAccount(username);
            if(account!=null)return account.getPassword();
        }finally {
            session.close();
        }
        return null;
    }

}
