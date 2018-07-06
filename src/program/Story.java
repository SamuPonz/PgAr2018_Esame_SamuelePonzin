package program;

import java.util.ArrayList;
import java.util.Comparator;

import libraries.InputData;
import libraries.MyMenu;

public class Story implements Comparable<Story>{

	private String title;
	private int id;
	private int numberOfChapters;
	private ArrayList<Paragraph> chapters = new ArrayList<Paragraph>();
	private Paragraph initialChapter;
//	private ArrayList<Paragraph> finalChapters = new ArrayList<Paragraph>();
	
	public Story(String title, int numberOfChapters) {
		this.title = title;
		this.numberOfChapters = numberOfChapters;
	}
	
	public String preview() {
		StringBuffer str = new StringBuffer();
		str.append(title);
		str.append('\n');
		str.append("Chapters: ");
		str.append(numberOfChapters);
		return str.toString();
	}
	
	public int compareTo(Story s1) {
		if(title.compareToIgnoreCase(s1.getTitle())>=0)
			return 1;
		else 
			return -1;
	}

	public Paragraph addChapter(Paragraph chapter) {
		chapters.add(chapter);
		return chapter;
	}
	
	public Paragraph searchChapter(int id) {
		return chapters.get(id);
	}
	
	public Paragraph getInitialChapter() {
		return searchChapter(0);
	}

	public void play() {
		Paragraph currentChapter = getInitialChapter();
		int action = 0;
		System.out.println("The game has started: ");
		do {
			System.out.println("---------------------------------");
			System.out.println(currentChapter.getDescription());
			System.out.println("---------------------------------");
			for(Option option : currentChapter.getOptions()) {
				System.out.println(option.getToChapter() + ") " + option.getMessage());
			}
			action = InputData.readInteger("select your action: ");
			currentChapter = searchChapter(currentChapter.getOptions().get(action).getToChapter());
		} while (currentChapter.getOptions().size() != 0);
		System.out.println("end game");
		
	}
	
	///////////////////////////////////////////////////////////////////////
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Paragraph> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Paragraph> chapters) {
		this.chapters = chapters;
	}

//	public ArrayList<Paragraph> getFinalChapters() {
//		return finalChapters;
//	}
//
//	public void setFinalChapters(ArrayList<Paragraph> finalChapters) {
//		this.finalChapters = finalChapters;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumberOfChapters() {
		return numberOfChapters;
	}

	public void setNumberOfParagraphs(int numberOfChapters) {
		this.numberOfChapters = numberOfChapters;
	}
	
	
	
	
	
}
