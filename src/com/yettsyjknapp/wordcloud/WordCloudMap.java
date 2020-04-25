package com.yettsyjknapp.wordcloud;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;


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
		QuickSortWords qsort = new QuickSortWord(map);//returns sorted array
		return q.sort.getSortedArray();
	}
	
	
	
	
	
	
	
}
