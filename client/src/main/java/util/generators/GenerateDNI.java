/*

 Nominal Application
 DNI Utility

 @author     Carlos Pomares
 Date        2021-05-03

*/

package util.generators;

public class GenerateDNI {

    public static boolean validateDNI(String dni) throws ValidationException {
        String numbers = dni.substring(0,8);
        String[] dn = dni.split("");
        try {
            String d = dn[8];
        } catch (IndexOutOfBoundsException indexOutOfBoundsException){
            throw new ValidationException("Doesn't have letter.");
        }
        return getLetter(Integer.parseInt(numbers)).equals(dn[8].toLowerCase());
    }

    public static String generateDNI(){
        String numbers = "";
        numbers = generateNumbers();
        return (numbers + getLetter(Integer.parseInt(numbers)));
    }

    private static String generateNumbers(){
        String dni = "";
        for (int j = 0; j < 8; j++) {
            int random = (int)(Math.random() * 9 + 1);
            dni += String.valueOf(random);
        }
        return dni;
    }

    private static String getLetter(int sum){
        String letter = "";
        switch (sum % 23){
            case 0:
                letter = "t";
                break;
            case 1:
                letter = "r";
                break;
            case 2:
                letter = "w";
                break;
            case 3:
                letter = "a";
                break;
            case 4:
                letter = "g";
                break;
            case 5:
                letter = "m";
                break;
            case 6:
                letter = "y";
                break;
            case 7:
                letter = "f";
                break;
            case 8:
                letter = "p";
                break;
            case 9:
                letter = "d";
                break;
            case 10:
                letter = "x";
                break;
            case 11:
                letter = "b";
                break;
            case 12:
                letter = "n";
                break;
            case 13:
                letter = "j";
                break;
            case 14:
                letter = "z";
                break;
            case 15:
                letter = "s";
                break;
            case 16:
                letter = "q";
                break;
            case 17:
                letter = "v";
                break;
            case 18:
                letter = "h";
                break;
            case 19:
                letter = "l";
                break;
            case 20:
                letter = "c";
                break;
            case 21:
                letter = "k";
                break;
            case 22:
                letter = "e";
                break;
        }
        return letter;
    }

}
