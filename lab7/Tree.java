import java.util.*;
import java.io.*;


public class Tree {
	Node root;

	public Node find(int key){
		Node current = root;
		while(current.key != key){
			if(current.key < key){
				current = current.leftChild;
			}
			else{
				current = current.rightChild;
			}
			if (current == null){
				return null;
			}
		}
		return current;
	}
	public void insert (int key, String data){
		Node node = new Node();
		node.key = key;
		node.data = data;
		if(root == null){
			root = node;
		}
		else{
			Node current = root;
			Node prev = null;
			while(true){
				prev = current;
				if(key < prev.key){
					current = current.leftChild;
					if(current == null){
						prev.leftChild = node;
						return;
					}
				}
				else{
					current = current.rightChild;
					if(current == null){
						prev.rightChild = node;
						return;
				    }
				}
			}
		}
	}
	public void saveToTextFile(String filename,Node startNode) throws IOException {
		OutputStream out = new FileOutputStream(filename);
    	Writer w = new BufferedWriter (new OutputStreamWriter(out));
    	child (startNode, w);
		w.close();
	}
	public void child (Node startNode, Writer w) throws IOException {
			if(startNode != null)
			{
				child(startNode.leftChild, w);
    			startNode.printText(w);
    			child(startNode.rightChild, w);
			}
	}

	public static Tree loadFromTextFile(String filename) throws IOException {
		Tree resTree = new Tree();
		String key = null;
		String data = null;
		InputStream in = new FileInputStream(filename);
		Reader r = new BufferedReader(new InputStreamReader(in));
       	Scanner sc = new Scanner (r);
    	while (sc.hasNext()) {
    		key = sc.next();
    		data = sc.next();
    		resTree.insert(Integer.parseInt(key), data);
    	}
    	sc.close ();
    	return resTree;
	}

	public void print(Node startNode){
        if(startNode != null){
            print(startNode.leftChild);
            startNode.printNode();
            print(startNode.rightChild);
        }
    }

}