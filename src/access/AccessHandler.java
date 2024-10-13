package src.access;

import src.level.Level;
import src.resource.Resource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AccessHandler {

    private final Level level;
    private List<Resource> resources;
    private final ArrayList<Path> resourcePaths;
    private final String resourceRoot;

    public AccessHandler(Level level) {
        this.level = level;
        this.resourcePaths = new ArrayList<>();
        this.resources = new ArrayList<>();
        String rootPath = "files";
        this.resourceRoot = String.format("%s/%s/", rootPath, level);
    }

    public void getAccess() {
        switch (this.level) {
            case low -> System.out.println("low");
            case middle -> System.out.println("middle");
            case high -> System.out.println("high");
        }
    }

    public Level getLevel() {
        return level;
    }

    public void updateResourcePaths() {
        String resourcePath = "files/" + level + '/';
        try (Stream<Path> paths = Files.walk(Paths.get(resourcePath))) {
            paths.filter(Files::isRegularFile)
                    .forEach(path -> resourcePaths.add(path.getFileName()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateResources() {
        List<Resource> resources = new ArrayList<>();
        File folder = new File(this.resourceRoot);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".ser")) {
                        Resource resource = this.loadResource(file);
                        if (resource != null) {
                            resources.add(resource);
                        }
                    }
                }
            }
        } else {
            System.err.println("The specified folder does not exist or is not a directory.");
        }

        this.resources = resources;
    }

    private Resource loadResource(File file) {
        try (FileInputStream fileIn = new FileInputStream(file);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            return (Resource) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading resource from file: " + file.getName() + ". Error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Path> getResourcePaths() {
        return this.resourcePaths;
    }

    public void saveResource(Resource resource, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(resource);
            System.out.println("Resource object has been saved.");
        } catch (IOException e) {
            System.err.println("Error saving the resource object: " + e.getMessage());
        }
    }

    public Resource getResource(String filePath) {
        return null;
    }

}
