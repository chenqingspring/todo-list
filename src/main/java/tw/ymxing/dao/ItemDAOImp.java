package tw.ymxing.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;
import tw.ymxing.model.Item;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ItemDAOImp {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static {
        try {
            reader = Resources.getResourceAsReader("SqlMapConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSessionFactory.getConfiguration().addMapper(ItemMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        ItemDAOImp.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Item> getAllItem(String username) {
        List itemList=new ArrayList<Item>();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ItemMapper itemMapper = session.getMapper(ItemMapper.class);
            itemList = itemMapper.getAllItem(username);
        } finally {
            session.close();
        }
        return itemList;
    }

    public void addNewItem(Item item) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ItemMapper itemMapper = session.getMapper(ItemMapper.class);
            itemMapper.addNewItem(item);
            session.commit();
        } finally {
            session.close();
        }
    }

}
