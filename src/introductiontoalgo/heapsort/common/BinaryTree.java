package introductiontoalgo.heapsort.common;


public class BinaryTree {
	private int[] intArray;

	public BinaryTree(int[] intArray) {
		this.intArray = intArray;
	}

	public int getParent(int index) {
		if (intArray != null) {
			if (index > 0 && index < intArray.length) {
				if (index == 0) {
					throw new IllegalArgumentException(
							"this point is root, no parent");
				} else {
					return index / 2;
				}
			}
		}
		return -1;
	}

	public int getLeft(int index) {
		if (intArray != null && index > 0 && index < intArray.length / 2) {
			return (2 * index + 1);
		}
		return -1;
	}

	public int[] toArray() {
		return intArray;
	}
}
