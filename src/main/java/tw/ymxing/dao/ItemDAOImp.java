package tw.ymxing.dao;

import org.springframework.stereotype.Repository;
import tw.ymxing.model.Item;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ItemDAOImp implements ItemDAO {
    List<Item> ItemList=new ArrayList<>();

    @Override
    public List<Item> getAllItem() {
        return ItemList;
    }

    @Override
    public void addNewItem(Item item) {
        ItemList.add(item);
    }
}
