import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		/*Tree tree = new Tree();
		tree.insert(1, "klass");
		tree.insert(4, "lass");
		tree.insert(2, "ass");
		tree.insert(3, "ss");
		Node startNode = tree.find(2);
		tree.saveToTextFile("output.txt", startNode);*/
		Settings sets2 = Settings.loadFromTextFile("in.txt");
		System.out.println("Loaded from text file");
		System.out.println();
		System.out.println(sets2);
		sets2.put("server", 912);
		System.out.println(sets2);
		sets2.saveToTextFile("out.txt");
		System.out.println("Saved to text file");
		System.out.println();
		sets2.saveToBinaryFile("out1");
		System.out.println("Saved to binary file");
		System.out.println();
		Settings sets3 = Settings.loadFromBinaryFile("out1");
		System.out.println("Loaded from binary file");
		System.out.println();
		System.out.println(sets3);
		sets3.delete("server");
		System.out.println(sets3);
	}
}