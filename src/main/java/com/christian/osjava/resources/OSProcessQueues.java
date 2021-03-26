package com.christian.osjava.resources;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import com.christian.osjava.config.Constants;
import com.christian.osjava.models.Process;
import com.christian.osjava.utils.Logger;

public class OSProcessQueues {
	private static Queue<Process> FE;
	private static Queue<Process> FTR;
	private static Queue<Process> FU;
	private static Queue<Process> FU2;
	private static Queue<Process> FU3;
    private static boolean queuesOn;

	public static void init() {
		Logger.info("Initing OSProcessQueues");

		Logger.info("Initing FE");
		FE = new LinkedList<Process>();
		Logger.info("FE initialized with success");

		Logger.info("Initing FTR");
		FTR = new LinkedList<Process>();
		Logger.info("FTR initialized with success");

		Logger.info("Initing FU");
		FU = new LinkedList<Process>();
		Logger.info("FU initialized with success");

		Logger.info("Initing FU2");
		FU2 = new LinkedList<Process>();
		Logger.info("FU2 initialized with success");

		Logger.info("Initing FU3");
		FU3 = new LinkedList<Process>();
		Logger.info("FU3 initialized with success");

		Logger.info("OSProcessQueues initialized with success");

        queuesOn = true;
	}

	public static void finish() {
        Logger.info("Finishing OSProcessQueues");
        queuesOn = false;

		Logger.info("Finishing FE");
		FE.clear();
		FE = null;
		Logger.info("FE finished with success");

		Logger.info("Finishing FTR");
		FTR.clear();
		FTR = null;
		Logger.info("FTR finished with success");

		Logger.info("Finishing FU");
		FU.clear();
		FU = null;
		Logger.info("FU finished with success");

		Logger.info("Finishing FU2");
		FU2.clear();
		FU2 = null;
		Logger.info("FU2 finished with success");

		Logger.info("Finishing FU3");
		FU3.clear();
		FU3 = null;
		Logger.info("FU3 finished with success");

		Logger.info("OSProcessQueues finished with success");
	}

	public static void addProcessOnFE(Process p) {
		if (isQueuesOn()) {
            FE.add(p);
        }
	}

	public static Process getProcessFromFE() {
		try {
            if (isQueuesOn()) {
                return FE.remove();
            }

            return null;
		}
		catch (NoSuchElementException e) {
			return null;
		}
	}

	public static void addProcessOnFTR(Process p) {
        if (isQueuesOn()) {
            if (p.getPriority() == Constants.REAL_TIME_PROCESS_PRIORITY) {
                FTR.add(p);
            }
        }
	}

	public static Process getProcessFromFTR() {
		try {
            if (isQueuesOn()) {
                return FTR.remove();
            }

            return null;
		}
		catch (NoSuchElementException e) {
			return null;
		}
	}

	public static void addProcessOnFU(Process p) {
        if (isQueuesOn()) {
            if (p.getPriority() != Constants.REAL_TIME_PROCESS_PRIORITY) {
                FU.add(p);
            }
        }
	}

	public static Process getProcessFromFU() {
		try {
            if (isQueuesOn()) {
                return FU.remove();
            }

            return null;
		}
		catch (NoSuchElementException e) {
			return null;
		}
	}

	public static void addProcessOnFU2(Process p) {
        if (isQueuesOn()) {
            if (p.getPriority() != Constants.REAL_TIME_PROCESS_PRIORITY) {
                FU2.add(p);
            }
        }
	}

	public static Process getProcessFromFU2() {
		try {
            if (isQueuesOn()) {
                return FU2.remove();
            }

            return null;
		}
		catch (NoSuchElementException e) {
			return null;
		}
	}

	public static void addProcessOnFU3(Process p) {
        if (isQueuesOn()) {
            if (p.getPriority() != Constants.REAL_TIME_PROCESS_PRIORITY) {
                FU3.add(p);
            }
        }
	}

	public static Process getProcessFromFU3() {
		try {
            if (isQueuesOn()) {
                return FU3.remove();
            }

            return null;
		}
		catch (NoSuchElementException e) {
			return null;
		}
	}

    public static boolean isQueuesOn() {
        return queuesOn;
    }
}
