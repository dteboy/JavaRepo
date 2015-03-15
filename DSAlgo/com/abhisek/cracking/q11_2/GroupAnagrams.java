package com.abhisek.cracking.q11_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagrams{
	public static String sortString(String pString){
		char[] content = pString.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	public static class AnagramComparator implements Comparator<String>{
		@Override
		public int compare(String pString1, String pString2){
			return sortString(pString1).compareTo(sortString(pString2));
		}		
	}
	public static void sortAnagrams(String[] pStrings){
		Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
		for(String string : pStrings){
			String sortedString = sortString(string);
			List<String> anagramGroup = anagramMap.get(sortedString);
			if(anagramGroup == null){
				anagramGroup = new ArrayList<String>();
			}
			anagramGroup.add(string);
			anagramMap.put(sortedString, anagramGroup);
		}
		int index = 0;
		for(Map.Entry<String, List<String>> entry : anagramMap.entrySet()){
			List<String> anagramGroup = entry.getValue();
			Collections.sort(anagramGroup);
			for (String anagram : anagramGroup){
				pStrings[index++] = anagram;
			}
		}
	}
	public static void main(String... args){
	
		String[] anagrams = {"resistance", "paternal", "dreads", "admirer", "creative", "parental", "sadder"};
		//Arrays.sort(anagrams, new AnagramComparator());
		sortAnagrams(anagrams);
		System.out.println(Arrays.asList(anagrams));
	}
}