import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Graph g = new Graph(3);
		g.insert(1, 2);
		g.insert(0, 1);
		g.saveToTextFile("out.txt");
		g.saveToBinaryFile("output");
		Graph g1 = new Graph();
		g1.loadFromTextFile("out.txt");
		Graph g2 = new Graph();
		g2.loadFromBinaryFile("output");
		System.out.println(g1);
		System.out.println(g2);
	}
}