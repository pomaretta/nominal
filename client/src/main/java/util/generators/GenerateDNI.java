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
        String letters = "TRWAGMYFPDXBNJZSQVHLCKET";
        int rest = sum % 23;
        return letters.substring(rest,rest + 1).toLowerCase();
    }

}
