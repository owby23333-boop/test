package com.duokan.dkreadercore_export.service;

import android.content.SharedPreferences;
import androidx.arch.core.util.Function;
import androidx.core.util.Consumer;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.yuewen.bv0;
import java.io.File;

/* JADX INFO: loaded from: classes14.dex */
public interface PreferenceService extends IProvider {
    boolean M2();

    void R0();

    File W1();

    void b3(boolean z);

    void c(boolean z);

    boolean c1();

    void c2(Consumer<SharedPreferences.Editor> consumer);

    <V> V d3(Function<SharedPreferences, V> function);

    long g1();

    void g3(boolean z);

    File i1();

    File[] l1();

    File n0();

    boolean n2();

    boolean r(bv0 bv0Var);

    boolean t1();

    void w(bv0 bv0Var);

    int x1();

    boolean[] y();
}
