
public class Crypto {
	
	private static int shift = 3;

	public static byte[] encrypt(byte[] data, byte[] key) {
		byte[] encData = data; // Variable to hold encrypted text.
		int keyIndex = 0; // Default key index
		key = key != null ? key : new byte[8]; // If no key is provided an empty byte is used as key
		
		// Loop through each byte of the data
		for (int i = 0; i < data.length; i++) {
			keyIndex = i % key.length; // Modulo of the current index and the length of the key always gives a valid index in key.
			int keyValue = key[keyIndex] % 2; // Modulo of the value at key index in key determines shift direction.
			
			if (keyValue == 1) {
				// If the value is not even the shift will be positive. 
				encData[i] = (byte) ((data[i] + shift) < 128 ? data[i] + shift : data[i]);
			} else {
				encData[i] = (byte) ((data[i] - shift) >= 0 ? data[i] - shift : data[i]);
			}
		}
		
		return encData;
	}
	
	public static byte[] decrypt(byte[] data, byte[] key) {
		byte[] decData = data;
		int keyIndex = 0;
		key = key != null ? key : new byte[8];
		
		for (int i = 0; i < data.length; i++) {
			keyIndex = i % key.length;
			int keyValue = key[keyIndex] % 2;
			
			if (keyValue == 0) {
				decData[i] = (byte) ((data[i] + shift) < 128 ? data[i] + shift : data[i]);
			} else {
				decData[i] = (byte) ((data[i] - shift) >= 0 ? data[i] - shift : data[i]);
			}
		}
		
		return decData;
	}
}
