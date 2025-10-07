package clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class server {
	
	ServerSocket ss;
	Socket s;
	BufferedReader keyIn;
	PrintWriter out;
	


	
	public server() {
		try {

			ss = new ServerSocket(2000);
			System.out.println("SERVER IS READY...");
			s = ss.accept();

			while(true)
			{
			
			
			
//			
			keyIn = new BufferedReader( new InputStreamReader(System.in));
			System.out.println("Type You Message:");
			String msgString = keyIn.readLine();
			System.out.println("MESSAGE SENT");
			
				
//			Sending	 message
			out  = new PrintWriter(s.getOutputStream(), true);
			out.println(msgString);
			
			
//			Reading the message sent by the server
			BufferedReader in =  new BufferedReader(
					new InputStreamReader(s.getInputStream())
					);
			
//			Reading message
			String msgFromServer = in.readLine();
			System.out.println("Client: " + msgFromServer);
			}
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		}

	
	public static void main(String[] args) {
		
		new server();
	}
}
