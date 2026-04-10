package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f1501c = "f";
    private final Set<String> a;
    private Looper b;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.onGranted();
        }
    }

    class b implements Runnable {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.onDenied(this.a);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.onGranted();
        }
    }

    class d implements Runnable {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.onDenied(this.a);
        }
    }

    static /* synthetic */ class e {
        static final /* synthetic */ int[] a = new int[bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.d.values().length];

        static {
            try {
                a[bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.d.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.d.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.d.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public f() {
        this.a = new HashSet(1);
        this.b = Looper.getMainLooper();
    }

    public f(@NonNull Looper looper) {
        this.a = new HashSet(1);
        this.b = Looper.getMainLooper();
        this.b = looper;
    }

    protected final void a(@NonNull String[] strArr) {
        synchronized (this) {
            Collections.addAll(this.a, strArr);
        }
    }

    protected final boolean a(@NonNull String str, int i2) {
        boolean zA;
        synchronized (this) {
            zA = a(str, i2 == 0 ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.d.GRANTED : bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.d.DENIED);
        }
        return zA;
    }

    protected final boolean a(@NonNull String str, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.d dVar) {
        boolean z2;
        Handler handler;
        Runnable aVar;
        Handler handler2;
        Runnable bVar;
        synchronized (this) {
            this.a.remove(str);
            int i2 = e.a[dVar.ordinal()];
            z2 = true;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        if (!shouldIgnorePermissionNotFound(str)) {
                            handler2 = new Handler(this.b);
                            bVar = new d(str);
                        } else if (this.a.isEmpty()) {
                            handler = new Handler(this.b);
                            aVar = new c();
                            handler.post(aVar);
                        }
                    }
                    z2 = false;
                } else {
                    handler2 = new Handler(this.b);
                    bVar = new b(str);
                }
                handler2.post(bVar);
            } else {
                if (this.a.isEmpty()) {
                    handler = new Handler(this.b);
                    aVar = new a();
                    handler.post(aVar);
                }
                z2 = false;
            }
        }
        return z2;
    }

    public abstract void onDenied(String str);

    public abstract void onGranted();

    public boolean shouldIgnorePermissionNotFound(String str) {
        synchronized (this) {
            String str2 = "Permission not found: " + str;
        }
        return true;
    }
}
