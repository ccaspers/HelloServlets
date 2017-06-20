package de.hsrm.cc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetAndPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String template = String.join("\n",
			"<html>",
			"	<head>",
			"		<title>Get and Post Servlet</title>",
			"	</head>",
			"	<body>",
			"		<p>Method was: %s</p>",
			"		<form method=\"POST\">", // kein Attribut 'action' definiert, abschicken an aktuelle URL im Browser
			"			<input type=\"submit\" value=\"Do the Post!\">",
			"		</form>",
			"	</body>",
			"</html>"
		);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sendResponse(response, "GET");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sendResponse(response, "POST");
	}
	
	private void sendResponse(HttpServletResponse response, String method) throws IOException{
		String markup = String.format(template, method);
		response.getWriter().write(markup);
	}

}
