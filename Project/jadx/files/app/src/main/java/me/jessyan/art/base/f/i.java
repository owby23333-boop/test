package me.jessyan.art.base.f;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import me.jessyan.art.mvp.c;

/* JADX INFO: compiled from: IFragment.java */
/* JADX INFO: loaded from: classes.dex */
public interface i<P extends me.jessyan.art.mvp.c> {
    int a();

    void initData(@Nullable Bundle bundle);

    @Nullable
    P obtainPresenter();

    @NonNull
    me.jessyan.art.d.j.a<String, Object> provideCache();

    void setPresenter(@Nullable P p2);

    boolean useEventBus();
}
