package com.umeng.message.common.inter;

import com.umeng.analytics.pro.am;
import com.umeng.message.common.UPLog;
import java.util.Hashtable;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ITagManager {
    public static final String FAIL = "fail";
    public static final String STATUS_FALSE = "false";
    public static final String STATUS_TRUE = "true";
    public static final String SUCCESS = "ok";

    Result addTags(JSONObject jSONObject, String... strArr) throws Exception;

    Result addWeightedTags(JSONObject jSONObject, Hashtable<String, Integer> hashtable) throws Exception;

    Result deleteTags(JSONObject jSONObject, String... strArr) throws Exception;

    Result deleteWeightedTags(JSONObject jSONObject, String... strArr) throws Exception;

    List<String> getTags(JSONObject jSONObject) throws Exception;

    Hashtable<String, Integer> getWeightedTags(JSONObject jSONObject) throws Exception;

    public static class Result {
        private int a;
        public String errors;
        public long interval;
        public String jsonString;
        public long last_requestTime;
        public String msg;
        public int remain;
        public String status;

        public Result() {
            this.status = "fail";
            this.a = 0;
            this.msg = "";
            this.remain = 0;
            this.interval = 0L;
            this.errors = "";
            this.last_requestTime = 0L;
            this.jsonString = "";
        }

        public void setErrors(String str) {
            this.errors = str;
        }

        public void setInterval(long j2) {
            this.interval = j2;
        }

        public void setLast_requestTime(long j2) {
            this.last_requestTime = j2;
        }

        public void setRemain(int i2) {
            this.remain = i2;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public String toString() {
            return this.jsonString;
        }

        public Result(JSONObject jSONObject, boolean z2) {
            this.status = "fail";
            this.a = 0;
            this.msg = "";
            this.remain = 0;
            this.interval = 0L;
            this.errors = "";
            this.last_requestTime = 0L;
            this.jsonString = "";
            try {
                if (!z2) {
                    this.status = jSONObject.optString("success", "fail");
                    this.remain = jSONObject.optInt("remain", 0);
                    this.interval = jSONObject.optLong(am.aU, 0L);
                    this.errors = jSONObject.optString("errors");
                    if (!jSONObject.has("last_requestTime")) {
                        jSONObject.put("last_requestTime", System.currentTimeMillis());
                    } else {
                        this.last_requestTime = jSONObject.optLong("last_requestTime", 0L);
                    }
                } else {
                    this.a = jSONObject.optInt("code");
                    this.msg = jSONObject.optString("msg", "");
                    this.status = jSONObject.optString("status", ITagManager.STATUS_FALSE);
                    this.interval = jSONObject.optLong(am.aU, 0L);
                    this.last_requestTime = jSONObject.optLong("timestamp", System.currentTimeMillis());
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                    if (jSONObjectOptJSONObject != null) {
                        this.remain = jSONObjectOptJSONObject.optInt("remain", 0);
                    }
                }
                this.jsonString = jSONObject.toString();
            } catch (Exception unused) {
                UPLog.e("ITagManager.Result", "Json error.");
            }
        }
    }
}
