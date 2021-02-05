package hr.vgsoft;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class AccessPointFileParser {
  private final ObjectMapper mapper;
  private final File targetFile;

  public AccessPointFileParser(final String fileName) {
    mapper = new ObjectMapper();
    targetFile = new File(fileName);
  }

  public AccessPoints getData() throws IOException {
    return mapper.readValue(targetFile, AccessPoints.class);
  }
}
