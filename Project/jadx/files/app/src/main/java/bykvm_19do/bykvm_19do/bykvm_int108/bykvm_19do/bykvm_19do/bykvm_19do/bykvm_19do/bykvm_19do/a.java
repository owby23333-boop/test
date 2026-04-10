package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile a f1818c;

    private a(Context context) {
        super(context);
    }

    public static a a(Context context) {
        if (f1818c == null) {
            synchronized (a.class) {
                if (f1818c == null) {
                    f1818c = new a(context);
                }
            }
        }
        return f1818c;
    }
}
