package system.global;

import java.util.LinkedList;
import java.util.Queue;
import system.models.Process;

public class System {
    private static Queue<Process> FE = null;
    private static Queue<Process> FTR = null;
    private static Queue<Process> FU = null;
    private static Queue<Process> FU2 = null;
    private static Queue<Process> FU3 = null;


    public static void init() {
        FE = new LinkedList<Process>();
        FTR = new LinkedList<Process>();
        FU = new LinkedList<Process>();
        FU2 = new LinkedList<Process>();
        FU3 = new LinkedList<Process>();
    }


    public void addProcessOnFE(Process p) {
        FE.add(p);
    }

    public void addProcessOnFTR(Process p) {
        FTR.add(p);
    }

    public void addProcessOnFU(Process p) {
        FU.add(p);
    }

    public void addProcessOnFU2(Process p) {
        FU2.add(p);
    }

    public void addProcessOnFU3(Process p) {
        FU3.add(p);
    }
}
