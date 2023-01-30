package com.example.paymentservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResultData<T>{
    private T data;
    private int code;
    private String msg;

    public CommonResultData(T data){
        this.data = data;
        this.msg = CommonResponse.SUCCESS.getMsg();
        this.code = CommonResponse.SUCCESS.getCode();
    }

    public CommonResultData(int code, String msg){
        this.msg = msg;
        this.code = code;
    }
}
