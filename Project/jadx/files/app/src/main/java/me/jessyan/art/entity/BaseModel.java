package me.jessyan.art.entity;

import androidx.annotation.NonNull;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class BaseModel<T> implements Serializable {
    private int code;
    private T data;
    private String msg;
    private String type;
    private long updated_at;

    public BaseModel(String str, int i2) {
        this.msg = str;
        this.code = i2;
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

    public String getType() {
        return this.type;
    }

    public long getUpdated_at() {
        return this.updated_at;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setData(T t2) {
        this.data = t2;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUpdated_at(long j2) {
        this.updated_at = j2;
    }

    @NonNull
    public String toString() {
        return "BaseModel{code=" + this.code + ", msg='" + this.msg + "', result=" + this.data + '}';
    }
}
