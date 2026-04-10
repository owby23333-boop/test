package com.yuewen;

import androidx.annotation.NonNull;
import com.duokan.free.tts.data.TTSIndex;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class l43 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13806b;
    public final String c;
    public final String d;
    public final String e;

    public l43(String str, String str2, String str3, String str4, String str5) {
        this.f13805a = str;
        this.f13806b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public static l43 a(@NonNull JSONObject jSONObject) throws Exception {
        return new l43(jSONObject.getString("channel"), jSONObject.getString("cover"), jSONObject.getString(TTSIndex.b.f3704a), jSONObject.getString("popular"), jSONObject.getString("title"));
    }

    public static List<l43> b(@NonNull JSONArray jSONArray) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(a(jSONArray.optJSONObject(i)));
        }
        return arrayList;
    }
}
