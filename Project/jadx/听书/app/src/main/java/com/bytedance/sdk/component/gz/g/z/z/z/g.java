package com.bytedance.sdk.component.gz.g.z.z.z;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.gz.z.m;

/* JADX INFO: loaded from: classes2.dex */
public class g implements m {
    public static final g z = new g();
    private volatile SQLiteDatabase g;

    @Override // com.bytedance.sdk.component.gz.z.m
    public String a() {
        return "logstats";
    }

    @Override // com.bytedance.sdk.component.gz.z.m
    public String dl() {
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.z.m
    public String g() {
        return "adevent";
    }

    @Override // com.bytedance.sdk.component.gz.z.m
    public String gc() {
        return "logstatsbatch";
    }

    @Override // com.bytedance.sdk.component.gz.z.m
    public String m() {
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.z.m
    public String z() {
        return "loghighpriority";
    }

    @Override // com.bytedance.sdk.component.gz.z.m
    public SQLiteDatabase z(Context context) {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.g = new z(context, this).getWritableDatabase();
                }
            }
        }
        return this.g;
    }
}
