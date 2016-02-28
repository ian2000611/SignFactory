import java.util.HashMap;

public class InventorySign extends Sign {
	private static HashMap<String,HashMap<Direction,Integer>> indexes = new HashMap<String,HashMap<Direction,Integer>>();

	private static void createLastIndex(String text, Direction direction) {
		if (!indexes.containsKey(text)) {
			indexes.put(text,new HashMap<Direction,Integer>());
		}
		HashMap<Direction,Integer> l2 = indexes.get(text);
		if (!l2.containsKey(direction)) {
			l2.put(direction,-1);
		}
	}

	private static int getNextLastIndex(String text,Direction direction) {
		createLastIndex(text,direction);
		Integer index = indexes.get(text).get(direction);
		index = new Integer(index.intValue() + 1);
		indexes.get(text).put(direction,index);
		return index.intValue();
	}

	public InventorySign(Sign sign) {
		super(sign,InventorySign.getNextLastIndex(sign.getText(),sign.getDirection()));
	}
			
	public InventorySign(String text, Direction direction, Length length) {
		super(text,direction,length,InventorySign.getNextLastIndex(text,direction));
	}
	
	public InventorySign(String text, Direction direction) {
		super(text,direction,InventorySign.getNextLastIndex(text,direction));
	}
}
