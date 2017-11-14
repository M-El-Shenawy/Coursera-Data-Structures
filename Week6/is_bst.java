import java.util.*;
import java.io.*;

public class is_bst {
	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class recuIsBST {
		class Node {
			int key;
			int left;
			int right;

			Node(int key, int left, int right) {
				this.left = left;
				this.right = right;
				this.key = key;
			}
		}

		int nodes;
		Node[] tree;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			nodes = in.nextInt();
			tree = new Node[nodes];
			for (int i = 0; i < nodes; i++) {
				tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
			}
		}

		boolean isBinarySearchTree() {
			// Implement correct algorithm here
			if(tree.length == 0) return true;
			return isBSTUntil(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		boolean isBSTUntil(int k, int min, int max) {
			if (k == -1) {
				return true;
			}
			if (tree[k].key < min || tree[k].key > max) {
				return false;
			}
			return (isBSTUntil(tree[k].left, min, tree[k].key - 1) && isBSTUntil(tree[k].right, tree[k].key + 1, max));
		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new is_bst().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		recuIsBST tree = new recuIsBST();
		tree.read();
		if (tree.isBinarySearchTree()) {
			System.out.println("CORRECT");
		} else {
			System.out.println("INCORRECT");
		}
	}
}

