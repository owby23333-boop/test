package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class g {
    static final b a;

    private static class b {
        private b() {
        }

        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }
    }

    @TargetApi(16)
    private static class c extends b {
        private c() {
            super();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.g.b
        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    static {
        a = Build.VERSION.SDK_INT >= 16 ? new c() : new b();
    }

    public static long a(ActivityManager.MemoryInfo memoryInfo) {
        return a.a(memoryInfo);
    }
}
