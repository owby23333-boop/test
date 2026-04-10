package com.amgcyo.cuttadon.activity.bookcity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.MkAllBookBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkBookclassifyBean;
import com.amgcyo.cuttadon.api.entity.other.MkLtypeListBean;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.b.c.t;
import com.amgcyo.cuttadon.f.n;
import com.amgcyo.cuttadon.f.r;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.view.otherview.AllClassifyTopView;
import com.amgcyo.cuttadon.view.otherview.k;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkCategoryAllActivity extends BaseRefreshMoreRecyclerActivity<BookPresenter> implements BaseQuickAdapter.g {
    int A0;
    private View E0;
    private View H0;
    private k I0;
    private TextView J0;
    private k K0;
    private String O0;
    AllClassifyTopView P0;
    AllClassifyTopView Q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    List<MkLtypeListBean> f2318r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    List<MkLtypeListBean> f2319s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    List<MkLtypeListBean> f2320t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private String f2321u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    int f2322v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    int f2323w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    int f2324x0 = -1;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    int f2325y0 = -1;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    int f2326z0 = -1;
    int B0 = 0;
    int C0 = 0;
    int D0 = 0;
    private int F0 = 1;
    List<MkBook> G0 = new ArrayList();
    String L0 = "全部";
    String M0 = "全部";
    String N0 = "热门";

    private void A() {
        PopupWindow popupWindowB;
        k kVar = this.K0;
        if (kVar == null || (popupWindowB = kVar.b()) == null || !popupWindowB.isShowing()) {
            if (this.K0 == null) {
                View viewInflate = LayoutInflater.from(this.f2277w).inflate(R.layout.mk_view_head_flowlayout, (ViewGroup) null);
                k.c cVar = new k.c(this);
                cVar.a(viewInflate);
                cVar.a(-1, -2);
                cVar.a(false);
                cVar.b(false);
                this.K0 = cVar.a();
                this.P0 = (AllClassifyTopView) viewInflate.findViewById(R.id.allclassifytopview);
                ((TextView) viewInflate.findViewById(R.id.tv_desc)).setVisibility(8);
                ((ImageView) viewInflate.findViewById(R.id.img_category)).setVisibility(8);
                viewInflate.findViewById(R.id.line_bottom).setVisibility(0);
                this.P0.a(this.f2318r0, this.f2319s0, this.f2320t0);
                this.P0.setTabSelectedListener(new AllClassifyTopView.b() { // from class: com.amgcyo.cuttadon.activity.bookcity.h
                    @Override // com.amgcyo.cuttadon.view.otherview.AllClassifyTopView.b
                    public final void a(MkLtypeListBean mkLtypeListBean, int i2) {
                        this.a.b(mkLtypeListBean, i2);
                    }
                });
            }
            this.K0.a(this.H0);
            this.P0.a(this.B0, this.C0, this.D0);
        }
    }

    private void a(List<MkBook> list, int i2) {
        if (this.F0 == 1) {
            this.G0.clear();
            this.G0.addAll(list);
            NewApiAd newApiAdA = com.amgcyo.cuttadon.app.o.c.a(n.N);
            if (newApiAdA != null) {
                try {
                    this.G0.add(2, new MkBook(newApiAdA, 1));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.f2256n0.b((Collection) this.G0);
        } else {
            this.f2256n0.a((Collection) list);
        }
        this.f2256n0.m();
        if (list.size() >= i2) {
            this.F0++;
        } else {
            this.f2256n0.n();
        }
    }

    private void r() {
        com.amgcyo.cuttadon.utils.otherutils.d dVarA = com.amgcyo.cuttadon.utils.otherutils.d.a(this);
        if (dVarA != null) {
            ArrayList<MkBookclassifyBean> arrayList = (ArrayList) dVarA.b("all_book_classify_bean_" + this.f2322v0);
            if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) arrayList)) {
                return;
            }
            for (MkBookclassifyBean mkBookclassifyBean : arrayList) {
                if (this.f2323w0 == mkBookclassifyBean.getLtype_id()) {
                    this.f2318r0 = mkBookclassifyBean.getLtype_list();
                    this.f2321u0 = mkBookclassifyBean.getLtype_desc();
                    this.B.setText(mkBookclassifyBean.getLtype_name());
                    return;
                }
            }
        }
    }

    private PopupWindow s() {
        k kVar = this.K0;
        if (kVar != null) {
            return kVar.b();
        }
        return null;
    }

    private PopupWindow t() {
        k kVar = this.I0;
        if (kVar != null) {
            return kVar.b();
        }
        return null;
    }

    private void u() {
        x();
        this.f2256n0 = new t(this.G0, true, false, true, this.G);
        this.f2256n0.a(this.recyclerView);
        this.f2256n0.a(new BaseQuickAdapter.i() { // from class: com.amgcyo.cuttadon.activity.bookcity.f
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
            public final void a() {
                this.a.q();
            }
        }, this.recyclerView);
        this.f2256n0.a((BaseQuickAdapter.g) this);
        this.recyclerView.addOnScrollListener(new r(this.f2277w, new r.a() { // from class: com.amgcyo.cuttadon.activity.bookcity.i
            @Override // com.amgcyo.cuttadon.f.r.a
            public final void a(int i2) {
                this.a.c(i2);
            }
        }));
        String str = "性别：" + this.f2322v0 + "  大类id：" + this.f2323w0;
        this.f2256n0.b(this.E0);
        z();
        loadData();
    }

    private void w() {
        PopupWindow popupWindowT;
        AdFrameLayout adFrameLayout;
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.recyclerView.getLayoutManager();
        if (linearLayoutManager != null) {
            int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            PopupWindow popupWindowS = s();
            if (popupWindowS != null && popupWindowS.isShowing()) {
                popupWindowS.dismiss();
            }
            if (this.I0 == null || (popupWindowT = t()) == null) {
                return;
            }
            this.O0 = this.L0 + " · " + com.amgcyo.cuttadon.utils.otherutils.g.v(this.M0) + " · " + this.N0;
            TextView textView = this.J0;
            if (textView != null) {
                textView.setText(this.O0);
            }
            if (iFindFirstVisibleItemPosition < 2) {
                if (popupWindowT.isShowing()) {
                    this.I0.a();
                }
            } else {
                if (popupWindowT.isShowing() || popupWindowT.isShowing() || (adFrameLayout = this.adFrameLayout) == null) {
                    return;
                }
                this.H0 = adFrameLayout;
                this.I0.a(this.H0, 0, 0);
            }
        }
    }

    private void x() {
        this.E0 = LayoutInflater.from(this.f2277w).inflate(R.layout.mk_view_head_flowlayout, (ViewGroup) null);
        this.Q0 = (AllClassifyTopView) this.E0.findViewById(R.id.allclassifytopview);
        ((TextView) this.E0.findViewById(R.id.tv_desc)).setText(this.f2321u0);
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2318r0)) {
            this.f2318r0.add(0, new MkLtypeListBean(-1, "全部"));
        }
        this.f2319s0 = new ArrayList();
        this.f2319s0.add(new MkLtypeListBean(-1, "全部"));
        this.f2319s0.add(new MkLtypeListBean(2, "连载"));
        this.f2319s0.add(new MkLtypeListBean(1, "完结"));
        this.f2320t0 = new ArrayList();
        this.f2320t0.add(new MkLtypeListBean(1, "热门"));
        this.f2320t0.add(new MkLtypeListBean(2, "评分"));
        this.Q0.a(this.f2318r0, this.f2319s0, this.f2320t0);
        this.Q0.setTabSelectedListener(new AllClassifyTopView.b() { // from class: com.amgcyo.cuttadon.activity.bookcity.g
            @Override // com.amgcyo.cuttadon.view.otherview.AllClassifyTopView.b
            public final void a(MkLtypeListBean mkLtypeListBean, int i2) {
                this.a.a(mkLtypeListBean, i2);
            }
        });
    }

    private void y() {
        showMessage("暂无数据");
        BaseQuickAdapter baseQuickAdapter = this.f2256n0;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.n();
        }
    }

    private void z() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.popup_title, (ViewGroup) null);
        k.c cVar = new k.c(this);
        cVar.a(viewInflate);
        cVar.a(-1, -2);
        cVar.a(false);
        cVar.b(false);
        this.I0 = cVar.a();
        this.J0 = (TextView) viewInflate.findViewById(R.id.tv_title);
        this.O0 = this.L0 + " · " + com.amgcyo.cuttadon.utils.otherutils.g.v(this.M0) + " · " + this.N0;
        TextView textView = this.J0;
        if (textView != null) {
            textView.setText(this.O0);
            this.J0.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.bookcity.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2349s.e(view);
                }
            });
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public /* synthetic */ void b(MkLtypeListBean mkLtypeListBean, int i2) {
        if (mkLtypeListBean == null) {
            return;
        }
        if (mkLtypeListBean.getSelect_type() == R.id.tabLayout_type) {
            this.f2324x0 = mkLtypeListBean.getStype_id();
            this.L0 = mkLtypeListBean.getStype_name();
            this.B0 = i2;
        } else if (R.id.tabLayout_status == mkLtypeListBean.getSelect_type()) {
            this.f2325y0 = mkLtypeListBean.getStype_id();
            this.M0 = mkLtypeListBean.getStype_name();
            this.C0 = i2;
        } else if (R.id.tabLayout_score == mkLtypeListBean.getSelect_type()) {
            this.f2326z0 = mkLtypeListBean.getStype_id();
            this.N0 = mkLtypeListBean.getStype_name();
            this.D0 = i2;
        }
        this.F0 = 1;
        this.Q0.a(this.B0, this.C0, this.D0);
        showLoading();
        loadData();
    }

    public /* synthetic */ void c(int i2) {
        w();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    public /* synthetic */ void e(View view) {
        A();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        d(false);
        hideLoading();
        if (message.f21197s == 825) {
            MkAllBookBean mkAllBookBean = (MkAllBookBean) message.f21202x;
            if (mkAllBookBean == null) {
                y();
                return;
            }
            if (this.G0 == null) {
                this.G0 = new ArrayList();
            }
            this.A0 = mkAllBookBean.getLimit();
            List<MkBook> lists = mkAllBookBean.getLists();
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(lists)) {
                y();
            } else {
                this.G0.addAll(lists);
                a(lists, this.A0);
            }
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.f2322v0 = extras.getInt(ArticleInfo.USER_SEX, 1);
        this.f2323w0 = extras.getInt("ltype", 0);
        this.f2321u0 = extras.getString("key_desc");
        String string = extras.getString("title");
        String string2 = extras.getString("LtypeListBean");
        this.B.setText(string);
        if (TextUtils.isEmpty(string2)) {
            r();
        } else {
            this.f2318r0 = com.amgcyo.cuttadon.utils.otherutils.r.b(string2, MkLtypeListBean.class);
        }
        u();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    public void loadData() {
        if (this.F0 == 1) {
            d(true);
        }
        ((BookPresenter) this.f2276v).k(Message.a(this, new Object[]{Integer.valueOf(this.f2322v0), Integer.valueOf(this.f2323w0), Integer.valueOf(this.f2324x0), Integer.valueOf(this.f2325y0), Integer.valueOf(this.f2326z0), Integer.valueOf(this.F0)}));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        MkBook mkBook;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.G0) || (mkBook = this.G0.get(i2)) == null) {
            return;
        }
        r0.a(this.f2277w, mkBook.getBook_id(), mkBook.getForm());
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        PopupWindow popupWindowS = s();
        if (isFinishing() && popupWindowS != null) {
            popupWindowS.dismiss();
        }
        if (!isFinishing() || t() == null) {
            return;
        }
        t().dismiss();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        super.onRefresh();
        this.F0 = 1;
        loadData();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    protected boolean p() {
        return false;
    }

    public /* synthetic */ void q() {
        String str = "加载更多: " + this.F0;
        loadData();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    @Nullable
    public BookPresenter obtainPresenter() {
        return new BookPresenter(me.jessyan.art.f.e.a(this));
    }

    public /* synthetic */ void a(MkLtypeListBean mkLtypeListBean, int i2) {
        if (mkLtypeListBean == null) {
            return;
        }
        if (mkLtypeListBean.getSelect_type() == R.id.tabLayout_type) {
            this.f2324x0 = mkLtypeListBean.getStype_id();
            this.L0 = mkLtypeListBean.getStype_name();
            this.B0 = i2;
        } else if (R.id.tabLayout_status == mkLtypeListBean.getSelect_type()) {
            this.f2325y0 = mkLtypeListBean.getStype_id();
            this.M0 = mkLtypeListBean.getStype_name();
            this.C0 = i2;
        } else if (R.id.tabLayout_score == mkLtypeListBean.getSelect_type()) {
            this.f2326z0 = mkLtypeListBean.getStype_id();
            this.N0 = mkLtypeListBean.getStype_name();
            this.D0 = i2;
        }
        this.F0 = 1;
        loadData();
    }
}
