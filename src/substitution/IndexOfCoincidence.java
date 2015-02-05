/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package substitution;

/**
 * 
 * @author modified by Donny Dedman...n00816280
 */
import java.util.*;
public class IndexOfCoincidence {
 
    public FrequencyAnalysis ana;
    private final String newline = System.getProperty("line.separator");
 
    public String analyse(String code) {
        ana = new FrequencyAnalysis();
        ana.analyse(code);
 
        double kappaText = computeKappaText();
        double kappaRand = computeKappaRandom();
        double ic = kappaText * amountOfCharacters();
        return "IC: " + ic + newline + newline
                + "kappa text: " + kappaText + newline
                + "kappa random: " + kappaRand + newline + newline
                + "If kappa text is close to kappa random, you probably have a "
                + "polyalphabethic cipher, otherwise a monoalphabetic one";
    }
 
    public double computeKappaRandom() 
    {
        return 1 / (double) ana.getFrequency().size();
    }
   
    public int amountOfCharacters()
    {
        return ana.getFrequency().size();
    }
 
    public double computeKappaText() 
    {
        Map<Character, Integer> frequency = ana.getFrequency();
 
        long n = ana.getSumCount();
        int sumNi = 0;
        for (Integer i : frequency.values()) {
            sumNi += (i * (i - 1));
        }
        return (sumNi / (double) (n * (n - 1)));
    }
 
}