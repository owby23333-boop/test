package com.bytedance.e.e.v;

import android.annotation.TargetApi;
import android.os.Debug;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    static final e e = new C0074bf();

    /* JADX INFO: renamed from: com.bytedance.e.e.v.bf$bf, reason: collision with other inner class name */
    @TargetApi(19)
    public static class C0074bf extends e {
        private C0074bf() {
            super();
        }

        @Override // com.bytedance.e.e.v.bf.e
        public int bf(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // com.bytedance.e.e.v.bf.e
        public int d(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }

        @Override // com.bytedance.e.e.v.bf.e
        public int e(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }
    }

    public static class e {
        private e() {
        }

        public int bf(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int d(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int e(Debug.MemoryInfo memoryInfo) {
            return -1;
        }
    }

    public static int bf(Debug.MemoryInfo memoryInfo) {
        return e.bf(memoryInfo);
    }

    public static int d(Debug.MemoryInfo memoryInfo) {
        return e.d(memoryInfo);
    }

    public static int e(Debug.MemoryInfo memoryInfo) {
        return e.e(memoryInfo);
    }
}
