package me.jessyan.art.d.j;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: compiled from: CacheType.java */
/* JADX INFO: loaded from: classes3.dex */
public interface b {
    public static final b a = new a();
    public static final b b = new C0580b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f21177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f21178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f21179e;

    /* JADX INFO: compiled from: CacheType.java */
    class a implements b {
        a() {
        }

        @Override // me.jessyan.art.d.j.b
        public int a() {
            return 0;
        }

        @Override // me.jessyan.art.d.j.b
        public int a(Context context) {
            int memoryClass = (int) (((ActivityManager) context.getSystemService("activity")).getMemoryClass() * 0.002f * 1024.0f);
            return memoryClass >= 150 ? TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO : memoryClass;
        }
    }

    /* JADX INFO: renamed from: me.jessyan.art.d.j.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CacheType.java */
    class C0580b implements b {
        C0580b() {
        }

        @Override // me.jessyan.art.d.j.b
        public int a() {
            return 1;
        }

        @Override // me.jessyan.art.d.j.b
        public int a(Context context) {
            int memoryClass = (int) (((ActivityManager) context.getSystemService("activity")).getMemoryClass() * 0.002f * 1024.0f);
            return memoryClass >= 150 ? TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO : memoryClass;
        }
    }

    /* JADX INFO: compiled from: CacheType.java */
    class c implements b {
        c() {
        }

        @Override // me.jessyan.art.d.j.b
        public int a() {
            return 2;
        }

        @Override // me.jessyan.art.d.j.b
        public int a(Context context) {
            int memoryClass = (int) (((ActivityManager) context.getSystemService("activity")).getMemoryClass() * 0.002f * 1024.0f);
            return memoryClass >= 150 ? TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO : memoryClass;
        }
    }

    /* JADX INFO: compiled from: CacheType.java */
    class d implements b {
        d() {
        }

        @Override // me.jessyan.art.d.j.b
        public int a() {
            return 3;
        }

        @Override // me.jessyan.art.d.j.b
        public int a(Context context) {
            int memoryClass = (int) (((ActivityManager) context.getSystemService("activity")).getMemoryClass() * 0.005f * 1024.0f);
            if (memoryClass >= 500) {
                return 500;
            }
            return memoryClass;
        }
    }

    /* JADX INFO: compiled from: CacheType.java */
    class e implements b {
        e() {
        }

        @Override // me.jessyan.art.d.j.b
        public int a() {
            return 4;
        }

        @Override // me.jessyan.art.d.j.b
        public int a(Context context) {
            int memoryClass = (int) (((ActivityManager) context.getSystemService("activity")).getMemoryClass() * 8.0E-4f * 1024.0f);
            if (memoryClass >= 80) {
                return 80;
            }
            return memoryClass;
        }
    }

    /* JADX INFO: compiled from: CacheType.java */
    class f implements b {
        f() {
        }

        @Override // me.jessyan.art.d.j.b
        public int a() {
            return 5;
        }

        @Override // me.jessyan.art.d.j.b
        public int a(Context context) {
            int memoryClass = (int) (((ActivityManager) context.getSystemService("activity")).getMemoryClass() * 8.0E-4f * 1024.0f);
            if (memoryClass >= 80) {
                return 80;
            }
            return memoryClass;
        }
    }

    static {
        new c();
        f21177c = new d();
        f21178d = new e();
        f21179e = new f();
    }

    int a();

    int a(Context context);
}
