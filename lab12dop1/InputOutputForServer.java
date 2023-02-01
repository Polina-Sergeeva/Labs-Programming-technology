/*import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;*/
import java.io.*;
import java.net.Socket;
/*import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map*/;
import java.util.*;

public class InputOutputForServer extends Thread {
    private String name;
    private Socket client;
    private int password;
    private  HashMap<String,ArrayList<Socket>> arrayOfSockets;
    public InputOutputForServer(Socket client, HashMap<String,ArrayList<Socket>> a){
        this.client = client;
        this.arrayOfSockets = a;
    }

    public boolean command(String in) throws IOException {
        char[] mas = in.toCharArray();
        int i = 0;
        for(i = 0; mas[i] != '@'; i++);
        StringBuilder sb = new StringBuilder();
        for(;mas[i] != ' '; i++){
            sb.append(mas[i]);
            if(i+1 == in.length())break;
        }

        i++;
        System.out.println(sb.toString());
            if(sb.toString().equals("@senduser")){
                sb.delete(0,sb.length());
            for(;mas[i] !=' '; i++){
                sb.append(mas[i]);
                if(i+1 == in.length())break;
            }
            i++;
            if(i < in.length()){
                String receiver = sb.toString();
                sb.delete(0,sb.length());
                for(;i<in.length(); i++){
                    sb.append(mas[i]);
                }
                String massage = sb.toString();
                for(i = 0; mas[i] != ':';i++)
                    sb.append(mas[i]);
                String sender = sb.toString();
                for (Map.Entry<String, ArrayList<Socket>> tmp : arrayOfSockets.entrySet()) {
                    String key = tmp.getKey();
                    if(key.equals(receiver)){
                        ArrayList<Socket> list = new ArrayList<Socket>();
                        list = tmp.getValue();
                        for(int j = 0; j < list.size(); j++){
                            Socket curClient = list.get(j);
                            DataOutputStream toUser = new DataOutputStream(curClient.getOutputStream());
                            toUser.writeUTF("Private message from " + name + ": " + massage);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }



    public void run(){
        try {
            DataInputStream fromUser = new DataInputStream(client.getInputStream());
            this.name = fromUser.readUTF();
            this.password = Integer.parseInt(fromUser.readUTF());
            BufferedReader r = new BufferedReader (new InputStreamReader(new FileInputStream("loginPassword.txt")));
            HashMap<String,Integer> loginPassword = new HashMap<>();
            String[] subStr;
            String temp, delimeter = " ";
            while(r.ready()) {
                temp = r.readLine();
                subStr = temp.split(delimeter);
                loginPassword.put(subStr[0], Integer.parseInt(subStr[1]));
            }
            if (loginPassword.containsKey(name) && loginPassword.get(name) == password) {
	            if (arrayOfSockets.containsKey(name)) {
	            	ArrayList<Socket> lis = arrayOfSockets.get(name);
	                lis.add(client);
	                arrayOfSockets.put(name, lis);
	                System.out.println("Yes1");
	            } else {
	            	System.out.println("Yes2");
	                ArrayList<Socket> lis = new ArrayList<Socket>();
	                lis.add(client);
	                arrayOfSockets.put(name, lis);
	            }
	            while(true){
	                String line = fromUser.readUTF();
	                char[] str = line.toCharArray();
	                boolean haveCommand = false;
	                int i;
	                for(i = 0; i<line.length(); i++){
	                    if(str[i] == '@'){
	                        haveCommand = true;
	                    }
	                    if(haveCommand)break;
	                }
	                if(haveCommand){
	                    if(this.command(line))continue;
	                }
	                char[] lettersOfName = new char[i+1];
	                for(int j = 0; j< i; j++){
	                    lettersOfName[j] = str[j];
	                }
	                System.out.println(line);
	                for (Map.Entry<String, ArrayList<Socket>> tmp : arrayOfSockets.entrySet()) {
	                    String key = tmp.getKey();
	                    ArrayList<Socket> list = new ArrayList<Socket>();
	                    list = tmp.getValue();
	                    for(int j = 0; j < list.size(); j++){
	                        Socket curClient = list.get(j);
	                        DataOutputStream toUser = new DataOutputStream(curClient.getOutputStream());
	                        toUser.writeUTF(line);
	                    }
	                }
	            }
	        } else {
            	client.close();
                System.out.println("Incorrect name or password of user");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
