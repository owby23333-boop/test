package com.amgcyo.cuttadon.database;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MixinOpenHelperFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d extends SupportSQLiteOpenHelper.Callback {
    private final SupportSQLiteOpenHelper.Callback a;
    private final c b;

    public d(@NotNull SupportSQLiteOpenHelper.Callback callback, @NotNull c cVar) {
        super(callback.version);
        this.a = callback;
        this.b = cVar;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onConfigure(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
        this.b.b(supportSQLiteDatabase);
        this.a.onConfigure(supportSQLiteDatabase);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCorruption(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
        this.b.c(supportSQLiteDatabase);
        this.a.onCorruption(supportSQLiteDatabase);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCreate(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
        this.b.d(supportSQLiteDatabase);
        this.a.onCreate(supportSQLiteDatabase);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onDowngrade(@NotNull SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3) {
        this.b.b(supportSQLiteDatabase, i2, i3);
        this.a.onDowngrade(supportSQLiteDatabase, i2, i3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onOpen(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
        this.b.a(supportSQLiteDatabase);
        this.a.onOpen(supportSQLiteDatabase);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(@NotNull SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3) {
        this.b.a(supportSQLiteDatabase, i2, i3);
        this.a.onUpgrade(supportSQLiteDatabase, i2, i3);
    }
}
