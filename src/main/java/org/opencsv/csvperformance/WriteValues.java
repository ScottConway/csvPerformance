package org.opencsv.csvperformance;

import java.io.File;

public class WriteValues {
    private long numRecords;
    private File file;

    public long getNumRecords() {
        return numRecords;
    }

    public void setNumRecords(long numRecords) {
        this.numRecords = numRecords;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
