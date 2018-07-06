package program;

import java.util.ArrayList;
import java.util.LinkedList;

import libraries.MyMenu;

public class Paragraph {

	private String description;
	private int id;
	private String type;
	private LinkedList<Integer> possibleChapters = new LinkedList<Integer>();
	private ArrayList<Option> options = new ArrayList<Option>();
	
	public Paragraph(int id, String type) {
		this.id = id;
		this.type = type;
	}
	
	public void addPossibleChapter(int idChapter) {
		possibleChapters.add(idChapter);
	}
	
	public void addOption(Option option) {
		options.add(option);
	}
	
	public String printChapter() {
		StringBuffer str = new StringBuffer();
		for(int i = 0;  i < description.length() + 2; i++) {
			str.append('-');
		}
		str.append("\n\n");
		str.append(description);
		str.append("\n\n");
		for(int i = 0;  i < description.length() + 2; i++) {
			str.append('-');
		}
		str.append("\n\n");
		for(Option option : options) {
			str.append(option.getMessage());
			str.append('\n');
		}
		return str.toString();
	}
	
	
	
	///////////////////////////////////////////////////////////
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Option> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<Option> options) {
		this.options = options;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
