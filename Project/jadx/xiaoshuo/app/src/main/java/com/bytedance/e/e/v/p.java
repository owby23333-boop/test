package com.bytedance.e.e.v;

import android.annotation.TargetApi;
import android.app.ActivityManager;

/* JADX INFO: loaded from: classes.dex */
public class p {
    static final e e = new bf();

    @TargetApi(16)
    public static class bf extends e {
        private bf() {
            super();
        }

        @Override // com.bytedance.e.e.v.p.e
        public long e(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    public static class e {
        private e() {
        }

        public long e(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }
    }

    public static long e(ActivityManager.MemoryInfo memoryInfo) {
        return e.e(memoryInfo);
    }
}
