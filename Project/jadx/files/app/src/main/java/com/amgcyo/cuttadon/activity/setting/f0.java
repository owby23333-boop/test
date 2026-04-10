package com.amgcyo.cuttadon.activity.setting;

import com.fatcatfat.io.R;

/* JADX INFO: compiled from: MkClearCacheActivity.java */
/* JADX INFO: loaded from: classes.dex */
class f0 extends com.amgcyo.cuttadon.j.g.h.a<String, Boolean> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MkClearCacheActivity f2867c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    f0(MkClearCacheActivity mkClearCacheActivity, String str) {
        super(str);
        this.f2867c = mkClearCacheActivity;
    }

    @Override // com.amgcyo.cuttadon.j.g.g.a
    public Boolean a(String str) {
        return Boolean.valueOf(com.amgcyo.cuttadon.utils.otherutils.z.a(this.f2867c.f2827n0, "Glide"));
    }

    @Override // com.amgcyo.cuttadon.j.g.g.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(Boolean bool) {
        if (bool.booleanValue()) {
            this.f2867c.showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.clear_cache_success));
            this.f2867c.tvAdCacheSize.setText("0.0B");
        } else {
            this.f2867c.showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.clear_cache_error));
        }
        this.f2867c.hideLoading();
    }
}
