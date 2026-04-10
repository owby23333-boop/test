package com.tramini.plugin.a.f;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> {
    private b a;

    a(b bVar) {
        this.a = bVar;
    }

    protected final synchronized SQLiteDatabase a() {
        return this.a.a();
    }

    protected final synchronized SQLiteDatabase b() {
        return this.a.b();
    }
}
