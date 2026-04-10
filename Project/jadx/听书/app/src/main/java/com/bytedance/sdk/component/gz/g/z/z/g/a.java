package com.bytedance.sdk.component.gz.g.z.z.g;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class a extends m {
    @Override // com.bytedance.sdk.component.gz.g.z.z.g.m
    public byte dl() {
        return (byte) 0;
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z.g.m
    public byte g() {
        return (byte) 1;
    }

    public a(Context context, com.bytedance.sdk.component.gz.g.a.g.z zVar, com.bytedance.sdk.component.gz.z.gc gcVar) {
        super(context, zVar, gcVar);
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z.g.m, com.bytedance.sdk.component.gz.g.z.z.g.g
    public String z() {
        com.bytedance.sdk.component.gz.z.m mVarG = this.g.g();
        if (mVarG != null) {
            return mVarG.z();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z.g.m, com.bytedance.sdk.component.gz.g.z.z
    public boolean z(com.bytedance.sdk.component.gz.z.g gVar) {
        return com.bytedance.sdk.component.gz.g.dl.z.z(gVar);
    }

    public static String g(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public static String dl(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }
}
