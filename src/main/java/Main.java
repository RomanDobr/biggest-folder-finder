
import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        String folderPath = "C:/CheckPoint";
        File file = new File(folderPath);
        System.out.println(getFolderSize(file));
    }

    private static long getFolderSize(File folder) {
        AtomicLong length = new AtomicLong(0L);
        if (!folder.isFile()) {
            Arrays.stream(Objects.requireNonNull(folder.listFiles())).forEach(file ->
                    length.addAndGet(getFolderSize(file)));
        }
            length.addAndGet(folder.length());

        return length.get();
    }
}
