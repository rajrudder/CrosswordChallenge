package View;

public class DisplayResults {
	
	public void checkState(String word, String buildWord,String saveFirstPosition,String saveLastPosition) {
		
		if (buildWord.equals(word))
		{
					 
			 System.out.println(buildWord + " " + saveFirstPosition + " " + saveLastPosition);
			 
		}
		
	}
	
	

}
