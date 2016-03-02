import java.util.HashMap;

public class MakeSign extends Sign {
	private static HashMap<String,HashMap<String,Integer>> indexes = new HashMap<String,HashMap<String,Integer>>();

	private static void createLastIndex(String text, String direction) {
		if (!indexes.containsKey(text)) {
			indexes.put(text,new HashMap<String,Integer>());
		}
		HashMap<String,Integer> l2 = indexes.get(text);
		if (!l2.containsKey(direction)) {
			l2.put(direction,-1);
		}
	}

	private static int getNextLastIndex(String text,String direction) {
		createLastIndex(text,direction);
		Integer index = indexes.get(text).get(direction);
		index = new Integer(index.intValue() + 1);
		indexes.get(text).put(direction,index);
		return index.intValue();
	}

	public MakeSign(Sign sign) {
		super(sign,MakeSign.getNextLastIndex(sign.getText(),sign.getDirection()));
	}
	
	public MakeSign(String text, String direction, String length) {
		super(text,direction,length,MakeSign.getNextLastIndex(text,direction));
	}
	
	public MakeSign(String text, String direction) {
		super(text,direction,MakeSign.getNextLastIndex(text,direction));
	}
}
