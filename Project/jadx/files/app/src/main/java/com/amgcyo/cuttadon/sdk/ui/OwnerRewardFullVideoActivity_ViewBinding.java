package com.amgcyo.cuttadon.sdk.ui;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.otherview.CommonShapeButton;
import com.amgcyo.cuttadon.view.otherview.ProgressWheel;
import com.fatcatfat.io.R;
import xyz.doikki.videoplayer.player.VideoView;

/* JADX INFO: loaded from: classes.dex */
public class OwnerRewardFullVideoActivity_ViewBinding implements Unbinder {
    private OwnerRewardFullVideoActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f4290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f4291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f4292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f4293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f4294g;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ OwnerRewardFullVideoActivity f4295s;

        a(OwnerRewardFullVideoActivity_ViewBinding ownerRewardFullVideoActivity_ViewBinding, OwnerRewardFullVideoActivity ownerRewardFullVideoActivity) {
            this.f4295s = ownerRewardFullVideoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f4295s.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ OwnerRewardFullVideoActivity f4296s;

        b(OwnerRewardFullVideoActivity_ViewBinding ownerRewardFullVideoActivity_ViewBinding, OwnerRewardFullVideoActivity ownerRewardFullVideoActivity) {
            this.f4296s = ownerRewardFullVideoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f4296s.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ OwnerRewardFullVideoActivity f4297s;

        c(OwnerRewardFullVideoActivity_ViewBinding ownerRewardFullVideoActivity_ViewBinding, OwnerRewardFullVideoActivity ownerRewardFullVideoActivity) {
            this.f4297s = ownerRewardFullVideoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f4297s.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ OwnerRewardFullVideoActivity f4298s;

        d(OwnerRewardFullVideoActivity_ViewBinding ownerRewardFullVideoActivity_ViewBinding, OwnerRewardFullVideoActivity ownerRewardFullVideoActivity) {
            this.f4298s = ownerRewardFullVideoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f4298s.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ OwnerRewardFullVideoActivity f4299s;

        e(OwnerRewardFullVideoActivity_ViewBinding ownerRewardFullVideoActivity_ViewBinding, OwnerRewardFullVideoActivity ownerRewardFullVideoActivity) {
            this.f4299s = ownerRewardFullVideoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f4299s.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ OwnerRewardFullVideoActivity f4300s;

        f(OwnerRewardFullVideoActivity_ViewBinding ownerRewardFullVideoActivity_ViewBinding, OwnerRewardFullVideoActivity ownerRewardFullVideoActivity) {
            this.f4300s = ownerRewardFullVideoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f4300s.onViewClicked(view);
        }
    }

    @UiThread
    public OwnerRewardFullVideoActivity_ViewBinding(OwnerRewardFullVideoActivity ownerRewardFullVideoActivity, View view) {
        this.a = ownerRewardFullVideoActivity;
        ownerRewardFullVideoActivity.cb_vloume = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_vloume, "field 'cb_vloume'", CheckBox.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_close_ad, "field 'iv_close_ad' and method 'onViewClicked'");
        ownerRewardFullVideoActivity.iv_close_ad = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_close_ad, "field 'iv_close_ad'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, ownerRewardFullVideoActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_ad_time, "field 'tv_ad_time' and method 'onViewClicked'");
        ownerRewardFullVideoActivity.tv_ad_time = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_ad_time, "field 'tv_ad_time'", TextView.class);
        this.f4290c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, ownerRewardFullVideoActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.imageview, "field 'imageview' and method 'onViewClicked'");
        ownerRewardFullVideoActivity.imageview = (ImageView) Utils.castView(viewFindRequiredView3, R.id.imageview, "field 'imageview'", ImageView.class);
        this.f4291d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, ownerRewardFullVideoActivity));
        ownerRewardFullVideoActivity.progress_wheel = (ProgressWheel) Utils.findRequiredViewAsType(view, R.id.progress_wheel, "field 'progress_wheel'", ProgressWheel.class);
        ownerRewardFullVideoActivity.logoImgeview = (ImageView) Utils.findRequiredViewAsType(view, R.id.logoImgeview, "field 'logoImgeview'", ImageView.class);
        ownerRewardFullVideoActivity.logoImgeview_small = (ImageView) Utils.findRequiredViewAsType(view, R.id.logoImgeview_small, "field 'logoImgeview_small'", ImageView.class);
        ownerRewardFullVideoActivity.iv_adImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_adImg, "field 'iv_adImg'", ImageView.class);
        ownerRewardFullVideoActivity.tv_adTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_adTitle, "field 'tv_adTitle'", TextView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn_action, "field 'btn_action' and method 'onViewClicked'");
        ownerRewardFullVideoActivity.btn_action = (CommonShapeButton) Utils.castView(viewFindRequiredView4, R.id.btn_action, "field 'btn_action'", CommonShapeButton.class);
        this.f4292e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, ownerRewardFullVideoActivity));
        ownerRewardFullVideoActivity.tv_ad_score = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ad_score, "field 'tv_ad_score'", TextView.class);
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.player, "field 'videoView' and method 'onViewClicked'");
        ownerRewardFullVideoActivity.videoView = (VideoView) Utils.castView(viewFindRequiredView5, R.id.player, "field 'videoView'", VideoView.class);
        this.f4293f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, ownerRewardFullVideoActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.rl_ad_bottom, "method 'onViewClicked'");
        this.f4294g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, ownerRewardFullVideoActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        OwnerRewardFullVideoActivity ownerRewardFullVideoActivity = this.a;
        if (ownerRewardFullVideoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        ownerRewardFullVideoActivity.cb_vloume = null;
        ownerRewardFullVideoActivity.iv_close_ad = null;
        ownerRewardFullVideoActivity.tv_ad_time = null;
        ownerRewardFullVideoActivity.imageview = null;
        ownerRewardFullVideoActivity.progress_wheel = null;
        ownerRewardFullVideoActivity.logoImgeview = null;
        ownerRewardFullVideoActivity.logoImgeview_small = null;
        ownerRewardFullVideoActivity.iv_adImg = null;
        ownerRewardFullVideoActivity.tv_adTitle = null;
        ownerRewardFullVideoActivity.btn_action = null;
        ownerRewardFullVideoActivity.tv_ad_score = null;
        ownerRewardFullVideoActivity.videoView = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f4290c.setOnClickListener(null);
        this.f4290c = null;
        this.f4291d.setOnClickListener(null);
        this.f4291d = null;
        this.f4292e.setOnClickListener(null);
        this.f4292e = null;
        this.f4293f.setOnClickListener(null);
        this.f4293f = null;
        this.f4294g.setOnClickListener(null);
        this.f4294g = null;
    }
}
