package View;

import java.util.Locale;
import java.util.ResourceBundle;

import static View.Constant_String.INPUT_STRING_DATA;

public class View {

    private Locale locale = new Locale("en");
    private ResourceBundle bundle =
            ResourceBundle.getBundle(
                    "messages", locale);

    public void printMessage(String message){
        System.out.println(bundle.getString(message));
    }

    public void print(String message){
        System.out.println(message);
    }

    public void printStringInput() {
        printMessage(bundle.getString(INPUT_STRING_DATA));
    }

    public void setLocale(Locale locale){
        this.bundle = ResourceBundle.getBundle(
                "messages", locale);
    }


}
