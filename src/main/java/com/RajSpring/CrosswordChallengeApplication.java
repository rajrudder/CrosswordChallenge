package com.RajSpring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Hashtable;
import java.util.Map;
import java.awt.FileDialog;
import java.awt.Frame;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import Model.LoadInputData;
import View.DisplayResults;

@SpringBootApplication
public class CrosswordChallengeApplication implements IControlLookup {

	public static void main(String[] args) {
		/*
		 * RRUDDER - 06/21/2022 - CREATE PROCESS TO LOAD A TEXT CROSSWORD PUZZLE TEXT FILE 
		 * OUTPUT COORDINATE RESULTS BASED ON LIST OF WORDS EMBEDED IN THE FILE 
		 */
		
		//start crossword challenge by loading data from a file
		LoadInputData loadData = readFile();
		//load list of words to search into Table
		Map<Integer,String> load =  new Hashtable<Integer, String>(); 
		load = loadData.BookOfWords;

		//iterate through the list of words
	    ArrayList<Integer> keys = new ArrayList<Integer>(load.keySet());
	    for(int i=keys.size()-1; i>=0;i--){
	        FindLetter(loadData.GridArray,load.get(keys.get(i)));
	    }
		
	}

	

	 static void FindLetter(char[][] grid,String word)
	 {
	    //set parameters from passed in grid and search word
	     char match = word.charAt(0);
	     int gridRows = grid.length;
	     int gridColumns = grid[0].length;
	     String savePositions = "";
	     int firstLetterCol =0;
	     int firstLetterRow =0;
	     int maxGrid = grid.length -1; // Because grid starts at zero
	     
	     
		     //iterate through rows in grid 
		     for (int rowcount=0; rowcount < gridRows; rowcount++ )  
	 			 {
		    	 
			    	 //iterate through columns of grid 
			    	 for(int columncount=0; columncount< gridColumns; columncount++) {
			    		 
				    		//checks if end of grid
				    		if (rowcount <= maxGrid || columncount <= maxGrid) {
				    			
					    		//Check each char in the grid at row and col position
					    		char val =  (grid[rowcount][columncount]); //val will contain each letter in the grid
					    		
							    		//Found a matching letter
							    		if(match == val) 
							    		 {
							    			
							    			// PASS TO CONSTRUCTOR LOAD TO DATA DICTIONARY OR AN ARRAY
							    			firstLetterRow = rowcount; 
							    			firstLetterCol = columncount;
							    			savePositions  =  firstLetterRow + ":" + firstLetterCol;
							    			
							    					//DATA NEEDS TO BE PASSED IN A CONSTRUCTOR
							    					getPossibleMatch(rowcount, columncount,word, grid,savePositions);
							    					break;		
							    		 }
							    		else
							    		{
							    			
							    		}
				    			 
				    		}
				    				 
			    	 	}
		    	 
		     }
	     
	    
	 }
	
		public static void getPossibleMatch(int startRow, int startCol, String word, char[][] grid,String saveFirstPosition)
		{
			//this method calls all of the possible directions when the first letter of the word is found
			
			String buildWord = "";
			
		
			checkToDiagonal(startRow, startCol, grid, word, buildWord,saveFirstPosition);
			
			
			checkToRight(startRow, startCol, grid, word, buildWord,saveFirstPosition);
			
			
			checkToLeft(startRow, startCol, grid, word, buildWord,saveFirstPosition);
			
			
			checkToUp(startRow, startCol, grid, word, buildWord,saveFirstPosition);
			
			
			checkToDown(startRow, startCol, grid, word, buildWord,saveFirstPosition);
			
			
			
			
		}
		
	
		
		
		
		public static void checkToDiagonal(int startRow, int startCol, char[][] grid, String word, String buildWord,String saveFirstPosition) {
			
			char findWordMatch;
			int numLetters  = word.length();
			int maxGrid = grid.length -1; // Because grid starts at zero
			String saveLastPositions="";
			
			
			// CHECK TO THE Diagonal OF THE GRID
			for(int lc = 0; lc < numLetters; lc++)
			{
				findWordMatch =  grid[startRow][startCol];
				buildWord = buildWord + findWordMatch;
				
				if (startRow < maxGrid || startCol < maxGrid)
				{
					if (startRow != maxGrid)
					{
					startRow ++;
					}
					if (startCol != maxGrid)
					{
					startCol ++;
					}
				
				}
				else
				{
				 break;
				}
			}
			saveLastPositions =  startRow + "," + startCol;
			wordPositionResults(word, buildWord, saveFirstPosition, saveLastPositions);
		}
		
		
		
		
		public static void checkToRight(int startRow, int startCol, char[][] grid, String word, String buildWord,String saveFirstPosition) {
			
			char findWordMatch;
			int numLetters  = word.length();
			int maxGrid = grid.length -1; // Because grid starts at zero
			String saveLastPositions="";
			
			// CHECK TO THE Right OF THE GRID
			for(int lc = 0; lc < numLetters; lc++)
			{
				findWordMatch =  grid[startCol][startRow];
				buildWord = buildWord + findWordMatch;
				
				if (startRow < maxGrid)
				{
				startRow ++;
				}
				else
				{
				 break;
				}
			}
			saveLastPositions =  startRow + "," + startCol;
			wordPositionResults(word, buildWord, saveFirstPosition, saveLastPositions);
		}

