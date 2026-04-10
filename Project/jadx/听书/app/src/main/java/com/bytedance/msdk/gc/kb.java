package com.bytedance.msdk.gc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes2.dex */
public class kb implements com.bytedance.sdk.component.gz.z.m {
    public static final kb z = new kb();
    private volatile SQLiteDatabase g;

    @Override // com.bytedance.sdk.component.gz.z.m
    public String a() {
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.z.m
    public String dl() {
        return "adevent_applog";
    }

    @Override // com.bytedance.sdk.component.gz.z.m
    public String g() {
        return "adevent";
    }

    @Override // com.bytedance.sdk.component.gz.z.m
    public String gc() {
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.z.m
    public String m() {
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.z.m
    public String z() {
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.z.m
    public SQLiteDatabase z(Context context) {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.g = com.bytedance.msdk.gc.z.m.z(context).z().z();
                    com.bytedance.msdk.z.gc.dl.z("---------------DB CREATE  SUCCESS new------------");
                }
            }
        }
        return this.g;
    }
}
