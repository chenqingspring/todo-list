package tw.ymxing.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import tw.ymxing.model.Item;
import tw.ymxing.services.impl.AccountServiceImpl;
import tw.ymxing.services.impl.ItemServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ToDoListControllerTest {
    private MockMvc mockMvc;
    @Mock
    ItemServiceImpl mockItemServiceImpl;
    @Mock
    AccountServiceImpl mockAccountServiceImpl;

    @Before
    public void setUp() throws Exception {
        this.mockMvc=MockMvcBuilders.standaloneSetup(new ToDoListController(mockItemServiceImpl, mockAccountServiceImpl)).build();
    }


    @Test
    public void shouldAcceptShowListUrl() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/homePage"))
                .andExpect(status().is(200));
    }

    @Test
    public void shouldAcceptAddItemUrl() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/addItem?description=''&username=''"))
                .andExpect(status().is(200))
                .andReturn();
    }

    @Test
    public void shouldAcceptLoginUrlAndToLoginPage() throws Exception {
        when(mockAccountServiceImpl.varifyLogin(anyString(),anyString(), (ModelMap) anyObject())).thenReturn(Boolean.TRUE);
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/Login?username=minmin&password=aaa"))
                .andExpect(status().is(200))
                .andReturn();
//        verify(mockAccountDAOImp,times(1)).hasAccount("minmin");
//        verify(mockAccountDAOImp,times(1)).itsPassword("minmin");
        verify(mockAccountServiceImpl,times(1)).varifyLogin(anyString(),anyString(), (ModelMap) anyObject());
        assertEquals("index" , mvcResult.getModelAndView().getViewName());
    }

    @Test
    public void shouldAcceptLoginUrlAndToErrorPage() throws Exception {
        when(mockAccountServiceImpl.varifyLogin(anyString(),anyString(), (ModelMap) anyObject())).thenReturn(Boolean.FALSE);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/Login?username=minmin&password=bbb"))
                .andExpect(status().is(200))
                .andReturn();
//        verify(mockAccountDAOImp,times(1)).hasAccount("minmin");
//        verify(mockAccountDAOImp,times(1)).itsPassword("minmin");
        verify(mockAccountServiceImpl,times(1)).varifyLogin(anyString(),anyString(), (ModelMap) anyObject());
        assertEquals("error" , mvcResult.getModelAndView().getViewName());
    }

    @Test
    public void shouldAcceptRegisertUrl() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Register"))
                .andExpect(status().is(200));
    }

    @Test
    public void shouldAcceptAddAccountUrl() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/addAccount?username=minmin&pwfirst=aaa&pwsecond=aaa"))
                .andExpect(status().is(200))
                .andReturn();
    }
}