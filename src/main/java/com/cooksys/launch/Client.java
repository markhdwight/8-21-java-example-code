package com.cooksys.launch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		String message = "";
		Socket socket = new Socket("localhost", 1337);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		System.out.println(reader.readLine());
		
		while(running)
		{
			System.out.print("::");
			message = scanner.nextLine();
			writer.println(message);
			writer.flush();
			System.out.println(reader.readLine());
			if(message.equalsIgnoreCase("close"))
			{
				running = false;
			}
		}
		scanner.close();
		socket.close();
	}
	
}
