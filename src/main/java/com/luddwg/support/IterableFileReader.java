package com.luddwg.support;

import java.io.BufferedReader;
import java.io.File;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableFileReader implements Iterable<Character> {

    private final File file;

    public IterableFileReader(File file) {
        this.file = file;
    }

    @Override
    public Iterator<Character> iterator() {
        return new FileReaderIterator(file);
    }

    private static class FileReaderIterator implements Iterator<Character> {

        private final Reader reader;
        private int nextChar;

        public FileReaderIterator(File file) {
            try {
                this.reader = new BufferedReader(new java.io.FileReader(file));
                this.nextChar = reader.read();
            } catch (Exception e) {
                throw new RuntimeException("File not found: " + file.getAbsolutePath());
            }
        }

        @Override
        public boolean hasNext() {
            return nextChar != -1;
        }

        @Override
        public Character next() {
            if (nextChar == -1) {
                throw new NoSuchElementException("No more symbols");
            }
            int currentChar = nextChar;

            try {
                nextChar = reader.read();
                if (nextChar == -1) {
                    reader.close();
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to read file", e);
            }

            return (char) currentChar;
        }
    }
}
