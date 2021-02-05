package hr.vgsoft;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileMonitor {
  private final Path path;
  private final String fileName;

  public FileMonitor(final String fileNameWithPath) {
    final String pathPart = extractPath(fileNameWithPath);
    fileName = extractFileName(fileNameWithPath);

    path = FileSystems.getDefault().getPath(pathPart);
  }

  private String extractFileName(String fileNameWithPath) {
    File file = new File(fileNameWithPath);

    return file.getName();
  }

  private String extractPath(String fileNameWithPath) {
    File file = new File(fileNameWithPath);

    return file.getParentFile().getPath();
  }

  public Boolean monitor() {
    try (final WatchService watchService = FileSystems.getDefault().newWatchService()) {

      path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

      while (true) {
        final WatchKey wk = watchService.take();
        for (WatchEvent<?> event : wk.pollEvents()) {
          //we only register "ENTRY_MODIFY" so the context is always a Path.
          final Path changed = (Path) event.context();
          if (changed.endsWith(fileName)) {
            return Boolean.TRUE;
          }
        }
        // reset the key
        boolean valid = wk.reset();
        if (!valid) {
          System.out.println("Key has been unregistered");
        }
      }
    } catch (IOException | InterruptedException e) {
      System.err.println("Error happened: " + e.getLocalizedMessage());
    }

    return Boolean.FALSE;
  }
}
