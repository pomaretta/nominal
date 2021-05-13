package util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {

    public static String getMD5(String input)
            throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger no = new BigInteger(1,messageDigest);
        String hashText = no.toString(16);
        while(hashText.length() < 32){
            hashText = "0" + hashText;
        }
        return hashText;
    }

}
