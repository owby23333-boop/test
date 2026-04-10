package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.d0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f1498d = "e";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static e f1499e;
    private final Set<String> a = new HashSet(1);
    private final List<WeakReference<f>> b = new ArrayList(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<f> f1500c = new ArrayList(1);

    private e() {
        b();
    }

    public static e a() {
        if (f1499e == null) {
            f1499e = new e();
        }
        return f1499e;
    }

    private void a(@Nullable f fVar) {
        synchronized (this) {
            Iterator<WeakReference<f>> it = this.b.iterator();
            while (it.hasNext()) {
                WeakReference<f> next = it.next();
                if (next.get() == fVar || next.get() == null) {
                    it.remove();
                }
            }
            Iterator<f> it2 = this.f1500c.iterator();
            while (it2.hasNext()) {
                if (it2.next() == fVar) {
                    it2.remove();
                }
            }
        }
    }

    private void a(@NonNull String[] strArr, @Nullable f fVar) {
        synchronized (this) {
            if (fVar != null) {
                fVar.a(strArr);
                this.f1500c.add(fVar);
                this.b.add(new WeakReference<>(fVar));
            }
        }
    }

    private void a(@NonNull String[] strArr, @NonNull int[] iArr, String[] strArr2) {
        int i2;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<f>> it = this.b.iterator();
            while (it.hasNext()) {
                f fVar = it.next().get();
                while (i2 < length) {
                    i2 = (fVar == null || fVar.a(strArr[i2], iArr[i2])) ? 0 : i2 + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<f> it2 = this.f1500c.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        String str;
        synchronized (this) {
            for (Field field : Manifest.permission.class.getFields()) {
                try {
                    str = (String) field.get("");
                } catch (IllegalAccessException unused) {
                    str = null;
                }
                this.a.add(str);
            }
        }
    }

    private void b(@NonNull Activity activity, @NonNull String[] strArr, @Nullable f fVar) {
        for (String str : strArr) {
            if (fVar != null) {
                try {
                    if (fVar.a(str, !this.a.contains(str) ? d.NOT_FOUND : c.a(activity, str) != 0 ? d.DENIED : d.GRANTED)) {
                        break;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        a(fVar);
    }

    @NonNull
    private List<String> c(@NonNull Activity activity, @NonNull String[] strArr, @Nullable f fVar) {
        d dVar;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.a.contains(str)) {
                if (!a(activity, str)) {
                    arrayList.add(str);
                } else if (fVar != null) {
                    dVar = d.GRANTED;
                    fVar.a(str, dVar);
                }
            } else if (fVar != null) {
                dVar = d.NOT_FOUND;
                fVar.a(str, dVar);
            }
        }
        return arrayList;
    }

    public void a(@Nullable Activity activity, @NonNull String[] strArr, @Nullable f fVar) {
        synchronized (this) {
            if (activity != null) {
                try {
                    a(strArr, fVar);
                    if (Build.VERSION.SDK_INT < 23) {
                        b(activity, strArr, fVar);
                    } else {
                        List<String> listC = c(activity, strArr, fVar);
                        if (listC.isEmpty()) {
                            a(fVar);
                        } else {
                            c.a(activity, (String[]) listC.toArray(new String[listC.size()]), 1);
                        }
                    }
                } finally {
                }
            }
        }
    }

    public void a(@NonNull Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        synchronized (this) {
            try {
                new ArrayList(3);
                int length = strArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    String str = strArr[i2];
                    if ((iArr[i2] == -1 || (d0.t() && !b.b(activity, str))) && iArr[i2] != -1) {
                        iArr[i2] = -1;
                    }
                }
                a(strArr, iArr, (String[]) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean a(@Nullable Context context, @NonNull String str) {
        boolean z2;
        synchronized (this) {
            z2 = false;
            if (context != null) {
                if (!d0.t() ? c.a(context, str) == 0 || !this.a.contains(str) : b.b(context, str) && (c.a(context, str) == 0 || !this.a.contains(str))) {
                    z2 = true;
                }
            }
        }
        return z2;
    }
}
