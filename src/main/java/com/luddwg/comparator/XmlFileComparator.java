package com.luddwg.comparator;

import org.xmlunit.assertj3.XmlAssert;

import java.io.File;

class XmlFileComparator implements FileComparator {

    @Override
    public boolean compare(File a, File b) {
        try {
            XmlAssert.assertThat(a)
                    .and(b)
                    .ignoreWhitespace()
                    .ignoreChildNodesOrder()
                    .areIdentical();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
