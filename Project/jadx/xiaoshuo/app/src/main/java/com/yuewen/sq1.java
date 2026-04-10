package com.yuewen;

import android.text.TextUtils;
import io.reactivex.annotations.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class sq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17519a;

    public sq1(boolean z) {
        this.f17519a = z;
    }

    public static sq1 a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return b(new JSONObject(str));
            } catch (JSONException e) {
                qt1.p(e);
            }
        }
        return new sq1(false);
    }

    public static sq1 b(@NonNull JSONObject jSONObject) {
        return new sq1(false);
    }

    public boolean c() {
        return this.f17519a;
    }
}
