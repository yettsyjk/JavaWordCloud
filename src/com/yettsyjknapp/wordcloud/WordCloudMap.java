package com.yettsyjknapp.wordcloud;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class WordCloudMap {

	private Map< String, Word > map = new HashMap<String, Word>();
	
	//StopWordMap from 
	private StopWordMap stopWordMap;
	
	private BufferedReaderParser bufferedReaderParser;
	
	public WordCloudMap(StopWordMap stopWordFile) throws IOException{
		this.stopWordMap = stopWordFile;
	}
	
	public Word[] generate(String urlOrFile) throws IOException {
		//detect if the url was passed
		if(urlOrFile.substring(0, 4).equals("http") ) {
			populateFromUrl(urlOrFile);
		} else {
			populateFromFile(urlOrFile);
		}
		QuickSortWords qsort = new QuickSortWords(map);//returns sorted array
		return qsort.getSortedArray();
	}
	
	private void populateFromUrl(String urlName) throws IOException {
		
		URL url = new URL(urlName);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()) );
		bufferedReaderParser = new BufferedReaderFileParser();
		
		bufferedReaderParser.parse(in,  this);
		in.close();
		
	}
	
	private void populateFromFile(String fileName) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName) ) );
		bufferedReaderParser = new BufferedReaderFileParser();
		
		bufferedReaderParser.parse(in, this);
		in.close();
	}
	
	
	public void validateWord(String word) {
		//calculated case sensitive
		if(!stopWordMap.containsKey(word.toLowerCase() ) )
			put(word);
	}
	
	private Word put(String key) {
		Word word;
		if(map.containsKey(key) ) {
			word = map.get(key);
			int value = word.getFrequency();
			word.setFrequency(++value);
		} else {
			word = new Word(key);
		}
		return map.put(key, word);
	}
	
	
	
	
}
