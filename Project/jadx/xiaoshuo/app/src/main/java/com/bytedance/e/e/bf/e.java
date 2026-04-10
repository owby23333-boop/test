package com.bytedance.e.e.bf;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.e.e.v.m;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static volatile e e;
    private com.bytedance.e.e.bf.bf.bf bf;
    private SQLiteDatabase d;

    private e() {
    }

    public static e e() {
        if (e == null) {
            synchronized (e.class) {
                if (e == null) {
                    e = new e();
                }
            }
        }
        return e;
    }

    public void e(Context context) {
        try {
            this.d = new bf(context).getWritableDatabase();
        } catch (Throwable th) {
            m.bf(th);
        }
        this.bf = new com.bytedance.e.e.bf.bf.bf();
    }

    public synchronized void e(com.bytedance.e.e.bf.e.e eVar) {
        com.bytedance.e.e.bf.bf.bf bfVar = this.bf;
        if (bfVar != null) {
            bfVar.insert(this.d, eVar);
        }
    }

    public synchronized boolean e(String str) {
        com.bytedance.e.e.bf.bf.bf bfVar = this.bf;
        if (bfVar == null) {
            return false;
        }
        return bfVar.e(this.d, str);
    }
}
