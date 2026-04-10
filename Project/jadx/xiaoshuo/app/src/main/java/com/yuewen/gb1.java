package com.yuewen;

import android.os.Build;
import android.text.TextUtils;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.SystemInfoHelper;
import com.duokan.reader.BasePrivacyManager;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class gb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f11528a = new a();

    public static class a extends c {
        @Override // com.yuewen.gb1.c
        public String b() {
            return SystemInfoHelper.A();
        }

        public a() {
        }
    }

    public static class b extends c {
        @Override // com.yuewen.gb1.c
        public String b() {
            if (Build.VERSION.SDK_INT > 28) {
                return SystemInfoHelper.G();
            }
            try {
                return SystemInfoHelper.C();
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11529a = -1;

        public int a() {
            return this.f11529a;
        }

        public abstract String b();

        public c c() {
            return d(true);
        }

        public c d(boolean z) {
            String strB = b();
            if (!TextUtils.isEmpty(strB)) {
                if (z) {
                    strB = od0.f(strB, "md5");
                }
                this.f11529a = Integer.parseInt(strB.substring(strB.length() - 1), 16);
            }
            return this;
        }

        public boolean e(int i, int i2) {
            int i3 = this.f11529a;
            return i3 >= i && i3 <= i2;
        }

        public boolean f(List<Integer> list) {
            return list.contains(Integer.valueOf(this.f11529a));
        }
    }

    static {
        BasePrivacyManager.o().A(new BasePrivacyManager.b() { // from class: com.yuewen.eb1
            @Override // com.duokan.reader.BasePrivacyManager.b
            public final void W9() {
                gb1.f();
            }
        });
    }

    public static c b(boolean z) {
        return e(a.class, z);
    }

    public static c c(boolean z) {
        return e(b.class, z);
    }

    public static c d(Class<? extends c> cls) {
        try {
            return cls.newInstance().c();
        } catch (Throwable th) {
            ia0.w().j(LogLevel.ERROR, "ab_test", "constructor error", th);
            return null;
        }
    }

    public static c e(Class<? extends c> cls, boolean z) {
        c cVar = null;
        try {
            c cVarNewInstance = cls.newInstance();
            if (!z) {
                return cVarNewInstance;
            }
            try {
                cVarNewInstance.c();
                return cVarNewInstance;
            } catch (Throwable unused) {
                cVar = cVarNewInstance;
                return cVar;
            }
        } catch (Throwable unused2) {
        }
    }

    public static /* synthetic */ void f() {
        f11528a.d(false);
    }
}
