package Util;


public class UtilityRicerca {
	
	
	
	
	/*private String getFileName(final Part part) {
		//System.out.println(part.getHeader("content-disposition"));
		for(String content : part.getHeader("content-disposition").split(" ")) {
			if(content.trim().startsWith("filename")) {
				return content.substring(
						content.indexOf('=')+1).trim().replace("\"", "");
			}
		}
		return null;
	}*/
	
	public static String[] spezzaStringhe(String str) { 
	String[] splited = str.toLowerCase().split(" ");
	return splited;
	}
	
}
