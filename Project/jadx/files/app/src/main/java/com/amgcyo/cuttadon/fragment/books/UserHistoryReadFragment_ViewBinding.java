package com.amgcyo.cuttadon.fragment.books;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment_ViewBinding;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class UserHistoryReadFragment_ViewBinding extends BaseRefreshMoreRecyclerFragment_ViewBinding {
    private UserHistoryReadFragment b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f3798c;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ UserHistoryReadFragment f3799s;

        a(UserHistoryReadFragment_ViewBinding userHistoryReadFragment_ViewBinding, UserHistoryReadFragment userHistoryReadFragment) {
            this.f3799s = userHistoryReadFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3799s.onClick();
        }
    }

    @UiThread
    public UserHistoryReadFragment_ViewBinding(UserHistoryReadFragment userHistoryReadFragment, View view) {
        super(userHistoryReadFragment, view);
        this.b = userHistoryReadFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_collect, "field 'tv_collect' and method 'onClick'");
        userHistoryReadFragment.tv_collect = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_collect, "field 'tv_collect'", TextView.class);
        this.f3798c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, userHistoryReadFragment));
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        UserHistoryReadFragment userHistoryReadFragment = this.b;
        if (userHistoryReadFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        userHistoryReadFragment.tv_collect = null;
        this.f3798c.setOnClickListener(null);
        this.f3798c = null;
        super.unbind();
    }
}
