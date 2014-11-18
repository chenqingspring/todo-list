package tw.ymxing.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import tw.ymxing.model.Item;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface ItemMapper {
    @Select("select * from todoList where username=#{username}")
    @Results(value = {
            @Result(property="username", column="username"),
            @Result(property="description", column="item")
    })
    public List<Item> getAllItem(String username);

    @Insert("INSERT INTO todoList(username,item) VALUES(#{username},#{description})")
    public void addNewItem(Item item);
}
