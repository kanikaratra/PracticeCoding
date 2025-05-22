package Java8;

import java.util.Locale;

interface Parser{
    String parse(String str);
}

class Printer{
    public void print(String str, Parser p){
        str = p.parse(str); // what use?
        System.out.println(str);
    }
}

class StringParser{
    public static String convert(String str){
        if(str.length() <=3)
            str = str.toLowerCase();
        else
            str = str.toUpperCase();

        return str;
    }
}

public class MethodRef {
    public static void main(String[] args) {

        String str = "Kanika";
        Printer mp = new Printer();
        mp.print(str, StringParser::convert);
        //create obj of StringParser if not static
    }
}
