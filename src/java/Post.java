import java.util.ArrayList;
import java.util.HashMap;

public class Post {
	private static HashMap<String,Post> posts = new HashMap<String,Post>();
	public static Post addSign(String post,String side, Sign sign) {
		Post p = getPost(post);
		p.addSign(side,sign);
		return p;
	}

	public static Post getPost(String post) {
		if (!Post.posts.containsKey(post)) {
			Post.posts.put(post,new Post(post));
		}
		return Post.posts.get(post);
	}

	private String label;
	private HashMap<String,ArrayList<Sign>> sides = new HashMap<String,ArrayList<Sign>>();

	public Post(String label) {
		this.label = label;
	}
	
	public void addSign(String side, Sign sign) {
		if (!sides.containsKey(side))
			sides.put(side,new ArrayList<Sign>());
		sides.get(side).add(sign);
	}


	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(label+ ": " +"signs tall\n");
		for (String side : sides.keySet()) {
			sb.append("\t"+side+": " + sides.get(side).size() +" signs\n");
			for (Sign sign : sides.get(side))
				sb.append("\t\t" + sign.postText()+"\n");
		}
		return sb.toString();
	}
}
