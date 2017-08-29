package com.cooksys.launch;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConcurrentLauncher {

	public static void main(String[] args) throws InterruptedException, IOException {

		ServerSocket server = new ServerSocket(1337);

		while (true) {
			//System.out.println("Awaiting client");
			Socket client = server.accept();

			Thread clientHandler = new Thread(new ClientHandler(client));

			clientHandler.start();
		}

	}

}
