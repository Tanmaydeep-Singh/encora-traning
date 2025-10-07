package clientserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
	Socket s;
	BufferedReader keyIn,in;
	PrintWriter out;
	
	public client() {
		try {
			s  = new Socket("localhost", 2000);
			System.out.println("Connected to the client:");
			
			while(true)
			{
				
					
//			Reading the message sent by the server
			in = new BufferedReader(
					new InputStreamReader(s.getInputStream())
					);
			
//			Reading message
			String msgFromServer = in.readLine();
			System.out.println("Server: " + msgFromServer);
			
			
//			
			keyIn = new BufferedReader( new InputStreamReader(System.in));
			System.out.println("Type You Message:");
			String msgString = keyIn.readLine();
			System.out.println("MESSAGE SENT");
			
				
//			Sending	 message
			out  = new PrintWriter(s.getOutputStream(), true);
			out.println(msgString);
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public static void main(String[] args) {
		
		new client();
	}

}
