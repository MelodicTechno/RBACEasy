package src.operation;

import src.level.Level;
import src.resource.Resource;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Operator {

    // the button to present the operation and the access
    private final JButton addButton;

    public Level getLevel() {
        return level;
    }

    private final Level level;

    public Operator(Level level) {
        this.level = level;
        this.addButton = new JButton("Add code");
    }

    public void readResource(Resource resource) {
        System.out.println(resource.getResourceName());
        System.out.println(resource.getResourceId());
        System.out.println(resource.getResourcePath());
    }

    public Resource addResource(String resourceName) throws IOException {
        Resource resource = new Resource(resourceName, this.level);
        PrintWriter writer = new PrintWriter(resource.getResourcePath(), StandardCharsets.UTF_8);
        writer.println("The first line");
        writer.println("The second line");
        writer.close();

        try (FileOutputStream fileOut = new FileOutputStream(resource.getResourcePath()); ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(resource);
            System.out.println("Resource object has been saved.");
        } catch (IOException e) {
            System.err.println("Error saving the resource object: " + e.getMessage());
        }


        return resource;
    }

    public Resource addResource(String resourceName, Level level) throws IOException {
        Resource resource = new Resource(resourceName, level);
        PrintWriter writer = new PrintWriter(resource.getResourcePath(), StandardCharsets.UTF_8);
        writer.println("The first line");
        writer.println("The second line");
        writer.close();

        return resource;
    }

    public void readResource(String resourceName) {
        System.out.println();
    }
}
