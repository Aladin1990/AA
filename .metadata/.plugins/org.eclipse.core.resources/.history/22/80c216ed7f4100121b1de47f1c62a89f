package main;

public class FormatAccess {
	String formatterString="";
	public FormatAccess(){
		
	}
	
	String formatTitle(String title){
		formatterString = " ::"+title+":: ";
		return formatterString;
	}
	String formatTrueFalse(String question,Boolean answer){
		if(answer) formatterString="T";
		else formatterString="F";
		formatterString = " "+question+" {"+formatterString+"}";
		return formatterString;
	}
	String formatMatching(String part1,String part2){
		formatterString = " ="+part1+" -> "+part2;
		return formatterString;
	}
}
