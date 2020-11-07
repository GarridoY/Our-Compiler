package dk.aau.cs.d703e20.uppaal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Handles file setup and clearing
public class FileHandler {
    private final File model = new File("/UPPAAL_models/generatedModel.xml");
    private FileWriter writer;

    public FileHandler() {
        try {
            writer = new FileWriter(model.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Setup initial file
    public void setupFile() {
        try {
            if (model.createNewFile()) {
                System.out.println("File created: " + model.getName());
            } else {
                clearFile();
            }
        } catch (IOException e) {
            System.out.println("Failed to create model file");
            e.printStackTrace();
        }

    }

    // Delete and remake file
    public void clearFile() {
        try {
            if (model.delete()) {
                model.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Failed to clear file");
            e.printStackTrace();
        }
    }

    public File getModel() {
        return model;
    }

    public FileWriter getWriter() {
        return writer;
    }
}
