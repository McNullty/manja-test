package hr.vgsoft;

import java.util.Arrays;
import java.util.List;

public class CompareAccessLists {

  public static List<String> compare(
      final AccessPoints oldAccessPoints,final AccessPoints newAccessPoints) {
    // TODO: calculate change and construct message
    // CASES:
    // 1. ACCESS POINT IS ADDED TO LIST (more then one accesPoint can be added in one change)
    // 2. ACCESS POINT IS CHANGED (more then one accesPoint can be changed in one file change)
    // 3. ACCESS POINT REMOVED (same as before)
    // 4. No change between (file was changed bud data is the same)

    return Arrays.asList("calculate change and construct message");
  }

}
