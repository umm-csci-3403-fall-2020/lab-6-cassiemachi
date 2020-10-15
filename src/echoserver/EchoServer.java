package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class EchoServer {
	
	// REPLACE WITH PORT PROVIDED BY THE INSTRUCTOR
	public static final int PORT_NUMBER = 6013; 
	public static void main(String[] args) throws IOException, InterruptedException {
		EchoServer server = new EchoServer();
		server.start();
	}

	private void start() throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
		ExecutorService executor = Executors.newCachedThreadPool();
		ThreadPoolExecutor butler = (ThreadPoolExecutor) executor;
		while (true) {
			Socket socket = serverSocket.accept();
                        
			InputStream socketInputStream = socket.getInputStream();
			OutputStream socketOutputStream = socket.getOutputStream();

			//HandleClient butler = new HandleClient(socket, socketOutputStream, socketInputStream);

			//Thread buttThread = new Thread(butler);
			//buttThread.start();

			executor.submit(new HandleClient(socket, socketOutputStream, socketInputStream));
		        executor.shutdown();
		}
		//executor.shutdown();
	}
	public class HandleClient implements Runnable{
	  Socket s;
	  OutputStream os;
	  InputStream is;
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
