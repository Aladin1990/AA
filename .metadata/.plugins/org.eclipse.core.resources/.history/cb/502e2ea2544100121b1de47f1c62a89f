package main;

import java.util.ArrayList;

public class GiftBuilder{
	ArrayList<StringBuilder> giftOutPutBuilderList = new ArrayList<StringBuilder>();
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
}
