package com.amgcyo.cuttadon.fragment.fission6;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.otherview.ProgressWheel;
import com.amgcyo.cuttadon.view.smilerefresh.MkPullToRefresh;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class Fission6IndexFragment_ViewBinding implements Unbinder {
    private Fission6IndexFragment a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f3853c;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission6IndexFragment f3854s;

        a(Fission6IndexFragment_ViewBinding fission6IndexFragment_ViewBinding, Fission6IndexFragment fission6IndexFragment) {
            this.f3854s = fission6IndexFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3854s.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission6IndexFragment f3855s;

        b(Fission6IndexFragment_ViewBinding fission6IndexFragment_ViewBinding, Fission6IndexFragment fission6IndexFragment) {
            this.f3855s = fission6IndexFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3855s.onViewClicked(view);
        }
    }

    @UiThread
    public Fission6IndexFragment_ViewBinding(Fission6IndexFragment fission6IndexFragment, View view) {
        this.a = fission6IndexFragment;
        fission6IndexFragment.tvValiCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_vali_count, "field 'tvValiCount'", TextView.class);
        fission6IndexFragment.imgQrcode = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_qrcode, "field 'imgQrcode'", ImageView.class);
        fission6IndexFragment.mRefreshView = (MkPullToRefresh) Utils.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mRefreshView'", MkPullToRefresh.class);
        fission6IndexFragment.fission6Progresswheel = (ProgressWheel) Utils.findRequiredViewAsType(view, R.id.fission6_progresswheel, "field 'fission6Progresswheel'", ProgressWheel.class);
        fission6IndexFragment.tvMycode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_mycode, "field 'tvMycode'", TextView.class);
        fission6IndexFragment.tv_fission6_type = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_fission6_type, "field 'tv_fission6_type'", TextView.class);
        fission6IndexFragment.tv_fission_day = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_fission_day, "field 'tv_fission_day'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_share, "field 'tvShare' and method 'onViewClicked'");
        fission6IndexFragment.tvShare = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_share, "field 'tvShare'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, fission6IndexFragment));
        fission6IndexFragment.tvDescFission6 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_desc_fission6, "field 'tvDescFission6'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.img_vip, "field 'img_vip' and method 'onViewClicked'");
        fission6IndexFragment.img_vip = (ImageView) Utils.castView(viewFindRequiredView2, R.id.img_vip, "field 'img_vip'", ImageView.class);
        this.f3853c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, fission6IndexFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        Fission6IndexFragment fission6IndexFragment = this.a;
        if (fission6IndexFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        fission6IndexFragment.tvValiCount = null;
        fission6IndexFragment.imgQrcode = null;
        fission6IndexFragment.mRefreshView = null;
        fission6IndexFragment.fission6Progresswheel = null;
        fission6IndexFragment.tvMycode = null;
        fission6IndexFragment.tv_fission6_type = null;
        fission6IndexFragment.tv_fission_day = null;
        fission6IndexFragment.tvShare = null;
        fission6IndexFragment.tvDescFission6 = null;
        fission6IndexFragment.img_vip = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f3853c.setOnClickListener(null);
        this.f3853c = null;
    }
}
