import java.util.HashMap;
import java.util.Map;

public class FileCategory {

    private static final Map<String, String> extensionMap = new HashMap<>();

    static {

        // Images
        extensionMap.put("jpg", "Images");
        extensionMap.put("jpeg", "Images");
        extensionMap.put("png", "Images");
        extensionMap.put("gif", "Images");

        // Documents
        extensionMap.put("pdf", "Documents");
        extensionMap.put("docx", "Documents");
        extensionMap.put("txt", "Documents");

        // Audio
        extensionMap.put("mp3", "Audio");
        extensionMap.put("wav", "Audio");

        // Videos
        extensionMap.put("mp4", "Videos");
        extensionMap.put("mkv", "Videos");

        // Archives
        extensionMap.put("zip", "Archives");
        extensionMap.put("rar", "Archives");
    }

    public static String getCategory(String extension) {

        return extensionMap.getOrDefault(extension.toLowerCase(), "Others");
    }
}
