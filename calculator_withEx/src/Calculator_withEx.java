package calculator_withEx.src;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Calculator_withEx {
    public static String calc(String input) throws ScannerException {
        String[] inputArr = input.split(" ");
        //проверка того, что в массиве 3 символа
        if (inputArr.length != 3) {
            throw new ScannerException("Некорректный ввод.");
            //System.out.println("Некорректный ввод. Прочитай условия еще раз и попробуй снова ввести выражение:");
            //Scanner s = new Scanner(System.in);
            //input = s.nextLine();
            //return calc(input);
        }
        String[] arabicNumerals = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] romanNumerals = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] operations = new String[]{"+", "-", "*", "/"};
        int check1 = 0;
        int check2 = 0;
        boolean check3 = false;
        for (String x : arabicNumerals) {
            if (x.equals(inputArr[0])) {
                check1 += 1;
                break;
            }
        }
        for (String x : arabicNumerals) {
            if (x.equals(inputArr[2])) {
                check2 += 1;
                break;
            }
        }
        for (String x : romanNumerals) {
            if (x.equals(inputArr[0])) {
                check1 += 2;
                break;
            }
        }
        for (String x : romanNumerals) {
            if (x.equals(inputArr[2])) {
                check2 += 2;
                break;
            }
        }
        for (String x : operations) {
            if (x.equals(inputArr[1])) {
                check3 = true;
                break;
            }
        }
        if (!((check1 == check2) && check3)) {
            throw new ScannerException("Некорректный ввод.");
            //System.out.println("Некорректный ввод. Прочитай условия еще раз и попробуй снова ввести выражение:");
            //Scanner s = new Scanner(System.in);
            //input = s.nextLine();
            //return calc(input);
        }
        int result = 0;
        String output = null;
        //сам подсчет
        if (check1 == 1) {
            int value1 = Integer.parseInt(inputArr[0]);
            int value2 = Integer.parseInt(inputArr[2]);
            switch (inputArr[1]) {
                case "+":
                    result = value1 + value2;
                    break;
                case "-":
                    result = value1 - value2;
                    break;
                case "*":
                    result = value1 * value2;
                    break;
                case "/":
                    result = value1 / value2;
                    break;
            }
            output = String.valueOf(result);
        } else if (check2 == 2) {
            int value1 = convRomanToArabian(inputArr[0]);
            int value2 = convRomanToArabian(inputArr[2]);
            /*switch (inputArr[0]) {
                case "I":
                    value1 = 1;
                    break;
                case "II":
                    value1 = 2;
                    break;
                case "III":
                    value1 = 3;
                    break;
                case "IV":
                    value1 = 4;
                    break;
                case "V":
                    value1 = 5;
                    break;
                case "VI":
                    value1 = 6;
                    break;
                case "VII":
                    value1 = 7;
                    break;
                case "VIII":
                    value1 = 8;
                    break;
                case "IX":
                    value1 = 9;
                    break;
                case "X":
                    value1 = 10;
                    break;
            }
            switch (inputArr[2]) {
                case "I":
                    value2 = 1;
                    break;
                case "II":
                    value2 = 2;
                    break;
                case "III":
                    value2 = 3;
                    break;
                case "IV":
                    value2 = 4;
                    break;
                case "V":
                    value2 = 5;
                    break;
                case "VI":
                    value2 = 6;
                    break;
                case "VII":
                    value2 = 7;
                    break;
                case "VIII":
                    value2 = 8;
                    break;
                case "IX":
                    value2 = 9;
                    break;
                case "X":
                    value2 = 10;
                    break;
            }*/

            switch (inputArr[1]) {
                case "+":
                    result = value1 + value2;
                    break;
                case "-":
                    if (value1>value2){
                        result = value1 - value2;
                        break;
                    } else {
                        throw new ScannerException("В римской системе нет отрицательных чисел и нуля.");
                        //System.out.println("В римской системе нет отрицательных чисел и нуля. Попробуй снова ввести выражение:");
                        //Scanner s = new Scanner(System.in);
                        //input = s.nextLine();
                        //return calc(input);
                    }

                case "*":
                    result = value1 * value2;
                    break;
                case "/":
                    if (value1>value2){
                        result = value1 / value2;
                        break;
                    } else {
                        throw new ScannerException("При такой операции получится ноль, а римской системе нуля нет.");
                        //System.out.println("При такой операции получится ноль, а римской системе нуля нет. Попробуй снова ввести выражение:");
                        //Scanner s = new Scanner(System.in);
                        //input = s.nextLine();
                        //return calc(input);
                    }
            }
            /*switch (result){
                case 1:
                    output = "I";
                    break;
                case 2:
                    output = "II";
                    break;
                case 3:
                    output = "III";
                    break;
                case 4:
                    output = "IV";
                    break;
                case 5:
                    output = "V";
                    break;
                case 6:
                    output = "VI";
                    break;
                case 7:
                    output = "VII";
                    break;
                case 8:
                    output = "VIII";
                    break;
                case 9:
                    output = "IX";
                    break;
                case 10:
                    output = "X";
                    break;
                case 11:
                    output = "XI";
                    break;
                case 12:
                    output = "XII";
                    break;
                case 13:
                    output = "XIII";
                    break;
                case 14:
                    output = "XIV";
                    break;
                case 15:
                    output = "XV";
                    break;
                case 16:
                    output = "XVI";
                    break;
                case 17:
                    output = "XVII";
                    break;
                case 18:
                    output = "XVIII";
                    break;
                case 19:
                    output = "XIX";
                    break;
                case 20:
                    output = "XX";
                    break;
                case 21:
                    output = "XXI";
                    break;
                case 24:
                    output = "XXIV";
                    break;
                case 25:
                    output = "XXV";
                    break;
                case 27:
                    output = "XXVII";
                    break;
                case 28:
                    output = "XXVIII";
                    break;
                case 30:
                    output = "XXX";
                    break;
                case 32:
                    output = "XXXII";
                    break;
                case 35:
                    output = "XXXV";
                    break;
                case 36:
                    output = "XXVI";
                    break;
                case 40:
                    output = "XL";
                    break;
                case 42:
                    output = "XLII";
                    break;
                case 45:
                    output = "XLV";
                    break;
                case 48:
                    output = "XLVIII";
                    break;
                case 49:
                    output = "XLIX";
                    break;
                case 50:
                    output = "L";
                    break;
                case 54:
                    output = "LIV";
                    break;
                case 56:
                    output = "LVI";
                    break;
                case 60:
                    output = "LX";
                    break;
                case 63:
                    output = "LXIII";
                    break;
                case 64:
                    output = "LXIV";
                    break;
                case 70:
                    output = "LXX";
                    break;
                case 72:
                    output = "LXXII";
                    break;
                case 80:
                    output = "LXXX";
                    break;
                case 81:
                    output = "LXXXI";
                    break;
                case 90:
                    output = "XC";
                    break;
                case 100:
                    output = "C";
                    break;
            }*/

        } else {
            throw new ScannerException("Некорректный ввод.");
            //System.out.println("Некорректный ввод. Прочитай условия еще раз и попробуй снова ввести выражение:");
            //Scanner s = new Scanner(System.in);
            //input = s.nextLine();
            //return calc(input);
        }
        output = convArabianToRoman(result);
        return output;
    }

    public static void main(String[] args) throws ScannerException {
        System.out.println("Это калькулятор. Для выхода нажмите 'Enter'.");
        Scanner s = new Scanner(System.in);
        System.out.println("Введите данные:");
        String input = s.nextLine();
        String output = new String();
        while (!input.isEmpty()) {
            output = calc(input);
            System.out.println(output);
            System.out.println("Введите следующее выражение:");
            input = s.nextLine();
        }
        System.out.println("Вы вышли из калькулятора");
    }
    public static int convRomanToArabian (String input){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        char [] inputArr = input.toCharArray();
        int s;
        int output = map.get(inputArr[inputArr.length-1]);
        //if (inputArr.length>1){
        for (int i = inputArr.length-2; i >= 0; i--){
            s = map.get(inputArr[i]);
            if (s < map.get(inputArr[i+1])){
                output -= map.get(inputArr[i]);
                //i--;
            }else{
                output += map.get(inputArr[i]);
            }
        }
        //}//else{
        //output = Integer.parseInt(inputArr[inputArr.length-1]);
        //}
        return output;
    }

    public static String convArabianToRoman (int result) {
        TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();
        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(90, "XC");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(40, "XL");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");
        String roman = "";
        int arabianKey;
        do {
            arabianKey = arabianKeyMap.floorKey(result);
            roman += arabianKeyMap.get(arabianKey);
            result -= arabianKey;
        } while (result != 0);
        return roman;
    }
}



class ScannerException extends Exception {
    public ScannerException (String description){
        super(description);
    }
}