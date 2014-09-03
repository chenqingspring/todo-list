package tw.ymxing.controller;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tw.ymxing.dao.ItemDAOImp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ToDoListControllerTest {

    ItemDAOImp itemDAOImp;

    @Before
    public void setUp() throws Exception {
        itemDAOImp=new ItemDAOImp();
    }


    @Test
    public void shouldAcceptShowListUrl() throws Exception {
        MvcResult result=MockMvcBuilders.standaloneSetup(new ToDoListController(itemDAOImp))
                .build()
                .perform(MockMvcRequestBuilders.get("/todo"))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Items"))
                .andReturn();
        Assert.assertNotNull(result.getModelAndView().getModel().get("Items"));
    }
}