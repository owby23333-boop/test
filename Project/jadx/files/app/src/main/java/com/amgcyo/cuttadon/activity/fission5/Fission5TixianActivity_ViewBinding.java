package com.amgcyo.cuttadon.activity.fission5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class Fission5TixianActivity_ViewBinding implements Unbinder {
    private Fission5TixianActivity a;
    private View b;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5TixianActivity f2529s;

        a(Fission5TixianActivity_ViewBinding fission5TixianActivity_ViewBinding, Fission5TixianActivity fission5TixianActivity) {
            this.f2529s = fission5TixianActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2529s.onViewClicked();
        }
    }

    @UiThread
    public Fission5TixianActivity_ViewBinding(Fission5TixianActivity fission5TixianActivity, View view) {
        this.a = fission5TixianActivity;
        fission5TixianActivity.tv_money = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_money, "field 'tv_money'", TextView.class);
        fission5TixianActivity.tv_tx_state = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tx_state, "field 'tv_tx_state'", TextView.class);
        fission5TixianActivity.rv_step = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_step, "field 'rv_step'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_yq, "field 'tv_yq' and method 'onViewClicked'");
        fission5TixianActivity.tv_yq = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_yq, "field 'tv_yq'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, fission5TixianActivity));
        fission5TixianActivity.tv_type = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_type, "field 'tv_type'", TextView.class);
        fission5TixianActivity.tv_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tv_time'", TextView.class);
        fission5TixianActivity.rl_plat = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_plat, "field 'rl_plat'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        Fission5TixianActivity fission5TixianActivity = this.a;
        if (fission5TixianActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        fission5TixianActivity.tv_money = null;
        fission5TixianActivity.tv_tx_state = null;
        fission5TixianActivity.rv_step = null;
        fission5TixianActivity.tv_yq = null;
        fission5TixianActivity.tv_type = null;
        fission5TixianActivity.tv_time = null;
        fission5TixianActivity.rl_plat = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
