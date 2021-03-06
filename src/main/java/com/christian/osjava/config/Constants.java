package com.christian.osjava.config;

public class Constants {
	public static final char REAL_TIME_PROCESS_PRIORITY = '0';
	public static final int CPUS_TOTAL = 4;
	public static final int SYSTEM_MEMORY_TOTAL = 1024;
	public static final int SYSTEM_MEMORY_SCALE = 1;
	public static final short SYSTEM_STATUS_INITING = 1;
	public static final short SYSTEM_STATUS_NORMAL = 2;
	public static final short SYSTEM_STATUS_ERROR = 3;
	public static final short SYSTEM_STATUS_FINISHING = 4;
	public static final short SYSTEM_STATUS_FINISHED = 5;
	public static final short MEMORY_TASK_ALLOCATE = 1;
	public static final short MEMORY_TASK_DEALLOCATE = 2;
	public static final short MEMORY_TASK_DEALLOCATE_TO_ALLOCATE = 3;
	public static final short PERIPHERALS_TASK_ALLOCATE = 1;
	public static final short PERIPHERALS_TASK_DEALLOCATE = 2;
	public static final int QUANTUM = 2;
	public static final short MEMORY_TASK_STATUS_INITIAL = 0;
	public static final short MEMORY_TASK_STATUS_SUCCESS = 1;
	public static final short MEMORY_TASK_STATUS_NOT_SUCCESS = 2;
	public static final short MEMORY_TASK_ACTION_TYPE_ALLOCATE = 1;
	public static final short MEMORY_TASK_ACTION_TYPE_DEALLOCATE = 2;
	public static final short MEMORY_TASK_ACTION_TYPE_DEALLOCATE_TO_ALLOCATE = 3;
}
