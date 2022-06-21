package Model;

import java.util.Dictionary;
import java.util.Hashtable;

public class SaveDataResultsTest {


	public Dictionary<Integer, String> BookOfResults = new Hashtable<Integer, String>();
	
	public void SaveDataResults() {
		
	}
	
	public void SaveDataResults(Dictionary<Integer, String> bookOfResults) {
		
		BookOfResults = bookOfResults;
	}
	
}
