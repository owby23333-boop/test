package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public abstract class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8333a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private File f1068a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Runnable f1069a;

    public /* synthetic */ u(Context context, File file, v vVar) {
        this(context, file);
    }

    public static void a(Context context, File file, Runnable runnable) {
        new v(context, file, runnable).run();
    }

    public abstract void a(Context context);

    @Override // java.lang.Runnable
    public final void run() {
        t tVarA = null;
        try {
            try {
                if (this.f1068a == null) {
                    this.f1068a = new File(this.f8333a.getFilesDir(), "default_locker");
                }
                tVarA = t.a(this.f8333a, this.f1068a);
                Runnable runnable = this.f1069a;
                if (runnable != null) {
                    runnable.run();
                }
                a(this.f8333a);
                if (tVarA == null) {
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (tVarA == null) {
                    return;
                }
            }
            tVarA.a();
        } catch (Throwable th) {
            if (tVarA != null) {
                tVarA.a();
            }
            throw th;
        }
    }

    private u(Context context, File file) {
        this.f8333a = context;
        this.f1068a = file;
    }
}
