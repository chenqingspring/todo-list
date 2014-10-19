package tw.ymxing.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;
import tw.ymxing.dao.ItemDAOImp;
import tw.ymxing.model.Item;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceImplTest {
    private ItemServiceImpl itemService;
    @Mock
    ModelMap mockModel;
    @Mock
    ItemDAOImp mockItemDAOImp;
    List ItemList=new ArrayList<Item>();

    @Before
    public void setUp(){
        itemService = new ItemServiceImpl();
        itemService.setItemDAOImp(mockItemDAOImp);
        when(mockItemDAOImp.getAllItem(anyString())).thenReturn(ItemList);
    }

    @Test
    public void shouldAddAnItem(){
        itemService.addItem(null, "minmin", mockModel);
        verify(mockItemDAOImp,times(1)).addNewItem((Item) anyObject());
        verify(mockModel, times(1)).addAttribute("Items",ItemList);
        verify(mockModel,times(1)).addAttribute("username", "minmin");
    }
}