package com.yettsyjknapp.wordcloud;

import java.io.BufferedReader;
import java.io.*;

public interface BufferedReaderParser {
	
	public void parse(BufferedReader in, WordCloudMap wcm) throws IOException;
	
	
}
