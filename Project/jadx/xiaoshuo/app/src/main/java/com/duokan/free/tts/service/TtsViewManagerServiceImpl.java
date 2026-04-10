package com.duokan.free.tts.service;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.duokan.dkttsplayer_export.service.TtsViewManagerService;
import com.yuewen.gq0;
import com.yuewen.k44;
import com.yuewen.w60;

/* JADX INFO: loaded from: classes15.dex */
@Route(path = gq0.f11637a)
public class TtsViewManagerServiceImpl implements TtsViewManagerService<k44> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.duokan.free.tts.b f3715a;

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.duokan.dkttsplayer_export.service.TtsViewManagerService
    public View k(ViewGroup viewGroup) {
        return this.f3715a.e(viewGroup);
    }

    @Override // com.duokan.dkttsplayer_export.service.TtsViewManagerService
    /* JADX INFO: renamed from: k3, reason: merged with bridge method [inline-methods] */
    public void g(ViewGroup viewGroup, int i, ViewGroup.LayoutParams layoutParams, k44 k44Var) {
        this.f3715a.l(viewGroup, i, layoutParams, k44Var);
    }

    @Override // com.duokan.dkttsplayer_export.service.TtsViewManagerService
    public void l() {
        this.f3715a.k();
    }

    @Override // com.duokan.dkttsplayer_export.service.TtsViewManagerService
    /* JADX INFO: renamed from: l3, reason: merged with bridge method [inline-methods] */
    public void D2(ViewGroup viewGroup, k44 k44Var) {
        this.f3715a.m(viewGroup, k44Var);
    }

    @Override // com.duokan.dkttsplayer_export.service.TtsViewManagerService
    public void m() {
        this.f3715a.j();
    }

    @Override // com.duokan.dkttsplayer_export.service.TtsViewManagerService
    /* JADX INFO: renamed from: m3, reason: merged with bridge method [inline-methods] */
    public void A(w60 w60Var, k44 k44Var) {
        this.f3715a.n(w60Var, k44Var);
    }

    @Override // com.duokan.dkttsplayer_export.service.TtsViewManagerService
    public void prepare() {
        this.f3715a = new com.duokan.free.tts.b();
    }
}
