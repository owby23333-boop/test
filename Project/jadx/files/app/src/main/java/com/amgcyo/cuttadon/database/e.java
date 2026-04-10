package com.amgcyo.cuttadon.database;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MixinOpenHelperFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e implements SupportSQLiteOpenHelper.Factory {
    private final SupportSQLiteOpenHelper.Factory a;
    private final c b;

    public e(@NotNull SupportSQLiteOpenHelper.Factory factory, @NotNull c cVar) {
        this.a = factory;
        this.b = cVar;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @NotNull
    public SupportSQLiteOpenHelper create(@NotNull SupportSQLiteOpenHelper.Configuration configuration) {
        return this.a.create(SupportSQLiteOpenHelper.Configuration.builder(configuration.context).name(configuration.name).callback(new d(configuration.callback, this.b)).build());
    }
}
