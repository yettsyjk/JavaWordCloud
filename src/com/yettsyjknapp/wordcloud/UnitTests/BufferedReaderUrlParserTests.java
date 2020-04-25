package com.yettsyjknapp.wordcloud.UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yettsyjknapp.wordcloud.StopWordMap;
import com.yettsyjknapp.wordcloud.WordCloudMap;

class BufferedReaderUrlParserTests {

private URL url;
	
	private BufferedReader in;
	private WordCloudMap wcm;
	
	private Exception exception;
	
	@BeforeEach
	public void setup() throws IOException{
		url = new URL("https://en.wikipedia.org/wiki/Tag_cloud");
		in = new BufferedReader(new InputStreamReader(url.openStream()));
		wcm = new WordCloudMap(StopWordMap.getInstance());
	}
	
	
	
	
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	url = null;
	in = null;
	wcm = null;
	exception = null;
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
