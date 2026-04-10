package com.amgcyo.cuttadon.activity.fission6;

import android.view.View;
import android.widget.Button;
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
public class Fission6VipActivity_ViewBinding implements Unbinder {
    private Fission6VipActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2559c;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission6VipActivity f2560s;

        a(Fission6VipActivity_ViewBinding fission6VipActivity_ViewBinding, Fission6VipActivity fission6VipActivity) {
            this.f2560s = fission6VipActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2560s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission6VipActivity f2561s;

        b(Fission6VipActivity_ViewBinding fission6VipActivity_ViewBinding, Fission6VipActivity fission6VipActivity) {
            this.f2561s = fission6VipActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2561s.onClick(view);
        }
    }

    @UiThread
    public Fission6VipActivity_ViewBinding(Fission6VipActivity fission6VipActivity, View view) {
        this.a = fission6VipActivity;
        fission6VipActivity.cz_recyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.cz_recyclerview, "field 'cz_recyclerview'", RecyclerView.class);
        fission6VipActivity.zffs_recyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.zffs_recyclerview, "field 'zffs_recyclerview'", RecyclerView.class);
        fission6VipActivity.tv_desc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_desc, "field 'tv_desc'", TextView.class);
        fission6VipActivity.tv_money = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_money, "field 'tv_money'", TextView.class);
        fission6VipActivity.tv_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tv_time'", TextView.class);
        fission6VipActivity.tv_vip_title = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_vip_title, "field 'tv_vip_title'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_submit, "field 'btn_submit' and method 'onClick'");
        fission6VipActivity.btn_submit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_submit, "field 'btn_submit'", Button.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, fission6VipActivity));
        fission6VipActivity.tv_pack = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pack, "field 'tv_pack'", TextView.class);
        fission6VipActivity.ll_submit = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_submit, "field 'll_submit'", LinearLayout.class);
        fission6VipActivity.ll_free_time = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_free_time, "field 'll_free_time'", LinearLayout.class);
        fission6VipActivity.ll_package = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_package, "field 'll_package'", LinearLayout.class);
        fission6VipActivity.ll_pay = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_pay, "field 'll_pay'", LinearLayout.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_cz_help, "method 'onClick'");
        this.f2559c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, fission6VipActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        Fission6VipActivity fission6VipActivity = this.a;
        if (fission6VipActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        fission6VipActivity.cz_recyclerview = null;
        fission6VipActivity.zffs_recyclerview = null;
        fission6VipActivity.tv_desc = null;
        fission6VipActivity.tv_money = null;
        fission6VipActivity.tv_time = null;
        fission6VipActivity.tv_vip_title = null;
        fission6VipActivity.btn_submit = null;
        fission6VipActivity.tv_pack = null;
        fission6VipActivity.ll_submit = null;
        fission6VipActivity.ll_free_time = null;
        fission6VipActivity.ll_package = null;
        fission6VipActivity.ll_pay = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2559c.setOnClickListener(null);
        this.f2559c = null;
    }
}
