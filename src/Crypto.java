import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {

	public static byte[] encrypt(byte[] data, String password) throws Exception {
		SecretKey secretKey = genSecretKeySpec(password);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		return cipher.doFinal(data);
	}

	public static byte[] decrypt(byte[] data, String password) throws Exception {
		SecretKey secretKey = genSecretKeySpec(password);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		return cipher.doFinal(Base64.getDecoder().decode(data));
	}

	private static SecretKey genSecretKeySpec(String password) {
		MessageDigest shaMD = null;
		SecretKey secretKey = null;
		byte[] key;
		try {
			key = password.getBytes("UTF-8");
			shaMD = MessageDigest.getInstance("SHA-512");
			key = shaMD.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return secretKey;
	}

	public static String encryptString(String data, String password) {
		try {
			return new String(Base64.getEncoder().encodeToString(encrypt(data.getBytes("UTF-8"), password)));
		} catch (Exception e) {
			e.printStackTrace();
			return "Error! Something went wrong with the encryption.";
		}
	}

	public static String decryptString(String data, String password) {
		try {
			return new String(decrypt(data.getBytes("UTF-8"), password), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return "Error! Something went wrong with the Decryption. Make sure to use the right key.";
		}
	}
}
