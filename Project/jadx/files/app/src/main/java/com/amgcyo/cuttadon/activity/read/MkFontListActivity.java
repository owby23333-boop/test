package com.amgcyo.cuttadon.activity.read;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.reader.FontBean;
import com.amgcyo.cuttadon.api.presenter.ConfigPresenter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkFontListActivity extends BaseRefreshMoreRecyclerActivity<ConfigPresenter> {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    List<FontBean> f2690r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    String f2691s0;

    private void r() {
        this.f2256n0.a(new BaseQuickAdapter.f() { // from class: com.amgcyo.cuttadon.activity.read.b
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.f
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.f2732s.a(baseQuickAdapter, view, i2);
            }
        });
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public /* synthetic */ void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        FontBean fontBean;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2690r0) || (fontBean = this.f2690r0.get(i2)) == null) {
            return;
        }
        if (com.amgcyo.cuttadon.utils.otherutils.z.d(fontBean.getFont_en_name(), fontBean.getFontmd5())) {
            me.jessyan.art.d.f.a().a(fontBean, "setFont");
            finish();
            return;
        }
        String url = fontBean.getUrl();
        if (TextUtils.isEmpty(url)) {
            return;
        }
        new com.amgcyo.cuttadon.j.b.c(this, com.amgcyo.cuttadon.utils.otherutils.z.d() + File.separator + fontBean.getFont_en_name(), new com.amgcyo.cuttadon.j.b.b() { // from class: com.amgcyo.cuttadon.activity.read.c
            @Override // com.amgcyo.cuttadon.j.b.b
            public final void a() {
                this.a.q();
            }
        }).execute(url);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return getResources().getString(R.string.string_font_manage);
    }

    public /* synthetic */ void e(View view) {
        FontBean fontBean = new FontBean();
        fontBean.setFont_en_name("");
        me.jessyan.art.d.f.a().a(fontBean, "setFont");
        finish();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (message.f21197s == 853) {
            a((ArrayList<FontBean>) message.f21202x);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        this.f2691s0 = com.amgcyo.cuttadon.view.read.page.k.c(this.f2277w).j();
        if (!TextUtils.isEmpty(this.f2691s0)) {
            this.f2691s0 = com.amgcyo.cuttadon.utils.otherutils.z.g(this.f2691s0);
        }
        loadData();
        this.D.setVisibility(0);
        this.D.setText("默认字体");
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2737s.e(view);
            }
        });
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    public void loadData() {
        ArrayList<FontBean> arrayListM = com.amgcyo.cuttadon.utils.otherutils.h.M();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(arrayListM)) {
            ((ConfigPresenter) this.f2276v).c(Message.a(this, new Object[]{true}));
        } else {
            a(arrayListM);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    protected boolean p() {
        return false;
    }

    public /* synthetic */ void q() {
        BaseQuickAdapter baseQuickAdapter = this.f2256n0;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    @Nullable
    public ConfigPresenter obtainPresenter() {
        return new ConfigPresenter(me.jessyan.art.f.e.a(this));
    }

    private void a(ArrayList<FontBean> arrayList) {
        this.f2690r0 = arrayList;
        this.f2256n0 = new com.amgcyo.cuttadon.adapter.other.i(this.f2690r0, this.G, this.f2691s0);
        this.recyclerView.setAdapter(this.f2256n0);
        c(false);
        d(false);
        r();
    }
}
