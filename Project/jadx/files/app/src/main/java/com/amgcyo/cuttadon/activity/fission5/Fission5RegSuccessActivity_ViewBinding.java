package com.amgcyo.cuttadon.activity.fission5;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class Fission5RegSuccessActivity_ViewBinding implements Unbinder {
    private Fission5RegSuccessActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2524c;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5RegSuccessActivity f2525s;

        a(Fission5RegSuccessActivity_ViewBinding fission5RegSuccessActivity_ViewBinding, Fission5RegSuccessActivity fission5RegSuccessActivity) {
            this.f2525s = fission5RegSuccessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2525s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5RegSuccessActivity f2526s;

        b(Fission5RegSuccessActivity_ViewBinding fission5RegSuccessActivity_ViewBinding, Fission5RegSuccessActivity fission5RegSuccessActivity) {
            this.f2526s = fission5RegSuccessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2526s.onClick(view);
        }
    }

    @UiThread
    public Fission5RegSuccessActivity_ViewBinding(Fission5RegSuccessActivity fission5RegSuccessActivity, View view) {
        this.a = fission5RegSuccessActivity;
        fission5RegSuccessActivity.tv_title = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tv_title'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.imageView_back, "field 'imageView_back' and method 'onClick'");
        fission5RegSuccessActivity.imageView_back = (ImageView) Utils.castView(viewFindRequiredView, R.id.imageView_back, "field 'imageView_back'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, fission5RegSuccessActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_yqhy, "method 'onClick'");
        this.f2524c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, fission5RegSuccessActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        Fission5RegSuccessActivity fission5RegSuccessActivity = this.a;
        if (fission5RegSuccessActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        fission5RegSuccessActivity.tv_title = null;
        fission5RegSuccessActivity.imageView_back = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2524c.setOnClickListener(null);
        this.f2524c = null;
    }
}
