import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;


public class main {

	private ArrayList<Sign> Needed = new ArrayList<Sign>();
	private enum Location {
		South_Lakes_Enterence,
		Hughes_Enterence,
		Path_Intersection,
		Path_End;
	}
	private enum PostFace {
		North,
		South,
		East,
		West;
	}
	private HashMap<Location,HashMap<PostFace,HashMap<String,Sign.Direction>>> posts = new HashMap<Location,HashMap<PostFace,HashMap<String,Sign.Direction>>>();
	private void post(Location location, PostFace side, String[] signs, Sign.Direction direction) {
		for (String sign : signs) {
			Post.addSign(location.name().replace("_"," "),side.name(),need(sign,direction));
		}
	}	
	private Sign need(String text, Sign.Direction direction) {
		Sign sign =new MakeSign(text,direction);
		Needed.add(sign);
		return sign;
	}

	private ArrayList<Sign> Have = new ArrayList<Sign>();
	private void have(String text, Sign.Direction direction) {
		Have.add(new InventorySign(text,direction));
	}

	public main() {
		String[] slhs = new String[] {"Fiber Alley","Gaming","Young Makers","Robots & ROV","Bicycles","Rockets/Space","Makerspaces","Science","Woodworks","Drone Zone","Electric Avenue","Creativity Corner","3D Printing Village"};
		String[] lhms = new String[] {"Sustainability Village","3D Printing","Young Makers","Programming","Speaker Series","Take Apart Activity"};
		String[] backn = new String[] {"Trebuchet"};
		String[] food = new String[] {"Food Trucks"};
		String[] other = new String[] {"Other Attractions"};
		String[] backs = new String[] {"Aluminum Smelting","Blacksmity","Electric Bikes","EVs & Auto Hacking"};

		post(Location.South_Lakes_Enterence,PostFace.North,slhs,Sign.Direction.right);
		post(Location.South_Lakes_Enterence,PostFace.East,lhms,Sign.Direction.left);
		post(Location.South_Lakes_Enterence,PostFace.East,backn,Sign.Direction.left);
		post(Location.South_Lakes_Enterence,PostFace.East,backs,Sign.Direction.left);
		post(Location.South_Lakes_Enterence,PostFace.East,food,Sign.Direction.left);

		post(Location.Hughes_Enterence,PostFace.North,slhs,Sign.Direction.ahead);
		post(Location.Hughes_Enterence,PostFace.North,backn,Sign.Direction.ahead);
		post(Location.Hughes_Enterence,PostFace.North,backs,Sign.Direction.ahead);
		post(Location.Hughes_Enterence,PostFace.North,food,Sign.Direction.ahead);
		post(Location.Hughes_Enterence,PostFace.South,lhms,Sign.Direction.ahead);

		post(Location.Hughes_Enterence,PostFace.East,slhs,Sign.Direction.right);
		post(Location.Hughes_Enterence,PostFace.East,backn,Sign.Direction.right);
		post(Location.Hughes_Enterence,PostFace.East,backs,Sign.Direction.right);
		post(Location.Hughes_Enterence,PostFace.East,food,Sign.Direction.right);
		post(Location.Hughes_Enterence,PostFace.West,lhms,Sign.Direction.right);

		post(Location.Hughes_Enterence,PostFace.West,slhs,Sign.Direction.left);
		post(Location.Hughes_Enterence,PostFace.West,backn,Sign.Direction.left);
		post(Location.Hughes_Enterence,PostFace.West,backs,Sign.Direction.left);
		post(Location.Hughes_Enterence,PostFace.West,food,Sign.Direction.left);
		post(Location.Hughes_Enterence,PostFace.East,lhms,Sign.Direction.left);

		post(Location.Path_Intersection,PostFace.North,slhs,Sign.Direction.ahead);
		post(Location.Path_Intersection,PostFace.South,backn,Sign.Direction.ahead);
		post(Location.Path_Intersection,PostFace.North,backs,Sign.Direction.right);
		post(Location.Path_Intersection,PostFace.North,food,Sign.Direction.right);
		post(Location.Path_Intersection,PostFace.North,lhms,Sign.Direction.right);
		post(Location.Path_Intersection,PostFace.South,backs,Sign.Direction.left);
		post(Location.Path_Intersection,PostFace.South,food,Sign.Direction.left);
		post(Location.Path_Intersection,PostFace.South,lhms,Sign.Direction.left);
		post(Location.Path_Intersection,PostFace.East,slhs,Sign.Direction.left);
		post(Location.Path_Intersection,PostFace.East,lhms,Sign.Direction.right);

		post(Location.Path_End,PostFace.South,backn,Sign.Direction.ahead);
		post(Location.Path_End,PostFace.South,other,Sign.Direction.right);
		post(Location.Path_End,PostFace.North,backs,Sign.Direction.ahead);
		post(Location.Path_End,PostFace.North,other,Sign.Direction.left);
		post(Location.Path_End,PostFace.West,backn,Sign.Direction.right);
		post(Location.Path_End,PostFace.West,backs,Sign.Direction.left);


		have("Young Makers",Sign.Direction.ahead);
		have("Young Makers",Sign.Direction.ahead);
		have("Robotics",Sign.Direction.ahead);
		have("Robotics",Sign.Direction.ahead);


		have("Technology Square",Sign.Direction.left);
		have("Technology Square",Sign.Direction.left);
		have("Technology Square",Sign.Direction.left);
		have("Bike Lane",Sign.Direction.left);
		have("Bike Lane",Sign.Direction.left);
		have("Flight Path",Sign.Direction.left);
		have("Flight Path",Sign.Direction.left);
		have("Fabrication Village",Sign.Direction.left);
		have("Fabrication Village",Sign.Direction.left);
		have("Creativity Lane",Sign.Direction.left);
		have("Creativity Lane",Sign.Direction.left);
		have("3D Printing Village",Sign.Direction.left);
		have("3D Printing Village",Sign.Direction.left);
		have("Story Loom",Sign.Direction.left);
		have("Story Loom",Sign.Direction.left);
		have("Woodworking Way",Sign.Direction.left);
		have("Woodworking Way",Sign.Direction.left);
		have("Story Zone",Sign.Direction.left);
		have("Science Labs",Sign.Direction.left);
		have("Science Labs",Sign.Direction.left);
		have("Maker Spaces",Sign.Direction.left);
		have("Maker Spaces",Sign.Direction.left);
		have("Maker Spaces",Sign.Direction.left);
		have("Drone Zone",Sign.Direction.left);
		have("Engineering Row",Sign.Direction.left);
		have("Engineering Row",Sign.Direction.left);
		have("Engineering Row",Sign.Direction.left);
		have("Creativity Corner",Sign.Direction.left);
		have("Creativity Corner",Sign.Direction.left);
		have("Creativity Corner",Sign.Direction.left);
		have("Creativity Central",Sign.Direction.left);


		have("Sustainability Village",Sign.Direction.right);
		have("Sustainability Village",Sign.Direction.right);
		have("Upcycle",Sign.Direction.right);
		have("Upcycle",Sign.Direction.right);
		have("Blacksmith",Sign.Direction.right);
		have("Fiber Alley",Sign.Direction.right);
		have("Fiber Alley",Sign.Direction.right);
		have("Fiber Alley",Sign.Direction.right);
		have("Young Makers",Sign.Direction.right);
		have("Cinemas",Sign.Direction.right);
		have("Cinemas",Sign.Direction.right);
		have("Speakers",Sign.Direction.right);
		have("Speakers",Sign.Direction.right);
		have("Take Apart",Sign.Direction.right);
		have("Take Apart",Sign.Direction.right);
		have("Activity Ticket Village",Sign.Direction.right);
		have("Activity Ticket Village",Sign.Direction.right);
		have("Robotics Row",Sign.Direction.right);
		have("Robotics Row",Sign.Direction.right);
		have("Robotics Row",Sign.Direction.right);
		have("Food Trucks",Sign.Direction.right);
		have("Sustainability Village",Sign.Direction.right);

		have("Sustainability Village",Sign.Direction.right);
		have("Sustainability Village",Sign.Direction.right);
		have("Upcycle",Sign.Direction.right);
		have("Upcycle",Sign.Direction.right);

		ArrayList<Sign> Extra = new ArrayList<Sign>();

		Extra.addAll(Have);
		Extra.removeAll(Needed);

		Needed.removeAll(Have);

		Have.removeAll(Extra);

		Collections.sort(Needed);
		Collections.sort(Have);
		Collections.sort(Extra);

		ArrayList<String> sheet = printSigns(Needed);

		try {
			savePostList();
			saveSignList("Make", Needed);
			saveSignList("Reuse", Have);
			saveSignList("Extra", Extra);
			InputStream input = getClass().getResourceAsStream("/signs.scad");
			File scad = new File("base.scad");
			if (scad.exists())
				scad.delete();
			OutputStream output = new FileOutputStream(scad);
			while (input.available()>0)
				output.write(input.read());
			output.close();
			input.close();
			FileWriter out = new FileWriter(scad,true);
			out.write(sheet.remove(0));
			out.close();
			for (String s:sheet) {
				scad = new File(s+".scad");
				File dxf = new File(s+".dxf");
				if (scad.exists())
					scad.delete();
				out = new FileWriter(scad);
				out.write("use <base.scad>;\n"+s+"();");
				out.close();
				Process p = Runtime.getRuntime().exec("openscad -o "+dxf.getName()+" "+scad.getName());
				p.waitFor();
				scad.delete();
				if (false) {
					InputStream is = p.getInputStream();
					InputStream es = p.getErrorStream();
					while (is.available() > 0)
						System.out.write(is.read());
					while (es.available() > 0)
						System.out.write(es.read());
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new main();
	}

	private ArrayList<String> printSigns(ArrayList<Sign> signs) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int sn = 0;
		int ss = 6;
		boolean clean = true;
		sb.append("\n");
		ArrayList<String> sheet = new ArrayList<String>();
		for (Sign s : signs) {
			if (i==0) {
				sheet.add("sheet"+(sn/4+1)+"_"+(sn%4+1));
				sb.append("module "+ sheet.get(sheet.size()-1) +"() { //make dxf\n");
				sb.append("\t sheet([");
				clean = false;
			}
			sb.append(s.getScad());
			if (++i==ss) {
				i=0;
				sn++;
				sb.append("]);\n");
				sb.append("}\n");
				sb.append("\n");
				clean = true;
			} else {
				sb.append(",");
			}
		}
		if (!clean) {
			sb.append("]);\n");
			sb.append("}\n");
		}
		sheet.add(0,sb.toString());
		return sheet;
	}

	private void saveSignList(String prefix, ArrayList<Sign> signs) throws java.io.IOException {
		File f = new File(prefix+".txt");
		if (f.exists())
			f.delete();
		FileWriter fw = new FileWriter(f);
		fw.write("Number of signs: "+signs.size());
		for (Sign s : signs) 
			fw.write(s.postText()+"\n");
		fw.close();
	}

	private void savePostList() throws java.io.IOException {
		File f = new File("posts.txt");
		if (f.exists())
			f.delete();
		FileWriter fw = new FileWriter(f);
		EnumSet<Location> location = EnumSet.allOf(Location.class);
		for (Location l : location) 
			fw.write(Post.getPost(l.name().replace("_"," "))+"\n");
		fw.close();
	}
}
