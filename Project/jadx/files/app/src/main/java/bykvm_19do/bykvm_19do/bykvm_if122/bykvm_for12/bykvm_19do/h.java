package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class h extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile h f1672d;

    private h(Context context) {
        super(context);
    }

    public static h a(Context context) {
        if (f1672d == null) {
            synchronized (h.class) {
                if (f1672d == null) {
                    f1672d = new h(context);
                }
            }
        }
        return f1672d;
    }
}
