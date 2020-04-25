package com.yettsyjknapp.wordcloud;

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
	}
	
}
