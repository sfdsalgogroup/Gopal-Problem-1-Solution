/**
 * 
 */
package github.gopal.problem1.util;

import github.gopal.problem1.structures.ModifiedLLNode;

/**
 * @author Gopal
 *
 */
public class ListPrinter {

	private ListPrinter() {
		// NOOP
	}

	public static void printList(ModifiedLLNode headNode) {
		if (headNode == null) {
			return;
		}
		ModifiedLLNode temp = headNode;
		int count = 1;
		while (temp != null) {
			System.out.println("Printing Node : " + count);
			System.out.println("Node Data : " + temp.getData());
			String nextNodeData = null;
			if (temp.getNext() != null) {
				nextNodeData = temp.getNext().getData();
			}
			System.out.println("Next Node : " + nextNodeData);

			String jumpNodeData = null;
			if (temp.getJump() != null) {
				jumpNodeData = temp.getJump().getData();
			}
			System.out.println("Jump Node : " + jumpNodeData);
			System.out.println("Hash : " + temp.hashCode());
			temp = temp.getNext();
			count++;
		}
	}

}
