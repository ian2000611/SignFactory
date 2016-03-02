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
	private void post(Location location, PostFace side, String[] signs, String direction) {
		post(location,side,signs,direction,"longsign");
	}
	private void post(Location location, PostFace side, String[] signs, String direction, String length) {
		for (String sign : signs) {
			post(location,side,sign,direction,length);
		}
	}	
	private void post(Location location, PostFace side, String sign, String direction) {
		post(location,side,sign,direction,"longsign");
	}
	private void post(Location location, PostFace side, String sign, String direction, String length) {
		Post.addSign(location.name().replace("_"," "),side.name(),need(sign,direction,length));
	}
	private Sign need(String text, String direction) {
		return need(text,direction,"longsign");
	}
	private Sign need(String text, String direction,String length) {
		Sign sign =new MakeSign(text,direction,length);
		Needed.add(sign);
		return sign;
	}

	private ArrayList<Sign> Have = new ArrayList<Sign>();
	private void have(String text, String direction) {
		have(text,direction,"longsign");
	}
	private void have(String text, String direction, String length) {
		Have.add(new InventorySign(text,direction,length));
	}

	public main(String[] args) {
		post(Location.South_Lakes_Enterence,PostFace.South,"Fiber Alley","right");
		post(Location.South_Lakes_Enterence,PostFace.South,"Gaming","right","shortsign");
		post(Location.South_Lakes_Enterence,PostFace.South,"Woodworks","right","shortsign");
		post(Location.South_Lakes_Enterence,PostFace.South,"Drone Zone","right","shortsign");

		post(Location.South_Lakes_Enterence,PostFace.East,"Sustainability Village","left");
		post(Location.South_Lakes_Enterence,PostFace.East,"Programming","left","shortsign");
		post(Location.South_Lakes_Enterence,PostFace.East,"Trebuchet","left","shortsign");
		post(Location.South_Lakes_Enterence,PostFace.East,"Blacksmith","left","shortsign");
		post(Location.South_Lakes_Enterence,PostFace.East,"EVs - Auto Hacking","left");
		
		post(Location.Hughes_Enterence,PostFace.West,"Robots & ROV","left","shortsign");
		post(Location.Hughes_Enterence,PostFace.West,"Makerspaces","left","shortsign");
		post(Location.Hughes_Enterence,PostFace.West,"Trebuchet","left","shortsign");
		post(Location.Hughes_Enterence,PostFace.West,"Young Makers","right");
		
		post(Location.Hughes_Enterence,PostFace.North,"Speaker Series","ahead","shortsign");
		post(Location.Hughes_Enterence,PostFace.North,"Take Apart Activity","ahead");
		
		post(Location.Path_Intersection,PostFace.South,"Trebuchet","right","shortsign");
		post(Location.Path_Intersection,PostFace.South,"Aluminum Smelting","right");
		post(Location.Path_Intersection,PostFace.South,"Blacksmith","right","shortsign");
		post(Location.Path_Intersection,PostFace.South,"Electric Bikes","right","shortsign");
		post(Location.Path_Intersection,PostFace.South,"EVs - Auto Hacking","right");
		
		post(Location.Path_Intersection,PostFace.North,"Trebuchet","left","shortsign");
		post(Location.Path_Intersection,PostFace.North,"Aluminum Smelting","left");
		post(Location.Path_Intersection,PostFace.North,"Blacksmith","left","shortsign");
		post(Location.Path_Intersection,PostFace.North,"Electric Bikes","left","shortsign");
		post(Location.Path_Intersection,PostFace.North,"EVs - Auto Hacking","left");
		
		post(Location.Path_Intersection,PostFace.West,"Trebuchet","right","shortsign");
		post(Location.Path_Intersection,PostFace.West,"Aluminum Smelting","left");
		post(Location.Path_Intersection,PostFace.West,"Blacksmith","left","shortsign");
		post(Location.Path_Intersection,PostFace.West,"Electric Bikes","left","shortsign");
		post(Location.Path_Intersection,PostFace.West,"EVs - Auto Hacking","left");
		


		have("Young Makers","ahead");
		have("Young Makers","ahead");
		have("Robotics","ahead");
		have("Robotics","ahead");


		have("Technology Square","left");
		have("Technology Square","left");
		have("Technology Square","left");
		have("Bike Lane","left");
		have("Bike Lane","left");
		have("Flight Path","left");
		have("Flight Path","left");
		have("Fabrication Village","left");
		have("Fabrication Village","left");
		have("Creativity Lane","left");
		have("Creativity Lane","left");
		have("3D Printing Village","left");
		have("3D Printing Village","left");
		have("Story Loom","left");
		have("Story Loom","left");
		have("Woodworking Way","left");
		have("Woodworking Way","left");
		have("Story Zone","left");
		have("Science Labs","left");
		have("Science Labs","left");
		have("Maker Spaces","left");
		have("Maker Spaces","left");
		have("Maker Spaces","left");
		have("Drone Zone","left");
		have("Engineering Row","left");
		have("Engineering Row","left");
		have("Engineering Row","left");
		have("Creativity Corner","left");
		have("Creativity Corner","left");
		have("Creativity Corner","left");
		have("Creativity Central","left");


		have("Sustainability Village","right");
		have("Sustainability Village","right");
		have("Upcycle","right");
		have("Upcycle","right");
		have("Blacksmith","right");
		have("Fiber Alley","right");
		have("Fiber Alley","right");
		have("Fiber Alley","right");
		have("Young Makers","right");
		have("Cinemas","right");
		have("Cinemas","right");
		have("Speakers","right");
		have("Speakers","right");
		have("Take Apart","right");
		have("Take Apart","right");
		have("Activity Ticket Village","right");
		have("Activity Ticket Village","right");
		have("Robotics Row","right");
		have("Robotics Row","right");
		have("Robotics Row","right");
		have("Food Trucks","right");
		have("Sustainability Village","right");

		have("Sustainability Village","right");
		have("Sustainability Village","right");
		have("Upcycle","right");
		have("Upcycle","right");

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
			int i = 0;
			out.write("\n\nmodule proof() { //make dxf\n");
			for (String s:sheet) { 
				out.write("\ttranslate([0,"+(i++)+"*-6*(signheight+5)]) " +s+"();\n");
			}
			out.write("}");
			out.close();
			sheet.add("proof");
			for (String s:sheet) {
				scad = new File(s+".scad");
				File dxf = new File(s+".dxf");
				if (scad.exists())
					scad.delete();
				out = new FileWriter(scad);
				out.write("use <base.scad>;\n"+s+"();");
				out.close();
				if (args.length == 1 && args[0].equals("dxf")) {
					Process p = Runtime.getRuntime().exec("openscad -o "+dxf.getName()+" "+scad.getName());
					p.waitFor();
					scad.delete();
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
		new main(args);
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
