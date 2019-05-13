package org.opencsv.csvperformance;

import java.io.File;

public class ReadValues {
    private long iterations;
    private File file;
    private String readInto;

    public long getIterations() {
        return iterations;
    }

    public void setIterations(long iterations) {
        this.iterations = iterations;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getReadInto() {
        return readInto;
    }

    public void setReadInto(String readInto) {
        this.readInto = readInto;
    }
}
