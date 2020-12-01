package system.tests;

import system.models.Process;

public class Teste {
    public static void init() {
        Process p = new Process(
            '0', (byte)1, (byte)2, (byte)64, (byte)1, (byte)0, (byte)0, (byte)2, null
        );

        System.out.println(p);
    }
}
