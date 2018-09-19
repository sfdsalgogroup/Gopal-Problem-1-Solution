/**
 * 
 */
package github.gopal.problem1.solution;

import github.gopal.problem1.structures.ModifiedLLNode;
import github.gopal.problem1.util.ListPrinter;

/**
 * @author Gopal
 *
 */
public class Solve {

	private Solve() {
		// NOOP
	}

	public static ModifiedLLNode cloneOriginalList(ModifiedLLNode originalHeadNode) {
		if (originalHeadNode == null) {
			return null;
		}

		ModifiedLLNode tempOriginalNode = originalHeadNode;
		ModifiedLLNode prevClonedNode = null;

		while (tempOriginalNode != null) {
			ModifiedLLNode tempOriginalNextNode = tempOriginalNode.getNext();

			ModifiedLLNode tempClonedNode = new ModifiedLLNode();
			tempClonedNode.setData(tempOriginalNode.getData());

			tempOriginalNode.setNext(tempClonedNode);
			tempClonedNode.setJump(tempOriginalNode);
			
			if (prevClonedNode != null) {
				prevClonedNode.setNext(tempClonedNode);
			}
			prevClonedNode = tempClonedNode;
			tempOriginalNode = tempOriginalNextNode;
		}

		ModifiedLLNode clonedHeadNode = originalHeadNode.getNext();
		ModifiedLLNode tempClonedNode = clonedHeadNode;
		
		
		System.out.println("#############################################");
		ListPrinter.printList(clonedHeadNode);
		System.out.println("#############################################");
		
		
		
		while (tempClonedNode != null) {
			ModifiedLLNode tempClonedNextNode = tempClonedNode.getNext();
			ModifiedLLNode correspondingOriginalNode = tempClonedNode.getJump();
			ModifiedLLNode jumpNodeForTempClonedNode = correspondingOriginalNode.getJump().getNext();
			ModifiedLLNode correspondingOriginalNextNode = (tempClonedNode.getNext() != null)
					? tempClonedNode.getNext().getJump() : null;
			correspondingOriginalNode.setNext(correspondingOriginalNextNode);
			tempClonedNode.setJump(jumpNodeForTempClonedNode);
			tempClonedNode = tempClonedNextNode;
		}

		return clonedHeadNode;
	}

}
