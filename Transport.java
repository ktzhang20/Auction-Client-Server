import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;
public class Transport {
	private Socket cSocket;
	public PrintWriter out;
	public BufferedReader in;
	
	public Transport(Socket cSocket) {
		this.cSocket = cSocket;
		try {
			out = new PrintWriter(new OutputStreamWriter(cSocket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void messageClient(String s) throws IOException{
		out.print(s + "\n");
		out.flush();
	}
	
	public String getFromClient(String s) throws IOException{
		out.print(s + ": ");
		out.flush();
		return in.readLine();
	}
}
