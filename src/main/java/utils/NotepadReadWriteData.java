package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NotepadReadWriteData {
	
	public static void WriteDataInNotePad(String fileName,String test) throws IOException {
		String fName = System.getProperty(test)+fileName+".txt";
	      FileWriter myWriter = new FileWriter(fName);
	      myWriter.write(test);
	      myWriter.close();
	      System.out.println("ileName"+fName);
	      
			/*
			 * try {
			 * 
			 * FileWriter myWriter = new FileWriter(ileName);
			 * 
			 * if (myObj.createNewFile()) { System.out.println("File created: " +
			 * myObj.getName()); myWriter.write(test); } else {
			 * System.out.println("File already exists."); } } catch (IOException e) {
			 * System.out.println("An error occurred."); e.printStackTrace(); }
			 */
		  }
	
	

}
