package org.repackage.com.meizu.flyme.openidsdk;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
class SupportInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f2550a;
    Boolean b;

    SupportInfo() {
    }

    void a(boolean z) {
        this.b = Boolean.valueOf(z);
    }

    boolean a() {
        return this.b != null;
    }

    boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f2550a, str);
    }

    void b(String str) {
        this.f2550a = str;
    }

    boolean b() {
        Boolean bool = this.b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
