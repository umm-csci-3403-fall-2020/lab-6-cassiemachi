package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	// REPLACE WITH PORT PROVIDED BY THE INSTRUCTOR
	public static final int PORT_NUMBER = 6013; 
	public static void main(String[] args) throws IOException, InterruptedException {
		EchoServer server = new EchoServer();
		server.start();
	}

	private void start() throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
		while (true) {
			Socket socket = serverSocket.accept();
                        
			// Put your code here.
			// This should do very little, essentially:
			//   * Construct an instance of your runnable class
			//   * Construct a Thread with your runnable
			//      * Or use a thread pool
			//   * Start that thread
		}
	}
	public class HandleClient implements Runnable{
	  Socket s;
	  outputStream os;
	  inputStream is;
	  // Constructor
	  public HandleClient(Socket s, OutputStream os, InputStream is){
	     this.s = s;
	     this.os = os;
	     this.is =is;
	  }
	  public void run(){
	    try{
	    int inputbyte;
	    while((inputbyte = is.read()) != -1){
	      os.write(inputbyte);	    
	    
	    }
	    s.shutdownOutput();   	    
	    s.shutdownInput();
	    }catch(IOException ioe){
	      System.out.println("we caught an unexpected exception");	    
	    
	    }
	  }
	
	
	}//end HandlClients class
}
