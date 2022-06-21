package Model;

import java.util.Hashtable;
import java.util.Map;

public class LoadInputDataTest {
	public int row =0;
	public int col =0;
	
    public Map<Integer, String> BookOfWords = new Hashtable<Integer, String>();
			


	public char [][] GridArray = new char[0][0];
    
	public void LoadInputData() {
		
	}
	
	    public void LoadInputData(int row, int col, Map<Integer, String> bookOfWords, char[][] gridArray) {
		
		this.row = row;
		this.col = col;
		BookOfWords = bookOfWords;
		GridArray = gridArray;
	}

	public void LoadInputData(int row, int col, Map<Integer, String> bookOfWords) {
		
		this.row = row;
		this.col = col;
		BookOfWords = bookOfWords;
	}
}
