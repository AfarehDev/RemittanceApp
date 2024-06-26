package com.example.remittanceapp.domain.utils;
/**
 * This class represents different states of a response,
 * and we use it with any operation that required defferent states such as Idle, Loading, Success, or Error.
 * @param <T> The type of data associated with the response state.
 */
public class ResponseState<T> {
    public static class Idle<T> extends ResponseState<T> {}
    public static class Loading<T> extends ResponseState<T> {}
    public static class Success<T> extends ResponseState<T> {
        private T data;

        public Success(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
    public static class Error<T> extends ResponseState<T> {
        private String message;

        public Error(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
