package com.amgcyo.cuttadon.activity.search;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.view.otherview.ProgressWheel;
import com.amgcyo.cuttadon.view.otherview.WanyiwanView;
import com.amgcyo.cuttadon.view.xtablayout.XTabLayout;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkSearchActivity_ViewBinding implements Unbinder {
    private MkSearchActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f2793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f2794f;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkSearchActivity f2795s;

        a(MkSearchActivity_ViewBinding mkSearchActivity_ViewBinding, MkSearchActivity mkSearchActivity) {
            this.f2795s = mkSearchActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2795s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkSearchActivity f2796s;

        b(MkSearchActivity_ViewBinding mkSearchActivity_ViewBinding, MkSearchActivity mkSearchActivity) {
            this.f2796s = mkSearchActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2796s.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkSearchActivity f2797s;

        c(MkSearchActivity_ViewBinding mkSearchActivity_ViewBinding, MkSearchActivity mkSearchActivity) {
            this.f2797s = mkSearchActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2797s.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkSearchActivity f2798s;

        d(MkSearchActivity_ViewBinding mkSearchActivity_ViewBinding, MkSearchActivity mkSearchActivity) {
            this.f2798s = mkSearchActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2798s.onClick(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkSearchActivity f2799s;

        e(MkSearchActivity_ViewBinding mkSearchActivity_ViewBinding, MkSearchActivity mkSearchActivity) {
            this.f2799s = mkSearchActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2799s.onClick(view);
        }
    }

    @UiThread
    public MkSearchActivity_ViewBinding(MkSearchActivity mkSearchActivity, View view) {
        this.a = mkSearchActivity;
        mkSearchActivity.et_search = (EditText) Utils.findRequiredViewAsType(view, R.id.et_search, "field 'et_search'", EditText.class);
        mkSearchActivity.adFrameLayout = (AdFrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_ad, "field 'adFrameLayout'", AdFrameLayout.class);
        mkSearchActivity.rv_hot_search = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_hot_search, "field 'rv_hot_search'", RecyclerView.class);
        mkSearchActivity.rv_history_search = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_history_search, "field 'rv_history_search'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_cancel, "field 'iv_cancel' and method 'onClick'");
        mkSearchActivity.iv_cancel = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_cancel, "field 'iv_cancel'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkSearchActivity));
        mkSearchActivity.progress_wheel = (ProgressWheel) Utils.findRequiredViewAsType(view, R.id.progress_wheel, "field 'progress_wheel'", ProgressWheel.class);
        mkSearchActivity.tb_select = (XTabLayout) Utils.findRequiredViewAsType(view, R.id.tb_select, "field 'tb_select'", XTabLayout.class);
        mkSearchActivity.view_line = Utils.findRequiredView(view, R.id.view_line, "field 'view_line'");
        mkSearchActivity.vp_classify = (ViewPager) Utils.findRequiredViewAsType(view, R.id.vp_classify, "field 'vp_classify'", ViewPager.class);
        mkSearchActivity.lv_auto_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.lv_auto_list, "field 'lv_auto_list'", RecyclerView.class);
        mkSearchActivity.ll_history = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_history, "field 'll_history'", LinearLayout.class);
        mkSearchActivity.ll_toBookNull = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_toBookNull, "field 'll_toBookNull'", LinearLayout.class);
        mkSearchActivity.wanyiwanview = (WanyiwanView) Utils.findRequiredViewAsType(view, R.id.wanyiwanview, "field 'wanyiwanview'", WanyiwanView.class);
        mkSearchActivity.img_change = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_change, "field 'img_change'", ImageView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_delete_his, "method 'onClick'");
        this.f2791c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkSearchActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_cancel, "method 'onClick'");
        this.f2792d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, mkSearchActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_hot_search, "method 'onClick'");
        this.f2793e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, mkSearchActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.tv_toBookCity, "method 'onClick'");
        this.f2794f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, mkSearchActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkSearchActivity mkSearchActivity = this.a;
        if (mkSearchActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkSearchActivity.et_search = null;
        mkSearchActivity.adFrameLayout = null;
        mkSearchActivity.rv_hot_search = null;
        mkSearchActivity.rv_history_search = null;
        mkSearchActivity.iv_cancel = null;
        mkSearchActivity.progress_wheel = null;
        mkSearchActivity.tb_select = null;
        mkSearchActivity.view_line = null;
        mkSearchActivity.vp_classify = null;
        mkSearchActivity.lv_auto_list = null;
        mkSearchActivity.ll_history = null;
        mkSearchActivity.ll_toBookNull = null;
        mkSearchActivity.wanyiwanview = null;
        mkSearchActivity.img_change = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2791c.setOnClickListener(null);
        this.f2791c = null;
        this.f2792d.setOnClickListener(null);
        this.f2792d = null;
        this.f2793e.setOnClickListener(null);
        this.f2793e = null;
        this.f2794f.setOnClickListener(null);
        this.f2794f = null;
    }
}
