package com.amgcyo.cuttadon.activity.read;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.BgmMp3;
import com.amgcyo.cuttadon.app.MkApplication;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkMp3RecomActivity extends BaseRefreshMoreRecyclerActivity implements BaseQuickAdapter.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    List<BgmMp3> f2694r0;

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "好听的背景音乐推荐";
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        try {
            this.f2694r0 = com.amgcyo.cuttadon.utils.otherutils.r.b(com.amgcyo.cuttadon.utils.otherutils.v.b(MkApplication.getAppContext(), "mp3.json"), BgmMp3.class);
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2694r0)) {
                showEmpty();
                return;
            }
            Iterator<BgmMp3> it = this.f2694r0.iterator();
            while (it.hasNext()) {
                it.next().setItemType(2);
            }
            this.f2256n0 = new com.amgcyo.cuttadon.b.c.o(this.f2694r0);
            this.recyclerView.setAdapter(this.f2256n0);
            c(false);
            d(false);
            this.f2256n0.a((BaseQuickAdapter.g) this);
        } catch (Exception unused) {
            showEmpty();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    public void loadData() {
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        BgmMp3 bgmMp3;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2694r0) || (bgmMp3 = this.f2694r0.get(i2)) == null) {
            return;
        }
        com.amgcyo.cuttadon.f.o.a(this, bgmMp3.getName(), R.string.mp3_copy);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    protected boolean p() {
        return false;
    }
}
