package com.amgcyo.cuttadon.view.popupview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.detail.MkBookDetailActivity;
import com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkSiteBean;
import com.amgcyo.cuttadon.b.c.q;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.utils.otherutils.k;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.utils.otherutils.z;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import com.lxj.xpopup.core.DrawerPopupView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NovelSourceDrawerPopup extends DrawerPopupView implements BaseQuickAdapter.g {
    private BaseTitleBarActivity V;
    private String W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private MkBook f5159a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private q f5160b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    AdFrameLayout f5161c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    LinearLayout f5162d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    LinearLayout f5163e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    TextView f5164f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    RecyclerView f5165g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    View f5166h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    k f5167i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private b f5168j0;

    class a extends com.amgcyo.cuttadon.j.g.h.a<String, MkBook> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MkSiteBean f5169c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, MkSiteBean mkSiteBean) {
            super(str);
            this.f5169c = mkSiteBean;
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public MkBook a(String str) {
            MkBook mkBook = new MkBook();
            mkBook.setBook_id(NovelSourceDrawerPopup.this.f5159a0.getBook_id());
            mkBook.setReading_site_path(this.f5169c.getSite_path());
            mkBook.setReading_site_id(this.f5169c.getSite_id());
            mkBook.setSiteName(this.f5169c.getSite_name());
            mkBook.setCrawl_book_id(this.f5169c.getCrawl_book_id());
            mkBook.setSite_path_reload(this.f5169c.getSite_path_reload());
            if (z.a(z.a(NovelSourceDrawerPopup.this.f5159a0.getBook_id(), this.f5169c.getSite_id()))) {
                com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.clear_cache_success);
            } else {
                com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.clear_cache_error);
            }
            return mkBook;
        }

        @Override // com.amgcyo.cuttadon.j.g.g.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(MkBook mkBook) {
            NovelSourceDrawerPopup.this.V.hideLoading();
            NovelSourceDrawerPopup.this.f5168j0.a(mkBook);
            NovelSourceDrawerPopup.this.g();
        }
    }

    public interface b {
        void a(MkBook mkBook);

        void b(MkBook mkBook);
    }

    public NovelSourceDrawerPopup(@NonNull BaseTitleBarActivity baseTitleBarActivity, MkBook mkBook) {
        super(baseTitleBarActivity);
        this.V = baseTitleBarActivity;
        this.f5159a0 = mkBook;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.source_pager_drawer;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        MkSiteBean item;
        q qVar = this.f5160b0;
        if (qVar == null || this.f5159a0 == null || this.f5168j0 == null || this.V == null || (item = qVar.getItem(i2)) == null) {
            return;
        }
        if (!(this.V instanceof MkBookDetailActivity) && !TextUtils.isEmpty(this.W) && this.W.equals(item.getSite_id())) {
            o.b("已选择该源，无需切换!");
        } else {
            this.V.showLoading("努力加载中...");
            com.amgcyo.cuttadon.j.g.b.a(new a("", item));
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.f5161c0 = (AdFrameLayout) findViewById(R.id.fl_ad);
        this.f5165g0 = (RecyclerView) findViewById(android.R.id.list);
        this.f5165g0.setLayoutManager(new LinearLayoutManager(this.V));
        this.f5162d0 = (LinearLayout) findViewById(R.id.ll_root);
        this.f5163e0 = (LinearLayout) findViewById(R.id.ll_bar);
        this.f5166h0 = findViewById(R.id.view_line);
        this.f5164f0 = (TextView) findViewById(R.id.toolbar_title);
        this.f5164f0.setText(o.d(R.string.choose_source));
        BaseTitleBarActivity baseTitleBarActivity = this.V;
        if (baseTitleBarActivity instanceof MkNovelBaseReaderActivity) {
            this.f5167i0 = ((MkNovelBaseReaderActivity) baseTitleBarActivity).getReaderColorStyle();
            k kVar = this.f5167i0;
            if (kVar != null) {
                this.f5164f0.setTextColor(kVar.a);
                this.f5164f0.setBackgroundColor(this.f5167i0.f4401e);
                this.f5163e0.setBackgroundColor(this.f5167i0.f4401e);
                this.f5165g0.setBackgroundColor(this.f5167i0.f4405i);
                this.f5161c0.setBackgroundColor(this.f5167i0.f4405i);
                this.f5166h0.setBackgroundColor(this.f5167i0.f4409m);
            }
        } else {
            this.f5165g0.setBackgroundColor(-1);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f5162d0.getLayoutParams();
        double dC = n.c(this.V);
        Double.isNaN(dC);
        layoutParams.width = (int) (dC * 0.85d);
        layoutParams.height = n.a(this.V);
        this.f5162d0.setLayoutParams(layoutParams);
        if (!(this.V instanceof MkNovelBaseReaderActivity)) {
            ViewGroup.LayoutParams layoutParams2 = this.f5163e0.getLayoutParams();
            layoutParams2.height = com.amgcyo.cuttadon.utils.otherutils.g.d((Context) this.V);
            this.f5163e0.setVisibility(0);
            this.f5163e0.setLayoutParams(layoutParams2);
        }
        NormalAdParams normalAdParamsA = this.V instanceof MkNovelBaseReaderActivity ? com.amgcyo.cuttadon.sdk.utils.e.a("position_book_detail_source", "csj_new_position_book_city", 1) : com.amgcyo.cuttadon.sdk.utils.e.a("position_book_detail_source", "csj_new_position_book_city");
        if (normalAdParamsA != null) {
            normalAdParamsA.setSelfAdPosition(com.amgcyo.cuttadon.f.n.f3703q);
            normalAdParamsA.setAdWidth(n.b(layoutParams.width));
            String str = "宽度是：" + normalAdParamsA.getAdWidth();
            this.f5161c0.b(normalAdParamsA);
        }
    }

    public void setListener(b bVar) {
        this.f5168j0 = bVar;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void t() {
        b bVar;
        MkBook mkBook;
        super.t();
        q qVar = this.f5160b0;
        if ((qVar != null && !com.amgcyo.cuttadon.utils.otherutils.g.a(qVar.getData())) || (bVar = this.f5168j0) == null || (mkBook = this.f5159a0) == null) {
            return;
        }
        bVar.b(mkBook);
    }

    public void a(List<MkSiteBean> list, k kVar) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
            return;
        }
        MkBook mkBook = this.f5159a0;
        if (mkBook != null) {
            this.W = mkBook.getReading_site_id();
        }
        if (kVar != null) {
            this.f5160b0 = new q(list, this.W, kVar);
        } else {
            this.f5160b0 = new q(list, this.W);
        }
        this.f5165g0.setAdapter(this.f5160b0);
        this.f5160b0.a((BaseQuickAdapter.g) this);
    }
}
