package com.bytedance.z.g.e;

import android.content.Context;
import com.bytedance.z.g.gc.e;
import com.bytedance.z.g.gz;
import com.bytedance.z.g.gz.fo;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {
    private Context z;

    private a(Context context) {
        this.z = context;
    }

    public static void z(Context context, int i) {
        try {
            if (!gz.z().a().equals(context.getPackageName())) {
                return;
            }
        } catch (Exception unused) {
        }
        e.g().postDelayed(new a(context), i);
    }

    public static void z(Context context) {
        z(context, 0);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            new com.bytedance.z.g.gc.dl(this.z).z(fo.g(this.z));
        } finally {
            try {
            } finally {
            }
        }
    }
}
