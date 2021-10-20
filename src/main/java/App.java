import Controller.ItemController;
import Dao.EventLogDao;
import Dao.ItemDao;
import UI.UserConsoleInterface;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        ItemController controller = new ItemController(new UserConsoleInterface(), new ItemDao(), new EventLogDao());
        controller.run();
    }
}
