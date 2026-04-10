package com.amgcyo.cuttadon.fragment.books;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkBookshelfFragment_ViewBinding implements Unbinder {
    private MkBookshelfFragment a;
    private View b;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkBookshelfFragment f3763s;

        a(MkBookshelfFragment_ViewBinding mkBookshelfFragment_ViewBinding, MkBookshelfFragment mkBookshelfFragment) {
            this.f3763s = mkBookshelfFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3763s.onClick(view);
        }
    }

    @UiThread
    public MkBookshelfFragment_ViewBinding(MkBookshelfFragment mkBookshelfFragment, View view) {
        this.a = mkBookshelfFragment;
        mkBookshelfFragment.adFrameLayout = (AdFrameLayout) Utils.findRequiredViewAsType(view, R.id.shelf_top_ad, "field 'adFrameLayout'", AdFrameLayout.class);
        mkBookshelfFragment.constraintlayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.constraintlayout, "field 'constraintlayout'", ConstraintLayout.class);
        mkBookshelfFragment.tv_vali = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_vali, "field 'tv_vali'", TextView.class);
        mkBookshelfFragment.tv_shelf_fission6 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_shelf_fission6, "field 'tv_shelf_fission6'", TextView.class);
        mkBookshelfFragment.ll_bookNull = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ll_bookNull, "field 'll_bookNull'", RelativeLayout.class);
        mkBookshelfFragment.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, android.R.id.list, "field 'mRecyclerView'", RecyclerView.class);
        mkBookshelfFragment.mRefreshView = (PullToRefreshView) Utils.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mRefreshView'", PullToRefreshView.class);
        mkBookshelfFragment.ll_book_size = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_book_size, "field 'll_book_size'", LinearLayout.class);
        mkBookshelfFragment.tv_bottom_text = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bottom_text, "field 'tv_bottom_text'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_findBookCity, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkBookshelfFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkBookshelfFragment mkBookshelfFragment = this.a;
        if (mkBookshelfFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkBookshelfFragment.adFrameLayout = null;
        mkBookshelfFragment.constraintlayout = null;
        mkBookshelfFragment.tv_vali = null;
        mkBookshelfFragment.tv_shelf_fission6 = null;
        mkBookshelfFragment.ll_bookNull = null;
        mkBookshelfFragment.mRecyclerView = null;
        mkBookshelfFragment.mRefreshView = null;
        mkBookshelfFragment.ll_book_size = null;
        mkBookshelfFragment.tv_bottom_text = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