		public static void checkToLeft(int startRow, int startCol, char[][] grid, String word, String buildWord,String saveFirstPosition) {
			
			char findWordMatch;
			int numLetters  = word.length();
			String saveLastPositions="";
		
			
			// CHECK TO THE Left OF THE GRID
			for(int lc = 0; lc < numLetters; lc++)
			{
				findWordMatch =  grid[startRow][startCol]; // Swiched Row and Column since iterating backwards
				buildWord = buildWord + findWordMatch;
				if (startCol > 0)
				{
					startCol --;
				}
				else
				{
				 break;
				}
			}
			
			saveLastPositions =  startRow + "," + startCol;
			wordPositionResults(word, buildWord, saveFirstPosition, saveLastPositions);
			
		}

		public static void checkToUp(int startRow, int startCol, char[][] grid, String word, String buildWord,String saveFirstPosition) {
			
			char findWordMatch;
			int numLetters  = word.length();
			String saveLastPositions="";

			
			// CHECK TO THE Up OF THE GRID
			for(int lc = 0; lc < numLetters; lc++)
			{
				findWordMatch =  grid[startCol][startRow];
				buildWord = buildWord + findWordMatch;
				if (startCol > 0)
				{
					startCol --;
				}
				else
				{
				 break;
				}
			}
			
			saveLastPositions =  startRow + "," + startCol;
			wordPositionResults(word, buildWord, saveFirstPosition, saveLastPositions);
		
		}
		
		
		public static void checkToDown(int startRow, int startCol, char[][] grid, String word, String buildWord,String saveFirstPosition) {
			
			char findWordMatch;
			int numLetters  = word.length();
			int maxGrid = grid.length -1; // Because grid starts at zero;
			String saveLastPositions="";
			
			// CHECK TO THE Down OF THE GRID
			for(int lc = 0; lc < numLetters; lc++)
			{
				findWordMatch =  grid[startRow][startCol]; // Flipped grid row and column because coordinates were returning inverse
				buildWord = buildWord + findWordMatch;
				
				if (startRow < maxGrid)
				{
					startRow ++;
				}
				else
				{
				 break;
				}
			}
			saveLastPositions =  startRow + "," + startCol;
			wordPositionResults(word, buildWord, saveFirstPosition, saveLastPositions);
				
		
		}



		private static void wordPositionResults(String word, String buildWord, String saveFirstPosition, String saveLastPositions) {
			DisplayResults results = new DisplayResults();	
			results.checkState(word, buildWord,saveFirstPosition,saveLastPositions);
			
		}
		
		
	
		
		
		
	
	
	  public static LoadInputData readFile()  {
	 	   
			LoadInputData lid = new LoadInputData();
			   
			   try {
			    String getFilePath =  openFile().getPath().toString(); //store physical file path as string
			    File file=new File(getFilePath); //open file 
			    FileReader filereader=new FileReader(file);   //reads the file  
			    BufferedReader bufferReader=new BufferedReader(filereader);  //creates a buffering character input stream  
			
			    //get row and column parameters from file
			    String line;  
			    char Row = (char) 0;
			    char Col = (char) 0;
			    line=bufferReader.readLine();  //read first line of file to get row and column values
			    Row = line.charAt(0);
			    Col = line.charAt(2);
			   
			    
			    
			    //set static row and column values for iteration
				int rowCount = Character.getNumericValue(Row);
				int columnCount = Character.getNumericValue(Col);
				int rowCounter = Character.getNumericValue(Row) -1;
				int columnCounter = Character.getNumericValue(Col) -1;
				
				//assign grid row and column dimensions to the [lid] constructor
				lid.col = columnCount;
				lid.row = rowCount;
				
				//set gridArray to hold row and column count from the file
				char [][] gridArray = new char[rowCount][columnCount];
				
				
				int row = 0; // row counter iterates through the rows in the file through the while loop
				
				//to build the grid, while loop will iterate through the rows and columns of the file
			    while((line=bufferReader.readLine())!=null)  {  
			    	if(row<=rowCounter) {
			    	line = line.trim();  
			    	line=removeSpaces(line);
				    	for (int col=0; col<=columnCounter; col++) {  
				    		
			    			char getCharInFile=	line.charAt(col);
			    			gridArray[row][col] = getCharInFile;
			    			//lid.GridArray[row][col] = getCharInFile;
				 
					      }
		    		row++;
			    		if(row<=rowCounter) {
			    			continue;
			    		}
			    		else {
			    			break;
			    		}
			    	}
			    	else {
			    		break;
			    	}

			    }
			    
			  lid.GridArray=  gridArray;
			    
			    //add the words found into a dictionary
			    int countWords = 1;
			    while((line=bufferReader.readLine())!=null)  {

						  	String getWord = line.toString();
						  	lid.BookOfWords.put(countWords, getWord);
					        //System.out.println(getWord);
					        countWords++;
			    }
			    
			    
			    filereader.close();    //closes the stream and release the resources  
			    bufferReader.close();  //closes the stream and release the resources 
			    

			   }
			   catch(IOException e)  {  
				   e.printStackTrace();  
			   }
			   
			   
			return lid;  
			   
			
			 
		
		   }
		   
	  
	  
	  public static String removeSpaces (String arg){
			   //Method to remove spaces from file
		       Pattern whitespace = Pattern.compile("\\s");
		       Matcher matcher = whitespace.matcher(arg);
		       String result = "";
		       if (matcher.find()) {
		           result = matcher.replaceAll("");
		       }
		       return result;
		   }
		   
		   
	private static File openFile() {
		    	//Method to allow user to select file to load
		        FileDialog dialog = new FileDialog((Frame) null, "Select File");
		        dialog.setMode(FileDialog.LOAD);
		        dialog.setVisible(true);
		        File[] file = dialog.getFiles();
		        return file[0];
		    }
		 
	
	
	
}
