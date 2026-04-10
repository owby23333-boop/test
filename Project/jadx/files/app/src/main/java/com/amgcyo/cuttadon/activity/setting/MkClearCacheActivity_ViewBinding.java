package com.amgcyo.cuttadon.activity.setting;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkClearCacheActivity_ViewBinding implements Unbinder {
    private MkClearCacheActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2829d;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkClearCacheActivity f2830s;

        a(MkClearCacheActivity_ViewBinding mkClearCacheActivity_ViewBinding, MkClearCacheActivity mkClearCacheActivity) {
            this.f2830s = mkClearCacheActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2830s.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkClearCacheActivity f2831s;

        b(MkClearCacheActivity_ViewBinding mkClearCacheActivity_ViewBinding, MkClearCacheActivity mkClearCacheActivity) {
            this.f2831s = mkClearCacheActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2831s.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkClearCacheActivity f2832s;

        c(MkClearCacheActivity_ViewBinding mkClearCacheActivity_ViewBinding, MkClearCacheActivity mkClearCacheActivity) {
            this.f2832s = mkClearCacheActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2832s.onViewClicked(view);
        }
    }

    @UiThread
    public MkClearCacheActivity_ViewBinding(MkClearCacheActivity mkClearCacheActivity, View view) {
        this.a = mkClearCacheActivity;
        mkClearCacheActivity.tvPicCacheSize = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pic_cache_size, "field 'tvPicCacheSize'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_pic_cache, "field 'llPicCache' and method 'onViewClicked'");
        mkClearCacheActivity.llPicCache = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.ll_pic_cache, "field 'llPicCache'", LinearLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkClearCacheActivity));
        mkClearCacheActivity.tvBookCacheSize = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_book_cache_size, "field 'tvBookCacheSize'", TextView.class);
        mkClearCacheActivity.tvAdCacheSize = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ad_cache_size, "field 'tvAdCacheSize'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_book_cache, "field 'llBookCache' and method 'onViewClicked'");
        mkClearCacheActivity.llBookCache = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.ll_book_cache, "field 'llBookCache'", LinearLayout.class);
        this.f2828c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkClearCacheActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_ad_cache, "method 'onViewClicked'");
        this.f2829d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, mkClearCacheActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkClearCacheActivity mkClearCacheActivity = this.a;
        if (mkClearCacheActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkClearCacheActivity.tvPicCacheSize = null;
        mkClearCacheActivity.llPicCache = null;
        mkClearCacheActivity.tvBookCacheSize = null;
        mkClearCacheActivity.tvAdCacheSize = null;
        mkClearCacheActivity.llBookCache = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2828c.setOnClickListener(null);
        this.f2828c = null;
        this.f2829d.setOnClickListener(null);
        this.f2829d = null;
    }
}
