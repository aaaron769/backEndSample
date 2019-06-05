package com.one.mpp.Response;

public class UserResponse<T> {

    public Boolean success;
    public String exceptionMessage;
    public T dataResponse;

    public UserResponse() {
    }

    public UserResponse(Boolean success, String exceptionMessage, T dataResponse) {
        this.success = success;
        this.exceptionMessage = exceptionMessage;
        this.dataResponse = dataResponse;
    }

    public UserResponse(Boolean success, String exceptionMessage) {
        this.success = success;
        this.exceptionMessage = exceptionMessage;
    }

    public UserResponse(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public UserResponse(T dataResponse) {
        this.dataResponse = dataResponse;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public T getDataResponse() {
        return dataResponse;
    }

    public void setDataResponse(T dataResponse) {
        this.dataResponse = dataResponse;
    }
}
