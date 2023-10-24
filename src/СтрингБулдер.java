import java.util.Scanner;

public class СтрингБулдер {
    public static void main(String[] args) throws Exception {
        System.out.println("Длина строки  не должна превышать 10 символов и числа не более 10  ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (input.contains("+")) {
            getResultPlus(input);
        } else if (input.contains("-")) {
            getResultMinus(input);
        } else if (input.contains("*")) {
            try {
                getResultMulti(input);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if (input.contains("/")) {
            try {
                getResultDivision(input);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            throw new Exception("Неподдерживаемая операция");

        }

    }
    public static void invertedCommas (String string){
        System.out.print("\"" + string + "\"");
    }
    public static void removeQuotes (String[]data){
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }
    }
    public static void remove (String[]data){
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace(" ", "");
        }
    }

    public static void getResultPlus (String input  ) throws Exception {
        String[] data = input.split("\\+");
        if (data[0].length()>13||data[1].length()>13){
            throw new Exception("Длина строки не должна превышать 10 символов  ");
        }
        removeQuotes(data);
        remove(data);
        invertedCommas(data[0] + data[1]);
    }
    public static void getResultMinus (String input) throws Exception {
        String[] data = input.split("\" - \"");// Для примеров типа "Bye-Bye" - " "
        if (data[0].length()>11||data[1].length()>11){
            throw new Exception("Длина строки не должна превышать 10 символов  ");
        }
        removeQuotes(data);
        int index = data[0].indexOf(data[1]);
        if (index == -1) {
            System.out.println(data[0]);
        } else {
            String result = data[0].substring(0, index);
            result += data[0].substring(index + data[1].length());
            invertedCommas(result);
        }
    }
    public static String getResultMulti (String input) throws Exception {

        String[] data = input.split("\\*");
        if (data[1].contains("\"")){
            throw new Exception("Строку нельзя делить или умножать на строку ");
        }
        if (data[0].length()>13){
            throw new Exception("Длина строки не должна превышать 10 символов  ");
        }
        removeQuotes(data);
        remove(data);
        int multi = Integer.parseInt(data[1]);
        if (multi>10){
            throw new Exception(" Число не должно превышать 10 ");
        }
        String result = "";
        for (int i = 0; i < multi; i++) {
            result += data[0];
        }
        if (result.length()>40){
            result = result.substring(0,40);
            result+="...";
        }
        invertedCommas(result);
        return result;
    }
    public static void getResultDivision (String input) throws Exception {
        String[] data = input.split("/");
        if (data[0].length()>13){
            throw new Exception("Длина строки не должна превышать 10 символов  ");
        }
        removeQuotes(data);
        remove(data);
        if (data[1].contains("\"")){
            throw new Exception("Строку нельзя делить или умножать на строку ");
        }
        removeQuotes(data);
        remove(data);
        int multi = Integer.parseInt(data[1]);
        if (multi>10){
            throw new Exception(" Число не должно превышать 10 ");
        }
        invertedCommas(data[0].substring(0, data[0].length() / multi));


    }

}
