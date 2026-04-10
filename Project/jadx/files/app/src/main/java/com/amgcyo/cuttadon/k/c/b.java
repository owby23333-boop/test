package com.amgcyo.cuttadon.k.c;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.amgcyo.cuttadon.api.entity.other.LocalReadHistoryBean;
import com.amgcyo.cuttadon.database.ReadHistoryDatabase;
import java.util.List;

/* JADX INFO: compiled from: MkReadHistoryViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends AndroidViewModel {
    private ReadHistoryDatabase a;

    public b(@NonNull Application application) {
        super(application);
        this.a = ReadHistoryDatabase.b();
    }

    public LiveData<List<LocalReadHistoryBean>> a() {
        return this.a.a().a();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }
}
