package com.amgcyo.cuttadon.activity.fission5;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class Fission5BankCountActivity_ViewBinding implements Unbinder {
    private Fission5BankCountActivity a;
    private View b;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5BankCountActivity f2502s;

        a(Fission5BankCountActivity_ViewBinding fission5BankCountActivity_ViewBinding, Fission5BankCountActivity fission5BankCountActivity) {
            this.f2502s = fission5BankCountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2502s.onClick();
        }
    }

    @UiThread
    public Fission5BankCountActivity_ViewBinding(Fission5BankCountActivity fission5BankCountActivity, View view) {
        this.a = fission5BankCountActivity;
        fission5BankCountActivity.etRealName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_real_name, "field 'etRealName'", EditText.class);
        fission5BankCountActivity.zfbAccountTv = (EditText) Utils.findRequiredViewAsType(view, R.id.zfb_account_tv, "field 'zfbAccountTv'", EditText.class);
        fission5BankCountActivity.tv_moneys = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_moneys, "field 'tv_moneys'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_save_count, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, fission5BankCountActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        Fission5BankCountActivity fission5BankCountActivity = this.a;
        if (fission5BankCountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        fission5BankCountActivity.etRealName = null;
        fission5BankCountActivity.zfbAccountTv = null;
        fission5BankCountActivity.tv_moneys = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
