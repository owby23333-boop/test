package com.amgcyo.cuttadon.activity.fission5;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.fission5.WithdrawalListBean;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.f.o;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class Fission5TixianListActivity extends BaseRefreshMoreRecyclerActivity<UserPresenter> implements BaseQuickAdapter.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private List<WithdrawalListBean> f2530r0 = new ArrayList();

    public class a extends BaseQuickAdapter<WithdrawalListBean, com.chad.library.adapter.base.b> {
        a(@Nullable Fission5TixianListActivity fission5TixianListActivity, List<WithdrawalListBean> list) {
            super(R.layout.item_points_bean, list);
        }

        private void b(com.chad.library.adapter.base.b bVar, WithdrawalListBean withdrawalListBean) {
            TextView textView = (TextView) bVar.a(R.id.reg_time);
            TextView textView2 = (TextView) bVar.a(R.id.reg_from);
            TextView textView3 = (TextView) bVar.a(R.id.reg_gold);
            textView.setText(withdrawalListBean.getCreated_at());
            textView2.setText(withdrawalListBean.getMsg());
            int state = withdrawalListBean.getState();
            if (state == -1) {
                textView3.setTextColor(o.b(R.color.accent_orange));
            } else if (state == 0) {
                textView3.setTextColor(o.b(R.color.text_33));
            } else if (state == 1) {
                textView3.setTextColor(o.b(R.color.colorPrimary));
            } else if (state == 3) {
                textView3.setTextColor(o.b(R.color.color_FF0000));
                textView3.getPaint().setFlags(17);
            } else if (state != 4) {
                textView3.getPaint().setFlags(0);
                textView3.getPaint().setFlags(17);
                textView3.setTextColor(o.b(R.color.grey_888));
            } else {
                textView3.setTextColor(o.b(android.R.color.holo_red_dark));
                textView3.getPaint().setFlags(17);
            }
            textView3.setText(String.format("%s", withdrawalListBean.getAmount()));
            if (bVar.getAdapterPosition() % 2 == 0) {
                bVar.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            } else {
                bVar.itemView.setBackgroundColor(Color.parseColor("#FBFBFB"));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void a(@NonNull com.chad.library.adapter.base.b bVar, WithdrawalListBean withdrawalListBean) {
            b(bVar, withdrawalListBean);
        }
    }

    private void a(List<WithdrawalListBean> list) {
        if (this.pageNo == 1) {
            this.f2530r0.clear();
            this.f2530r0.addAll(list);
            this.f2256n0.b((Collection) this.f2530r0);
        } else {
            this.f2256n0.a((Collection) list);
        }
        this.f2256n0.m();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "提现记录";
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        d(false);
        if (message.f21197s == 825) {
            List<WithdrawalListBean> list = (List) message.f21202x;
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                this.recyclerView.setVisibility(0);
                a(list);
                this.pageNo++;
            } else if (this.pageNo == 1) {
                if (this.f2256n0 != null) {
                    b("", 0);
                }
            } else {
                BaseQuickAdapter baseQuickAdapter = this.f2256n0;
                if (baseQuickAdapter != null) {
                    baseQuickAdapter.a("系统仅展示最近30天的收益");
                    this.f2256n0.n();
                }
            }
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        this.recyclerView.setItemAnimator(null);
        this.f2256n0 = new a(this, this.f2530r0);
        this.recyclerView.setAdapter(this.f2256n0);
        this.f2256n0.a((BaseQuickAdapter.g) this);
        this.recyclerView.setItemAnimator(null);
        this.f2256n0.c(1);
        this.f2256n0.a(this.recyclerView);
        this.f2256n0.a(new BaseQuickAdapter.i() { // from class: com.amgcyo.cuttadon.activity.fission5.d
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
            public final void a() {
                this.a.q();
            }
        }, this.recyclerView);
        loadData();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    public void loadData() {
        ((UserPresenter) this.f2276v).H(Message.a(this, new Object[]{Integer.valueOf(this.pageNo)}));
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
