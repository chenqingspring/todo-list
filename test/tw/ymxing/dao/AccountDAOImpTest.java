package tw.ymxing.dao;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import tw.ymxing.model.Account;
import tw.ymxing.model.Item;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountDAOImpTest {
    private AccountDAOImp accountDAOImp;
    @Mock
    DataSource dataSource;
    @Mock
    Connection connection;
    @Mock
    Statement statement;
    @Mock
    ResultSet resultSet;
    @Mock
    Item item;
    @Mock
    Account account;

    @Before
    public void setUp() throws Exception{
        accountDAOImp=new AccountDAOImp();
        accountDAOImp.setDataSource(dataSource);
        when(dataSource.getConnection()).thenReturn(connection);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery(anyString())).thenReturn(resultSet);
        when(resultSet.wasNull()).thenReturn(true);
        when(item.getDescription()).thenReturn("Do homework");
    }


    @Test
    public void shouldReturnTrueWhenThereHasTheAccount() throws Exception {
        when(resultSet.wasNull()).thenReturn(false);
        Assert.assertTrue(accountDAOImp.hasAccount("a"));
        verify(statement,times(1)).executeQuery(anyString());
    }

    @Test
    public void shouldReturnFalseWhenThereHasNoTheAccount() throws Exception {
        Assert.assertFalse(accountDAOImp.hasAccount("a"));
        verify(statement,times(1)).executeQuery(anyString());
    }

    @Test
    public void shouldGetTheNotNullPassword() throws Exception {
        accountDAOImp.itsPassword("a");
        verify(statement,times(1)).executeQuery(anyString());
    }

    @Test
    public void addNewAccountTest() throws Exception{
        accountDAOImp.addAccount(account);
        verify(statement,times(1)).executeUpdate(anyString());
    }
}