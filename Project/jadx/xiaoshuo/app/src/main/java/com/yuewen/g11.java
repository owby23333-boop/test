package com.yuewen;

import com.duokan.reader.InputContentCache;
import com.duokan.reader.common.cache.ListCache;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class g11 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ListCache.d<c, JSONObject> f11390b = new a();
    public static ListCache.b<c, JSONObject> c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11391a;

    public class a extends ListCache.e<c, JSONObject> {
        @Override // com.duokan.reader.common.cache.ListCache.d
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public String b(c cVar) {
            return "";
        }

        @Override // com.duokan.reader.common.cache.ListCache.d
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public JSONObject e(c cVar) {
            return null;
        }

        @Override // com.duokan.reader.common.cache.ListCache.d
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public JSONObject a(c cVar, JSONObject jSONObject) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("content", cVar.f11392a);
            } catch (JSONException unused) {
            }
            return jSONObject2;
        }
    }

    public class b implements ListCache.b<c, JSONObject> {
        @Override // com.duokan.reader.common.cache.ListCache.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c i(String str, JSONObject jSONObject) {
            return null;
        }

        @Override // com.duokan.reader.common.cache.ListCache.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c g(String str, JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            c cVar = new c();
            cVar.f11392a = jSONObject.optString("content");
            return cVar;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11392a;
    }

    public g11(String str) {
        this.f11391a = InputContentCache.c + str;
    }

    public void a() {
        InputContentCache.h(this.f11391a);
    }

    public c b() {
        return (c) InputContentCache.b(this.f11391a, c);
    }

    public String c() {
        c cVarB = b();
        return cVarB == null ? "" : cVarB.f11392a;
    }

    public void d(c cVar) {
        InputContentCache.f(this.f11391a, cVar, f11390b);
    }

    public void e(String str) {
        c cVar = new c();
        cVar.f11392a = str;
        d(cVar);
    }
}
