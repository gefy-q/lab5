package menu.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.CollectionController;
import model.Dragon;

import java.io.InputStream;

public class AddAction implements Action {
    private CollectionController controller;

    public AddAction(CollectionController controller) {
        this.controller = controller;
    }

    @Override
    public void process(InputStream input) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            controller.add(objectMapper.readValue(input, Dragon.class));
        } catch (Exception e) {
            // TODO
        }
        // TODO
    }
}
