package program;

import java.util.LinkedList;

public class StoryList {

	private LinkedList<Story> library = new LinkedList<Story>();
	
	public StoryList() {}
	
	public void showStories() {
		for(Story story : library) {
			System.out.println(story.getTitle() + "\n");
		}
	}
	
	public Story searchStory(String title) {
		for(Story story : library) {
			if(story.getTitle().equalsIgnoreCase(title)) {
				return story;
			}
		}
		return null;
	}
	
	public void sortStoriesByName() {
		java.util.Collections.sort(library);
	}
	
	public void sortStoriesbyDuration() {
		
		
	}
}
