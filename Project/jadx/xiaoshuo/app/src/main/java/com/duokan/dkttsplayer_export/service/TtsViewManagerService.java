package com.duokan.dkttsplayer_export.service;

import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.yuewen.w60;
import java.lang.Runnable;

/* JADX INFO: loaded from: classes15.dex */
public interface TtsViewManagerService<R extends Runnable> extends IProvider {
    void A(w60 w60Var, R r);

    void D2(ViewGroup viewGroup, R r);

    void g(ViewGroup viewGroup, int i, ViewGroup.LayoutParams layoutParams, R r);

    View k(ViewGroup viewGroup);

    void l();

    void m();

    void prepare();
}
