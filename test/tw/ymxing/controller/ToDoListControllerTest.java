package tw.ymxing.controller;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tw.ymxing.dao.AccountDAOImp;
import tw.ymxing.dao.ItemDAOImp;
import tw.ymxing.model.Item;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ToDoListControllerTest {
    private MockMvc mockMvc;
    @Mock
    ItemDAOImp mockItemDAOImp;
    @Mock
    AccountDAOImp mockAccountDAOImp;
    @Mock
    Item item;

    @Before
    public void setUp() throws Exception {
        List ItemList=new ArrayList<Item>();
        when(mockAccountDAOImp.hasAccount("minmin")).thenReturn(true);
        when(mockAccountDAOImp.itsPassword("minmin")).thenReturn("aaa");
        when(mockItemDAOImp.getAllItem(anyString())).thenReturn(ItemList);
        this.mockMvc=MockMvcBuilders.standaloneSetup(new ToDoListController(mockItemDAOImp,mockAccountDAOImp)).build();

    }


    @Test
    public void shouldAcceptShowListUrl() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/homePage"))
                .andExpect(status().is(200));
    }

    @Test
    public void shouldAcceptAddLItemUrl() throws Exception {
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/addItem?description=''&username=''"))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Items"))
                .andReturn();
        Assert.assertNotNull(mvcResult.getModelAndView().getModel().get("Items"));
    }

    @Test
    public void shouldAcceptLoginUrlAndToLoginPage() throws Exception {
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/Login?username=minmin&password=aaa"))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Items"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("username"))
                .andReturn();
        verify(mockAccountDAOImp,times(1)).hasAccount("minmin");
        verify(mockAccountDAOImp,times(1)).itsPassword("minmin");
        mvcResult.getModelAndView().getViewName().equals("index");
        Assert.assertNotNull(mvcResult.getModelAndView().getModel().get("Items"));
        Assert.assertNotNull(mvcResult.getModelAndView().getModel().get("username"));
    }

    @Test
    public void shouldAcceptLoginUrlAndToErrorPage() throws Exception {
        when(mockAccountDAOImp.itsPassword("minmin")).thenReturn("bbb");
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/Login?username=minmin&password=aaa"))
                .andExpect(status().is(200))
                .andReturn();
        verify(mockAccountDAOImp,times(1)).hasAccount("minmin");
        verify(mockAccountDAOImp,times(1)).itsPassword("minmin");
        mvcResult.getModelAndView().getViewName().equals("error");
    }

    //  if the function "verify(,)" of ToDoListController is public ,we can use following tests to checked it.

    /*@Test
    public void shouldReturnFalseWhenThereHasNoTheAccount(){
        when(mockAccountDAOImp.hasAccount("minmin")).thenReturn(false);
        Assert.assertFalse(new ToDoListController(mockItemDAOImp,mockAccountDAOImp).varify("minmin","aaa"));
        verify(mockAccountDAOImp,times(1)).hasAccount("minmin");
        verify(mockAccountDAOImp,times(0)).itsPassword("minmin");
    }

    @Test
    public void shouldReturnFalseWhenPasswordWrong(){
        Assert.assertFalse(new ToDoListController(mockItemDAOImp,mockAccountDAOImp).varify("minmin","bbb"));
        verify(mockAccountDAOImp,times(1)).hasAccount("minmin");
        verify(mockAccountDAOImp,times(1)).itsPassword("minmin");
    }

    @Test
    public void shouldReturnTrueWhenThereHasTheAccountAndPasswordRight(){
        Assert.assertTrue(new ToDoListController(mockItemDAOImp,mockAccountDAOImp).varify("minmin","aaa"));
        verify(mockAccountDAOImp,times(1)).hasAccount("minmin");
        verify(mockAccountDAOImp,times(1)).itsPassword("minmin");

    }
*/

}