package program;

import java.util.ArrayList;
import java.util.Comparator;

public class Story implements Comparable<Story>{

	private String title;
	private int id;
	private int numberOfChapters;
	private ArrayList<Paragraph> chapters = new ArrayList<Paragraph>();
	private Paragraph initialChapter;
	private ArrayList<Paragraph> finalChapters = new ArrayList<Paragraph>();
	
	public Story() {
	}
	
	public void play() {
		
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

	public Paragraph getInitialChapter() {
		return initialChapter;
	}

	public void setInitialChapter(Paragraph initialChapter) {
		this.initialChapter = initialChapter;
	}

	public ArrayList<Paragraph> getFinalChapters() {
		return finalChapters;
	}

	public void setFinalChapters(ArrayList<Paragraph> finalChapters) {
		this.finalChapters = finalChapters;
	}

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