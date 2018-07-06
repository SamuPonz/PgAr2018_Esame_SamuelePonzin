package program;

public class Option {

	private int fromChapter;
	private int toChapter;
	private String message;
	
	public Option(int from, int to, String message) {
		this.fromChapter = from;
		this.toChapter = to;
		this.message = message;
	}

	/////////////////////////////////////////////////////////////
	
		public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	public int getFromChapter() {
		return fromChapter;
	}



	public void setFromChapter(int fromChapter) {
		this.fromChapter = fromChapter;
	}



	public int getToChapter() {
		return toChapter;
	}



	public void setToChapter(int toChapter) {
		this.toChapter = toChapter;
	}
	
}
