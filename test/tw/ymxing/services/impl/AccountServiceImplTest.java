package tw.ymxing.services.impl;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;
import tw.ymxing.dao.AccountDAOImp;
import tw.ymxing.dao.ItemDAOImp;
import tw.ymxing.model.Account;
import tw.ymxing.model.Item;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {
    private AccountServiceImpl accountService;
    @Mock
    ModelMap mockModel;
    @Mock
    AccountDAOImp mockAccountDAOImp;
    @Mock
    ItemDAOImp mockItemDAOImp;
    List ItemList=new ArrayList<Item>();

    @Before
    public void setUp(){
        accountService = new AccountServiceImpl();
        accountService.setItemDAOImp(mockItemDAOImp);
        accountService.setAccountDAOImp(mockAccountDAOImp);
        when(mockAccountDAOImp.hasAccount(anyString())).thenReturn(Boolean.TRUE);
        when(mockAccountDAOImp.itsPassword("minmin")).thenReturn("aaa");
        when(mockItemDAOImp.getAllItem(anyString())).thenReturn(ItemList);
    }

    @Test
    public void shouldAddAnAccountWhenPasswordsIsSame(){
        accountService.addAccount("minmin", "aaa", "aaa", mockModel);
        verify(mockModel,times(1)).addAttribute("username", "minmin");
        verify(mockAccountDAOImp,times(1)).addAccount((Account) anyObject());
        verify(mockModel, times(1)).addAttribute("Items", null);
    }

    @Test
    public void shouldNotAddAnAccountWhenPasswordsIsNotSame(){
        accountService.addAccount("minmin", "aaa", "bbb", mockModel);
        verify(mockModel,times(1)).addAttribute("username", "minmin");
        verify(mockAccountDAOImp,times(0)).addAccount((Account) anyObject());
        verify(mockModel, times(1)).addAttribute("Items", null);
    }

    @Test
    public void shouldReturnTrueWhenAccountIsExist(){
        Assert.assertTrue(accountService.varifyLogin("minmin", "aaa", mockModel));
        verify(mockModel,times(1)).addAttribute("username","minmin");
        verify(mockModel,times(1)).addAttribute("Items",ItemList);
    }

    @Test
    public void shouldReturnFalseWhenAccountIsNotExist(){
        when(mockAccountDAOImp.itsPassword("minmin")).thenReturn("bbb");
        Assert.assertFalse(accountService.varifyLogin("minmin", "aaa", mockModel));
        verify(mockModel,times(0)).addAttribute("username","minmin");
        verify(mockModel,times(0)).addAttribute("Items",ItemList);

    }

}