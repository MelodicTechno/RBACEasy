package src.resource;

import src.level.Level;

import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

public class Resource implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final String resourceName;
    private final UUID resourceId;
    private String resourcePath;
    Level level;

    public Resource(String resourceName, Level level) {
        this.resourceName = resourceName;
        this.level = level;
        String rootPath = "files";
        this.resourceId = UUID.randomUUID();
        this.resourcePath = String.format("%s/%s/%s", rootPath, level, this.resourceId);
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public UUID getResourceId() {
        return this.resourceId;
    }

    public void getResource() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.resourcePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("no resource found");
        }
    }
}
