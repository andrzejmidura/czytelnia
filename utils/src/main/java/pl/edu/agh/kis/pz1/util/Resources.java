package pl.edu.agh.kis.pz1.util;

import java.util.ArrayList;

public class Resources {
    public static final int MAX_READERS = 5;
    public static final int MAX_WRITERS = 1;

    public boolean enter(Reader reader) {
        if (currentReaders.size()<5 && currentWriter.isEmpty()) {
            currentReaders.add(reader);
            return true;
        } else {
            return false;
        }
    }
    public boolean enter(Writer writer) {
        if (currentReaders.isEmpty() && currentWriter.isEmpty()) {
            currentWriter.add(writer);
            return true;
        }
        return false;
    }

    public boolean exit(Reader reader) {
        if (currentReaders.contains(reader)) {
            currentReaders.remove(reader);
            return true;
        } else {

            return false;
        }
    }
    public boolean exit(Writer writer) {
        if (currentWriter.contains(writer)) {
            currentWriter.remove(writer);
            return true;
        }
        return false;
    }

    public void readData(Reader reader) {
        if (currentReaders.contains(reader) || currentWriter.contains(reader)) {
            System.out.println(reader.getName() + " reads. Readers: " + this.currentReaders.size() + ", Writers: " + this.currentWriter.size());
            this.exit(reader);
        } else {
            System.out.println(reader.getName() + " has to wait to read the data...");
        }
    }
    public void overwriteData(Writer writer, String newData) {
        if (currentWriter.contains(writer)) {
            this.data = newData;
            System.out.println(writer.getName() + " writes. Readers: " + this.currentReaders.size() + ", Writers: " + this.currentWriter.size());
            this.readData(writer);
        } else {
            System.out.println(writer.getName() + " has to wait to overwrite the data...");
        }
    }
    public void appendData(Writer writer, String dataToAppend) {
        if (currentWriter.contains(writer)) {
            this.data.concat(dataToAppend);
            System.out.println(writer.getName() + " writes.");
            this.exit(writer);
        } else {
            System.out.println(writer.getName() + " has to wait to append the data...");
        }
    }


    // private
    private String data;
    private final ArrayList<Reader> currentReaders = new ArrayList<>();
    private final ArrayList<Writer> currentWriter = new ArrayList<>(1);
}
