package com.example.uzcardservice.dto;

public enum CommonResponse {
    SUCCESS(0, "success"),
    UNKNOWN(1, "unknown"),
    CARD_NOT_FOUND(2, "card not found"),
    CARD_AMOUNT_INCORRECT(3, "balance incorrect");

    private final int code;
    private final String msg;

    CommonResponse(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
