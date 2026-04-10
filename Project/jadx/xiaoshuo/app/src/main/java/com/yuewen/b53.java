package com.yuewen;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes5.dex */
public class b53 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("description")
    private String f8984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName(TTDownloadField.TT_LABEL)
    private String f8985b;

    @SerializedName(so2.eb)
    private String c;

    @SerializedName("category_id")
    private int d;

    public b53() {
    }

    public int a() {
        return this.d;
    }

    public String b() {
        return this.f8984a;
    }

    public String c() {
        return this.f8985b;
    }

    public String d() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b53)) {
            return false;
        }
        b53 b53Var = (b53) obj;
        return TextUtils.equals(this.f8984a, b53Var.f8984a) && TextUtils.equals(this.f8985b, b53Var.f8985b) && TextUtils.equals(this.c, b53Var.c) && this.d == b53Var.d;
    }

    public int hashCode() {
        String str = this.f8984a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f8985b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.d;
    }

    public b53(String str, String str2, String str3, int i) {
        this.f8984a = str;
        this.f8985b = str2;
        this.c = str3;
        this.d = i;
    }
}
