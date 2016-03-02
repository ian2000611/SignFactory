public class Sign implements Comparable<Sign>{
	private String direction = "";
	private String text = "";
	private int index = -1;
	private String length = "";

	public Sign(Sign sign, int index) {
		this.direction = sign.direction;
		this.text = sign.text;
		this.index = index;
	}

	public Sign(String text, String direction, String length,int index) {
		this.direction = direction;
		this.text = text;
		this.index = index;
		this.length = length;
	}

	public Sign(String text, String direction, int index) {
		this(text,direction,"longsign",index);
	}

	public Sign(String text, String direction, String length) {
		this(text,direction,length,-1);
	}

	public Sign(String text, String direction) {
		this(text,direction,-1);
	}

	public String getScad() {
		return "[\""+text+"\","+direction+","+length+"]";
	}

	public int compareTo(Sign o) {
		int ct = text.compareTo(o.text);
		int cd = direction.compareTo(o.direction);
		int ci = (index < o.index) ? -1 : (index > o.index) ? 1 : 0; 
		return (ct==0) ? ((cd == 0) ? ci : cd) : ct;
	}

	public boolean equals(Object o) {
		try {
			Sign sign = (Sign) o;
			return compareTo(sign) == 0;
		} catch (Exception e) {
			return super.equals(o);
		}
	}

	protected String getText() {
		return new String(text);
	}

	protected String getDirection() {
		return direction;
	}

	public int getIndex() {
		return index;
	}

	public String postText() {
		return text+": "+direction;
	}

	public String toString() {
		return getScad();
	}

}
