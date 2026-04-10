package com.amgcyo.cuttadon.activity.fission5;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.xtablayout.XTabLayout;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class Fission5IncomeActivity_ViewBinding implements Unbinder {
    private Fission5IncomeActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2509c;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5IncomeActivity f2510s;

        a(Fission5IncomeActivity_ViewBinding fission5IncomeActivity_ViewBinding, Fission5IncomeActivity fission5IncomeActivity) {
            this.f2510s = fission5IncomeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2510s.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5IncomeActivity f2511s;

        b(Fission5IncomeActivity_ViewBinding fission5IncomeActivity_ViewBinding, Fission5IncomeActivity fission5IncomeActivity) {
            this.f2511s = fission5IncomeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2511s.onViewClicked(view);
        }
    }

    @UiThread
    public Fission5IncomeActivity_ViewBinding(Fission5IncomeActivity fission5IncomeActivity, View view) {
        this.a = fission5IncomeActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_earnings, "field 'tv_earnings' and method 'onViewClicked'");
        fission5IncomeActivity.tv_earnings = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_earnings, "field 'tv_earnings'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, fission5IncomeActivity));
        fission5IncomeActivity.tv_money_type = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_money_type, "field 'tv_money_type'", TextView.class);
        fission5IncomeActivity.tvMoneyGolde = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_type, "field 'tvMoneyGolde'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_tx, "field 'll_tx' and method 'onViewClicked'");
        fission5IncomeActivity.ll_tx = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.ll_tx, "field 'll_tx'", LinearLayout.class);
        this.f2509c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, fission5IncomeActivity));
        fission5IncomeActivity.mTabLayout = (XTabLayout) Utils.findRequiredViewAsType(view, R.id.tab_layout, "field 'mTabLayout'", XTabLayout.class);
        fission5IncomeActivity.mViewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.view_pager, "field 'mViewPager'", ViewPager.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        Fission5IncomeActivity fission5IncomeActivity = this.a;
        if (fission5IncomeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        fission5IncomeActivity.tv_earnings = null;
        fission5IncomeActivity.tv_money_type = null;
        fission5IncomeActivity.tvMoneyGolde = null;
        fission5IncomeActivity.ll_tx = null;
        fission5IncomeActivity.mTabLayout = null;
        fission5IncomeActivity.mViewPager = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2509c.setOnClickListener(null);
        this.f2509c = null;
    }
}
