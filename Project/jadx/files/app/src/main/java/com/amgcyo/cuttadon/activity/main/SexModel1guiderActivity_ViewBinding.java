package com.amgcyo.cuttadon.activity.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.otherview.CommonShapeButton;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class SexModel1guiderActivity_ViewBinding implements Unbinder {
    private SexModel1guiderActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f2625e;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ SexModel1guiderActivity f2626s;

        a(SexModel1guiderActivity_ViewBinding sexModel1guiderActivity_ViewBinding, SexModel1guiderActivity sexModel1guiderActivity) {
            this.f2626s = sexModel1guiderActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2626s.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ SexModel1guiderActivity f2627s;

        b(SexModel1guiderActivity_ViewBinding sexModel1guiderActivity_ViewBinding, SexModel1guiderActivity sexModel1guiderActivity) {
            this.f2627s = sexModel1guiderActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2627s.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ SexModel1guiderActivity f2628s;

        c(SexModel1guiderActivity_ViewBinding sexModel1guiderActivity_ViewBinding, SexModel1guiderActivity sexModel1guiderActivity) {
            this.f2628s = sexModel1guiderActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2628s.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ SexModel1guiderActivity f2629s;

        d(SexModel1guiderActivity_ViewBinding sexModel1guiderActivity_ViewBinding, SexModel1guiderActivity sexModel1guiderActivity) {
            this.f2629s = sexModel1guiderActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2629s.onViewClicked(view);
        }
    }

    @UiThread
    public SexModel1guiderActivity_ViewBinding(SexModel1guiderActivity sexModel1guiderActivity, View view) {
        this.a = sexModel1guiderActivity;
        sexModel1guiderActivity.ivBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bg, "field 'ivBg'", ImageView.class);
        sexModel1guiderActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        sexModel1guiderActivity.tvDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_desc, "field 'tvDesc'", TextView.class);
        sexModel1guiderActivity.ivBoy = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_boy, "field 'ivBoy'", ImageView.class);
        sexModel1guiderActivity.tvBoyDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_boy_desc, "field 'tvBoyDesc'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.csb_boy, "field 'csbBoy' and method 'onViewClicked'");
        sexModel1guiderActivity.csbBoy = (CommonShapeButton) Utils.castView(viewFindRequiredView, R.id.csb_boy, "field 'csbBoy'", CommonShapeButton.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, sexModel1guiderActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.traint_boy, "field 'traintBoy' and method 'onViewClicked'");
        sexModel1guiderActivity.traintBoy = (ConstraintLayout) Utils.castView(viewFindRequiredView2, R.id.traint_boy, "field 'traintBoy'", ConstraintLayout.class);
        this.f2623c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, sexModel1guiderActivity));
        sexModel1guiderActivity.ivGirl = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_girl, "field 'ivGirl'", ImageView.class);
        sexModel1guiderActivity.tvGirlDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_girl_desc, "field 'tvGirlDesc'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.csb_girl, "field 'csbGirl' and method 'onViewClicked'");
        sexModel1guiderActivity.csbGirl = (CommonShapeButton) Utils.castView(viewFindRequiredView3, R.id.csb_girl, "field 'csbGirl'", CommonShapeButton.class);
        this.f2624d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, sexModel1guiderActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.traint_girl, "field 'traintGirl' and method 'onViewClicked'");
        sexModel1guiderActivity.traintGirl = (ConstraintLayout) Utils.castView(viewFindRequiredView4, R.id.traint_girl, "field 'traintGirl'", ConstraintLayout.class);
        this.f2625e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, sexModel1guiderActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SexModel1guiderActivity sexModel1guiderActivity = this.a;
        if (sexModel1guiderActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        sexModel1guiderActivity.ivBg = null;
        sexModel1guiderActivity.tvTitle = null;
        sexModel1guiderActivity.tvDesc = null;
        sexModel1guiderActivity.ivBoy = null;
        sexModel1guiderActivity.tvBoyDesc = null;
        sexModel1guiderActivity.csbBoy = null;
        sexModel1guiderActivity.traintBoy = null;
        sexModel1guiderActivity.ivGirl = null;
        sexModel1guiderActivity.tvGirlDesc = null;
        sexModel1guiderActivity.csbGirl = null;
        sexModel1guiderActivity.traintGirl = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2623c.setOnClickListener(null);
        this.f2623c = null;
        this.f2624d.setOnClickListener(null);
        this.f2624d = null;
        this.f2625e.setOnClickListener(null);
        this.f2625e = null;
    }
}
