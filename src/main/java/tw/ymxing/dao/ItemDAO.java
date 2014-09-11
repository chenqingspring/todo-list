package tw.ymxing.dao;

import tw.ymxing.model.Item;

import java.util.List;

public interface ItemDAO {
    public List<Item> getAllItem();
    public int addNewItem(Item item);
}
