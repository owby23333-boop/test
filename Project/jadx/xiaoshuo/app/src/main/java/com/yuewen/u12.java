package com.yuewen;

import android.text.TextUtils;
import cn.kuaipan.android.kss.KssDef;
import com.dangdang.reader.domain.GroupType;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class u12 {
    public static final String o = "file_cloud_path";
    public static final String p = "parent_cloud_path";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f18285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f18286b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public long j;
    public long k;
    public long l;
    public String m;
    public boolean n;

    public u12(JSONObject jSONObject) throws JSONException {
        this.f18285a = jSONObject;
        this.f18286b = jSONObject.getString("__mi_account_id__");
        this.c = this.f18285a.getString("__mi_cloud_storage_namespace__");
        this.d = this.f18285a.getString("__cloud_parent_path__");
        this.n = this.f18285a.optBoolean("__is_files_of_this_directory_refreshed__");
        u();
    }

    public static ArrayList<u12> a(String str, String str2, String str3, JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return new ArrayList<>();
        }
        ArrayList<u12> arrayList = new ArrayList<>(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new u12(str, str2, str3, jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    public static ArrayList<u12> b(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return new ArrayList<>();
        }
        ArrayList<u12> arrayList = new ArrayList<>(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new u12(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    public long c() {
        return this.j;
    }

    public JSONObject d() {
        return this.f18285a;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f18286b;
    }

    public long g() {
        return this.k;
    }

    public String h() {
        return this.g;
    }

    public String i() {
        return this.c;
    }

    public String j() {
        return this.f;
    }

    public String k() {
        return this.d;
    }

    public String l() {
        return this.h;
    }

    public String m() {
        return this.m;
    }

    public long n() {
        return this.l;
    }

    public boolean o() {
        return this.i.equals("dir");
    }

    public boolean p() {
        return this.i.equals(xa3.f19839a);
    }

    public boolean q() {
        return this.n;
    }

    public boolean r(u12 u12Var) {
        if (u12Var == null) {
            return false;
        }
        return this.e.equals(u12Var.e());
    }

    public void s() {
        this.n = true;
        try {
            this.f18285a.put("__is_files_of_this_directory_refreshed__", true);
        } catch (JSONException unused) {
        }
    }

    public void t() {
        this.n = false;
        try {
            this.f18285a.put("__is_files_of_this_directory_refreshed__", false);
        } catch (JSONException unused) {
        }
    }

    public final void u() throws JSONException {
        this.e = this.f18285a.getString("id");
        this.f = this.f18285a.getString("parent_id");
        this.g = this.f18285a.getString("name");
        this.i = this.f18285a.getString("type");
        this.j = this.f18285a.getLong(GroupType.TypeColumn.CREATE_TIME);
        this.k = this.f18285a.getLong(KssDef.KEY_MODIFY_TIME);
        this.l = this.f18285a.optLong("size");
        this.m = this.f18285a.optString("sha1");
        if (this.g.equals("/")) {
            return;
        }
        if (this.d.endsWith("/")) {
            this.h = this.d + this.g;
            return;
        }
        this.h = this.d + "/" + this.g;
    }

    public u12(String str, String str2, String str3, JSONObject jSONObject) throws JSONException {
        this.f18285a = jSONObject;
        this.f18286b = str;
        jSONObject.put("__mi_account_id__", str);
        this.c = str2;
        this.f18285a.put("__mi_cloud_storage_namespace__", str2);
        if (TextUtils.isEmpty(str3)) {
            this.d = "/";
        } else {
            this.d = new File(str3).getAbsolutePath();
        }
        this.f18285a.put("__cloud_parent_path__", this.d);
        this.n = false;
        this.f18285a.put("__is_files_of_this_directory_refreshed__", false);
        u();
    }
}
