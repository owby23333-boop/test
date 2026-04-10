package me.jessyan.art.base.f;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import me.jessyan.art.mvp.c;

/* JADX INFO: compiled from: IActivity.java */
/* JADX INFO: loaded from: classes.dex */
public interface h<P extends me.jessyan.art.mvp.c> {
    void initData(@Nullable Bundle bundle);

    int initView(@Nullable Bundle bundle);

    @Nullable
    P obtainPresenter();

    @NonNull
    me.jessyan.art.d.j.a<String, Object> provideCache();

    void setPresenter(@Nullable P p2);

    boolean useEventBus();

    boolean useFragment();
}
