package tw.ymxing.services;

import org.springframework.ui.ModelMap;

public interface ItemService {
    void addItem(String inputItem, String username, ModelMap model);
}
