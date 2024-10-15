package src.operation;

import src.level.Level;
import src.resource.Resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Operator {

    public Level getLevel() {
        return level;
    }

    private final Level level;

    public Operator(Level level) {
        this.level = level;
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
