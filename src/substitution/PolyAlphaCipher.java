/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package substitution;

/**
 * 
 * @author modified by Donny Dedman...n00816280
 * @author http://javapapers.com/java/simple-encryption-decryption-with-modulo-26-polyalphabetic-cipher/
 */
public class PolyAlphaCipher 
{
    
    public StringBuffer encryptedString, strDecryption;
    private int secretKeyInt, plainTextInt, encryptedInt;
    private int decryptionInt, decryptionTextInt;
    
    
        public String encrypt(String plainText, String secretKey) 
        {
		encryptedString = new StringBuffer();                
		for (int i = 0; i < plainText.length(); i++) 
                {
			plainTextInt = (int) (plainText.charAt(i) - 'A');
			secretKeyInt = (int) (secretKey.charAt(i) - 'A');
			encryptedInt = (plainTextInt + secretKeyInt) % 26;
			encryptedString.append((char) ((encryptedInt) + (int) 'A'));
		}
                
		return encryptedString.toString();
	}

	public String decrypt(String decryptionText, String secretKey) 
        {
		strDecryption = new StringBuffer();
		for (int i = 0; i < decryptionText.length(); i++) 
                {
			decryptionTextInt = (int) (decryptionText.charAt(i) - 'A');
			secretKeyInt = (int) (secretKey.charAt(i) - 'A');
			decryptionInt = decryptionTextInt - secretKeyInt;
			if (decryptionInt < 1)
				decryptionInt += 26;
			strDecryption.append((char) ((decryptionInt) + (int) 'A'));
		}
		return strDecryption.toString();
	}
}
