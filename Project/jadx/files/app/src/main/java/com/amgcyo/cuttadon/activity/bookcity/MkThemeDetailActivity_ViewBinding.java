package com.amgcyo.cuttadon.activity.bookcity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity_ViewBinding;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkThemeDetailActivity_ViewBinding extends BaseRefreshMoreRecyclerActivity_ViewBinding {
    private MkThemeDetailActivity b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2344c;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkThemeDetailActivity f2345s;

        a(MkThemeDetailActivity_ViewBinding mkThemeDetailActivity_ViewBinding, MkThemeDetailActivity mkThemeDetailActivity) {
            this.f2345s = mkThemeDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2345s.onClick();
        }
    }

    @UiThread
    public MkThemeDetailActivity_ViewBinding(MkThemeDetailActivity mkThemeDetailActivity, View view) {
        super(mkThemeDetailActivity, view);
        this.b = mkThemeDetailActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_collect, "field 'tv_collect' and method 'onClick'");
        mkThemeDetailActivity.tv_collect = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_collect, "field 'tv_collect'", TextView.class);
        this.f2344c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkThemeDetailActivity));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity_ViewBinding, butterknife.Unbinder
    public void unbind() {
        MkThemeDetailActivity mkThemeDetailActivity = this.b;
        if (mkThemeDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        mkThemeDetailActivity.tv_collect = null;
        this.f2344c.setOnClickListener(null);
        this.f2344c = null;
        super.unbind();
    }
}
