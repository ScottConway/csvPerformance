package org.opencsv.csvperformance;

import java.io.File;

public class WriteValues {
    private long numRecords;
    private File file;
    private String writeFrom;

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

    public String getWriteFrom() {
        return writeFrom;
    }

    public void setWriteFrom(String writeFrom) {
        this.writeFrom = writeFrom;
    }
}
