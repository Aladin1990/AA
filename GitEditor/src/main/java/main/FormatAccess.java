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
}
