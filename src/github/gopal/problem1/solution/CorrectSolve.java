/**
 * 
 */
package github.gopal.problem1.solution;

import github.gopal.problem1.structures.ModifiedLLNode;

/**
 * @author Gopal
 *
 */
public class CorrectSolve {

	private CorrectSolve() {
		// NOOP
	}

	public static ModifiedLLNode cloneOriginalList(ModifiedLLNode originalHeadNode) {
		if (originalHeadNode == null) {
			return null;
		}

		ModifiedLLNode tempOriginalNode = originalHeadNode;
		while (tempOriginalNode != null) {
			ModifiedLLNode tempOriginalNextNode = tempOriginalNode.getNext();
			ModifiedLLNode tempClonedNode = new ModifiedLLNode();
			tempClonedNode.setData((tempOriginalNode.getData()));
			tempClonedNode.setNext(tempOriginalNextNode);
			tempClonedNode.setJump(tempOriginalNode);
			tempOriginalNode.setNext(tempClonedNode);
			tempOriginalNode = tempOriginalNextNode;
		}

		tempOriginalNode = originalHeadNode;
		while (tempOriginalNode != null) {
			ModifiedLLNode tempClonedNode = tempOriginalNode.getNext();
			ModifiedLLNode tempOriginalJumpNode = tempOriginalNode.getJump();
			ModifiedLLNode tempClonedJumpNode = tempOriginalJumpNode.getNext();
			tempClonedNode.setJump(tempClonedJumpNode);
			tempOriginalNode = tempClonedNode.getNext();
		}

		tempOriginalNode = originalHeadNode;
		ModifiedLLNode clonedHeadNode = originalHeadNode.getNext();
		ModifiedLLNode clonedPrevNode = null;
		while (tempOriginalNode != null) {
			ModifiedLLNode tempClonedNode = tempOriginalNode.getNext();
			ModifiedLLNode tempOriginalNextNode = tempClonedNode.getNext();
			tempOriginalNode.setNext(tempOriginalNextNode);
			if (clonedPrevNode != null) {
				clonedPrevNode.setNext(tempClonedNode);
			}
			clonedPrevNode = tempClonedNode;
			tempOriginalNode = tempOriginalNextNode;
		}

		return clonedHeadNode;
	}

}
