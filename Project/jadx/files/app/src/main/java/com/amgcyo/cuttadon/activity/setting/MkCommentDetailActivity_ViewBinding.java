package com.amgcyo.cuttadon.activity.setting;

import android.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity_ViewBinding;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;

/* JADX INFO: loaded from: classes.dex */
public class MkCommentDetailActivity_ViewBinding extends BaseRefreshMoreRecyclerActivity_ViewBinding {
    private MkCommentDetailActivity b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2845d;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkCommentDetailActivity f2846s;

        a(MkCommentDetailActivity_ViewBinding mkCommentDetailActivity_ViewBinding, MkCommentDetailActivity mkCommentDetailActivity) {
            this.f2846s = mkCommentDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2846s.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkCommentDetailActivity f2847s;

        b(MkCommentDetailActivity_ViewBinding mkCommentDetailActivity_ViewBinding, MkCommentDetailActivity mkCommentDetailActivity) {
            this.f2847s = mkCommentDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2847s.onViewClicked(view);
        }
    }

    @UiThread
    public MkCommentDetailActivity_ViewBinding(MkCommentDetailActivity mkCommentDetailActivity, View view) {
        super(mkCommentDetailActivity, view);
        this.b = mkCommentDetailActivity;
        mkCommentDetailActivity.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.list, "field 'mRecyclerView'", RecyclerView.class);
        mkCommentDetailActivity.mRefreshView = (PullToRefreshView) Utils.findRequiredViewAsType(view, com.fatcatfat.io.R.id.swipe_refresh_layout, "field 'mRefreshView'", PullToRefreshView.class);
        mkCommentDetailActivity.commentEditImage = (ImageView) Utils.findRequiredViewAsType(view, com.fatcatfat.io.R.id.comment_edit_image, "field 'commentEditImage'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, com.fatcatfat.io.R.id.tv_comment_list_edittext, "field 'tv_comment_list_edittext' and method 'onViewClicked'");
        mkCommentDetailActivity.tv_comment_list_edittext = (TextView) Utils.castView(viewFindRequiredView, com.fatcatfat.io.R.id.tv_comment_list_edittext, "field 'tv_comment_list_edittext'", TextView.class);
        this.f2844c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkCommentDetailActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, com.fatcatfat.io.R.id.fb_comment, "method 'onViewClicked'");
        this.f2845d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkCommentDetailActivity));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity_ViewBinding, butterknife.Unbinder
    public void unbind() {
        MkCommentDetailActivity mkCommentDetailActivity = this.b;
        if (mkCommentDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        mkCommentDetailActivity.mRecyclerView = null;
        mkCommentDetailActivity.mRefreshView = null;
        mkCommentDetailActivity.commentEditImage = null;
        mkCommentDetailActivity.tv_comment_list_edittext = null;
        this.f2844c.setOnClickListener(null);
        this.f2844c = null;
        this.f2845d.setOnClickListener(null);
        this.f2845d = null;
        super.unbind();
    }
}
