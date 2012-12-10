package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GiftBuilder{
	ArrayList<StringBuilder> giftOutPutBuilderList = new ArrayList<StringBuilder>();
	public ArrayList<StringBuilder> getGiftOutPutBuilderList() {
		return giftOutPutBuilderList;
	}
	StringBuilder giftOutPutBuilder = new StringBuilder();
	GiftBuilder()
	{
		
	}
	public StringBuilder getGiftOutPut() {
		return giftOutPutBuilder;
	}
	public void append(String giftOutPut) {
		giftOutPutBuilder.append(giftOutPut);
	}
	public void appendQuestion() {
		giftOutPutBuilderList.add(giftOutPutBuilder);
		giftOutPutBuilder = new StringBuilder();
	}
	public void deleteLastQuestion(String lastEntery) {
		int lastIndex=giftOutPutBuilderList.size()-1;
		if(giftOutPutBuilderList.get(lastIndex).toString().contains("lastEntery")){
			giftOutPutBuilderList.remove(lastIndex);
		}
		
	}
	public StringBuilder getLastIsert() {
		int lastIndex=giftOutPutBuilderList.size()-1;
		return giftOutPutBuilderList.get(lastIndex);	
	}
	public void writeQuestionsTofile() {
		String name=JOptionPane.showInputDialog("Enter file name");
		try {
			FileIO fileOutput = new FileIO(name+".gift", 2);
			for(StringBuilder i:giftOutPutBuilderList){
			fileOutput.writeLine(i.toString());
			}
			fileOutput.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
