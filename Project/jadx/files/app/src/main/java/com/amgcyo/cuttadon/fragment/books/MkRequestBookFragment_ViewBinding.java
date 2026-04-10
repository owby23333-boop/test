package com.amgcyo.cuttadon.fragment.books;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.widget.ui.SmoothCheckBox;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkRequestBookFragment_ViewBinding implements Unbinder {
    private MkRequestBookFragment a;
    private View b;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkRequestBookFragment f3797s;

        a(MkRequestBookFragment_ViewBinding mkRequestBookFragment_ViewBinding, MkRequestBookFragment mkRequestBookFragment) {
            this.f3797s = mkRequestBookFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3797s.onViewClicked();
        }
    }

    @UiThread
    public MkRequestBookFragment_ViewBinding(MkRequestBookFragment mkRequestBookFragment, View view) {
        this.a = mkRequestBookFragment;
        mkRequestBookFragment.bookName = (EditText) Utils.findRequiredViewAsType(view, R.id.book_name, "field 'bookName'", EditText.class);
        mkRequestBookFragment.bookAuthor = (EditText) Utils.findRequiredViewAsType(view, R.id.book_author, "field 'bookAuthor'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_request, "field 'btn_request' and method 'onViewClicked'");
        mkRequestBookFragment.btn_request = (Button) Utils.castView(viewFindRequiredView, R.id.btn_request, "field 'btn_request'", Button.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkRequestBookFragment));
        mkRequestBookFragment.book_website = (EditText) Utils.findRequiredViewAsType(view, R.id.book_website, "field 'book_website'", EditText.class);
        mkRequestBookFragment.book_mian_name = (EditText) Utils.findRequiredViewAsType(view, R.id.book_mian_name, "field 'book_mian_name'", EditText.class);
        mkRequestBookFragment.tv_desc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_desc, "field 'tv_desc'", TextView.class);
        mkRequestBookFragment.tv_comic3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_comic3, "field 'tv_comic3'", TextView.class);
        mkRequestBookFragment.tv_novel1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_novel1, "field 'tv_novel1'", TextView.class);
        mkRequestBookFragment.tv_notice = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_notice, "field 'tv_notice'", TextView.class);
        mkRequestBookFragment.scb_novel1 = (SmoothCheckBox) Utils.findRequiredViewAsType(view, R.id.scb_novel1, "field 'scb_novel1'", SmoothCheckBox.class);
        mkRequestBookFragment.scb_comic3 = (SmoothCheckBox) Utils.findRequiredViewAsType(view, R.id.scb_comic3, "field 'scb_comic3'", SmoothCheckBox.class);
        mkRequestBookFragment.container = (ScrollView) Utils.findRequiredViewAsType(view, R.id.container, "field 'container'", ScrollView.class);
        mkRequestBookFragment.ll_qiushu_type = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_qiushu_type, "field 'll_qiushu_type'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkRequestBookFragment mkRequestBookFragment = this.a;
        if (mkRequestBookFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkRequestBookFragment.bookName = null;
        mkRequestBookFragment.bookAuthor = null;
        mkRequestBookFragment.btn_request = null;
        mkRequestBookFragment.book_website = null;
        mkRequestBookFragment.book_mian_name = null;
        mkRequestBookFragment.tv_desc = null;
        mkRequestBookFragment.tv_comic3 = null;
        mkRequestBookFragment.tv_novel1 = null;
        mkRequestBookFragment.tv_notice = null;
        mkRequestBookFragment.scb_novel1 = null;
        mkRequestBookFragment.scb_comic3 = null;
        mkRequestBookFragment.container = null;
        mkRequestBookFragment.ll_qiushu_type = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
