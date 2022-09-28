package challenges3;

public class Emoji {
	public int points = 0;
	public String symbol = "";
	public String command = "";

	public Emoji(String string, int i, String c) {
		symbol = string;
		points = i;
		command = c;
	}

	public String getChar() {
		return symbol;
	}
	
	public int getPoints() {
		return points;
	}
	
	public String getCommand() {
		return command;
	}

}
