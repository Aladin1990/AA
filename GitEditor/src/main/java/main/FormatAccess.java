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
	String formatMultiChoice(String part1,String part2){
		int precentage=Integer.parseInt(part2);
		if(precentage==100){
			formatterString = " ="+part1+"# correct";
		}
		else if(precentage==0){
			formatterString = " ~"+part1+"# wrong"; 
		}
		else{
			formatterString = " =%"+precentage+"%"+part1+""; 
		}
		return formatterString;
	}
	String formatShortAnswer(String part1){
		formatterString = " ="+part1;
		return formatterString;
	}

	public String formatNumerical(String text, String text2) {
		formatterString="#"+text+":"+text2;
		return formatterString;
	}
}
