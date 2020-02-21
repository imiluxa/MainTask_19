package Controller;

public interface Regex {

    String REGEX_NUMBER = "[1-5]";
    String REGEX_NUMBERS = "[1-9]{1,4}$";
    String REGEX_LANGUAGE = "[1-2]";
    String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";

}
