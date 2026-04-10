package com.kwad.components.core.l;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.components.core.r.i;
import com.kwad.components.core.r.m;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends IFragmentActivityProxy {
    private final com.kwad.components.core.l.kwai.a mPageMonitor = new com.kwad.components.core.l.kwai.a();
    private final com.kwad.sdk.h.kwai.a mBackPressDelete = new com.kwad.sdk.h.kwai.a();
    private boolean enableDestroyer = true;

    public void addBackPressable(com.kwad.sdk.h.kwai.b bVar) {
        this.mBackPressDelete.addBackPressable(bVar);
    }

    public void addBackPressable(com.kwad.sdk.h.kwai.b bVar, int i2) {
        this.mBackPressDelete.addBackPressable(bVar, i2);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public Intent getIntent() {
        Intent intent = super.getIntent();
        m.e(intent);
        return intent;
    }

    protected abstract String getPageName();

    public boolean isEnableDestroyer() {
        return this.enableDestroyer;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        if (this.mBackPressDelete.bX()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        long longExtra = intent != null ? intent.getLongExtra("key_start_time", 0L) : 0L;
        this.mPageMonitor.au(getClass().getSimpleName());
        this.mPageMonitor.s(longExtra);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        if (this.enableDestroyer) {
            i.destroyActivity(getActivity(), getWindow());
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        com.kwad.components.core.l.kwai.a aVar = this.mPageMonitor;
        getActivity();
        aVar.pq();
    }

    public void removeBackPressable(com.kwad.sdk.h.kwai.b bVar) {
        this.mBackPressDelete.removeBackPressable(bVar);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void setContentView(int i2) {
        super.setContentView(com.kwad.sdk.i.a.inflate(Wrapper.wrapContextIfNeed(getActivity()), i2, null));
    }

    public void setEnableDestroyer(boolean z2) {
        this.enableDestroyer = z2;
    }
}
