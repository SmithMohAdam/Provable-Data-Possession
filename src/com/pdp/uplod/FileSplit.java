package com.pdp.uplod;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileSplit {
	
	FileClintBean object = new FileClintBean();
	List files = null ;
	List macs = null;
	
public  void loadFile(String filename) {
		
		
		int numLines = 0;
		int numLinesBreak = 0;
		int fileNumber = 1;
		File file = new File(filename);
	
		System.out.println(filename);// + " Path:" + file.getAbsolutePath()
		FileReader fileReader;
		try {
			fileReader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(fileReader);
			String line = null;
			String headerLine = null;
			StringBuffer breakLine = new StringBuffer();
			String splitFileName = null;
			File splitFile = null;
			FileWriter fileWritter = null;
			PrintWriter bufferWritter = null;
			headerLine = bufReader.readLine();
			while ((line = bufReader.readLine()) != null) {
				numLines++;
				numLinesBreak++;
				breakLine.append(line + "\n");
				if (numLinesBreak == 10) {
					splitFileName = "splitFile_" + fileNumber + ".txt";
					splitFile = new File(splitFileName);

					if (splitFile.exists()) {
						splitFile.delete();
						splitFile.createNewFile();
					}

					fileWritter = new FileWriter(splitFile);
					bufferWritter = new PrintWriter(fileWritter);
					breakLine.deleteCharAt(breakLine.length() - 1);// remove
																	// last
																	// newline
					bufferWritter.println(headerLine);
					files.add(headerLine);
					
					
					// calling the mac function 
					String macA = mac(breakLine.toString());
					macs.add(macA);
					
					
					//System.out.println(macA);
 
					
					//System.out.println(breakLine.toString());
//					System.out.println("file number"+ fileNumber);

					bufferWritter.println(breakLine.toString());
					bufferWritter.close();
					fileWritter.close();
					fileNumber++;
					numLinesBreak = 0;
					breakLine.setLength(0);
				}
				// System.out.println(numLines+":Line:"+line);
			}
			// for last iteration
			splitFileName = "splitFile_" + fileNumber + ".txt";
			splitFile = new File(splitFileName);
			if (splitFile.exists()) {
				splitFile.delete();
				splitFile.createNewFile();
			}
			fileWritter = new FileWriter(splitFile);
			bufferWritter = new PrintWriter(fileWritter);
			breakLine.deleteCharAt(breakLine.length()-1);// remove last
															// newline
			bufferWritter.println(headerLine);
			files.add(headerLine);
			
			
			// calling the mac function 
			String macA = mac(breakLine.toString());
			macs.add(macA);
			
			//System.out.println(macA);
//			System.out.println(breakLine.toString());
//			System.out.println("file number"+ fileNumber);
			bufferWritter.println(breakLine.toString());
			bufferWritter.close();
			fileWritter.close();
			fileNumber++;
			numLinesBreak = 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		object.setFiles( files);
		object.setMacs(macs);
		
	}
	
	
	
	/* declaring mac function */
	 public static  String mac(String input) 
	    { 
	        try { 
	            // getInstance() method is called with algorithm SHA-384 
	            MessageDigest md = MessageDigest.getInstance("SHA-384"); 
	  
	            // digest() method is called 
	            // to calculate message digest of the input string 
	            // returned as array of byte 
	            byte[] messageDigest = md.digest(input.getBytes()); 
	  
	            // Convert byte array into signum representation 
	            BigInteger no = new BigInteger(1, messageDigest); 
	  
	            // Convert message digest into hex value 
	            String hashtext = no.toString(16); 
	  
	            // Add preceding 0s to make it 32 bit 
	            while (hashtext.length() < 32) { 
	                hashtext = "0" + hashtext; 
	            } 
	  
	            // return the HashText 
	            return hashtext; 
	        } 
	  
	        // For specifying wrong message digest algorithms 
	        catch (NoSuchAlgorithmException e) { 
	            throw new RuntimeException(e); 
	        } 
	    } 
	

}
