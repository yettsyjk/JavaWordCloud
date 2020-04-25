package com.yettsyjknapp.wordcloud;
/*
 * QuickSort tutorial from https://www.vogella.com/tutorials/java.html
 * 
 * 
 * 
 * */




import java.util.Map;

public class QuickSortWords {
	private Word[] words;
	
	public QuickSortWords(Map<String, Word> map) {
		words = new Word[map.size()];
		
		referenceToArray(map);
		quicksort(0, map.size() -1);
	}
	
	public Word[] getSortedArray() {
		return words;
	}
	
	private void referenceToArray(Map<String, Word> map ) {
		int counter = 0;
		
		for(Map.Entry<String, Word> entry : map.entrySet()) {
			words[counter++] = entry.getValue();
			}
	}
	//display() from QuickSOrt is not used locally
	private void display() {
		for(int i =0; i <words.length; i++) {
			System.out.println(words[i].getWord() + " " + words[i].getFrequency() + "\n");
		}
	}
	private void quicksort(int low, int high) {
		int i = low, j = high;
		int pivot = words[low + (high - low) /2].getFrequency();
		//if the current value from the left list is smaller 
		while(i <= j) {
			
			while(words[i].getFrequency() < pivot) {
				i++;
			}
			
			while(words[j].getFrequency() > pivot) {
				j--;
			}
			
			if(i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		
		//recursive method
		if(low < j) {
			quicksort(low, j);
		}
		if(i < high) {
			quicksort(i, high);
		}
	}
	private void exchange(int i, int j) {
		Word word = words[i];
		words[i] = words[j];
		 words[j] = word;
	}
	
	
	
}
