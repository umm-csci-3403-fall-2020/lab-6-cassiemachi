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
 		WriteToServer write = new WriteToServer(socketOutputStream);
		// Put your code here.
	}
}
public class WriteToServer{

  // Constructor
  public WriteToServer(OutoutStream os){
	this.os = os;
  }
  public void run(){
    try{
    int inputbyte;
    while((inputbyte = System.in.read())!= -1){
	// Write that byte to socket
	os.write(inputbyte);
        os.flush();
    }
    os.shutdownOutput();
    }catch(IOExceotion ioe){
       System.out.println("we caught an unexpected exception");
    }
  }
}// end Writer class
public class Reader{
  public Reader(InputStream is, OutputStream os, Socket s){
    this.is = is;
    this.os = os; 
    this.s = s;
  }
  public void run(){
  while(true){
    try{
    // read single byte from socket
    
    // Write these bytes to stdin

    }catch{


    }



  }
  }
}// end reader class
