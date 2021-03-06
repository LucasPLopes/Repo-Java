package br.com.devdojo.essentials.error;

public class ErrorDetail {
  private String title;
  private Integer status;
  private String detail;
  private Long timestamp;
  private String developerMessage;


  public static final class Builder {
    private String title;
    private Integer status;
    private String detail;
    private Long timestamp;
    private String developerMessage;

    private Builder() {
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder status(Integer status) {
      this.status = status;
      return this;
    }

    public Builder detail(String detail) {
      this.detail = detail;
      return this;
    }

    public Builder timestamp(Long timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public Builder developerMessage(String message) {
      this.developerMessage = message;
      return this;
    }

    public ErrorDetail build() {
      ErrorDetail errorDetail = new ErrorDetail();
      errorDetail.setDeveloperMessage(developerMessage);
      errorDetail.setTitle(title);
      errorDetail.setDetail(detail);
      errorDetail.setTimestamp(timestamp);
      errorDetail.setStatus(status);
      return errorDetail;
    }

  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public String getDeveloperMessage() {
    return developerMessage;
  }

  public void setDeveloperMessage(String developerMessage) {
    this.developerMessage = developerMessage;
  }

}
