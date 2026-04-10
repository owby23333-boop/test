package com.yuewen;

import com.dangdang.reader.domain.GroupType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class g82 {
    public static final String p = "NewsBaseInfo";
    public static final String q = "note";
    public static final String r = "comment";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h82 f11509b;
    public int c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public int h;
    public String i;
    public String j;
    public int k;
    public int l;
    public long m;
    public String n;
    public List<x40> o = new ArrayList();

    public g82() {
    }

    public String a() {
        return this.n;
    }

    public boolean b() {
        return q.equals(this.f11508a);
    }

    public void c() {
        if (this.k == 0) {
            this.k = 1;
            this.h++;
        } else {
            this.k = 0;
            this.h--;
        }
    }

    public g82(JSONObject jSONObject) throws JSONException {
        this.n = jSONObject.getString("id");
        this.m = jSONObject.optLong(GroupType.TypeColumn.CREATE_TIME);
        this.f11508a = jSONObject.optString("discuss_type");
        this.c = jSONObject.optInt("status");
        this.d = jSONObject.optString("author");
        this.h = jSONObject.optInt("like_count");
        this.i = jSONObject.optString("translate_status");
        this.j = jSONObject.optString("content");
        this.m = jSONObject.optLong(GroupType.TypeColumn.CREATE_TIME);
        this.k = jSONObject.optInt("like_status");
        this.l = jSONObject.optInt("comment_count");
        this.e = jSONObject.optString("author_nick");
        this.f = jSONObject.optString("author_icon");
        this.g = jSONObject.optInt("is_vip") == 1;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("comments");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    x40 x40Var = new x40();
                    x40Var.f19784a = jSONObjectOptJSONObject.optInt("status");
                    x40Var.f19785b = jSONObjectOptJSONObject.optString("author_nick");
                    x40Var.c = jSONObjectOptJSONObject.optString("author");
                    x40Var.d = jSONObjectOptJSONObject.optInt("like_count");
                    x40Var.e = jSONObjectOptJSONObject.optInt("object_id");
                    x40Var.f = jSONObjectOptJSONObject.optString("translate_status");
                    x40Var.g = jSONObjectOptJSONObject.optString("content");
                    x40Var.h = jSONObjectOptJSONObject.optLong(GroupType.TypeColumn.CREATE_TIME);
                    x40Var.i = jSONObjectOptJSONObject.optInt("type");
                    x40Var.j = jSONObjectOptJSONObject.optInt("id");
                    this.o.add(x40Var);
                }
            }
        }
        this.f11509b = h82.a(jSONObject.optJSONObject("book_info"));
    }
}
