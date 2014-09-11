
package tw.ymxing.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import tw.ymxing.model.Item;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemDAOImpTest {

    private ItemDAOImp itemDaoImp;
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

    @Before
    public void setUp() throws Exception{
    itemDaoImp=new ItemDAOImp();
    itemDaoImp.setDataSource(dataSource);
    when(dataSource.getConnection()).thenReturn(connection);
    when(connection.createStatement()).thenReturn(statement);
    when(statement.executeQuery("select item from todoList")).thenReturn(resultSet);
    when(item.getDescription()).thenReturn("Do homework");
}

    @Test
    public void getAllItemTest() throws Exception{
        itemDaoImp.getAllItem();
        verify(statement,times(1)).executeQuery("select item from todoList");
    }



    @Test
    public void addNewItemTest() throws Exception{
        itemDaoImp.addNewItem(item);
        verify(statement,times(1)).executeUpdate("insert into todoList values ('Do homework')");
    }
}