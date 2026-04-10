package com.amgcyo.cuttadon.fragment.books;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.xtablayout.XTabLayout;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class BookAndComicFragment_ViewBinding implements Unbinder {
    private BookAndComicFragment a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f3735c;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ BookAndComicFragment f3736s;

        a(BookAndComicFragment_ViewBinding bookAndComicFragment_ViewBinding, BookAndComicFragment bookAndComicFragment) {
            this.f3736s = bookAndComicFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3736s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ BookAndComicFragment f3737s;

        b(BookAndComicFragment_ViewBinding bookAndComicFragment_ViewBinding, BookAndComicFragment bookAndComicFragment) {
            this.f3737s = bookAndComicFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3737s.onClick(view);
        }
    }

    @UiThread
    public BookAndComicFragment_ViewBinding(BookAndComicFragment bookAndComicFragment, View view) {
        this.a = bookAndComicFragment;
        bookAndComicFragment.llBar = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_bar, "field 'llBar'", LinearLayout.class);
        bookAndComicFragment.tb_select = (XTabLayout) Utils.findRequiredViewAsType(view, R.id.tb_select, "field 'tb_select'", XTabLayout.class);
        bookAndComicFragment.vp_classify = (ViewPager) Utils.findRequiredViewAsType(view, R.id.vp_classify, "field 'vp_classify'", ViewPager.class);
        bookAndComicFragment.rl_head = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_head, "field 'rl_head'", RelativeLayout.class);
        bookAndComicFragment.tv_sologon = (ImageView) Utils.findRequiredViewAsType(view, R.id.tv_sologon, "field 'tv_sologon'", ImageView.class);
        bookAndComicFragment.ll_notice = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_notice, "field 'll_notice'", LinearLayout.class);
        bookAndComicFragment.iv_colse_notice = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_colse_notice, "field 'iv_colse_notice'", ImageView.class);
        bookAndComicFragment.iv_laba = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_laba, "field 'iv_laba'", ImageView.class);
        bookAndComicFragment.tv_notice = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_notice, "field 'tv_notice'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_menu, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, bookAndComicFragment));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_search, "method 'onClick'");
        this.f3735c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, bookAndComicFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BookAndComicFragment bookAndComicFragment = this.a;
        if (bookAndComicFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        bookAndComicFragment.llBar = null;
        bookAndComicFragment.tb_select = null;
        bookAndComicFragment.vp_classify = null;
        bookAndComicFragment.rl_head = null;
        bookAndComicFragment.tv_sologon = null;
        bookAndComicFragment.ll_notice = null;
        bookAndComicFragment.iv_colse_notice = null;
        bookAndComicFragment.iv_laba = null;
        bookAndComicFragment.tv_notice = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f3735c.setOnClickListener(null);
        this.f3735c = null;
    }
}
