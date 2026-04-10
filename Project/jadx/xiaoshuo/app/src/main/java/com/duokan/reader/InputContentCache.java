package com.duokan.reader;

import android.content.ContentValues;
import com.duokan.reader.common.cache.ListCache;
import com.duokan.reader.common.cache.f;
import com.duokan.reader.common.cache.h;
import com.yuewen.lp2;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class InputContentCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3929a = "book_comment_";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3930b = "book_share_";
    public static final String c = "feed_reply_";
    public static final String d = "book_share_duokan_";
    public static final String e = "latest_update_time";

    public static class DkInputContentsInfo implements Serializable {
        private DkInputContentsInfo() {
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f3932b;
        public final long c;

        public a(String str, JSONObject jSONObject, long j) {
            this.f3931a = str;
            this.f3932b = jSONObject;
            this.c = j;
        }

        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new a(jSONObject.optString("key"), jSONObject.optJSONObject("content"), jSONObject.optLong(InputContentCache.e));
        }

        public JSONObject b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("key", this.f3931a);
                jSONObject.put("content", this.f3932b);
                jSONObject.put(InputContentCache.e, this.c);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public static class b implements f.b<a> {
        @Override // com.duokan.reader.common.cache.f.b
        public h.e[] a() {
            return new h.e[]{new h.e(InputContentCache.e, false)};
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(a aVar, a aVar2) {
            return Long.valueOf(aVar.c).compareTo(Long.valueOf(aVar2.c)) * (-1);
        }

        public b() {
        }
    }

    public static class c extends ListCache.h<DkInputContentsInfo, a, JSONObject> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final ListCache.o[] f3933b = {new ListCache.o(InputContentCache.e, "INTEGER")};

        @Override // com.duokan.reader.common.cache.ListCache.e, com.duokan.reader.common.cache.ListCache.d
        public ListCache.o[] h() {
            return f3933b;
        }

        @Override // com.duokan.reader.common.cache.ListCache.g
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public DkInputContentsInfo f(JSONObject jSONObject) {
            return (DkInputContentsInfo) lp2.i(jSONObject, new DkInputContentsInfo(), DkInputContentsInfo.class);
        }

        @Override // com.duokan.reader.common.cache.ListCache.b
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public a g(String str, JSONObject jSONObject) {
            return a.a(jSONObject);
        }

        @Override // com.duokan.reader.common.cache.ListCache.e, com.duokan.reader.common.cache.ListCache.d
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public ContentValues c(a aVar) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(InputContentCache.e, Long.valueOf(aVar.c));
            return contentValues;
        }

        @Override // com.duokan.reader.common.cache.ListCache.d
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public String b(a aVar) {
            return aVar.f3931a;
        }

        @Override // com.duokan.reader.common.cache.ListCache.g
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public JSONObject d(DkInputContentsInfo dkInputContentsInfo) {
            return lp2.P(dkInputContentsInfo);
        }

        @Override // com.duokan.reader.common.cache.ListCache.d
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public JSONObject a(a aVar, JSONObject jSONObject) {
            return aVar.b();
        }

        public c() {
        }
    }

    public static class d extends com.duokan.reader.common.cache.e<DkInputContentsInfo, a, JSONObject> {
        public static final int l = 0;

        public d() {
            super("InputContentsCachePrefix_SYSTEM", com.duokan.reader.common.cache.d.f4004a, new c(), new b(), 200);
        }

        public void M() {
            K(0);
        }
    }

    public static JSONObject a(String str) {
        a aVarW = d().w(str);
        if (aVarW == null) {
            return null;
        }
        return aVarW.f3932b;
    }

    public static <T> T b(String str, ListCache.b<T, JSONObject> bVar) {
        JSONObject jSONObjectA = a(str);
        if (jSONObjectA == null) {
            return null;
        }
        return bVar.g(str, jSONObjectA);
    }

    public static String c(String str) {
        JSONObject jSONObjectA = a(str);
        if (jSONObjectA == null) {
            return null;
        }
        return jSONObjectA.optString("text");
    }

    public static d d() {
        d dVar = new d();
        dVar.M();
        return dVar;
    }

    public static void e(String str, JSONObject jSONObject) {
        d().q(new a(str, jSONObject, System.currentTimeMillis()));
    }

    public static <T> void f(String str, T t, ListCache.d<T, JSONObject> dVar) {
        e(str, dVar.a(t, a(str)));
    }

    public static void g(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("text", str2);
        } catch (JSONException unused) {
        }
        e(str, jSONObject);
    }

    public static void h(String str) {
        d().g(str);
    }
}
