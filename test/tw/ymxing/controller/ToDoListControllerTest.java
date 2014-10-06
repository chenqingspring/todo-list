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
import tw.ymxing.dao.ItemDAOImp;
import tw.ymxing.model.Item;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ToDoListControllerTest {
    private MockMvc mockMvc;
    @Mock
    ItemDAOImp mockItemDAOImp;
    @Mock
    Item item;

    @Before
    public void setUp() throws Exception {
        List ItemList=new ArrayList<Item>();

        when(mockItemDAOImp.getAllItem()).thenReturn(ItemList);
        this.mockMvc=MockMvcBuilders.standaloneSetup(new ToDoListController(mockItemDAOImp)).build();

    }


    @Test
    public void shouldAcceptShowListUrl() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/todo"))
                .andExpect(status().is(200));
    }

    @Test
    public void shouldAcceptAddLItemUrl() throws Exception {
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/addItem?description=''"))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Items"))
                .andReturn();
        Assert.assertNotNull(mvcResult.getModelAndView().getModel().get("Items"));
    }

}