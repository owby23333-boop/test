package cn.bmob.v3.http.bean;

import com.google.gson.JsonElement;

/* JADX INFO: loaded from: classes.dex */
public class Api {
    public JsonElement data;
    public Result result;

    public JsonElement getData() {
        return this.data;
    }

    public Result getResult() {
        return this.result;
    }

    public void setData(JsonElement jsonElement) {
        this.data = jsonElement;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String toString() {
        return "result: code=" + this.result.getCode() + ", message=" + this.result.getMessage() + ", data=" + this.data.toString();
    }
}
