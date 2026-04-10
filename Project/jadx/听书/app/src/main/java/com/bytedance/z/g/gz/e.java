package com.bytedance.z.g.gz;

import android.app.ActivityManager;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    static final z z = new g();

    private static class z {
        public long z(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }

        private z() {
        }
    }

    private static class g extends z {
        private g() {
            super();
        }

        @Override // com.bytedance.z.g.gz.e.z
        public long z(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    public static long z(ActivityManager.MemoryInfo memoryInfo) {
        return z.z(memoryInfo);
    }
}
