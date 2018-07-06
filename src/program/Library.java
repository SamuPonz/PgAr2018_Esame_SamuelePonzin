package program;

import java.util.Collections;
import java.util.LinkedList;

public class Library {
	
	private LinkedList<Story> stories = new LinkedList<Story>();
	
	
	public Library() {}
	
	public void addStory(Story story) {
		stories.add(story);
	}
	
	public void showStories() {
		System.out.println();
		for(Story story : stories) {
			System.out.println("@ " + story.getTitle());
		}
		System.out.println();
	}

	public Story searchStory(String title) {
		for(Story story : stories) {
			if(story.getTitle().equalsIgnoreCase(title)) {
				return story;
			}
		}
		return null;
	}
	
	public void sortStoriesByName() throws ClassCastException{
		Collections.sort(stories);
	}
	
	public void sortStoriesbyDuration() {	
		
	}
	
	///////////////////////////////////////////////////////////////////
	
	public LinkedList<Story> getStories() {
		return stories;
	}

	public void setStories(LinkedList<Story> stories) {
		this.stories = stories;
	}
}
