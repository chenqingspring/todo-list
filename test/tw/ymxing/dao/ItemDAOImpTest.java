
package tw.ymxing.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import tw.ymxing.model.Item;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemDAOImpTest {

    private ItemDAOImp itemDaoImp;
    @Mock
    Item item;
    @Mock
    ItemMapper itemMapper;
    @Mock
    SqlSession sqlSession;
    @Mock
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception{
    itemDaoImp=new ItemDAOImp();
    itemDaoImp.setSqlSessionFactory(sqlSessionFactory);
    when(sqlSessionFactory.openSession()).thenReturn(sqlSession);
    when(item.getDescription()).thenReturn("Do homework");
    when(sqlSession.getMapper(ItemMapper.class)).thenReturn(itemMapper);
}

    @Test
    public void getAllItemTest() throws Exception{
        String username="minmin";
        itemDaoImp.getAllItem(username);
        verify(itemMapper, times(1)).getAllItem(username);
    }



    @Test
    public void addNewItemTest() throws Exception{
        itemDaoImp.addNewItem(item);
        verify(itemMapper,times(1)).addNewItem(item);
    }
}