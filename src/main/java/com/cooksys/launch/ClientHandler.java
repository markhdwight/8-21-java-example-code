package com.cooksys.launch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

	Socket client;

	public ClientHandler(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {

			PrintWriter writer = new PrintWriter(client.getOutputStream());
			writer.println("hey hey hey");

			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

			while (true) {
				String clientSays = reader.readLine();

				System.out.println("Client said: " + clientSays);

				writer.println("You said: " + clientSays);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
