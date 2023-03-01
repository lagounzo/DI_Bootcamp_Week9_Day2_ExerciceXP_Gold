/**
 * Exercice 1 : SumTree
 * Instructions
 * Écrivez une fonction qui renvoie true si l'arbre binaire donné est SumTree sinon false. Un SumTree est un arbre binaire
 * où la valeur d'un nœud est égale à la somme des nœuds présents dans son sous-arbre gauche et son sous-arbre droit.
 * Un arbre vide est SumTree et la somme d'un arbre vide peut être considérée comme 0. Un nœud feuille est également considéré comme SumTree.
 *
 * Voici un exemple de SumTree.
 *
 *           26
 *         /   \
 *       10     3
 *     /    \     \
 *   4      6      3
 */

package exercice1;

public class SumTree {
	
	 boolean isSumTree(Node node) {
	        if (node == null || (node.left == null && node.right == null)) {
	            // Si le nœud est null ou un nœud feuille, alors il est considéré comme SumTree.
	            return true;
	        }
	        
	        // Vérifiez si le nœud est un SumTree en fonction des valeurs des sous-arbres gauche et droit.
	        int left_sum = 0;
	        int right_sum = 0;
	        
	        if (node.left != null) {
	            left_sum = node.left.val;
	            if (node.left.left == null && node.left.right == null) {
	                left_sum = node.left.val;
	            } else {
	                left_sum = 2 * node.left.val;
	            }
	        }
	        
	        if (node.right != null) {
	            right_sum = node.right.val;
	            if (node.right.left == null && node.right.right == null) {
	                right_sum = node.right.val;
	            } else {
	                right_sum = 2 * node.right.val;
	            }
	        }
	        
	        if (node.val == left_sum + right_sum) {
	            return isSumTree(node.left) && isSumTree(node.right);
	        } else {
	            return false;
	        }
	    }

}
