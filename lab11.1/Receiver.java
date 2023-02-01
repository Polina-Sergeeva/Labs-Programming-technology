
import java.io.IOException;
import java.net.*;


public class Receiver extends Thread {
	private InputOutput inputOutput;
	private Client client;
	private String clientName = "Client";

	public Receiver(InputOutput inputOutput, Client client) {
		this.inputOutput = inputOutput;
		this.client = client;
	}

	public DatagramPacket receive() throws IOException {
		DatagramSocket socket = this.client.getSocket();
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        socket.receive(packet);
        return packet;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void run() {
		try {
			while(true) {
				if (isInterrupted()) {
					throw new InterruptedException();
				}
				DatagramPacket packet = this.receive();
				if (this.client.getAddress() == null) {
					this.client.setAddress(packet.getSocketAddress());
				}
            	String message =  new String (packet.getData(), "UTF-8");
            	String str = new String();
            	int j = 7;
            	char tmp = '\n';
            	this.clientName = new String();
            	while(message.charAt(j) != tmp){
            		this.clientName += message.charAt(j);
            		j++;
            	}
            	for(int i = 0; i < message.length(); i++) {
            		if(message.charAt(i) == 0)
            			break;
            		str += message.charAt(i);
            	}
            	message = message.trim();
            	inputOutput.write(message);
            	
			}
		}
		catch(InterruptedException e) {
			System.out.println("Chat is finished.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}