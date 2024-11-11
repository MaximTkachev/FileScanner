package com.luddwg.comparator;

import java.io.File;

class StubFileComparator implements FileComparator {

    @Override
    public boolean compare(File a, File b) {
        return false;
    }
}
