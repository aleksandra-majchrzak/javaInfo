import java.util.ListResourceBundle;

/**
 * Created by Mohru on 03.01.2017.
 */
public class Strings_de extends ListResourceBundle {

    static final Object[][] contents = {
            {"username", "username_de"},
            {"password", "password_de"},
            {"login", "login_de"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
