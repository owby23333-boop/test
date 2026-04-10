package com.duokan.reader.elegant.ui.user.data;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ReadingItemInfo extends BookInfo {
    public boolean isPublic;

    public static ReadingItemInfo fromJson(JSONObject jSONObject) throws JSONException {
        ReadingItemInfo readingItemInfo = new ReadingItemInfo();
        readingItemInfo.initFromJson(jSONObject);
        readingItemInfo.isPublic = jSONObject.optBoolean("isPublic", true);
        return readingItemInfo;
    }
}
