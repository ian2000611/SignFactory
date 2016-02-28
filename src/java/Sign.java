import java.util.HashMap;

public class Sign implements Comparable<Sign>{
	public static enum Length {
		longsign,
		shortsign
	}
	public static enum Direction implements Comparable<Direction> {
		left,
		ahead,
		right;
	}

	private static HashMap <String,Length> lengths = new HashMap<String,Length>();

	private Direction direction;
	private String text;
	private int index;

	public Sign(Sign sign, int index) {
		this.direction = sign.direction;
		this.text = sign.text;
		this.index = index;
	}

	public Sign(String text, Direction direction, Length length,int index) {
		this.direction = direction;
		this.text = text;
		this.index = index;
		if (!Sign.lengths.containsKey(text)) {
			Sign.lengths.put(text,length);
		}
	}

	public Sign(String text, Direction direction, int index) {
		this(text,direction,Length.longsign,index);
	}

	public Sign(String text, Direction direction, Length length) {
		this(text,direction,length,-1);
	}

	public Sign(String text, Direction direction) {
		this(text,direction,-1);
	}

	public String getScad() {
		return "[\""+text+"\","+direction.name()+","+Sign.lengths.get(text).name()+"]";
	}

	public int compareTo(Sign o) {
		int ct = text.compareTo(o.text);
		int cd = compareDirection(direction,o.direction);
		int ci = (index < o.index) ? -1 : (index > o.index) ? 1 : 0; 
		return (ct==0) ? ((cd == 0) ? ci : cd) : ct;
	}

	public int compareDirection(Direction d1, Direction d2) {
		if (d1 == Direction.left) {
			if (d2 == Direction.left)
				return 0;
			return -1;
		}
		if (d1 == Direction.ahead) {
			if (d2 == Direction.left)
				return 1;
			if (d2 == Direction.right)
				return -1;
			return 0;
		}
		if (d2 == Direction.right)
			return 0;
		return 1;
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

	protected Direction getDirection() {
		return direction;
	}

	public int getIndex() {
		return index;
	}

	public static String list() {
		StringBuilder sb = new StringBuilder();
		for (String n : lengths.keySet())
			sb.append(n+"\n");
		return sb.toString();
	}

	public String postText() {
		return text+": "+direction.name();
	}

	public String toString() {
		return getScad();
	}

}
