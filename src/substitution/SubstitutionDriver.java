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
    
    String filename = "C:\\Users\\Donald\\Documents\\College\\College Materials\\Prose.txt";

    public static void main(String args[])throws IOException
    {
        BufferedReader reader;
        FrequencyAnalysis fa;
        IndexOfCoincidence ioc;
        String filename = "C:\\Users\\Donald\\Documents\\College\\College Materials\\Prose.txt";
        String encrypted, faPlain, faEncrypted, txtPlain;
        
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
            
        } 
        
        catch(IOException ioException)
        {
            System.out.print("Error reading file" + ioException);
        }
    }//end Main 
}


