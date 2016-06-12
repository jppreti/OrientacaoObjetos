package br.edu.ifmt.cba.java.compressao;

public class Genome {

	public static void compress() {
		Alphabet DNA = new Alphabet("ACTG");
		int w = DNA.lgR(); // w == 2
		String s = BinaryStdIn.readString();
		int N = s.length();
		BinaryStdOut.write(N);
		for (int i = 0; i < N; i++) {
			int d = DNA.toIndex(s.charAt(i));
			BinaryStdOut.write(d, w); // escreve 2 bits
		}
		BinaryStdOut.close();
	}

	public static void expand() {
		Alphabet DNA = new Alphabet("ACTG");
		int w = DNA.lgR(); // w == 2
		int N = BinaryStdIn.readInt();
		for (int i = 0; i < N; i++) {
			char c = BinaryStdIn.readChar(w); // lê 2 bits e
			BinaryStdOut.write(DNA.toChar(c)); // escreve um char
		}
		BinaryStdOut.close();
	}

	public static void main(String[] args) {
		if (args[0].equals("-"))
			compress();
		if (args[0].equals("+"))
			expand();
	}
}
