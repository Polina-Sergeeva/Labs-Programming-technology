import java.util.*;
import java.io.*;

public class Node {
 
    public int key; 
    public String data; 
    public Node leftChild; 
    public Node rightChild; 
    
    public String toString(){
		return (this.key + " " + this.data + "\r\n");
    }
    public void printText(Writer w) throws IOException{
        String res = this.toString();
        w.append(res, 0, res.length());
    }

    public void printNode(){
        System.out.println("KEY " + key + " DATA: " + data);
    }
}