package com.cooksys.launch;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {
		
		Socket socket = new Socket("10.1.1.127", 4455);
		
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		writer.println("sup fam");
		
		writer.flush();
		
		socket.close();
	}
	
}
