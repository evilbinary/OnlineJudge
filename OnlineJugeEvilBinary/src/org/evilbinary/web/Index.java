package org.evilbinary.web;

public class Index {
	public static String getHead(){
		String head="<div class=\"head\">"+
					"<div class=\"head\">"+
					"<div class=\"logo\">"+
						"<p align=\"center\">"+
							"EvilBinary OnlineJuge"+
						"</p>"+
					"</div>"+
					 
					"<form action=\"JugeServlet?action=login\" method=\"post\">"+
						"<div class=\"login\">"+
							"’À ∫≈:"+
							"<input type=\"text\" maxlength=\"10\" name=\"username\">"+
							"√‹ ¬Î:"+
							"<input type=\"password\" maxlength=\"10\" name=\"password\">"+
							"<input type=\"submit\" value=\"µ«¬º\" name=\"button1\">"+
						"</div>"+
					"</form>"+
					"<div class=\"welcome\">"+
						"ª∂”≠<a href=\"JugeServlet?action=showUser\">"+ "</a>"+
					"</div>"+
				"</div>"+
				"<div class=\"path\">"+
				 "</div>";
		return head; 
	}
	public static String getFoot(){
		String foot="<div class=\"foot\">"+
			"<div class=\"foot_signe\">"+ "Copyright &copy; 2010 EvilBinary .Org "+"</div>"+
			"</div>";
		return foot;
	}
	
	public static  String getIndex(){
		 String indexHtml=
			 "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">"+
			 "<html>"+
			 	"<head>"+
			 		"<title>"+"OnlineJuge"+"</title>"+
			 		"<meta http-equiv=\"pragma\" content=\"no-cache\">"+
			 		"<meta http-equiv=\"cache-control\" content=\"no-cache\">"+
			 		"<meta http-equiv=\"expires\" content=\"0\">"+
			 		"<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">"+
			 		"<meta http-equiv=\"description\" content=\"This is my page\">"+
			 	"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/styles.css\">"+
			 	"</head>"+
			 	"<body class=\"index\">"+ 
			 	"<div class=\"contain\">"+
			 	getHead()+
			 	getFoot()+
			 	"</div"+
			 	"</body>"+
			 "</html>";
		return indexHtml;
	}
	public static String addBodyToIndex(String body){
		 String indexHtml=
			 "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">"+
			 "<html>"+
			 	"<head>"+
			 		"<title>"+"OnlineJuge"+"</title>"+
			 		"<meta http-equiv=\"pragma\" content=\"no-cache\">"+
			 		"<meta http-equiv=\"cache-control\" content=\"no-cache\">"+
			 		"<meta http-equiv=\"expires\" content=\"0\">"+
			 		"<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">"+
			 		"<meta http-equiv=\"description\" content=\"This is my page\">"+
			 	"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/styles.css\">"+
			 	"</head>"+
			 	"<body class=\"index\">"+ 
			 	"<div class=\"contain\">"+
			 	getHead()+
			 	body+
			 	getFoot()+
			 	"</div"+
			 	"</body>"+
			 "</html>";
		return indexHtml;
	}
}
