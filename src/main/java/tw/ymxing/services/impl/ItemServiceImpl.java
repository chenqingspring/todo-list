package tw.ymxing.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import tw.ymxing.dao.ItemDAOImp;
import tw.ymxing.model.Item;
import tw.ymxing.services.ItemService;
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemDAOImp itemDAOImp;

    public void setItemDAOImp(ItemDAOImp itemDAOImp) {
        this.itemDAOImp = itemDAOImp;
    }

    @Override
    public  void addItem(String inputItem, String username, ModelMap model) {
        Item item=new Item();
        item.setDescription(inputItem);
        item.setUsername(username);
        itemDAOImp.addNewItem(item);
        model.addAttribute("Items",itemDAOImp.getAllItem(username));
        model.addAttribute("username",username);
    }
}
