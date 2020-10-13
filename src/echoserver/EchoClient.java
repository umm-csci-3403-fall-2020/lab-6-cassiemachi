package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException {
		EchoClient client = new EchoClient();
		client.start();
	}

	private void start() throws IOException {
		Socket socket = new Socket("localhost", PORT_NUMBER);
		InputStream socketInputStream = socket.getInputStream();
		OutputStream socketOutputStream = socket.getOutputStream();

		// Put your code here.
	}
}
public class Writer{

  // Constructor
  public Writer(Socket s, InputStream is, OutoutStream os ){
	this.s =s;
	this.is = is
	this.os = os
  }
  public void run(){
    String recieved;
    String toWrite;
    while(true){
	try{
	    
	 // Read a byte from the socket  
	

	// Write that byte to standard output



	}


    }


  }
  

	




}// end Writer class
