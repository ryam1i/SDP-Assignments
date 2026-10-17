package com.fintech.subsystem;

import java.util.List;

public class IdentityValidator {
    private List<String> blacklist = List.of("991231500123", "000000000000");

    public boolean isValid(String iin) {
        if (iin == null || iin.length() != 12) {
            return false;
        }
        return !blacklist.contains(iin);
    }
}
