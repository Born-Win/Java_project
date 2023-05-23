package org.example.utility;

import java.nio.file.Paths;

public class FilePathManager {

    public static String getFilePath(String fileName) {
        return getProjectPath() + "\\src\\main\\resources\\" + fileName;
    }

    public static String getProjectPath() {
        return Paths.get("").toAbsolutePath().toString();
    }

}
