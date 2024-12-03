package src.firstComeFS;

import java.util.*;

public class FCFS {
    public static void main(String[] args) {
        Scanner fcfs = new Scanner(System.in);

        //Number of process  
        System.out.print("Enter the number of processes: ");
        int N = fcfs.nextInt(); 

        // Initialize array of arrival, burst, waiting and turnaround times;
        int[] at = new int[N]; 
        int[] bt = new int[N];  
        int[] wt = new int[N]; 
        int[] tat = new int[N]; 

        // Input arrival times and burst times
        System.out.println("Enter arrival times:");
        for (int i = 0; i < N; i++) {
            System.out.print("Process " + (i + 1) + ": ");
            at[i] = fcfs.nextInt();
        }

        System.out.println("Enter burst times:");
        for (int i = 0; i < N; i++) {
            System.out.print("Process " + (i + 1) + ": ");
            bt[i] = fcfs.nextInt();
        }

        // Calculate waiting time and turnaround time
        int[] ct = new int[N]; // Completion times

        ct[0] = at[0] + bt[0]; // Completion time for the first process

        tat[0] = ct[0] - at[0]; // Turnaround time for the first process
        
        wt[0] = tat[0] - bt[0]; // Waiting time for the first process

        for (int i = 1; i < N; i++) {
            ct[i] = Math.max(ct[i - 1], at[i]) + bt[i];
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
        }

        //  results
        System.out.println("\n+{---------}+{---------}-----+{---------}---+{---------}-----+{---------}--------+{---------}-------+");
        System.out.println("| Process | Arrival Time | Burst Time | Waiting Time | Turnaround Time | Completion Time |");
        System.out.println("+{---------}+{---------}-----+{---------}---+{---------}-----+{---------}--------+{---------}-------+");
        for (int i = 0; i < N; i++) {
            System.out.printf("| %-7d | %-12d | %-10d | %-12d | %-15d | %-14d |\n",
                    (i + 1), at[i], bt[i], wt[i], tat[i], ct[i]);
        }
        System.out.println("+{---------}+{---------}-----+{---------}---+{---------}-----+{---------}--------+{---------}-------+");
        

        // Average waiting time and turnaround time
        double avgWt = 0, avgTat = 0;
        for (int i = 0; i < N; i++) {
            avgWt += wt[i];
            avgTat += tat[i];
        }
        avgWt /= N;
        avgTat /= N;

        System.out.println("\nAverage Waiting Time: " + avgWt);
        System.out.println("Average Turnaround Time: " + avgTat);

        fcfs.close();
    }
}
