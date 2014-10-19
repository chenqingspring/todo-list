package tw.ymxing.services;

import org.springframework.ui.ModelMap;
import tw.ymxing.dao.ItemDAOImp;

public interface ItemService {
    void addItem(String inputItem, String username, ModelMap model);
}
