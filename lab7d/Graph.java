import java.io.*;
import java.util.*;

public class Graph {
	int size;
	int[][] matrix;

	public Graph (int s) {
		size = s;
		matrix = new int[size][size];
	}

	public Graph () {
	}

	public void insert(int vershina1, int vershina2){
		matrix[vershina1][vershina1] = 1;
	}
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(size + "\n");
		for (int i = 0; i < size; i++){ 
			for (int j = 0; j < size; j++) 
				res.append(matrix[i][j] + " ");
			res.append("\n");
		}

		return res.toString();
	}

	public void loadFromTextFile(String filename) throws IOException {
		FileReader file = new FileReader(filename);
		Scanner scan = new Scanner(file);
		String s = scan.nextLine();
		Integer tm = Integer.valueOf(s);
		size = tm;
		matrix = new int[size][size];
		int i = 0;
		while (scan.hasNextLine()) {
			String[] tmp = scan.nextLine().split(" ");
			for (int j = 0; j < size; j++) {
				Integer value = Integer.valueOf(tmp[j]);
				matrix[i][j] = value;
			}
			i++;
		}
		file.close();
	}
	public void loadFromBinaryFile(String filename) throws IOException {
		FileInputStream file = new FileInputStream(filename);
		byte[] buffer = new byte[file.available()];
		file.read(buffer, 0, file.available());
		size = buffer[0];
		matrix = new int[size][size];
		int g = 0, j = 0;
			for(int i = 1; i < buffer.length - 1; i++){
				if (g >= size | j >= size) break;
				if (buffer[i+1] == ' ')
					matrix[g][j] = buffer[i];
				else {
					int tm = 0;
					for (int q = 0; q < 3; q++) {
						tm += buffer[i++];
						tm = tm << 8;
					}
					tm += buffer[i];
					matrix[g][j] = tm;
				}
				i++;
				if (j == size - 1){
					g++;
					i++;
					j = 0;
				}
				else {
					j++;
				}
				
			}
	}

	public void saveToTextFile(String filename) throws IOException {
		FileOutputStream file = new FileOutputStream(filename);
		String text = toString();
		byte[] buffer = text.getBytes();
		file.write(buffer, 0, buffer.length);
	}

	public void saveToBinaryFile(String filename) throws IOException {
		FileOutputStream file = new FileOutputStream(filename);
		file.write(size);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int val = matrix[i][j];
				int num;
				if (val>255) {
					num = val&0xFF000000;
					num = num >> 24;
					file.write(num);
					num = val&0xFF0000;
					num = num >> 16;
					file.write(num);
					num = val&0xFF00;
					num = num >> 8;
					file.write(num);
					num = val&0xFF;
					file.write(num);
				}
				else {
					file.write(val);
				}
				file.write(' ');
			}
			file.write('\n');

		}
	}
}