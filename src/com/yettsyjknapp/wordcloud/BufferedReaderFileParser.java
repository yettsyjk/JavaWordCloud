package com.yettsyjknapp.wordcloud;

import java.io.BufferedReader;
import java.io.*;

public class BufferedReaderFileParser implements BufferedReaderParser {

	@Override
	public void parse(BufferedReader in, WordCloudMap wcm) throws  {
		
		
		StringBuilder word = new StringBuilder();
		WordValidator wordValidator = WordValidator.getInstance();
		
		
		int intChar;
		while( (intChar = in.read() != -1 )) {
			
			if(wordValidator.validate(word, intChar) ) {
				wcm.validateWord(word.toString());
				
				word.setLength(0);
				
			}
		}
	}

}
