package com.yettsyjknapp.wordcloud;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class StopWordMap {

	
	private Map<String, Integer> map = new HashMap<>();
	
	private static StopWordMap instance;
	
	private StopWordMap() {
	}
	
	public static StopWordMap getInstance() {
		if(instance == null) {
			instance = new StopWordMap();
		}
		return instance;
	}
	//populate map with words
	public void load(String filename) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename) ));
		String word;
		
		while((word = bufferedReader.readLine())!= null ) {
			if(!map.containsKey(word))
				map.put(word, 0);
		}
		bufferedReader.close();
		
	}
	//delegate job to the map
	public boolean containsKey(Object key) {
	return map.containsKey(key);
	}
	/*TESTING*/
	private void display() {
		for(Map.Entry<String, Integer> word: map.entrySet()) {
			System.out.println(word.getKey()+ " " + word.getValue());
		}
	}
	
}
