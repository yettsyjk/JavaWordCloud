package com.yettsyjknapp.wordcloud;

import java.awt.Color;
import java.awt.Font;

public class Word {
	public static int MAX_FONT_SIZE = 100;
	public static int[] FONT_TYPE = {Font.PLAIN, Font.ITALIC, Font.BOLD};
	
	public static String[] FONT_STYLE = { Font.SANS_SERIF, Font.MONOSPACED };
	
	public static Color[] TEXT_COLOR =  { Color.BLACK, Color.GRAY, Color.GREEN };
	
	public String word;
	private int frequency;
	private Font font;
	private Color color;
	private int fontSize;
	private int textWidth;
	
	public Word(String _word) {
		word = _word;
		frequency = 1;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public int getTextWidth() {
		return textWidth;
	}

	public void setTextWidth(int textWidth) {
		this.textWidth = textWidth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((font == null) ? 0 : font.hashCode());
		result = prime * result + fontSize;
		result = prime * result + frequency;
		result = prime * result + textWidth;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (font == null) {
			if (other.font != null)
				return false;
		} else if (!font.equals(other.font))
			return false;
		if (fontSize != other.fontSize)
			return false;
		if (frequency != other.frequency)
			return false;
		if (textWidth != other.textWidth)
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Word [Word = " + word + ", frequency = " + frequency + ", font = " + font + ", color = " + color + ", fontSize = "
				+ fontSize + ", textWidth = " + textWidth + "]";
	}
	
	
	
	
	
	
	
}
