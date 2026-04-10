package com.amgcyo.cuttadon.activity.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.otherview.ProgressWheel;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkShareActivity_ViewBinding implements Unbinder {
    private MkShareActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2609c;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkShareActivity f2610s;

        a(MkShareActivity_ViewBinding mkShareActivity_ViewBinding, MkShareActivity mkShareActivity) {
            this.f2610s = mkShareActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2610s.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkShareActivity f2611s;

        b(MkShareActivity_ViewBinding mkShareActivity_ViewBinding, MkShareActivity mkShareActivity) {
            this.f2611s = mkShareActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2611s.onViewClicked(view);
        }
    }

    @UiThread
    public MkShareActivity_ViewBinding(MkShareActivity mkShareActivity, View view) {
        this.a = mkShareActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_website, "field 'tv_website' and method 'onViewClicked'");
        mkShareActivity.tv_website = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_website, "field 'tv_website'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkShareActivity));
        mkShareActivity.imgQrcode = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_qrcode, "field 'imgQrcode'", ImageView.class);
        mkShareActivity.fission6Progresswheel = (ProgressWheel) Utils.findRequiredViewAsType(view, R.id.fission6_progresswheel, "field 'fission6Progresswheel'", ProgressWheel.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_share, "field 'tvShare' and method 'onViewClicked'");
        mkShareActivity.tvShare = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_share, "field 'tvShare'", TextView.class);
        this.f2609c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkShareActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkShareActivity mkShareActivity = this.a;
        if (mkShareActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkShareActivity.tv_website = null;
        mkShareActivity.imgQrcode = null;
        mkShareActivity.fission6Progresswheel = null;
        mkShareActivity.tvShare = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2609c.setOnClickListener(null);
        this.f2609c = null;
    }
}
