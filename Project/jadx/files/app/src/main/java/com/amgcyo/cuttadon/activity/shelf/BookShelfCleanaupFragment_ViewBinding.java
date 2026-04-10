package com.amgcyo.cuttadon.activity.shelf;

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
public class BookShelfCleanaupFragment_ViewBinding implements Unbinder {
    private BookShelfCleanaupFragment a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2900c;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ BookShelfCleanaupFragment f2901s;

        a(BookShelfCleanaupFragment_ViewBinding bookShelfCleanaupFragment_ViewBinding, BookShelfCleanaupFragment bookShelfCleanaupFragment) {
            this.f2901s = bookShelfCleanaupFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2901s.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ BookShelfCleanaupFragment f2902s;

        b(BookShelfCleanaupFragment_ViewBinding bookShelfCleanaupFragment_ViewBinding, BookShelfCleanaupFragment bookShelfCleanaupFragment) {
            this.f2902s = bookShelfCleanaupFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2902s.onViewClicked(view);
        }
    }

    @UiThread
    public BookShelfCleanaupFragment_ViewBinding(BookShelfCleanaupFragment bookShelfCleanaupFragment, View view) {
        this.a = bookShelfCleanaupFragment;
        bookShelfCleanaupFragment.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'mRecyclerView'", RecyclerView.class);
        bookShelfCleanaupFragment.rl_root = Utils.findRequiredView(view, R.id.rl_root, "field 'rl_root'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_check_all, "field 'tvCheckAll' and method 'onViewClicked'");
        bookShelfCleanaupFragment.tvCheckAll = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_check_all, "field 'tvCheckAll'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, bookShelfCleanaupFragment));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_delete, "field 'tvDelete' and method 'onViewClicked'");
        bookShelfCleanaupFragment.tvDelete = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_delete, "field 'tvDelete'", TextView.class);
        this.f2900c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, bookShelfCleanaupFragment));
        bookShelfCleanaupFragment.layBottom = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lay_bottom, "field 'layBottom'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BookShelfCleanaupFragment bookShelfCleanaupFragment = this.a;
        if (bookShelfCleanaupFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        bookShelfCleanaupFragment.mRecyclerView = null;
        bookShelfCleanaupFragment.rl_root = null;
        bookShelfCleanaupFragment.tvCheckAll = null;
        bookShelfCleanaupFragment.tvDelete = null;
        bookShelfCleanaupFragment.layBottom = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2900c.setOnClickListener(null);
        this.f2900c = null;
    }
}
