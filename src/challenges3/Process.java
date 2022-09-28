package challenges3;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Process {

	ArrayList<Emoji> emojis = new ArrayList<>();
	private String huidigPersoon = "";
	private ArrayList<Persoon> personen = new ArrayList<>();
	private String ss = "";
	private String separator = " — "; // dit is de string die discord gebruikt om na een persoon de datum weer te geven.
	
	public Process(BufferedReader br, BufferedReader brEmoji) throws IOException {
		maakEmojis(brEmoji);
		verwerk(br,ss);
	}
	
	private void maakEmojis(BufferedReader brEmoji) throws IOException {
		while ((ss=brEmoji.readLine()) != null) {
			maakEmoji(ss);
		}
	}

	public void verwerk(BufferedReader br, String ss) throws IOException {
		// regels verwerken
		while ((ss=br.readLine()) != null) {
			read(ss + ",");
		}
		
		// personen sorteren
		Collections.sort(personen);
		
		// resultaat printen
		for (Persoon p : personen) {
			System.out.println(p.getResults());
			p.done();
		}
	}

	private void maakEmoji(String ss) {
		int waarde = Integer.parseInt(ss.substring(4, ss.indexOf(" ")));
		String emojiString = ss.substring(0,4);
		String emojiCommand = ss.substring(ss.indexOf(" "), ss.length());
		Emoji emoji = new Emoji(emojiString, waarde , emojiCommand);
		emojis.add(emoji);
	}

	private void read(String ss) {
		if (ss.contains(separator)) { //  —
			huidigPersoon = ss.substring(0, ss.indexOf(" "));
		} else {
			addPoints(ss);
		}
	}

	private void addPoints(String ss) {
		for (Emoji em : emojis) {
			int amount = count(ss,em);
			Persoon persoon = getPersoon();
			persoon.add(em, amount);
		}
	}

	private Persoon getPersoon() {
		for (Persoon p : personen) {
			if (p.getNaam().equals(huidigPersoon)) {
				return p;
			}
		}
		Persoon p = new Persoon(huidigPersoon, emojis);
		personen.add(p);
		return p;
	}
	
	private int count(String ss, Emoji em) {
		int i = 0;
		while (ss.contains(em.getChar())) {
			i++;
			ss = ss.substring(ss.indexOf(em.getChar())+1);
		}
		return i;
	}
}
