package com.amgcyo.cuttadon.fragment.fission5;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.fission5.Fission5IncomeActivity;
import com.amgcyo.cuttadon.api.entity.fission5.EarningsList;
import com.amgcyo.cuttadon.api.entity.fission5.Income5Bean;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: compiled from: Fission5IncomeFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends BaseRefreshMoreRecyclerFragment<UserPresenter> {
    private int K = 1;
    private List<EarningsList> L = new ArrayList();

    /* JADX INFO: compiled from: Fission5IncomeFragment.java */
    public class a extends BaseQuickAdapter<EarningsList, com.chad.library.adapter.base.b> {
        a(@Nullable e eVar, List<EarningsList> list) {
            super(R.layout.item_points_bean, list);
        }

        private void b(com.chad.library.adapter.base.b bVar, EarningsList earningsList) {
            TextView textView = (TextView) bVar.a(R.id.reg_time);
            TextView textView2 = (TextView) bVar.a(R.id.reg_from);
            TextView textView3 = (TextView) bVar.a(R.id.reg_gold);
            textView.setText(earningsList.getLog_day());
            textView2.setText(earningsList.getLog_title());
            int log_as = earningsList.getLog_as();
            if (log_as == 1) {
                textView3.setText(String.format("+ %s", earningsList.getLog_amount()));
                textView3.setTextColor(o.b(R.color.color_FF5E00));
            } else if (log_as == 2) {
                textView3.setText(String.format("- %s", earningsList.getLog_amount()));
                textView3.setTextColor(o.b(R.color.color_3B5997));
            }
            if (bVar.getAdapterPosition() % 2 == 0) {
                bVar.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            } else {
                bVar.itemView.setBackgroundColor(Color.parseColor("#FBFBFB"));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void a(@NonNull com.chad.library.adapter.base.b bVar, EarningsList earningsList) {
            b(bVar, earningsList);
        }
    }

    private void a(List<EarningsList> list) {
        if (this.H == 1) {
            this.L.clear();
            this.L.addAll(list);
            ((a) this.G).b((Collection) this.L);
        } else {
            ((a) this.G).a((Collection) list);
        }
        this.G.m();
    }

    public static e c(int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("tabName", i2);
        e eVar = new e();
        eVar.setArguments(bundle);
        return eVar;
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        b(false);
        this.K = arguments.getInt("tabName");
        o();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (message.f21197s == 825) {
            hideLoading();
            PullToRefreshView pullToRefreshView = this.mRefreshView;
            if (pullToRefreshView == null) {
                return;
            }
            pullToRefreshView.setRefreshing(false);
            Income5Bean income5Bean = (Income5Bean) message.f21202x;
            if (income5Bean != null) {
                if (this.H == 1) {
                    String earnings = income5Bean.getEarnings();
                    String balance_gold = income5Bean.getBalance_gold();
                    String balance_money = income5Bean.getBalance_money();
                    Fission5IncomeActivity fission5IncomeActivity = (Fission5IncomeActivity) getActivity();
                    if (fission5IncomeActivity != null) {
                        fission5IncomeActivity.setTextData(earnings, balance_gold, balance_money, this.K);
                    }
                }
                List<EarningsList> lists = income5Bean.getLists();
                if (!g.a(lists)) {
                    this.recyclerView.setVisibility(0);
                    a(lists);
                    this.H++;
                } else if (this.H == 1) {
                    if (this.G != null) {
                        a("", 0);
                    }
                } else {
                    BaseQuickAdapter baseQuickAdapter = this.G;
                    if (baseQuickAdapter != null) {
                        baseQuickAdapter.a("系统仅展示最近30天的收益");
                        this.G.n();
                    }
                }
            }
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        this.G = new a(this, this.L);
        this.G.a(this.recyclerView);
        this.G.a(new BaseQuickAdapter.i() { // from class: com.amgcyo.cuttadon.fragment.fission5.d
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
            public final void a() {
                this.a.o();
            }
        }, this.recyclerView);
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment
    protected boolean m() {
        return false;
    }

    public void o() {
        if (this.H == 1) {
            showLoading("");
        }
        ((UserPresenter) this.f3726u).v(Message.a(this, new Object[]{Integer.valueOf(this.K), Integer.valueOf(this.H)}));
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this.f3725t));
    }
}
