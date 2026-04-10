package i0.a.b.b.a.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
class c {
    String a;
    Boolean b;

    c() {
    }

    void a(boolean z2) {
        this.b = Boolean.valueOf(z2);
    }

    boolean a() {
        return this.b != null;
    }

    boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.a, str);
    }

    void b(String str) {
        this.a = str;
    }

    boolean b() {
        Boolean bool = this.b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
