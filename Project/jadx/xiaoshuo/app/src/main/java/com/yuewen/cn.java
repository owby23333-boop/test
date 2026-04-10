package com.yuewen;

import com.duokan.account.b;
import com.duokan.download.domain.DownloadType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class cn extends st0 {
    public static final /* synthetic */ boolean n = false;
    public long e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public o02 m;

    public cn() {
        this.e = Long.MIN_VALUE;
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = null;
    }

    public static cn f(String str) {
        try {
            return g(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static cn g(JSONObject jSONObject) {
        try {
            if (DownloadType.valueOf(jSONObject.getString("download_type")) != DownloadType.BOOK) {
                return null;
            }
            return new cn(jSONObject);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.yuewen.st0
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        try {
            jSONObject.put("book_item_id", this.e);
            jSONObject.put(iw2.r, this.f);
            jSONObject.put("book_uuid", this.g);
            jSONObject.put("book_name", this.h);
            jSONObject.put(iw2.t, this.i);
            jSONObject.put("author", this.j);
            jSONObject.put("summary", this.k);
            jSONObject.put(b.d.a.c, this.l);
            o02 o02Var = this.m;
            if (o02Var == null) {
                jSONObject.put("cloud_private_book", (Object) null);
            } else {
                jSONObject.put("cloud_private_book", o02Var.e().d());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yuewen.st0
    public DownloadType b() {
        return DownloadType.BOOK;
    }

    @Override // com.yuewen.st0
    public String c() {
        o02 o02Var = this.m;
        return o02Var != null ? o02Var.h() : this.h;
    }

    public boolean e() {
        return this.e != Long.MIN_VALUE;
    }

    public cn(JSONObject jSONObject) {
        super(jSONObject);
        this.e = Long.MIN_VALUE;
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        o02 o02Var = null;
        this.m = null;
        this.e = jSONObject.optLong("book_item_id", Long.MIN_VALUE);
        this.f = jSONObject.optString(iw2.r);
        this.g = jSONObject.optString("book_uuid");
        this.h = jSONObject.optString("book_name");
        this.i = jSONObject.optString(iw2.t);
        this.j = jSONObject.optString("author");
        this.k = jSONObject.optString("summary");
        this.l = jSONObject.optString(b.d.a.c);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("cloud_private_book");
        if (jSONObjectOptJSONObject != null) {
            try {
                o02Var = new o02(new u12(jSONObjectOptJSONObject));
            } catch (JSONException unused) {
                return;
            }
        }
        this.m = o02Var;
    }
}
