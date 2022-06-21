package Model;

import java.util.Dictionary;
import java.util.Hashtable;

public class SaveDataResults {



	public Dictionary<Integer, String> BookOfResults = new Hashtable<Integer, String>();
	
	public SaveDataResults() {
		
	}
	
	public SaveDataResults(Dictionary<Integer, String> bookOfResults) {
		
		BookOfResults = bookOfResults;
	}
}
