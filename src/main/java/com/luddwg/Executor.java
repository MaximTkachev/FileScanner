package com.luddwg;

import com.luddwg.comprator.FileComparator;
import com.luddwg.comprator.FileComparatorFactory;
import com.luddwg.support.IterableFileReader;
import com.luddwg.support.Pair;
import com.luddwg.support.Store;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Executor {

    private final Store store = new Store();

    private final FileComparatorFactory factory = new FileComparatorFactory();

    public String execute(String path) {
        fillStore(new File(path));

        List<Pair<File>> doubles = findDoubles();

        return createResultMessage(doubles);
    }

    private void fillStore(File file) {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            for (File child : children) {
                fillStore(child);
            }

            return;
        }

        long hash = 0;
        for (Character ch : new IterableFileReader(file)) {
            if (!Character.isWhitespace(ch)) {
                hash += ch;
            }
        }

        store.add(hash, file);
    }

    private List<Pair<File>> findDoubles() {
        List<Pair<File>> result = new ArrayList<>();

        Set<Long> keySet = store.getKeySet();
        for (Long key : keySet) {
            List<File> files = store.get(key);

            for (int i = 0; i < files.size(); i++) {
                for (int j = i + 1; j < files.size(); j++) {
                    File file1 = files.get(i);
                    File file2 = files.get(j);

                    FileComparator comparator = factory.getFileComparator(file1, file2);
                    if (comparator.compare(file1, file2)) {
                        result.add(Pair.of(file1, file2));
                    }
                }
            }
        }

        return result;
    }

    private String createResultMessage(List<Pair<File>> list) {
        if (list.isEmpty()) {
            return "No doubles found";
        }

        StringBuilder stringBuilder = new StringBuilder("\n");

        for (Pair<File> pair : list) {
            stringBuilder.append(
                    "%s AND %s ARE SIMILAR".formatted(
                            pair.getFirst().getAbsoluteFile(),
                            pair.getSecond().getAbsoluteFile()
                    )
            );
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
