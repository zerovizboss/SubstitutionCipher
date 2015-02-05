/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substitution;

import java.io.*;
/**
 *
 * @author modified by Donald Dedman
 * @author original source code can be found at www.sanfoundry.com
 */

public class SubstitutionDriver
{    
    
    public static void main(String args[])throws IOException
    {
        BufferedReader reader;
        FrequencyAnalysis fa;
        IndexOfCoincidence ioc;
        PolyAlphaCipher paCipher;
        String filename = "C:\\Users\\Donald\\Documents\\College\\College Materials\\Prose.txt";
        String key = "S3Cr3Tk3y";
        String encrypted, faPlain, faEncrypted, txtPlain, iocPlain, iocEncrypt, paEncrypt, paDecrypt;
        
        try{
            reader = new BufferedReader(new FileReader(filename));
            txtPlain = reader.readLine();
            System.out.println("Plaintext Message: " + txtPlain + "\n");
            encrypted = MonoalphabeticCipher.doEncryption(txtPlain.toLowerCase());
            fa = new FrequencyAnalysis();
            faPlain = fa.analyse(filename);
            System.out.println("Plaintext Frequency Analysis\n" + faPlain);
            System.out.println("\nEncrypted message: " + encrypted);
            faEncrypted = fa.analyse(encrypted);
            System.out.println("\nEncrypted Frequency Analysis \n" + faEncrypted);
            System.out.println("\nDecrypted message: " + MonoalphabeticCipher.doDecryption(encrypted));
            
            ioc = new IndexOfCoincidence();
            iocPlain = ioc.analyse(txtPlain);
            iocEncrypt = ioc.analyse(encrypted);
            System.out.println("\n\nIndex of Coincidence for Plaintext: " + iocPlain);
            System.out.println("\nIndex of Coincidence after Encryption: " + iocEncrypt);
            
            paCipher = new PolyAlphaCipher();
            paEncrypt = paCipher.encrypt(txtPlain, key);
            paDecrypt = paCipher.decrypt(paEncrypt, key);
            System.out.println("\n\nPlaintext Message: " + txtPlain);
            System.out.println("\nEncrypted Message: " + paEncrypt);
            System.out.println("\nDecrypted Message: " + paDecrypt);
            
            
        } 
        
        catch(IOException ioException)
        {
            System.out.print("Error reading file" + ioException);
        }
    }//end Main 
}


