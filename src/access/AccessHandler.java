package src.access;

import src.level.Level;
import src.resource.Resource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class AccessHandler {

    private final Level level;
    private ArrayList<Resource> resources;
    private ArrayList<Path> resourcePaths;


    public AccessHandler(Level level) {
        this.level = level;
        this.resourcePaths = new ArrayList<>();
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

    public void updateResources() {
        String resourcePath = "files/" + level + '/';
        try (Stream<Path> paths = Files.walk(Paths.get(resourcePath))) {
            paths.filter(Files::isRegularFile) // 只筛选文件
                    .forEach(path -> resourcePaths.add(path.getFileName())); // 将文件名添加到列表
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Resource> getResources() {
        return this.resources;
    }

    public static void saveResource(Resource resource, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(resource); // 将对象写入文件
            System.out.println("Resource object has been saved.");
        } catch (IOException e) {
            System.err.println("Error saving the resource object: " + e.getMessage());
        }
    }

}
