package com.amgcyo.cuttadon.activity.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.fatcatfat.io.R;
import java.lang.reflect.Field;
import java.util.List;
import me.jessyan.art.mvp.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseXTablayoutActivity<P extends me.jessyan.art.mvp.c> extends BaseTitleBarActivity {

    @BindView(R.id.fl_ad)
    protected AdFrameLayout adFrameLayout;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    protected com.amgcyo.cuttadon.adapter.other.e f2286n0;

    @BindView(R.id.vp_classify)
    protected ViewPager vpClassify;

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    protected abstract List<Fragment> getmFragments();

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        List<Fragment> list = getmFragments();
        if (list == null) {
            showMessage(com.amgcyo.cuttadon.f.o.d(R.string.error_params));
            finish();
            return;
        }
        String[] strArrN = n();
        this.f2286n0 = new com.amgcyo.cuttadon.adapter.other.e(getSupportFragmentManager(), strArrN, list);
        this.vpClassify.setAdapter(this.f2286n0);
        this.vpClassify.setOffscreenPageLimit(strArrN.length);
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            com.amgcyo.cuttadon.widget.ui.a aVar = new com.amgcyo.cuttadon.widget.ui.a(this.vpClassify.getContext(), new LinearOutSlowInInterpolator());
            declaredField.set(this.vpClassify, aVar);
            aVar.a(200);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.vpClassify.setCurrentItem(0);
        this.E.setupWithViewPager(this.vpClassify);
        NormalAdParams normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a("position_lists", "csj_new_position_lists");
        if (normalAdParamsA != null) {
            normalAdParamsA.setSelfAdPosition(com.amgcyo.cuttadon.f.n.C);
            this.adFrameLayout.b(normalAdParamsA);
        }
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_feedback;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return true;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return l();
    }

    protected abstract String[] n();

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }
}
