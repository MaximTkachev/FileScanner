package com.luddwg.comparator;

import java.io.File;
import java.util.logging.Logger;

public class FileComparatorFactory {

    private static final Logger LOGGER = Logger.getLogger(FileComparatorFactory.class.getName());

    private final JsonFileComparator jsonFileComparator = new JsonFileComparator();
    private final XmlFileComparator xmlFileComparator = new XmlFileComparator();
    private final StubFileComparator stubFileComparator = new StubFileComparator();

    public FileComparator getFileComparator(File a, File b) {
        String extension1 = getFileExtension(a.getPath());
        String extension2 = getFileExtension(b.getPath());

        if (!extension1.equals(extension2)) {
            return stubFileComparator;
        }

        if (extension1.equals("json")) {
            return jsonFileComparator;
        }

        if (extension1.equals("xml")) {
            return xmlFileComparator;
        }

        LOGGER.info("Unsupported file extension %s".formatted(extension1));
        return stubFileComparator;
    }

    private String getFileExtension(String filePath) {
        return filePath.substring(filePath.lastIndexOf('.') + 1);
    }
}
