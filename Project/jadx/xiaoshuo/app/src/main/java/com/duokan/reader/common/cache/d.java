package com.duokan.reader.common.cache;

import android.text.TextUtils;
import com.duokan.reader.common.cache.ListCache;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d implements ListCache.c<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f4004a = new d();

    @Override // com.duokan.reader.common.cache.ListCache.c
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final String b(JSONObject jSONObject) {
        return jSONObject == null ? "" : jSONObject.toString();
    }

    @Override // com.duokan.reader.common.cache.ListCache.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final JSONObject c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.duokan.reader.common.cache.ListCache.c
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final boolean a(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }
}
