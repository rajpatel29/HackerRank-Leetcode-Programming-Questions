//You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.
//
//For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine 
//to one of its adjacent washing machines at the same time .
//
//Given an integer array representing the number of dresses in each washing machine from left to right on the line,
//you should find the minimum number of moves to make all the washing machines have the same number of dresses. 
//If it is not possible to do it, return -1.

package Super_Washing_Machines;

public class MainClass {
    public int findMinMoves(int[] machines) {
        int total = 0, target = 0, result = 0, n = machines.length;
        for (int d : machines) total += d;
        if (total == 0) return 0;
        if (total % n != 0) return -1;
        target = total / n;
        
        int[] move = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (machines[i] > target) {
                move[i] += machines[i] - target;
                machines[i + 1] += machines[i] - target;
                machines[i] = target;
                result = Math.max(result, move[i]);
            }
            else {
                move[i + 1] = target - machines[i];
                machines[i + 1] -= target - machines[i];
                machines[i] = target;
                result = Math.max(result, move[i + 1]);
            }
        }
        
        return result;
    }
}