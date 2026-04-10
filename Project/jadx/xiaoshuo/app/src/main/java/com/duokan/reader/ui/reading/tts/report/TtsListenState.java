package com.duokan.reader.ui.reading.tts.report;

import com.duokan.reader.ui.store.data.cms.Data;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class TtsListenState extends Data {
    public String mBookId;
    public long mReadMillis;

    public TtsListenState(long j, String str) {
        this.mReadMillis = j;
        this.mBookId = str;
    }

    private JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("readMillis", this.mReadMillis);
            jSONObject.put("bookId", this.mBookId);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return toJson().toString();
    }

    public TtsListenState(String str) {
        this.mReadMillis = 0L;
        this.mBookId = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mReadMillis = jSONObject.optLong("readMillis", 0L);
            this.mBookId = jSONObject.optString("bookId", "");
        } catch (JSONException unused) {
        }
    }
}
