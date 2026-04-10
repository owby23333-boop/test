package com.yuewen.openapi.entity;

/* JADX INFO: loaded from: classes8.dex */
public class OpenResponse<T> {
    public int code;
    public T data;
    public String msg;

    public OpenResponse(int i, String str, T t) {
        this.code = i;
        this.msg = str;
        this.data = t;
    }

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isSuccessful() {
        return this.code == 0;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "OpenResponse{code=" + this.code + ", msg='" + this.msg + "', data=" + this.data + '}';
    }
}
