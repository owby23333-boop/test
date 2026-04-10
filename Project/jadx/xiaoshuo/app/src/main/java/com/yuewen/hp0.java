package com.yuewen;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class hp0 {
    public static final Pattern d = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SERVER);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12075b;
    public final String c;

    public hp0(String str) {
        String[] strArrSplit = d.split(str);
        String str2 = "";
        int i = 0;
        if (strArrSplit.length < 3) {
            this.f12074a = str;
            this.f12075b = 0;
            this.c = "";
            return;
        }
        try {
            String str3 = strArrSplit[0];
            int i2 = Integer.parseInt(strArrSplit[1]);
            str2 = strArrSplit[2];
            str = str3;
            i = i2;
        } catch (Exception unused) {
        }
        this.f12074a = str;
        this.f12075b = i;
        this.c = str2;
    }

    public static boolean a(hp0 hp0Var, hp0 hp0Var2) {
        if (hp0Var == null && hp0Var2 == null) {
            return true;
        }
        if (hp0Var == null || hp0Var2 == null) {
            return false;
        }
        return hp0Var.equals(hp0Var2);
    }

    public static hp0 e(String str, int i, String str2) {
        return new hp0(str, i, str2);
    }

    public String b() {
        return this.f12074a;
    }

    public int c() {
        return this.f12075b;
    }

    public String d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof hp0) {
            return TextUtils.equals(this.f12074a, ((hp0) obj).f12074a);
        }
        return false;
    }

    public String toString() {
        return this.f12075b == 0 ? this.f12074a : String.format(Locale.getDefault(), "%s-%d-%s", this.f12074a, Integer.valueOf(this.f12075b), this.c);
    }

    public hp0(String str, int i, String str2) {
        this.f12074a = str;
        if (!TextUtils.isEmpty(str2)) {
            this.f12075b = i;
            this.c = str2;
        } else {
            this.f12075b = 0;
            this.c = "";
        }
    }
}
