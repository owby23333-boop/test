package com.yuewen;

import androidx.annotation.Nullable;
import com.duokan.free.tts.data.DkDataSource;
import com.duokan.reader.ui.store.fiction.data.FictionItem;

/* JADX INFO: loaded from: classes5.dex */
public class s34 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public k60[] f17351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public DkDataSource f17352b;

    @Nullable
    public com.duokan.reader.domain.bookshelf.b c;
    public FictionItem d;
    public FictionItem e;

    @Nullable
    public k60[] a() {
        return this.f17351a;
    }

    @Nullable
    public DkDataSource b() {
        return this.f17352b;
    }

    @Nullable
    public com.duokan.reader.domain.bookshelf.b c() {
        return this.c;
    }

    public FictionItem d() {
        return this.d;
    }

    public FictionItem e() {
        return this.e;
    }

    public void f(@Nullable k60[] k60VarArr) {
        this.f17351a = k60VarArr;
    }

    public void g(@Nullable DkDataSource dkDataSource) {
        this.f17352b = dkDataSource;
    }

    public void h(@Nullable com.duokan.reader.domain.bookshelf.b bVar) {
        this.c = bVar;
    }

    public void i(FictionItem fictionItem) {
        this.d = fictionItem;
    }

    public void j(FictionItem fictionItem, String str) {
        this.e = fictionItem;
        if (this.d == null) {
            this.d = fictionItem;
        }
        if (dj0.L.equals(str)) {
            this.d = fictionItem;
        }
    }
}
