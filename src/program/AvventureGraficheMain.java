package program;

public class AvventureGraficheMain {

	public static void main(String[] args) {
		
		Story storia = new Story();
		Utility.read("PgAr2018_Story_2.1.xml", storia);
		for(Paragraph chap : storia.getChapters()) {
			System.out.println(chap.printChapter());
			
		}
	}

}
