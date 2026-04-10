package com.amgcyo.cuttadon.view.popupview;

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
public class Fission5FirstTipDialog_ViewBinding implements Unbinder {
    private Fission5FirstTipDialog a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f5139c;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5FirstTipDialog f5140s;

        a(Fission5FirstTipDialog_ViewBinding fission5FirstTipDialog_ViewBinding, Fission5FirstTipDialog fission5FirstTipDialog) {
            this.f5140s = fission5FirstTipDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f5140s.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5FirstTipDialog f5141s;

        b(Fission5FirstTipDialog_ViewBinding fission5FirstTipDialog_ViewBinding, Fission5FirstTipDialog fission5FirstTipDialog) {
            this.f5141s = fission5FirstTipDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f5141s.onViewClicked(view);
        }
    }

    @UiThread
    public Fission5FirstTipDialog_ViewBinding(Fission5FirstTipDialog fission5FirstTipDialog, View view) {
        this.a = fission5FirstTipDialog;
        fission5FirstTipDialog.iv_bg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bg, "field 'iv_bg'", ImageView.class);
        fission5FirstTipDialog.tv_money = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_money, "field 'tv_money'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_close, "field 'iv_close' and method 'onViewClicked'");
        fission5FirstTipDialog.iv_close = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_close, "field 'iv_close'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, fission5FirstTipDialog));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_ljtx, "method 'onViewClicked'");
        this.f5139c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, fission5FirstTipDialog));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        Fission5FirstTipDialog fission5FirstTipDialog = this.a;
        if (fission5FirstTipDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        fission5FirstTipDialog.iv_bg = null;
        fission5FirstTipDialog.tv_money = null;
        fission5FirstTipDialog.iv_close = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f5139c.setOnClickListener(null);
        this.f5139c = null;
    }
}
