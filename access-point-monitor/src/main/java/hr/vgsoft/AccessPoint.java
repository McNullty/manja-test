package hr.vgsoft;

public class AccessPoint {
  private String ssid;
  private Integer snr;
  private Integer channel;

  public String getSsid() {
    return ssid;
  }

  public void setSsid(String ssid) {
    this.ssid = ssid;
  }

  public Integer getSnr() {
    return snr;
  }

  public void setSnr(Integer snr) {
    this.snr = snr;
  }

  public Integer getChannel() {
    return channel;
  }

  public void setChannel(Integer channel) {
    this.channel = channel;
  }
}
