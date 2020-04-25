package com.yettsyjknapp.wordcloud;

import java.io.BufferedReader;
import java.io.IOException;

public class BufferedReaderUrlParser implements BufferedReaderPArser {

	@Override
	public void parse(BufferedReader in, WordCloudMap wcm) throws IOException {
		StringBuilder word = new StringBuilder();

		WordValidator wordValidator = WordValidator.getInstance();
		// body part
		boolean bodyPart = false;
		boolean tag = true;
		int intChar;

		while ((intChar = in.read()) != -1) {
			char nextChar = (char) intChar;// downcast char

			// if we haven't got the bodyPart yet
			if (!bodyPart) {
				if (nextChar == '<' || nextChar == 'b' || nextChar == 'o' || nextChar == 'd' || nextChar == 'y') {
					// concat the string
					word.append(nextChar);

					if (new String("<body").equals(word.toString())) {
						bodyPart = true;
					}
				} else {
					word.setLength(0);
				}
			} else {
				// after getting body part, strip tags and populate map
				if (tag) {
					if (nextChar == '>') {
						tag = false;
						word.setLength(0);
					} else {

					}
					if (nextChar == '<') {
						tag = true;
						word.setLength(0);

					} else {
						// if it is not start of the tag then it is text
						if (wordValidator.validate(word, intChar)) {
							// insert into map
							wcm.validateWord(word.toString());
							// remove previous word
							word.setLength(0);
						}
					}
				}

			}
		}
	}
}
