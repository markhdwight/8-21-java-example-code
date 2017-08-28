package com.cooksys.launch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class Launcher {

	public static void main(String[] args) {

		try (ServerSocket serverSocket = new ServerSocket(4455)) {

			while (true) {
				System.out.println("Server created! Let's get a client!");
				serverSocket.setSoTimeout(1000 * 60 * 60);
				Socket client = serverSocket.accept();
				
				
				Thread t = new Thread(() -> {
					try {
						handleClient(client);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				
				t.start();
				
			}

		} catch (SocketTimeoutException timeout) {
			System.out.println("No connections within timeout limit :(");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void handleClient(Socket client) throws IOException {
		
		try {
		BufferedReader bis = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		String name = bis.readLine();
		System.out.println("[ " + name + " ] has connected! Let's play a game!");

		PrintWriter writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
		Integer magicNumber = (int)(Math.random() * 100);
		writer.println(magicNumber);
		writer.flush();
		
		magicNumber = magicNumber * 2;
		
		String clientSaid = bis.readLine();
		
		System.out.println("[ " + name + " ] said... " + clientSaid);
		
		Integer clientGuess = Integer.valueOf(clientSaid);
		System.out.println("Client " + name + " has guessed number... " + clientGuess + "! The real number was: " + magicNumber);
		
		if(magicNumber.equals(clientGuess)) {
			writer.println("Congratulations!");
			System.out.println("YAYYY! Congratulations " + name + "!");
		} else {
			writer.println("eh... not so good :(");
		}
		} catch(SocketException sockEx) {
			System.out.println("Someone disconnected not-so-gracefully...");
		} catch(NumberFormatException nEx) {
			System.out.println("Bad number!");
		}
	}

}
