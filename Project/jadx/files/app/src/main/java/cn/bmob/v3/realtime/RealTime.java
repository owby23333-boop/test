package cn.bmob.v3.realtime;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RealTime {
    private int code;
    private JSONObject data;
    private Exception ex;

    public int getCode() {
        return this.code;
    }

    public JSONObject getData() {
        return this.data;
    }

    public Exception getEx() {
        return this.ex;
    }

    public RealTime setCode(int i2) {
        this.code = i2;
        return this;
    }

    public RealTime setData(JSONObject jSONObject) {
        this.data = jSONObject;
        return this;
    }

    public RealTime setEx(Exception exc) {
        this.ex = exc;
        return this;
    }
}
