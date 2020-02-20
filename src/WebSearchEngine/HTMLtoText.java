package WebSearchEngine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import FileConversion.FileConverter;

public class HTMLtoText {
	public static void convert(String inputPath, String outputPath) {		
		String st,filename=""; 
		try {
			File fol= new File(inputPath);
			FileConverter obj= new FileConverter();
			File[] listoffiles = fol.listFiles();
			for(File f : listoffiles){
				obj.convert(f);
				Document docr = Jsoup.parse(f, "utf-8"); 
				st=docr.text();
				filename=f.getName();
				filename=filename.split("\\.",2)[0];
				filename=filename+".txt";
				BufferedWriter writer = new BufferedWriter( new FileWriter(outputPath+filename));
				writer.write(st);
				writer.close();
			}
				
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
