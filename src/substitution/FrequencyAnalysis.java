/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package substitution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author modified by Donny Dedman n00816280 for Network Security course at University of North Florida
 * 
 */
public class FrequencyAnalysis 
{

public Map<Character, Integer> frequency;
    //private Language language;
 
    public String analyse(String code) {
        frequency = new HashMap<>();
        count(code);
        return getAnalysisString();
    }
   
    public Map<Character, Integer> getFrequency(){
        return new HashMap<>(frequency);
    }
 
    private String getAnalysisString() {
        StringBuilder b = new StringBuilder();
        long sumcount = getSumCount();
        b.append("Char\tAbs\tRel\n");
        for (Character c : getSortedKeyList()) {
            b.append(c).append("\t").append(frequency.get(c)).append("\t").append(frequency.get(c) / (double) sumcount).append("\n");
        }
        b.append("\nletters: ").append(sumcount);
        b.append("\ncharacters: ").append(frequency.size());
        return b.toString();
    }
 
        //insertion sort is used here
    private List<Character> getSortedKeyList() {
        List<Character> list = new LinkedList<>();
        for(Entry<Character, Integer> entry : frequency.entrySet()){
            for(int i = 1; i < list.size(); i++){
                if(frequency.get(list.get(i)) > entry.getValue()){
                    list.add(i, entry.getKey());
                    break;
                }
            }
            if(!list.contains(entry.getKey())){
                list.add(entry.getKey());
            }
        }
        return list;
    }
 
    public long getSumCount() {
        long sum = 0;
        for (Integer i : frequency.values()) {
            sum += i;
        }
        return sum;
    }
 
    private void count(String code) {
        char[] text = code.toCharArray();
        for (char c : text) {
            if (frequency.containsKey(c)) {
                frequency.put(c, frequency.get(c) + 1);
            } else {
                frequency.put(c, 1);
            }
        }
    }
}
