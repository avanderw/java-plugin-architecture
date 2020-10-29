package net.avdw.plugin.main;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        Path pluginDirectory = Paths.get("plugin/target");
        Files.newDirectoryStream(pluginDirectory, "*.jar").forEach(path -> {
            try {
                System.out.printf("Creating classloader for jar%n");
                URLClassLoader localLoader = new URLClassLoader(new URL[]{path.toUri().toURL()}, Main.class.getClassLoader());
                Properties properties = new Properties();
                properties.load(localLoader.getResourceAsStream("META-INF/plugin.properties"));
                System.out.println(properties);
                System.out.println(Class.forName(properties.getProperty("class"), false, localLoader));
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        });

    }
}
