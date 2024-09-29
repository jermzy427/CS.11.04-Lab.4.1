public class Main {


    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String par) {
        if (!par.substring(0, 1).equals("(")) {
            return false;
        }

        int numberOfOP = 1;
        for (int i = 1; i < par.length(); i++) {
            if (par.substring(i, i + 1).equals("(")) {
                numberOfOP++;
            } else {
                if (par.substring(i, i + 1).equals(")")) {
                    if (numberOfOP < 0) {
                        return false;
                    }
                    numberOfOP--;

                }
            }
        }

        if (numberOfOP != 0) {
            return false;
        }

        return true;
    }


    // 2. reverseInteger
    public static String reverseInteger(int a) {
        String result = "";
        String num = Integer.toString(a);
        for (int i = 1; i <= num.length(); i++) {
            result = result + num.substring(num.length() - i, num.length() - i + 1);
        }
        return result;
    }

    // 3. encryptThis
    public static String encryptThis(String str) {
        int startOfWordPos = 0;
        int endOfWordPos = 0;
        String result = "";
        char temp = 'a';
        str += " ";
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals(" ")) {
                String word = str.substring(startOfWordPos, i);

                startOfWordPos = i + 1;
                String tempResult = "";
                String nstring = "";
                for (int j = 0; j < word.length(); j++) {
                    if (j == 0) {
                        int n = word.charAt(0);
                        nstring = Integer.toString(n);
                    }
                    if (j == 1) {
                        if (word.length() >= 3) {
                            temp = word.charAt(1);
                            tempResult = word.substring(0, 1) + word.substring(word.length() - 1, word.length()) +
                                    word.substring(2, word.length() - 1) + temp;

                            tempResult = nstring + tempResult.substring(1, tempResult.length());

/*
                    tempResult = String.valueOf(word.charAt(word.length()-1));
                    System.out.println(tempResult);

                    tempResult += word.substring(nstring.length()-1, word.length()-1);
                    System.out.println(tempResult);
*/
                            //tempResult += temp;
                        } else {
                            tempResult = nstring + word.substring(1);

                        }
                    }

                }
                result += tempResult + " ";
                word = "";
            }
        }

        return result.trim();
    }

    // 4. decipherThis
    public static String decipherThis(String str) {

        int startOfWordPos = 0;
        int endOfWordPos = 0;
        String result = "";
        char temp = 'a';
        str += " ";
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals(" ")) {
                String word = str.substring(startOfWordPos, i);
                startOfWordPos = i + 1;
                String tempResult = "";
                int endOfDigitPos = 0;

                for (int j =0; j< word.length(); j++) {
                    if (Character.isDigit(word.charAt(j))){
                        endOfDigitPos++;
                    }
                }

                int theDigit = Integer.parseInt(word.substring(0, endOfDigitPos));
                char theLetter = (char)theDigit;
                temp = word.charAt(endOfDigitPos);

                if(word.substring(endOfDigitPos,word.length()).length()>1)
                tempResult = theLetter + word.substring(word.length()-1,word.length())+
                        word.substring(endOfDigitPos+1, word.length()-1) +temp;
                else{
                    tempResult = theLetter + word.substring(word.length()-1,word.length());
                }
            result += tempResult + " ";


            }

            }
        return result.trim();
    }
}