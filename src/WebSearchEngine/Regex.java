package WebSearchEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Pattern;



public class Regex {
ArrayList<String> urls= new ArrayList<>();
	
	public ArrayList<String> findUrls(String data) {
		String checkword[];
		boolean flag;
		checkword=data.split(" ");
		for(String s: checkword) {
			flag=Pattern.matches("^(http|https)[\\S]*", s);
			if(flag==true) {
				urls.add(s); //[\\S]*
			}
		}  
		return urls;
	}
	public static void urlFinder(String pathTEXT) {
		String data="",line="";
		Regex obj=new Regex();
		File dir = new File(pathTEXT);
		File[] listofFiles=dir.listFiles();
		for(File f: listofFiles) {
			try {
				BufferedReader br = new BufferedReader( new FileReader(f));
				while((line=br.readLine()) != null) {
	 			   data=data+line;
				}
				obj.findUrls(data);
				br.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		System.out.println("Links in documents :: ");
		for(String s: obj.urls) {
			System.out.println(s);	
		}
	}
}
