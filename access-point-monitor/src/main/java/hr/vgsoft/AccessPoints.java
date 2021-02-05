package hr.vgsoft;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class AccessPoints {
  @JsonProperty("access_points")
  private List<AccessPoint> accessPoints;
}
