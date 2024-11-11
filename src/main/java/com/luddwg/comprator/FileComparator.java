package com.luddwg.comprator;

import java.io.File;

@FunctionalInterface
public interface FileComparator {
    boolean compare(File a, File b);
}
