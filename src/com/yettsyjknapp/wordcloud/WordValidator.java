package com.yettsyjknapp.wordcloud;

public class WordValidator {
	private static WordValidator instance;

	private WordValidator() {
	}

	public static WordValidator getInstance() {
		if (instance == null) {
			instance = new WordValidator();

		}
		return instance;
	}

	public boolean validate(StringBuilder word, int intChar) {
		char nextChar = (char) intChar;
		/*
		 * if current char is in the range of A-Z or a-z, add it to the word. In case
		 * current char is _ or - or number, check if new word is more than 0 chars
		 * long. Only in that case number or - _ are part of the word
		 */

		if ((nextChar >= 'A' && nextChar <= 'Z') || (nextChar >= 'a' && nextChar <= 'z')
				|| ((nextChar == '_' || nextChar == '-' || nextChar == '\'')
						|| (nextChar >= '0' && (nextChar <= '9')) && (word.length() > 0))) {
			// append char to new word
			word.append(nextChar);
		}

		/*
		 * check for special characters to id if the word is finished new line, spaces
		 * and other special characters including numbers
		 */
		else if ((intChar == 10) // new line
				|| ((intChar >= 32)// between space(ascii and char)
						&& (intChar <= 64))
				|| ((intChar >= 91) && (intChar <= 94)) || (intChar == 96) || ((intChar >= 123) && (intChar <= 126))) {
			// word is finished
			if (word.length() > 0) {
				/* valid word, can be inserted into map */
				return true;
			}

		}
		return false;

	}

}
