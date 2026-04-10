package com.xiaomi.ad;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.ad.common.util.SystemProperties;

/* JADX INFO: loaded from: classes5.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7255a = "ro.miui.ui.version.code";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7256b = "ro.miui.ui.version.name";

    @Override // com.xiaomi.ad.a
    public String a(Context context) {
        return d.b(context).a();
    }

    public static boolean a() {
        return (TextUtils.isEmpty(SystemProperties.get(f7255a)) || TextUtils.isEmpty(SystemProperties.get("ro.miui.ui.version.name"))) ? false : true;
    }
}
