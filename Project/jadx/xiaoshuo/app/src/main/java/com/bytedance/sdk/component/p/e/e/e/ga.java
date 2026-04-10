package com.bytedance.sdk.component.p.e.e.e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class ga implements com.bytedance.sdk.component.p.e.e.ga {
    public static final ga e = new ga();
    private volatile SQLiteDatabase bf;

    @Override // com.bytedance.sdk.component.p.e.e.ga
    public String bf() {
        return "adevent";
    }

    @Override // com.bytedance.sdk.component.p.e.e.ga
    public String d() {
        return null;
    }

    @Override // com.bytedance.sdk.component.p.e.e.ga
    public String e() {
        return "loghighpriority";
    }

    @Override // com.bytedance.sdk.component.p.e.e.ga
    public String ga() {
        return "logstatsbatch";
    }

    @Override // com.bytedance.sdk.component.p.e.e.ga
    public String tg() {
        return "logstats";
    }

    @Override // com.bytedance.sdk.component.p.e.e.ga
    public String vn() {
        return null;
    }

    @Override // com.bytedance.sdk.component.p.e.e.ga
    public SQLiteDatabase e(Context context) {
        if (this.bf == null) {
            synchronized (this) {
                if (this.bf == null) {
                    this.bf = new tg(context).getWritableDatabase();
                    com.bytedance.sdk.component.p.e.d.d.e("---------------DB CREATE  SUCCESS------------");
                }
            }
        }
        return this.bf;
    }
}
