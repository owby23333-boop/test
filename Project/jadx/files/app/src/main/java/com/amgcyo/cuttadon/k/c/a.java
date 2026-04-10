package com.amgcyo.cuttadon.k.c;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkCommentStatus;
import com.amgcyo.cuttadon.api.entity.other.MkConfigSource;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.database.AppDatabase;
import java.util.List;

/* JADX INFO: compiled from: MkComicBookViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends AndroidViewModel {
    private AppDatabase a;

    public a(@NonNull Application application) {
        super(application);
        this.a = AppDatabase.i();
    }

    public LiveData<MkBook> a(int i2) {
        return this.a.a().d(i2);
    }

    public LiveData<List<MkConfigSource>> b() {
        return this.a.c().a();
    }

    public LiveData<List<MkBook>> c() {
        return this.a.a().d();
    }

    public LiveData<MkUser> d() {
        return this.a.d().c();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }

    public LiveData<List<MkCommentStatus>> a() {
        return this.a.b().a();
    }
}
