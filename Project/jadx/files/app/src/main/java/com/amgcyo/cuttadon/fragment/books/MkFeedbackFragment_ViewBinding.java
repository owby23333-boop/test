package com.amgcyo.cuttadon.fragment.books;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkFeedbackFragment_ViewBinding implements Unbinder {
    private MkFeedbackFragment a;
    private View b;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkFeedbackFragment f3767s;

        a(MkFeedbackFragment_ViewBinding mkFeedbackFragment_ViewBinding, MkFeedbackFragment mkFeedbackFragment) {
            this.f3767s = mkFeedbackFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3767s.onClick(view);
        }
    }

    @UiThread
    public MkFeedbackFragment_ViewBinding(MkFeedbackFragment mkFeedbackFragment, View view) {
        this.a = mkFeedbackFragment;
        mkFeedbackFragment.etInput = (EditText) Utils.findRequiredViewAsType(view, R.id.et_input, "field 'etInput'", EditText.class);
        mkFeedbackFragment.tvTextNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_textNum, "field 'tvTextNum'", TextView.class);
        mkFeedbackFragment.etNum = (EditText) Utils.findRequiredViewAsType(view, R.id.et_num, "field 'etNum'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_submit, "field 'tvSubmit' and method 'onClick'");
        mkFeedbackFragment.tvSubmit = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_submit, "field 'tvSubmit'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkFeedbackFragment));
        mkFeedbackFragment.spinner = (Spinner) Utils.findRequiredViewAsType(view, R.id.spinner, "field 'spinner'", Spinner.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkFeedbackFragment mkFeedbackFragment = this.a;
        if (mkFeedbackFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkFeedbackFragment.etInput = null;
        mkFeedbackFragment.tvTextNum = null;
        mkFeedbackFragment.etNum = null;
        mkFeedbackFragment.tvSubmit = null;
        mkFeedbackFragment.spinner = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
