package FileConversion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class FileConverter {
	
	public void convert(File f) {		
		String st,filename=""; 
		try {
				Document docr = Jsoup.parse(f, "utf-8"); 
				st=docr.text();
				filename=f.getName();
				filename=filename.split("\\.",2)[0];
				filename=filename+".txt";
				BufferedWriter writer = new BufferedWriter( new FileWriter("D:\\Studies\\MAC\\ACC\\PRACTICAL\\ACC Workspace\\ACC PROJECT\\Text\\"+filename));
				writer.write(st);
				writer.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		File fol= new File("D:\\Studies\\MAC\\ACC\\PRACTICAL\\ACC Workspace\\ACC PROJECT\\Text\\");
		FileConverter obj= new FileConverter();
		File[] listoffiles = fol.listFiles();
		for(File f : listoffiles){
			obj.convert(f);
		}
		System.out.println("100 Files Converted Successfully");
	}

}
