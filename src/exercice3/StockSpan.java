/**
 * Exercice 3 : Le Problème De La Durée Du Stock
 * Instructions
 * Le problème de l'étendue des actions est un problème financier dans lequel nous avons une série de N cotations de prix quotidiennes
 *
 * pour une action et nous devons calculer l'étendue du prix de l'action pour tous les N jours. L'intervalle Si du cours de l'action un
 * jour donné i est défini comme le nombre maximum de jours consécutifs juste avant le jour donné, pour lesquels le cours de l'action du
 * jour courant est inférieur à son cours du jour donné.
 *
 * Exemples:
 *
 * Input: N = 7, price[] = [100 80 60 70 60 75 85]
 * Output: 1 1 1 2 1 4 6
 * Explication : Traverser la plage d'entrée donnée pour 100 sera 1, 80 est inférieur à 100 donc la plage est 1, 60 est plus petit
 * que 80 donc la plage est 1, 70 est supérieur à 60 donc la plage est 2 et ainsi de suite. Par conséquent,
 * la sortie sera 1 1 1 2 1 4 6.
 *
 * Input: N = 6, price[] = [10 4 5 90 120 80]
 * Output:1 1 2 4 5 1
 * Explication : Traverser la plage d'entrée donnée pour 10 sera 1, 4 est plus petit que 10 donc
 * la plage sera 1, 5 est supérieur à 4 donc la plage sera 2 et ainsi de suite. Par conséquent, la sortie sera 1 1 2 4 5 1.
 */

package exercice3;

import java.util.*;

public class StockSpan {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] spans = new int[n];

        // Stack to keep track of previous days where the price was lower
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Push the first day index onto the stack

        spans[0] = 1; // The span for the first day is always 1

        for (int i = 1; i < n; i++) {
            // Pop days from the stack until the price for the day at the top of the stack
            // is greater than the price for the current day
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If the stack is empty, then the current day is the highest price seen so far
            // and the span is just the number of days from the first day up to this day
            if (stack.isEmpty()) {
                spans[i] = i + 1;
            }
            // Otherwise, the current day is lower than the day at the top of the stack,
            // so the span is the difference between the current day and the day at the top
            // of the stack
            else {
                spans[i] = i - stack.peek();
            }

            // Push the index of the current day onto the stack for the next iteration
            stack.push(i);
        }

        return spans;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = calculateSpan(prices);
        System.out.println(Arrays.toString(spans)); // [1, 1, 1, 2, 1, 4, 6]
    }
}
