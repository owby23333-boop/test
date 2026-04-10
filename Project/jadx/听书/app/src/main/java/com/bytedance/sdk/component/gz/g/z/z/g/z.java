package com.bytedance.sdk.component.gz.g.z.z.g;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class z extends e {
    @Override // com.bytedance.sdk.component.gz.g.z.z.g.e
    public byte dl() {
        return (byte) 3;
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z.g.e
    public byte g() {
        return (byte) 1;
    }

    public z(Context context, com.bytedance.sdk.component.gz.g.a.g.z zVar, com.bytedance.sdk.component.gz.z.gc gcVar) {
        super(context, zVar, gcVar);
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z.g.e, com.bytedance.sdk.component.gz.g.z.z.g.g
    public String z() {
        return this.g.g().gc();
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z.g.e, com.bytedance.sdk.component.gz.g.z.z
    public boolean z(com.bytedance.sdk.component.gz.z.g gVar) {
        return com.bytedance.sdk.component.gz.g.dl.z.gc(gVar);
    }

    public static String g(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public static String dl(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }
}
