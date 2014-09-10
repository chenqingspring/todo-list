package tw.ymxing.dao;

import org.springframework.stereotype.Component;
import tw.ymxing.model.Item;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class ItemDAOImp implements ItemDAO {

    private DataSource dataSource;


    public DataSource getDataSource() {
        return dataSource;
    }
    @Resource
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Item> getAllItem() {
        List ItemList=new ArrayList<Item>();
        try{
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("select item from todoList");
            while (rs.next()){
                Item item=new Item();
                item.setDescription(rs.getString(1));
                ItemList.add(item);
            }
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ItemList;
    }

    @Override
    public void addNewItem(Item item) {
        try{
            Connection conn = dataSource.getConnection();
            String sql="insert into todoList values ( \'"+item.getDescription()+"\')";
            conn.createStatement().executeUpdate(sql);
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
