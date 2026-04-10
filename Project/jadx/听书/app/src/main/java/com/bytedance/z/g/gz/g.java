package com.bytedance.z.g.gz;

import android.os.Debug;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    static final z z = new C0230g();

    private static class z {
        public int dl(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int g(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int z(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        private z() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.z.g.gz.g$g, reason: collision with other inner class name */
    private static class C0230g extends z {
        private C0230g() {
            super();
        }

        @Override // com.bytedance.z.g.gz.g.z
        public int z(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // com.bytedance.z.g.gz.g.z
        public int g(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // com.bytedance.z.g.gz.g.z
        public int dl(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    public static int z(Debug.MemoryInfo memoryInfo) {
        return z.z(memoryInfo);
    }

    public static int g(Debug.MemoryInfo memoryInfo) {
        return z.g(memoryInfo);
    }

    public static int dl(Debug.MemoryInfo memoryInfo) {
        return z.dl(memoryInfo);
    }
}
