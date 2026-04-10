package com.yuewen;

import com.dangdang.reader.domain.GroupType;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ed2 {
    public static final int g = 3;
    public static final int h = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10570b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10572b;
        public String c;
        public String d;
        public String e;
        public String f;

        public a a(String str) {
            this.e = str;
            return this;
        }

        public ed2 b() {
            return new ed2(this.f10571a, this.f10572b, this.c, this.d, this.e, this.f);
        }

        public a c(String str) {
            this.f = str;
            return this;
        }

        public a d(String str) {
            this.f10571a = str;
            return this;
        }

        public a e(String str) {
            this.d = str;
            return this;
        }

        public a f(int i) {
            this.f10572b = i;
            return this;
        }

        public a g(String str) {
            this.c = str;
            return this;
        }
    }

    public static ed2 a(JSONObject jSONObject) {
        try {
            return new a().d(jSONObject.optString("open_id")).f(jSONObject.optInt("open_type")).g(jSONObject.optString("union_id")).e(jSONObject.optString("nick_name")).a(jSONObject.optString("head_url")).c(jSONObject.optString(GroupType.TypeColumn.CREATE_TIME)).b();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static List<ed2> b(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        if (jSONArray == null) {
            return linkedList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                ed2 ed2VarA = a(jSONArray.optJSONObject(i));
                if (ed2VarA != null) {
                    linkedList.add(ed2VarA);
                }
            } catch (Throwable unused) {
            }
        }
        return linkedList;
    }

    public static JSONArray c(List<ed2> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<ed2> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().d());
        }
        return jSONArray;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("open_id", this.f10569a);
            jSONObject.putOpt("open_type", Integer.valueOf(this.f10570b));
            jSONObject.putOpt("union_id", this.c);
            jSONObject.putOpt("nick_name", this.d);
            jSONObject.putOpt("head_url", this.e);
            jSONObject.putOpt(GroupType.TypeColumn.CREATE_TIME, this.f);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public ed2(String str, int i, String str2, String str3, String str4, String str5) {
        this.f10569a = str;
        this.f10570b = i;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
    }
}
