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
 		
		WriteToServer write = new WriteToServer(socketOutputStream, socket);
		Reader read = new Reader(socketInputStream, socket);

		Thread writer = new Thread(write);
		Thread reader = new Thread(read);

		writer.start();
		reader.start();
		// Put your code here.
	}

public class WriteToServer implements Runnable{
  OutputStream os;
  Socket s;  
  // Constructor
  public WriteToServer(OutputStream os ,Socket s){
    this.os = os;
    this.s = s;
  }
  public void run(){
    try{
    int inputbyte;
    while((inputbyte = System.in.read())!= -1){
	// Write that byte to socket
	os.write(inputbyte);
        
    }
    s.shutdownOutput();
    }catch(IOException ioe){
       System.out.println("we caught an unexpected exception");
    }
  }
}// end Writer class
public class Reader implements Runnable{
  Socket s;
  InputStream is;
  public Reader(InputStream is, Socket s){
    this.is = is;
    this.s = s;
  }
  public void run(){
     try{
     // read single byte from socket
     int inputbyte;
     while((inputbyte = is.read()) != -1){
        System.out.write(is.read());
        
     }
     System.out.flush();
     s.shutdownInput();
     }catch(IOException ioe){
        System.out.println("We caught an unexected exeption");
     }
  }
}// end reader class

}
