package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Debug;

/* JADX INFO: loaded from: classes.dex */
public class b {
    static final C0062b a;

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.b$b, reason: collision with other inner class name */
    private static class C0062b {
        private C0062b() {
        }

        public int a(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int b(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int c(Debug.MemoryInfo memoryInfo) {
            return -1;
        }
    }

    @TargetApi(19)
    private static class c extends C0062b {
        private c() {
            super();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.b.C0062b
        public int a(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.b.C0062b
        public int b(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.b.C0062b
        public int c(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    static {
        a = Build.VERSION.SDK_INT >= 19 ? new c() : new C0062b();
    }

    public static int a(Debug.MemoryInfo memoryInfo) {
        return a.a(memoryInfo);
    }

    public static int b(Debug.MemoryInfo memoryInfo) {
        return a.b(memoryInfo);
    }

    public static int c(Debug.MemoryInfo memoryInfo) {
        return a.c(memoryInfo);
    }
}
