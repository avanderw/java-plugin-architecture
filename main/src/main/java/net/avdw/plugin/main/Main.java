package net.avdw.plugin.main;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        try {
            System.out.println(Class.forName("net.avdw.plugin.plugin.Plugin"));
        } catch (ClassNotFoundException e) {
            System.out.println("Not found");
        }

        URLClassLoader localLoader = new URLClassLoader(new URL[]{new File("plugin/target/plugin-0.0-SNAPSHOT.jar").toURI().toURL()}, Main.class.getClassLoader());

        Class.forName("net.avdw.plugin.plugin.Plugin", false, localLoader);
        System.out.println("Found");
    }
}
