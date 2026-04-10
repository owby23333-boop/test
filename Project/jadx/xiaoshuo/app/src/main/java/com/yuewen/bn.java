package com.yuewen;

import android.text.TextUtils;
import com.duokan.download.common.DownloadDatabaseHelper;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class bn {
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 16;
    public static final int i = 32;
    public static final int j = 64;
    public static final int k = 128;
    public static final int l = 512;
    public static final int m = 1024;
    public static final int n = 2048;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9188b;
    public String c;
    public String d;
    public int e;

    public bn() {
        this.f9187a = "";
        this.f9188b = "";
        this.c = "";
        this.d = "";
        this.e = 16;
    }

    public static final int g(boolean z, rd2<Boolean> rd2Var) {
        int i2 = z ? 512 : 0;
        if (rd2Var.hasValue()) {
            return i2 | (rd2Var.equalsValue(Boolean.TRUE) ? 1024 : 2048);
        }
        return i2;
    }

    public void a(int i2) {
        this.e = i2 | this.e;
    }

    public void b(int i2) {
        this.e = (~i2) & this.e;
    }

    public boolean c(int i2) {
        return (this.e & i2) == i2;
    }

    public boolean d(int i2) {
        return (i2 & this.e) != 0;
    }

    public boolean e() {
        return TextUtils.isEmpty(this.f9187a);
    }

    public void f(boolean z, rd2<Boolean> rd2Var) {
        b(3584);
        a(g(z, rd2Var));
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DownloadDatabaseHelper.b.a.e, this.f9188b);
            jSONObject.put("source_revision", this.c);
            jSONObject.put("source_md5", this.d);
            jSONObject.put(DownloadDatabaseHelper.b.a.f, this.f9187a);
            jSONObject.put("flags", this.e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public bn(String str, String str2, String str3, String str4) {
        this.f9187a = str;
        this.f9188b = str2;
        this.c = str3;
        this.d = str4;
        this.e = 16;
    }

    public bn(bn bnVar) {
        this.f9187a = bnVar.f9187a;
        this.f9188b = bnVar.f9188b;
        this.c = bnVar.c;
        this.d = bnVar.d;
        this.e = bnVar.e;
    }

    public bn(String str) {
        String str2;
        String strOptString;
        String strOptString2;
        String str3;
        JSONObject jSONObject;
        String strOptString3;
        String strOptString4 = "";
        int iOptInt = 1024;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
            str3 = str2;
            strOptString2 = str3;
        } else {
            try {
                jSONObject = new JSONObject(str);
                strOptString3 = jSONObject.optString(DownloadDatabaseHelper.b.a.f);
                try {
                    strOptString = jSONObject.optString(DownloadDatabaseHelper.b.a.e);
                } catch (Exception e) {
                    e = e;
                    strOptString = "";
                    strOptString2 = strOptString;
                }
            } catch (Exception e2) {
                e = e2;
                str2 = "";
                strOptString = str2;
                strOptString2 = strOptString;
            }
            try {
                strOptString2 = jSONObject.optString("source_revision");
                try {
                    strOptString4 = jSONObject.optString("source_md5");
                    iOptInt = jSONObject.optInt("flags", 1024);
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("source_cloud_private_book");
                    if (jSONObjectOptJSONObject != null) {
                        str3 = "kuaipan:///" + new o02(new u12(jSONObjectOptJSONObject)).b() + "?info=" + jSONObjectOptJSONObject.toString();
                    } else {
                        str3 = strOptString;
                    }
                    strOptString4 = strOptString3;
                    str2 = strOptString4;
                } catch (Exception e3) {
                    e = e3;
                    String str4 = strOptString4;
                    strOptString4 = strOptString3;
                    str2 = str4;
                    e.printStackTrace();
                    str3 = strOptString;
                }
            } catch (Exception e4) {
                e = e4;
                strOptString2 = "";
                strOptString4 = strOptString3;
                str2 = strOptString2;
                e.printStackTrace();
                str3 = strOptString;
                this.f9187a = strOptString4;
                this.f9188b = str3;
                this.c = strOptString2;
                this.d = str2;
                this.e = iOptInt;
            }
        }
        this.f9187a = strOptString4;
        this.f9188b = str3;
        this.c = strOptString2;
        this.d = str2;
        this.e = iOptInt;
    }
}
