package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.bykvm_19do;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile e f1997e;
    private Context a;
    private Map<bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c, c> b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f1998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f1999d;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.values().length];

        static {
            try {
                a[bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private e(@NonNull Context context) {
        this.a = context;
        this.f1998c = new b(this.a);
        this.f1999d = new d(this.a);
    }

    @Nullable
    private c a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c cVar) {
        c gVar = this.b.get(cVar);
        if (gVar == null) {
            int i2 = a.a[cVar.ordinal()];
            if (i2 == 1) {
                gVar = new g(this.a, this.f1998c, this.f1999d);
            } else if (i2 == 2) {
                gVar = new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.bykvm_19do.a(this.a, this.f1998c, this.f1999d);
            } else if (i2 == 3) {
                gVar = new f(this.a, this.f1998c, this.f1999d);
            }
            if (gVar != null) {
                this.b.put(cVar, gVar);
            }
        }
        return gVar;
    }

    public static e a() {
        if (f1997e != null) {
            return f1997e;
        }
        throw new IllegalArgumentException("CrashContextAssembly not init");
    }

    public static void a(Context context) {
        if (f1997e == null) {
            f1997e = new e(context);
        }
    }

    public bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c cVar, bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar) {
        c cVarA;
        return (cVar == null || (cVarA = a(cVar)) == null) ? aVar : cVarA.b(aVar);
    }
}
