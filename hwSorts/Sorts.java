package hwSorts;

public class Sorts {
	public static void printArray(int[] data) {
		String s = "[ ";
		for (int x = 0; x < data.length; x++) {
			s += data[x];
			if (x + 1 != data.length) {
				s += ", ";
			}
		}
		s += "]";
		System.out.println(s);
	}

	public static void insertionSort(int[] data) {
		int[] ndata = new int[0];
		for (int x = 0; x < data.length; x++) {
			ndata = add(addIndex(data[x], ndata), data[x], ndata);
		}
		for (int x = 0; x < data.length; x++) {
			data[x] = ndata[x];
		}
	}

	public static void selectionSort(int[] data) {
		int min;
		int index;
		for (int x = 0; x < data.length; x++) {
			min = data[x];
			index = x;
			for (int y = x; y < data.length; y++) {
				if (min > data[y]) {
					min = data[y];
					index = y;
				}
			}
			data[index] = data[x];
			data[x] = min;
		}

	}

	private static int addIndex(int n, int[] data) {
		int place0 = 0;
		int place1 = data.length;
		double mid;
		while (true) {
			mid = (place1 - place0) / 2.;
			if (place0 == place1) {
				return place0;
			}
			if (data[place0] < n) {
				place0 += mid + .5;
			} else if (place0 - mid > 0 && data[(int) (place0 - mid)] > n) {
				place0 -= mid;
			} else if (place1 + mid < data.length && data[(int) (place1 + mid)] < n) {
				place1 += mid;
			} else {
				place1 -= mid;
			}
		}
	}

	private static int[] add(int index, int element, int[] data) {
		int[] ndata = new int[data.length + 1];
		for (int x = 0; x < index; x++) {
			ndata[x] = data[x];
		}
		ndata[index] = element;
		for (int x = index; x < data.length; x++) {
			ndata[x + 1] = data[x];
		}
		return ndata;
	}

	public static void main(String[] args) {
		int[] ints = { 0, 5, 3, 4, 2 };
		selectionSort(ints);
		printArray(ints);
	}

}
