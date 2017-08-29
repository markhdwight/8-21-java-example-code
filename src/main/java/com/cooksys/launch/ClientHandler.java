package com.cooksys.launch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

	Socket client;
	boolean running = true;

	public ClientHandler(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			System.out.println("Client handler now running");
			PrintWriter writer = new PrintWriter(client.getOutputStream());
			writer.println("hey hey hey");
			writer.flush();

			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

			while (running) {
				String clientSays = reader.readLine();

				if(clientSays.equalsIgnoreCase("close"))
				{
					running = false;
					writer.println("closing connection, peace out yo");
					writer.flush();
					System.out.println("Client Disconnected");
				}
				else
				{
					System.out.println("Client said: " + clientSays);

					writer.println("You said: " + clientSays);
					writer.flush();
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
