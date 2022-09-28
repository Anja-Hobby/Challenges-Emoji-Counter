package challenges3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class reader {

	static String LocatieChatLog = "C:\\Users\\chat.txt"; // txt file met een kopie van de discord chatlog
	static String LocatieHistoryLog =  "C:\\Users\\history.txt"  ; // txt file met voorgaande discord chatlogs
	static String LocatieEmojis = "C:\\Users\\emoji.txt"; // txt file met de emoji's die geteld moeten worden met hun punten en commando
	
	
	public static void main(String[] args) throws Exception {
		File chatLog = new File(LocatieChatLog); 
		File emojis = new File(LocatieEmojis);
		File chatHistory = new File(LocatieHistoryLog);
		BufferedReader br = new BufferedReader(new FileReader(chatLog));
		BufferedReader brem = new BufferedReader(new FileReader(emojis));
		BufferedReader br2 = new BufferedReader(new FileReader(chatHistory));
		Process process = new Process(br, brem);
		System.out.println("====================================================");
		process.verwerk(br2,"");
	}
	

	
	
			
}
