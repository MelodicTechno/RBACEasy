package src.access;

import src.level.Level;
import src.operation.Operator;
import src.page.OperationButton;
import src.resource.Resource;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AccessHandler {

    private final Level level;
    private List<Resource> resources;
    private final ArrayList<Path> resourcePaths;
    private final String resourceRoot;
    private final Operator operator;

    private final List<JButton> buttons;
    private OperationButton operationButton;

    public AccessHandler(Level level) {
        this.level = level;
        this.resourcePaths = new ArrayList<>();
        this.resources = new ArrayList<>();
        String rootPath = "files";
        this.resourceRoot = String.format("%s/%s/", rootPath, level);
        this.operator = new Operator(this.level);
        JButton getButton = new JButton("Get Code");
        JButton addButton = new JButton("Add Code");
        JButton removeButton = new JButton("Remove Code");
        JButton editButton = new JButton("Edit Code");
        this.buttons = new ArrayList<>();

        buttons.add(getButton);
        buttons.add(addButton);
        buttons.add(removeButton);
        buttons.add(editButton);
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

    public List<Resource> getResources() {
        return this.resources;
    }

    public Resource getResource(String filePath) {
        return null;
    }

    public void addResource(String name) throws IOException {
        if (this.level == Level.high || this.level == Level.middle) {
            Resource resource = this.operator.addResource(name);
            this.resources.add(resource);
            System.out.println("add " + name + " successfully");
            System.out.println(resource.getResourcePath());
        }
    }

    public void addResource(String name, Level level) throws IOException {
        if (this.level == Level.high || this.level == Level.middle) {
            Resource resource = this.operator.addResource(name, level);
            this.resources.add(resource);
            System.out.println("add " + name + " successfully");
            System.out.println(resource.getResourcePath());
        }
    }

    public List<Resource> setResources() {
        return this.resources;
    }

    public List<JButton> getButtons() {
        int buttonIndex = AccessHandler.mapLevel(level);
        List<JButton> buttons = new ArrayList<>();
        for (int i = 0; i < buttonIndex; i++) {
            buttons.add(this.buttons.get(i));
        }
        return buttons;
    }

    public static int mapLevel(Level level) {
        switch (level) {
            case low -> {
                return 1;
            }
            case middle -> {
                return 2;
            }
            case high -> {
                return 4;
            }
            default ->
            {
                return 0;
            }
        }
    }
}
