package com.amgcyo.cuttadon.activity.fission6;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.cz.CzRecordBean;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.f.o;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class Fission6CzRecoredListActivity extends BaseRefreshMoreRecyclerActivity<UserPresenter> implements BaseQuickAdapter.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private List<CzRecordBean> f2551r0 = new ArrayList();

    public class a extends BaseQuickAdapter<CzRecordBean, com.chad.library.adapter.base.b> {
        a(@Nullable Fission6CzRecoredListActivity fission6CzRecoredListActivity, List<CzRecordBean> list) {
            super(R.layout.item_cz_record, list);
        }

        private void b(com.chad.library.adapter.base.b bVar, CzRecordBean czRecordBean) {
            ((TextView) bVar.a(R.id.product_name)).setText(czRecordBean.getProduct_name());
            ((TextView) bVar.a(R.id.created_at)).setText(String.format("创建时间：%s", czRecordBean.getCreated_at()));
            TextView textView = (TextView) bVar.a(R.id.pay_at);
            TextView textView2 = (TextView) bVar.a(R.id.tv_status_msg);
            textView2.setText(czRecordBean.getStatus_msg());
            ((TextView) bVar.a(R.id.tv_money)).setText(String.format(Locale.getDefault(), "￥%d", Integer.valueOf(czRecordBean.getAmount())));
            if (czRecordBean.getStatus() == 0) {
                textView.setText(String.format("支付时间：%s", czRecordBean.getStatus_msg()));
                textView2.setTextColor(o.b(R.color.color_A4A5A7));
            } else {
                textView.setText(String.format("支付时间：%s", czRecordBean.getPay_at()));
                textView2.setTextColor(o.b(R.color.colorPrimary));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void a(@NonNull com.chad.library.adapter.base.b bVar, CzRecordBean czRecordBean) {
            b(bVar, czRecordBean);
        }
    }

    private void a(List<CzRecordBean> list) {
        if (this.pageNo == 1) {
            this.f2551r0.clear();
            this.f2551r0.addAll(list);
            this.f2256n0.b((Collection) this.f2551r0);
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
        return o.d(R.string.cz_recored);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        d(false);
        if (message.f21197s == 825) {
            List<CzRecordBean> list = (List) message.f21202x;
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
                    baseQuickAdapter.a("系统仅展示最近30天的记录");
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
        this.recyclerView.setItemAnimator(null);
        this.f2256n0 = new a(this, this.f2551r0);
        this.recyclerView.setAdapter(this.f2256n0);
        n();
        this.f2256n0.a((BaseQuickAdapter.g) this);
        this.recyclerView.setItemAnimator(null);
        this.f2256n0.c(1);
        this.f2256n0.a(this.recyclerView);
        this.f2256n0.a(new BaseQuickAdapter.i() { // from class: com.amgcyo.cuttadon.activity.fission6.b
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
        ((UserPresenter) this.f2276v).h(Message.a(this, new Object[]{Integer.valueOf(this.pageNo)}));
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
