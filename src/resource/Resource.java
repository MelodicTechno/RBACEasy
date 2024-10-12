package src.resource;

import src.level.Level;

import java.util.ArrayList;

public class Resource {
    private final String resourceName;
    private long resourceId;
    private String resourcePath;
    Level level;

    public Resource(String resourceName, String resourcePath, Level level) {
        this.resourceName = resourceName;
        this.resourcePath = resourcePath;
        this.level = level;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }
}
