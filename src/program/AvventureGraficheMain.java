package program;

import libraries.InputData;
import libraries.MyMenu;

public class AvventureGraficheMain {
	
	public static final String TITLE = "LIBRARY";
	public static final String TITLE_REQUEST = "Tell me which story whould you like to see: ";
	public static final String PLAY_REQUEST = "Would you like to play? press Y or N...  ";
	public static final String SORTING_MESSAGE = "The stories have been sorted in alphabetic order";
	public static final String[] OPTIONS = {"Show the collection of stories", "Search a story", "Sort the collection"};
	
	public static void main(String[] args) {
		
		String[] files = {"PgAr2018_Story_2.1.xml","PgAr2018_Story_2.2.xml","PgAr2018_Story_5.1.xml","PgAr2018_Story_5.2.xml","PgAr2018_Story_6.1.xml"};
		
		MyMenu libraryMenu = new MyMenu(TITLE, OPTIONS);
		int action;
		
		Library library = Utility.read(files);
		
		do {
			action = libraryMenu.choose();
			switch(action) {
			case 1:
				library.showStories();
				break;
			case 2: 
				Story story = null;
				do {
					story = library.searchStory(InputData.readNotEmptyString(TITLE_REQUEST));
				}
				while(story == null);
				System.out.println(story.preview());
				char c = InputData.readUpperChar(PLAY_REQUEST, "YN");
				if( c == 'Y') {
					play(story);
				}
				break;
			case 3: 
				library.sortStoriesByName();
				System.out.println(SORTING_MESSAGE);
			}
		} while(action != 0);				
	}
	
	public static void play(Story story) {}
}