package com.fintech.subsystem;

public class CreditScoreService {

    public int getScore(String iin) {
        if (iin.equals("950315301110")) {
            return 780;
        }
        if (iin.equals("981120400123")) {
            return 640;
        }
        return 450;
    }
}
