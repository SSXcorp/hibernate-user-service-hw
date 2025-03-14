package mate.academy.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import mate.academy.exception.DataProcessingException;

public class HashUtil {

    private static final String CRYPTO_ALGORITHM = "SHA-512";

    private HashUtil() {
    }

    public static byte[] getSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public static String hashPassword(String password, byte[] salt) {
        StringBuilder hashedPassword = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(CRYPTO_ALGORITHM);
            messageDigest.update(salt);
            byte[] hashedPasswordBytes = messageDigest.digest(password.getBytes());
            for (byte b : hashedPasswordBytes) {
                hashedPassword.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException e) {
            throw new DataProcessingException("Could not create hash using SHA-512 algorithm", e);
        }
        return hashedPassword.toString();
    }
}
