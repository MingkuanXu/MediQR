package website;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CommentsDao {
	
	private final static String FILE_NAME = "src/main/resources/comments";
	
    /*
	public static void main(String[] args) throws IOException {
    		writeToFile("student1","today","content");
    }*/
    
    /***
     * Write to the file storing all the comments from students.
     * @param name: name of the student
     * @param date
     * @param content
     * @throws IOException
     */
	public static void writeToFile(String name, String date, String content) throws IOException {
	    BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
	    writer.append("\n");
	    writer.append(name);
	    writer.append("\n");
	    writer.append(date);
	    writer.append("\n");
	    writer.append(content);
	    writer.append("\n");
	    writer.append("$$");	     
	    writer.close();
	}
	
	public static List<Map<String, String>> extractFromFile() throws FileNotFoundException {
        File file = new File(FILE_NAME);
        Scanner sc = new Scanner(file);
        List<Map<String, String>> lt = new ArrayList<Map<String, String>>();
        
        while (sc.hasNextLine()) {
        		Map <String, String> map = new HashMap<String, String>();
        		map.put("name", sc.nextLine());
        		map.put("date", sc.nextLine());
        		String st = sc.nextLine();
        		String nw = sc.nextLine();
        		while (!(nw.equals("$$"))) {
        			st = st + "\n" + nw;
        			nw = sc.nextLine();
        		}
        		map.put("content", st);
        		lt.add(map); 
        }
        sc.close();
        Collections.reverse(lt);
        return lt;
	}

}
