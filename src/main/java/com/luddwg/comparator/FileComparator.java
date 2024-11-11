package com.luddwg.comparator;

import java.io.File;

@FunctionalInterface
public interface FileComparator {
    boolean compare(File a, File b);
}
