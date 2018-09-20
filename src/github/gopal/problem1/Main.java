/**
 * 
 */
package github.gopal.problem1;

import github.gopal.problem1.solution.CorrectSolve;
import github.gopal.problem1.structures.ModifiedLLNode;
import github.gopal.problem1.util.ListCreator;
import github.gopal.problem1.util.ListPrinter;

/**
 * @author Gopal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ModifiedLLNode originalHeadNode = ListCreator.getOriginalList();
		System.out.println("Printing Original List Before Solving...");
		ListPrinter.printList(originalHeadNode);

		ModifiedLLNode clonedHeaderNode = CorrectSolve.cloneOriginalList(originalHeadNode);

		System.out.println("Printing Original List After Solving...");
		ListPrinter.printList(originalHeadNode);

		System.out.println("Printing Cloned List After Solving...");
		ListPrinter.printList(clonedHeaderNode);
	}

}
