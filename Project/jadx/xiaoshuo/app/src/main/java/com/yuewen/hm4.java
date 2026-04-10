package com.yuewen;

import android.text.TextUtils;
import com.duokan.core.diagnostic.LogLevel;

/* JADX INFO: loaded from: classes12.dex */
public class hm4 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12053b = "124697383123959808";
    public static final String c = "124697383212040192";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12054a;

    public hm4() {
        this.f12054a = "";
    }

    public String a() {
        return this.f12054a;
    }

    public boolean b() {
        return TextUtils.equals(this.f12054a, "124697383123959808");
    }

    public boolean c() {
        return TextUtils.equals(this.f12054a, "124697383212040192");
    }

    public boolean d() {
        return TextUtils.isEmpty(this.f12054a);
    }

    public hm4(int i) {
        if (i >= 0 && i <= 4) {
            this.f12054a = "124697383123959808";
            ia0.w().f(LogLevel.INFO, "YimiDownloadAdPopupAbTestConfig", "use style A");
        } else if (i > 4 && i <= 9) {
            this.f12054a = "124697383212040192";
            ia0.w().f(LogLevel.INFO, "YimiDownloadAdPopupAbTestConfig", "use style B");
        } else {
            this.f12054a = "";
            ia0.w().f(LogLevel.INFO, "YimiDownloadAdPopupAbTestConfig", "use style C");
        }
    }
}
