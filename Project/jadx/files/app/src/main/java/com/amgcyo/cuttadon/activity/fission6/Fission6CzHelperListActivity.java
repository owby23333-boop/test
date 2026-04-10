package com.amgcyo.cuttadon.activity.fission6;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.cz.CzHelperBean;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.r;
import com.amgcyo.cuttadon.view.dialog.b1;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class Fission6CzHelperListActivity extends BaseRefreshMoreRecyclerActivity<UserPresenter> implements BaseQuickAdapter.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private List<CzHelperBean> f2550r0 = new ArrayList();

    public class a extends BaseQuickAdapter<CzHelperBean, com.chad.library.adapter.base.b> {
        a(@Nullable Fission6CzHelperListActivity fission6CzHelperListActivity, List<CzHelperBean> list) {
            super(R.layout.item_cz_helper, list);
        }

        private void b(com.chad.library.adapter.base.b bVar, CzHelperBean czHelperBean) {
            ((RadioButton) bVar.a(R.id.tv_help_q)).setText(czHelperBean.getTitle());
            ((RadioButton) bVar.a(R.id.tv_help_a)).setText(czHelperBean.getRemark());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void a(@NonNull com.chad.library.adapter.base.b bVar, CzHelperBean czHelperBean) {
            b(bVar, czHelperBean);
        }
    }

    private void a(List<CzHelperBean> list) {
        if (this.pageNo == 1) {
            this.f2550r0.clear();
            this.f2550r0.addAll(list);
            this.f2256n0.b((Collection) this.f2550r0);
        } else {
            this.f2256n0.a((Collection) list);
        }
        this.f2256n0.a(o.b(R.color.color_A4A5A7), o.b(R.color.vip_root_bg));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return o.d(R.string.pay_helper);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        d(false);
        if (message.f21197s == 825) {
            List<CzHelperBean> list = (List) message.f21202x;
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                this.recyclerView.setVisibility(0);
                a(list);
                if (list.size() > 20) {
                    this.pageNo++;
                    return;
                } else {
                    this.f2256n0.n();
                    return;
                }
            }
            if (this.pageNo == 1) {
                if (this.f2256n0 != null) {
                    b("", 0);
                }
            } else {
                BaseQuickAdapter baseQuickAdapter = this.f2256n0;
                if (baseQuickAdapter != null) {
                    baseQuickAdapter.m();
                    this.f2256n0.n();
                }
            }
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        this.isNeedNightModel = false;
        o();
        this.f2256n0 = new a(this, this.f2550r0);
        this.recyclerView.setAdapter(this.f2256n0);
        n();
        this.f2256n0.a((BaseQuickAdapter.g) this);
        this.recyclerView.setItemAnimator(null);
        this.f2256n0.c(1);
        this.f2256n0.a(this.recyclerView);
        this.f2256n0.a(new BaseQuickAdapter.i() { // from class: com.amgcyo.cuttadon.activity.fission6.a
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
            public final void a() {
                this.a.q();
            }
        }, this.recyclerView);
        b1 b1Var = new b1(this);
        b1Var.show();
        b1Var.a(o.d(R.string.cz_help_tips), "", new String[0]);
        loadData();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    public void loadData() {
        Message messageA = Message.a(this, new Object[]{Integer.valueOf(this.pageNo)});
        String strD = g0.a().d("cz_help");
        if (TextUtils.isEmpty(strD)) {
            messageA.f21202x = null;
        } else {
            messageA.f21202x = r.b(strD, CzHelperBean.class);
        }
        messageA.f21197s = 825;
        messageA.b();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        super.onRefresh();
        this.pageNo = 1;
        loadData();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    protected boolean p() {
        return false;
    }

    public /* synthetic */ void q() {
        String str = "加载更多: " + this.pageNo;
        loadData();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }
}
