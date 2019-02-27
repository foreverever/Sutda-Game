import domain.User;
import view.InputView;

public class Main {
    public static void main(String[] args) {
        String name = InputView.name();
        User user = new User(name);
    }
}
