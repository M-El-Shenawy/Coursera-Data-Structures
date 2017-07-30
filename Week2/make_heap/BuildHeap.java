import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
	private int[] data;
	private List<Swap> swaps;

	private FastScanner in;
	private PrintWriter out;

	public static void main(String[] args) throws IOException {
		new BuildHeap().solve();
	}

	private void readData() throws IOException {
		int n = in.nextInt();
		data = new int[n];
		for (int i = 0; i < n; ++i) {
			data[i] = in.nextInt();
		}
	}

	private void writeResponse() {
		out.println(swaps.size());
		for (Swap swap : swaps) {
			out.println(swap.index1 + " " + swap.index2);
		}
	}

	private int getLeftChild(int i, int arrSize) {
		int left = 2 * i + 1;
		if (left >= arrSize) {
			return -1;
		}
		return left;
	}

	private int getRightChild(int i, int arrSize) {
		int right = 2 * i + 2;
		if (right >= arrSize) {
			return -1;
		}
		return right;
	}

	private void siftDown(int i, int arrSize, int[] arr) {
		int minIndex = i;
		int leftChild = getLeftChild(i, arrSize);
		if (leftChild != -1 && arr[leftChild] < arr[minIndex]) {
			minIndex = leftChild;
		}
		int rightChild = getRightChild(i, arrSize);
		if (rightChild != -1 && arr[rightChild] < arr[minIndex]) {
			minIndex = rightChild;
		}
		if (i != minIndex) {
			swaps.add(new Swap(i, minIndex));
			int tmp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = tmp;
		} else {
			return;
		}
		siftDown(minIndex, arrSize, arr);
	}

	private void generateSwaps() {
		swaps = new ArrayList<Swap>();
		// The following naive implementation just sorts
		// the given sequence using selection sort algorithm
		// and saves the resulting sequence of swaps.
		// This turns the given array into a heap,
		// but in the worst case gives a quadratic number of swaps.
		//
		// TODO: replace by a more efficient implementation
		int n = data.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			siftDown(i, n, data);
		}
	}

	public void solve() throws IOException {
		in = new FastScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		readData();
		generateSwaps();
		writeResponse();
		out.close();
	}

	static class Swap {
		int index1;
		int index2;

		public Swap(int index1, int index2) {
			this.index1 = index1;
			this.index2 = index2;
		}
	}

	static class FastScanner {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}

		public String next() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
}
