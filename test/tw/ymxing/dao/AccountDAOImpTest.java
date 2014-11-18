package tw.ymxing.dao;

import junit.framework.Assert;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import tw.ymxing.model.Account;
import tw.ymxing.model.Item;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountDAOImpTest {
    private AccountDAOImp accountDaoImp;
    @Mock
    Item item;
    @Mock
    Account account;
    @Mock
    AccountMapper accountMapper;
    @Mock
    SqlSession sqlSession;
    @Mock
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception{
        accountDaoImp =new AccountDAOImp();
        accountDaoImp.setSqlSessionFactory(sqlSessionFactory);
        when(sqlSessionFactory.openSession()).thenReturn(sqlSession);
        when(item.getDescription()).thenReturn("Do homework");
        when(sqlSession.getMapper(AccountMapper.class)).thenReturn(accountMapper);
        when(accountMapper.getAccount(anyString())).thenReturn(account);
    }

    @Test
    public void shouldReturnTrueWhenThereHasTheAccount() throws Exception {
        Assert.assertTrue(accountDaoImp.hasAccount("a"));
        verify(accountMapper,times(1)).getAccount("a");
    }

    @Test
    public void shouldReturnFalseWhenThereHasNoTheAccount() throws Exception {
        when(accountMapper.getAccount(anyString())).thenReturn(null);
        Assert.assertFalse(accountDaoImp.hasAccount("a"));
        verify(accountMapper,times(1)).getAccount("a");
    }

    @Test
    public void shouldGetTheNotNullPassword() throws Exception {
        when(account.getPassword()).thenReturn("password");
        Assert.assertEquals("password",accountDaoImp.itsPassword("a"));
        verify(account,times(1)).getPassword();
    }

    @Test
    public void addNewAccountTest() throws Exception{
        accountDaoImp.addAccount(account);
        verify(accountMapper,times(1)).addAccount(account);
    }
}