package challenges3;

import java.util.ArrayList;

public class Persoon implements Comparable<Persoon>{
	private String naam = "";
	private ArrayList<Integer> aantal = new ArrayList<>();
	private int score = 0;
	private boolean done = false;
	private ArrayList<Emoji> emojis = new ArrayList<>();

	public Persoon(String huidigPersoon, ArrayList<Emoji> emojisInput) {
		naam = huidigPersoon;
		emojis=emojisInput;
		for (Emoji em: emojis) {
			aantal.add(0);
		}
	}

	public String getNaam() {
		return naam;
	}

	public void add(Emoji em, int m) {
		for (int i = 0; i<emojis.size(); i++) {
			if (em.equals(emojis.get(i))) {
				aantal.set(i, aantal.get(i)+m);
			}
		}
	}

	public int getScore() {
		int score = 0;
		for (int i = 0; i< emojis.size(); i++) {
			score = score + emojis.get(i).getPoints()*aantal.get(i);
		}
		return score;
	}
	
	public int getImprovement() {
		return score;
	}

	public void done() {
		if (!done) {
			score = getScore();
			done = true;
		}
	}

	@Override
	public int compareTo(Persoon o) {
		return (o.getScore()-this.getScore());
	}
	
	public String getResults() {
		String st = " #. " + naam + whiteSpace(naam,10) + "(+" + getImprovement() + ")=" + getScore() + whiteSpace(""+getImprovement()+getScore(),8) ;
		for (int i = 0; i< emojis.size(); i++) {
			st = st + aantal.get(i) + "x "+ emojis.get(i).getCommand() + "  ";
		}
		return st;
	}
	
	public String whiteSpace(String inputString, int aantal) {
		String st="";
		for (int i =aantal; i>inputString.length(); i-- ) {
			st = st + " ";
		}
		return st;
	}
}
