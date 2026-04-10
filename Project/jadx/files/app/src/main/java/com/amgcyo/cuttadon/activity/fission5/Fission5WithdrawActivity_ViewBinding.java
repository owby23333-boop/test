package com.amgcyo.cuttadon.activity.fission5;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class Fission5WithdrawActivity_ViewBinding implements Unbinder {
    private Fission5WithdrawActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2538c;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5WithdrawActivity f2539s;

        a(Fission5WithdrawActivity_ViewBinding fission5WithdrawActivity_ViewBinding, Fission5WithdrawActivity fission5WithdrawActivity) {
            this.f2539s = fission5WithdrawActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2539s.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5WithdrawActivity f2540s;

        b(Fission5WithdrawActivity_ViewBinding fission5WithdrawActivity_ViewBinding, Fission5WithdrawActivity fission5WithdrawActivity) {
            this.f2540s = fission5WithdrawActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2540s.onViewClicked(view);
        }
    }

    @UiThread
    public Fission5WithdrawActivity_ViewBinding(Fission5WithdrawActivity fission5WithdrawActivity, View view) {
        this.a = fission5WithdrawActivity;
        fission5WithdrawActivity.tv_money = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_money, "field 'tv_money'", TextView.class);
        fission5WithdrawActivity.ll_tips = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tips, "field 'll_tips'", LinearLayout.class);
        fission5WithdrawActivity.rv_daylist = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_daylist, "field 'rv_daylist'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_yq, "method 'onViewClicked'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, fission5WithdrawActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_help, "method 'onViewClicked'");
        this.f2538c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, fission5WithdrawActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        Fission5WithdrawActivity fission5WithdrawActivity = this.a;
        if (fission5WithdrawActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        fission5WithdrawActivity.tv_money = null;
        fission5WithdrawActivity.ll_tips = null;
        fission5WithdrawActivity.rv_daylist = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2538c.setOnClickListener(null);
        this.f2538c = null;
    }
}
