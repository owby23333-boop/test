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
public class Fission5BindCodeActivity_ViewBinding implements Unbinder {
    private Fission5BindCodeActivity a;
    private View b;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5BindCodeActivity f2503s;

        a(Fission5BindCodeActivity_ViewBinding fission5BindCodeActivity_ViewBinding, Fission5BindCodeActivity fission5BindCodeActivity) {
            this.f2503s = fission5BindCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2503s.onClick();
            this.f2503s.onViewClicked();
        }
    }

    @UiThread
    public Fission5BindCodeActivity_ViewBinding(Fission5BindCodeActivity fission5BindCodeActivity, View view) {
        this.a = fission5BindCodeActivity;
        fission5BindCodeActivity.etCode = (EditText) Utils.findRequiredViewAsType(view, R.id.et_code, "field 'etCode'", EditText.class);
        fission5BindCodeActivity.tv_desc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_desc, "field 'tv_desc'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_exchange, "method 'onClick' and method 'onViewClicked'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, fission5BindCodeActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        Fission5BindCodeActivity fission5BindCodeActivity = this.a;
        if (fission5BindCodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        fission5BindCodeActivity.etCode = null;
        fission5BindCodeActivity.tv_desc = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
