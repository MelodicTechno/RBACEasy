package src.role;

import src.level.Level;

import java.io.IOException;

public class VisitorTest {
    public static void main(String[] args) throws IOException {
        Contributor contributor = new Contributor();
        contributor.addResource("code1");
        contributor.addResource("code2");
        contributor.addResource("code3", Level.low);

        contributor.getResource();
        Visitor visitor = new Visitor();
        visitor.getResource();
    }
}
