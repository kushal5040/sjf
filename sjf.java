import java.util.Scanner;

class sjf {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        // Get number of processes from user
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();
        
        String title[] = {"Processes", "BT", "WT", "TAT"};
        String processes[] = new String[n];
        int BT[] = new int[n];
        int WT[] = new int[n];
        int TAT[] = new int[n];
        
        // Input process names and burst times
        for(int i = 0; i < n; i++) {
            System.out.print("Enter process name (e.g., p" + (i+1) + "): ");
            processes[i] = scanner.next();
            
            System.out.print("Enter burst time for " + processes[i] + ": ");
            BT[i] = scanner.nextInt();
        }
        
        WT[0] = 0; // waiting time for first process is 0
        float total_BT = 0, total_WT = 0, total_TAT = 0;
        
        // Sort processes based on burst time
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < n; i++) {
                if(BT[i] > BT[j]) {
                    // Swap process names
                    String temp = processes[i];
                    processes[i] = processes[j];
                    processes[j] = temp;
                    
                    // Swap burst times
                    int temp1 = BT[i];
                    BT[i] = BT[j];
                    BT[j] = temp1;
                }
            }
        }
        
        // Calculate waiting time
        for(int i = 1; i < n; i++) {
            WT[i] = BT[i-1] + WT[i-1];
        }
        
        // Calculate turnaround time
        for(int i = 0; i < n; i++) {
            TAT[i] = BT[i] + WT[i];
        }
        
        // Print header
        for(int i = 0; i < 4; i++) {
            System.out.print(title[i] + "\t");
        }
        
        System.out.println("\n-------------------------------------");
        
        // Print process details
        for(int i = 0; i < n; i++) {
            System.out.println(processes[i] + "\t\t" + BT[i] + "\t" + WT[i] + "\t" + TAT[i]);
        }
        
        // Calculate totals
        for(int i = 0; i < n; i++) {
            total_BT += BT[i];
            total_WT += WT[i];
            total_TAT += TAT[i];
        }
        
        // Calculate averages
        float avg_BT = total_BT/n;
        float avg_WT = total_WT/n;
        float avg_TAT = total_TAT/n;
        
        // Print totals and averages
        System.out.println("\n");
        System.out.println("Total Burst Time = " + total_BT);
        System.out.println("Total Waiting Time = " + total_WT);
        System.out.println("Total Turn Around Time = " + total_TAT);
        System.out.println("Average Burst Time = " + avg_BT);
        System.out.println("Average Waiting Time = " + avg_WT);
        System.out.println("Average Turn Around Time = " + avg_TAT);
        
        scanner.close();
    }
}