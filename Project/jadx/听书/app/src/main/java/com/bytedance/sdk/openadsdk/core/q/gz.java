package com.bytedance.sdk.openadsdk.core.q;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.openadsdk.core.gz;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class gz implements com.bytedance.sdk.component.gz.z.m {
    public static final gz z = new gz();
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
            synchronized (gz.class) {
                if (this.g == null) {
                    gz.dl dlVarZ = com.bytedance.sdk.openadsdk.core.e.z(zw.getContext()).z();
                    dlVarZ.z();
                    this.g = dlVarZ.g();
                }
            }
        }
        return this.g;
    }
}
