package lec5_lists2;

public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Returns the ith item of this IntList. */
	public int get(int i) {
		if (i == 0) {
			return first;
		}
		return rest.get(i - 1);
	}

	public void addAdjacent() {
		if (rest == null) {
			return;
		}
		if (first == rest.first) {
			first *= 2;
			rest = rest.rest;
			addAdjacent();
		}
		rest.addAdjacent();
	}

	public void addSquare(int i) {
		if (rest != null) {
			rest = new IntList(first * first, rest);
			rest.rest.addSquare(i);
		} else {
			IntList L = new IntList(i, null);
			rest = new IntList(first * first, L);
		}
	}

	public static void main(String[] args) {
		// IntList L = new IntList(15, null);
		// L = new IntList(10, L);
		// L = new IntList(5, L);

		// System.out.println(L.get(100));

		// IntList L1 = new IntList(3, null);
		// L1 = new IntList(2, L1);
		// L1 = new IntList(1, L1);
		// L1 = new IntList(1, L1);
		// L1.addAdjacent();

		IntList L2 = new IntList(2, null);
		L2 = new IntList(1, L2);
		L2.addSquare(5);
		L2.addSquare(7);
	}
}