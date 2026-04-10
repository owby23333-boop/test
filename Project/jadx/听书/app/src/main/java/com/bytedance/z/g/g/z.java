package com.bytedance.z.g.g;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.z.g.gz.uy;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z z;
    private SQLiteDatabase dl;
    private com.bytedance.z.g.g.g.g g;

    private z() {
    }

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    public void z(Context context) {
        try {
            this.dl = new g(context).getWritableDatabase();
        } catch (Throwable th) {
            uy.g(th);
        }
        this.g = new com.bytedance.z.g.g.g.g();
    }

    public synchronized void z(com.bytedance.z.g.g.z.z zVar) {
        com.bytedance.z.g.g.g.g gVar = this.g;
        if (gVar != null) {
            gVar.insert(this.dl, zVar);
        }
    }

    public synchronized boolean z(String str) {
        com.bytedance.z.g.g.g.g gVar = this.g;
        if (gVar == null) {
            return false;
        }
        return gVar.z(this.dl, str);
    }
}
