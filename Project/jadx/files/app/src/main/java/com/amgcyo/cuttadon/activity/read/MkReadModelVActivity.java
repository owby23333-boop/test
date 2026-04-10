package com.amgcyo.cuttadon.activity.read;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import com.amgcyo.cuttadon.api.entity.other.MkChapterContent;
import com.amgcyo.cuttadon.api.entity.other.Slippage;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.view.otherview.LabelTextView;
import com.amgcyo.cuttadon.view.read.page.PageView;
import com.amgcyo.cuttadon.view.readermenu.AutoPollRecyclerView;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.amgcyo.cuttadon.widget.ui.ChapterAlignTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.mvp.Message;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class MkReadModelVActivity extends MkNovelBaseReaderActivity implements PullToRefreshView.j, BaseQuickAdapter.f {
    PullToRefreshView A1;
    private int B1;
    protected c C1;
    LinearLayoutManager D1;
    Typeface E1;
    private boolean F1;
    private int G1;
    private int H1;
    private int I1;
    protected int K1;
    protected int L1;
    protected int M1;
    String N1;
    Layout O1;
    ChapterAlignTextView P1;
    int Q1;
    int R1;
    int S1;
    protected String T1;
    int X1;
    AutoPollRecyclerView z1;
    protected int J1 = 0;
    boolean U1 = true;
    private boolean V1 = false;
    private boolean W1 = false;
    boolean Y1 = false;
    private int Z1 = 0;

    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                MkReadModelVActivity mkReadModelVActivity = MkReadModelVActivity.this;
                mkReadModelVActivity.U1 = false;
                mkReadModelVActivity.a(recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            MkReadModelVActivity mkReadModelVActivity = MkReadModelVActivity.this;
            if (mkReadModelVActivity.U1 || mkReadModelVActivity.isAutoRead) {
                MkReadModelVActivity.this.a(recyclerView);
            }
        }
    }

    class b extends DisposableObserver<Typeface> {
        b() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Typeface typeface) {
            MkReadModelVActivity mkReadModelVActivity = MkReadModelVActivity.this;
            mkReadModelVActivity.E1 = typeface;
            c cVar = mkReadModelVActivity.C1;
            cVar.notifyItemRangeChanged(mkReadModelVActivity.Q1, cVar.getItemCount());
            MkReadModelVActivity.this.hideLoading();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            MkReadModelVActivity.this.hideLoading();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            MkReadModelVActivity.this.hideLoading();
        }

        @Override // io.reactivex.observers.DisposableObserver
        protected void onStart() {
            super.onStart();
            MkReadModelVActivity.this.showLoading("努力加载中...");
        }
    }

    class c extends com.chad.library.adapter.base.a<MkChapterContent, com.chad.library.adapter.base.b> {
        LinearLayout.LayoutParams L;
        private List<BaseAd> M;
        private int N;
        private String O;

        c(List<MkChapterContent> list) {
            super(list);
            this.N = com.amgcyo.cuttadon.h.a.i.b(1);
            this.O = com.amgcyo.cuttadon.utils.otherutils.h.n(this.N);
            this.M = com.amgcyo.cuttadon.utils.otherutils.h.Z();
            b(1, R.layout.shangxia_page_view);
            b(2, R.layout.vertical_chapter_item);
        }

        public /* synthetic */ void e(View view) {
            MkReadModelVActivity.this.showMenuPanel();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void a(@NonNull com.chad.library.adapter.base.b bVar, final MkChapterContent mkChapterContent) {
            StringBuilder sb;
            String str;
            int i2 = MkReadModelVActivity.this.getReaderColorStyle().a;
            int itemViewType = bVar.getItemViewType();
            if (itemViewType == 1) {
                NormalAdParams adParams = mkChapterContent.getAdParams();
                TextView textView = (TextView) bVar.a(R.id.tv_next_read);
                textView.setTextColor(i2);
                textView.setText("--滑动可继续阅读--");
                textView.setVisibility(8);
                textView.setAlpha(0.3f);
                if (adParams != null) {
                    BaseAd baseAd = adParams.getBaseAd();
                    boolean zB = com.amgcyo.cuttadon.h.a.d.b(baseAd);
                    boolean zA = com.amgcyo.cuttadon.h.a.d.a(baseAd);
                    adParams.setSelfAdPosition(com.amgcyo.cuttadon.f.n.A);
                    AdFrameLayout adFrameLayout = (AdFrameLayout) bVar.a(R.id.sx_ad_page_content);
                    if (MkReadModelVActivity.this.is_screen_orientation_landscape && !zB) {
                        com.amgcyo.cuttadon.f.o.a(adFrameLayout, Math.round(com.amgcyo.cuttadon.utils.otherutils.n.a(r9) / 3.0f), 0, 0, 0);
                    }
                    adFrameLayout.removeAllViews();
                    if (!zB) {
                        int iA = com.amgcyo.cuttadon.utils.otherutils.n.a(10.0f);
                        com.amgcyo.cuttadon.f.o.a(adFrameLayout, iA, 0, iA, 0);
                    }
                    textView.setVisibility(zA ? 8 : 0);
                    adFrameLayout.b(adParams);
                }
                LabelTextView labelTextView = (LabelTextView) bVar.a(R.id.labeltextview);
                LinearLayout linearLayout = (LinearLayout) bVar.a(R.id.ll_root);
                bVar.a(R.id.labeltextview);
                TextView textView2 = (TextView) bVar.a(R.id.tv_ad_tips);
                textView2.setTextColor(i2);
                if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.M) || this.N <= 0) {
                    labelTextView.setVisibility(8);
                    textView2.setVisibility(8);
                } else {
                    labelTextView.setVisibility(0);
                    textView2.setVisibility(0);
                    labelTextView.setText(this.O);
                }
                TextView textView3 = (TextView) bVar.a(R.id.tv_next_chapter_name);
                TextView textView4 = (TextView) bVar.a(R.id.tv_unlock_btn);
                TextView textView5 = (TextView) bVar.a(R.id.tv_close);
                final Slippage slippage = mkChapterContent.getSlippage();
                if (slippage == null) {
                    textView3.setVisibility(8);
                    textView5.setVisibility(8);
                    textView4.setVisibility(8);
                    linearLayout.setOnClickListener(null);
                    textView.setVisibility(textView.getVisibility());
                    return;
                }
                textView.setVisibility(8);
                textView3.setText(slippage.getChapterName());
                textView3.setTextColor(i2);
                textView3.setVisibility(0);
                textView4.setText(com.amgcyo.cuttadon.utils.otherutils.h.V0());
                textView4.setVisibility(0);
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.v0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f2765s.a(slippage, view);
                    }
                });
                textView5.setTextColor(i2);
                bVar.a(R.id.tv_close);
                textView5.setVisibility(0);
                return;
            }
            if (itemViewType != 2) {
                return;
            }
            TextView textView6 = (TextView) bVar.a(R.id.tv_chapter_title);
            TextView textView7 = (TextView) bVar.a(R.id.tv_placeder);
            TextView textView8 = (TextView) bVar.a(R.id.tv_chapter_content_retry);
            textView7.setText(String.valueOf(mkChapterContent.getCatalogId()));
            MkReadModelVActivity.this.Q();
            ChapterAlignTextView chapterAlignTextView = (ChapterAlignTextView) bVar.a(R.id.tv_chapter_content);
            textView6.setTextColor(i2);
            chapterAlignTextView.setTextColor(i2);
            chapterAlignTextView.setTypeface(MkReadModelVActivity.this.E1);
            textView6.setTypeface(MkReadModelVActivity.this.E1);
            chapterAlignTextView.setTextSize(0, MkReadModelVActivity.this.H1);
            textView6.setTextSize(0, MkReadModelVActivity.this.H1 + 8);
            bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.w0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2767s.e(view);
                }
            });
            textView8.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.x0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2768s.a(mkChapterContent, view);
                }
            });
            chapterAlignTextView.setLineSpacing(com.amgcyo.cuttadon.utils.otherutils.n.b(MkReadModelVActivity.this.a(), MkReadModelVActivity.this.G1), 1.2f);
            MkReadModelVActivity.this.k1 = mkChapterContent.getName();
            textView6.setText(MkReadModelVActivity.this.k1);
            List<String> contentStrList = mkChapterContent.getContentStrList();
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(contentStrList)) {
                if (mkChapterContent.isOnErrorReturn()) {
                    textView8.setVisibility(0);
                    chapterAlignTextView.setText("请求章节内容失败，\n请先检查网络设置！！！\n网络设置成功后退出阅读器，\n重新打开阅读本章节。\n或者“点击重新加载本章节按钮“。\n如果网络通畅还是请求失败，\n请反馈给客服。\n谢谢支持与理解！");
                    return;
                } else {
                    textView8.setVisibility(8);
                    chapterAlignTextView.setText("章节缺失，请换源!\n如果本书只有一个书源;\n请反馈给客服。\n谢谢支持与理解！");
                    return;
                }
            }
            textView8.setVisibility(8);
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = contentStrList.iterator();
            while (it.hasNext()) {
                String strReplaceAll = it.next().replaceAll("\\s", "");
                if (!"".equals(strReplaceAll)) {
                    if (MkReadModelVActivity.this.getConfig().k() != 0) {
                        str = com.amgcyo.cuttadon.utils.otherutils.z.k("  ") + strReplaceAll + "\n";
                    } else {
                        str = strReplaceAll + "\n";
                    }
                    sb2.append(str);
                }
            }
            String string = sb2.toString();
            if (MkReadModelVActivity.this.F1) {
                string = com.amgcyo.cuttadon.utils.otherutils.n.a(string);
            }
            chapterAlignTextView.setText(string);
            try {
                if (MkReadModelVActivity.this.z().a(MkReadModelVActivity.this.E0.getReading_chapter_key(), MkReadModelVActivity.this.k1, MkReadModelVActivity.this.E0.getBook_id()) > 0) {
                    sb = new StringBuilder();
                    sb.append("章节改变时，保存章节信息成功");
                    sb.append(MkReadModelVActivity.this.k1);
                } else {
                    sb = new StringBuilder();
                    sb.append("章节改变时，保存章节信息失败...");
                    sb.append(MkReadModelVActivity.this.k1);
                }
                sb.toString();
                if (MkReadModelVActivity.this.is_screen_orientation_landscape) {
                    if (this.L == null) {
                        this.L = new LinearLayout.LayoutParams(chapterAlignTextView.getLayoutParams());
                    }
                    this.L.setMargins(MkReadModelVActivity.this.I0, 0, MkReadModelVActivity.this.I0, 0);
                    chapterAlignTextView.setLayoutParams(this.L);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public /* synthetic */ void a(Slippage slippage, View view) {
            MkReadModelVActivity.this.a(slippage);
        }

        public /* synthetic */ void a(MkChapterContent mkChapterContent, View view) {
            MkReadModelVActivity mkReadModelVActivity = MkReadModelVActivity.this;
            if (mkReadModelVActivity.E0 == null) {
                return;
            }
            if (mkReadModelVActivity.z().a(mkChapterContent.getCatalogId(), System.currentTimeMillis() / 1000, MkReadModelVActivity.this.E0.getBook_id(), 0, 0) > 0) {
                String str = "重试章节，保存章节信息成功,章节id：" + mkChapterContent.getCatalogId() + " tempY: 0";
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("book", MkReadModelVActivity.this.E0);
            com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(MkReadModelVActivity.this.a(), bundle, MkReadModelVActivity.class);
            MkReadModelVActivity.this.finish();
        }
    }

    private void X() {
        MkBook mkBook = this.E0;
        if (mkBook == null || this.f2276v == 0) {
            return;
        }
        if ((com.amgcyo.cuttadon.utils.otherutils.g.a(com.amgcyo.cuttadon.utils.otherutils.z.b(mkBook)) || this.U0) ? false : true) {
            obtainPresenter().f(Message.a(this, new Object[]{this.E0, 895}));
        } else {
            a0();
        }
    }

    private void Y() {
        this.D1 = new LinearLayoutManager(this.f2277w);
        this.z1.setLayoutManager(this.D1);
        this.z1.setItemAnimator(null);
        this.A1.setColorSchemeColors(com.amgcyo.cuttadon.utils.otherutils.g.a(R.color.colorPrimary), SupportMenu.CATEGORY_MASK);
        this.A1.setOnRefreshListener(this);
        this.z1.setItemAnimator(null);
        this.E1 = com.amgcyo.cuttadon.view.read.page.m.b(getConfig().j());
        this.F1 = getConfig().o();
        this.G1 = com.amgcyo.cuttadon.view.read.page.m.a(getConfig().k());
        this.H1 = com.amgcyo.cuttadon.utils.otherutils.s0.a(this.f2277w, getConfig().b(this.f2277w));
        this.layout_root.setBackgroundColor(getReaderColorStyle().f4405i);
        this.C1 = new c(this.K0);
        this.z1.setAdapter(this.C1);
        this.z1.setItemAnimator(null);
        this.C1.a((BaseQuickAdapter.f) this);
        this.C1.a((RecyclerView) this.z1);
        this.C1.a(new BaseQuickAdapter.i() { // from class: com.amgcyo.cuttadon.activity.read.y0
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
            public final void a() {
                this.a.b0();
            }
        }, this.z1);
        this.C1.a(new BaseQuickAdapter.l() { // from class: com.amgcyo.cuttadon.activity.read.z0
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.l
            public final void a(TextView textView, TextView textView2) {
                this.a.a(textView, textView2);
            }
        });
    }

    private void Z() {
        c cVar = this.C1;
        if (cVar != null) {
            cVar.b("请观看视频后进行解锁!");
            this.C1.a(true);
        }
    }

    private void a0() {
        c cVar = this.C1;
        if (cVar != null) {
            cVar.a("没有更多数据,请等待更新或换源!");
            this.C1.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        if (this.f2276v != 0) {
            if (this.X1 >= this.B1) {
                N();
                if (this.j1) {
                    return;
                }
                X();
                return;
            }
            String str = "加载下一章的index: " + this.X1;
            int book_id = this.E0.getBook_id();
            MkCatalog mkCatalog = y().get(this.X1);
            Slippage slippageA = com.amgcyo.cuttadon.utils.otherutils.g.a(mkCatalog, book_id, 1);
            if (slippageA == null) {
                String str2 = mkCatalog.getName() + "不需要解锁，那么加载下一章";
                N();
                obtainPresenter().h(Message.a(this, new Object[]{false, this.E0, Integer.valueOf(this.X1)}));
                return;
            }
            String str3 = mkCatalog.getName() + "rewardChapter需要解锁";
            MkChapterContent mkChapterContent = new MkChapterContent(1);
            NormalAdParams normalAdParamsC = com.amgcyo.cuttadon.sdk.utils.e.c();
            if (normalAdParamsC != null) {
                mkChapterContent.setAdParams(normalAdParamsC);
            }
            mkChapterContent.setSlippage(slippageA);
            this.C1.a(mkChapterContent);
            Z();
            this.C1.m();
        }
    }

    private void c0() {
        this.currentChpaterId--;
        this.X1--;
        String str = "currentChpaterId:" + this.currentChpaterId;
        ArrayList<MkCatalog> arrayListY = y();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(arrayListY)) {
            c("无法获取章节目录信息，请退出重试！");
            return;
        }
        int i2 = this.currentChpaterId;
        this.B1 = arrayListY.size();
        int i3 = this.B1;
        if (i2 >= i3) {
            i2 = i3 - 1;
        }
        int book_id = this.E0.getBook_id();
        MkCatalog mkCatalog = arrayListY.get(i2);
        Slippage slippageA = com.amgcyo.cuttadon.utils.otherutils.g.a(mkCatalog, book_id, 1);
        if (slippageA == null) {
            String str2 = mkCatalog.getName() + "下拉不需要解锁";
            this.A1.setRefreshing(false);
            this.Y1 = true;
            obtainPresenter().h(Message.a(this, new Object[]{true, this.E0, Integer.valueOf(this.currentChpaterId)}));
            return;
        }
        String str3 = mkCatalog.getName() + "下拉需要解锁";
        MkChapterContent mkChapterContent = new MkChapterContent(1);
        NormalAdParams normalAdParamsC = com.amgcyo.cuttadon.sdk.utils.e.c();
        if (normalAdParamsC != null) {
            mkChapterContent.setAdParams(normalAdParamsC);
        }
        mkChapterContent.setCatalogId(mkCatalog.getCatalogId());
        mkChapterContent.setSlippage(slippageA);
        this.C1.a(0, mkChapterContent);
        this.A1.setRefreshing(false);
        this.A1.setEnabled(false);
        LinearLayoutManager linearLayoutManager = this.D1;
        if (linearLayoutManager != null) {
            linearLayoutManager.scrollToPositionWithOffset(1, -(this.J1 - 1000));
        }
    }

    @Subscriber(mode = ThreadMode.POST, tag = "catalog_to_read")
    private void catalogToRead(MkBook mkBook) {
        finish();
    }

    private void d0() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z1.getLayoutParams();
        if (com.amgcyo.cuttadon.utils.otherutils.g.l(this)) {
            int i2 = this.I0;
            layoutParams.setMargins(0, i2, 0, this.bottom_adHeight + i2);
        } else {
            int i3 = this.I0;
            layoutParams.setMargins(0, i3, 0, this.bottom_adHeight + i3);
        }
        this.z1.setLayoutParams(layoutParams);
        this.z1.addOnScrollListener(new a());
    }

    private void m(int i2) {
        if (this.E0 == null || this.f2276v == 0 || com.amgcyo.cuttadon.utils.otherutils.g.a(obtainPresenter().f3247w)) {
            return;
        }
        String str = "currentChpaterId: " + i2;
        finish();
        overridePendingTransition(0, 0);
        Bundle bundle = new Bundle();
        this.E0.setReading_chapter_key(i2);
        bundle.putSerializable("book", this.E0);
        startActivity(new Intent(this, (Class<?>) MkReadModelVActivity.class).putExtras(bundle));
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    protected View C() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.vertical_content_list, (ViewGroup) null, false);
        this.A1 = (PullToRefreshView) viewInflate.findViewById(R.id.swipe_refresh_layout);
        this.z1 = (AutoPollRecyclerView) viewInflate.findViewById(android.R.id.list);
        viewInflate.setId(R.id.reader_view);
        return viewInflate;
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    protected void K() {
        try {
            this.B1 = y().size();
            String str = "更新后大小：" + this.B1 + " oldSize:" + this.i1;
            if (this.X1 < this.B1) {
                String str2 = "refreshChapterList加载下一章: " + this.X1;
                N();
                this.V1 = true;
                obtainPresenter().h(Message.a(this, new Object[]{false, this.E0, Integer.valueOf(this.X1)}));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    protected void M() {
        this.currentChpaterId++;
        m(this.currentChpaterId);
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyAnim(int i2) {
        super.applyAnim(i2);
        k(-1);
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyColorStyle(String str) {
        RelativeLayout relativeLayout;
        super.applyColorStyle(str);
        if (this.C1 == null || this.z1 == null || (relativeLayout = this.layout_root) == null) {
            return;
        }
        relativeLayout.setBackgroundColor(getReaderColorStyle().f4405i);
        c cVar = this.C1;
        cVar.notifyItemRangeChanged(this.Q1, cVar.getItemCount());
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyFont(final String str) {
        if (this.C1 == null || this.f2276v == 0) {
            return;
        }
        obtainPresenter().a((Disposable) Observable.create(new ObservableOnSubscribe() { // from class: com.amgcyo.cuttadon.activity.read.a1
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                this.a.a(str, observableEmitter);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new b()));
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyFontSize(int i2) {
        super.applyFontSize(i2);
        if (this.C1 == null || this.z1 == null) {
            return;
        }
        String str = "index: " + i2;
        this.H1 = com.amgcyo.cuttadon.utils.otherutils.s0.a(this.f2277w, i2);
        this.C1.notifyDataSetChanged();
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyLayoutStyle(int i2) {
        super.applyLayoutStyle(i2);
        if (this.C1 == null || this.z1 == null || this.layout_root == null) {
            return;
        }
        String str = "layoutStyle: " + i2;
        this.G1 = com.amgcyo.cuttadon.view.read.page.m.a(i2);
        c cVar = this.C1;
        cVar.notifyItemRangeChanged(this.Q1, cVar.getItemCount());
    }

    @Override // com.amgcyo.cuttadon.g.h
    public void applyNextChapterClick() {
        int i2 = this.currentChpaterId + 1;
        if (i2 >= this.B1) {
            showMessage("已经是最后一章了...");
        } else {
            m(i2);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyOrientation() {
        MkBook mkBook = this.E0;
        if (mkBook == null || this.f2277w == null) {
            return;
        }
        mkBook.setReading_chapter_key(this.currentChpaterId);
        this.E0.setFirstLineText("");
        this.E0.setVertical_top(1);
        Bundle bundle = new Bundle();
        bundle.putSerializable("book", this.E0);
        com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f2277w, bundle, MkReadModelVActivity.class);
        finish();
    }

    @Override // com.amgcyo.cuttadon.g.h
    public void applyPreChapterClick() {
        int i2 = this.currentChpaterId - 1;
        if (i2 < 0) {
            showMessage("已经是第一章了...");
        } else {
            m(i2);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyProgress(int i2) {
        super.applyProgress(i2);
        ChapterAlignTextView chapterAlignTextView = this.P1;
        if (chapterAlignTextView == null || chapterAlignTextView.getHeight() <= 0 || this.totalPage <= 0 || this.z1 == null) {
            return;
        }
        int height = this.P1.getHeight() / this.totalPage;
        String str = "当前页：" + i2 + " contentTextView: " + this.P1.getHeight() + " 每一页高度：" + height;
        this.z1.smoothScrollBy(0, i2 * height);
        hideMenuPanel(true);
    }

    @Override // com.amgcyo.cuttadon.g.h
    public void applySkipToChapter(MkCatalog mkCatalog) {
        if (mkCatalog == null) {
            return;
        }
        m(mkCatalog.getCatalogId());
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyStrTraditional(boolean z2) {
        super.applyStrTraditional(z2);
        if (this.C1 == null || this.z1 == null) {
            return;
        }
        if (z2) {
            showMessage("切换繁体");
        } else {
            showMessage("切换简体");
        }
        this.F1 = z2;
        c cVar = this.C1;
        cVar.notifyItemRangeChanged(this.Q1, cVar.getItemCount());
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void finishAutoRead() {
        AutoPollRecyclerView autoPollRecyclerView;
        super.finishAutoRead();
        if (this.C1 == null || (autoPollRecyclerView = this.z1) == null) {
            return;
        }
        this.isAutoRead = false;
        autoPollRecyclerView.b();
        showMessage(com.amgcyo.cuttadon.f.o.d(R.string.str_quit_auto_read));
        W();
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public PageView getPageView() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        LinearLayoutManager linearLayoutManager;
        ArrayList arrayList;
        super.handleMessage(message);
        if (this.E0 == null) {
            return;
        }
        int i2 = message.f21197s;
        if (i2 != 827) {
            if (i2 == 895) {
                MkBook mkBook = (MkBook) message.f21202x;
                if (mkBook == null || mkBook.getUpdated() != 0) {
                    a0();
                    return;
                }
                showMessage("书籍有更新，正在获取最新章节...");
                this.E0 = mkBook;
                obtainPresenter().a(Message.a(this, new Object[]{false, this.E0}));
                return;
            }
            if (i2 == 1543) {
                c("获取章节目录信息失败，请重试！");
                finish();
                return;
            }
            if (i2 != 1545) {
                return;
            }
            ArrayList arrayList2 = (ArrayList) message.f21202x;
            int i3 = this.currentChpaterId;
            this.B1 = arrayList2.size();
            int i4 = this.B1;
            if (i3 >= i4) {
                i3 = i4 - 1;
            }
            int book_id = this.E0.getBook_id();
            MkCatalog mkCatalog = (MkCatalog) arrayList2.get(i3);
            Slippage slippageA = com.amgcyo.cuttadon.utils.otherutils.g.a(mkCatalog, book_id, 1);
            if (slippageA != null) {
                MkChapterContent mkChapterContent = new MkChapterContent(1);
                NormalAdParams normalAdParamsC = com.amgcyo.cuttadon.sdk.utils.e.c();
                if (normalAdParamsC != null) {
                    mkChapterContent.setAdParams(normalAdParamsC);
                }
                String str = mkCatalog.getName() + "当前章节就需要解锁";
                mkChapterContent.setSlippage(slippageA);
                this.C1.a(mkChapterContent);
                this.A1.setEnabled(false);
                Z();
                this.C1.m();
            } else {
                obtainPresenter().h(Message.a(this, new Object[]{true, this.E0, Integer.valueOf(this.X1)}));
            }
            a(this.E0, this.currentChpaterId);
            return;
        }
        MkChapterContent mkChapterContent2 = (MkChapterContent) message.f21202x;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(obtainPresenter().f3247w)) {
            mkChapterContent2.setName("请求章节列表失败😭");
            this.C1.a(mkChapterContent2);
            this.C1.a((BaseQuickAdapter.i) null, this.z1);
            return;
        }
        String str2 = "handleMessage: " + mkChapterContent2.getName();
        d(1);
        try {
            if (!mkChapterContent2.isOnErrorReturn() && mkChapterContent2.isIs_content()) {
                arrayList = new ArrayList();
                Iterator<String> it = com.amgcyo.cuttadon.utils.otherutils.z.a(mkChapterContent2.getCacheFilePath(), this.T0).iterator();
                while (it.hasNext()) {
                    arrayList.add(com.amgcyo.cuttadon.utils.otherutils.z.o(it.next()));
                }
            } else {
                arrayList = null;
            }
            mkChapterContent2.setContentStrList(arrayList);
        } catch (Exception unused) {
        }
        this.B1 = y().size();
        this.i1 = y().size();
        mkChapterContent2.setItemType(2);
        int i5 = this.currentChpaterId;
        MkChapterContent mkChapterContentA = i5 != 0 ? com.amgcyo.cuttadon.utils.otherutils.h.a(this.I1, i5) : null;
        if (this.Y1) {
            this.C1.a(0, mkChapterContent2);
            showMessage("上一章获取成功");
            if (mkChapterContentA != null) {
                this.C1.a(1, mkChapterContentA);
            }
        } else {
            String str3 = "风格：" + this.Z1;
            if (2 == this.Z1) {
                this.C1.a(mkChapterContent2);
                if (mkChapterContentA != null) {
                    this.C1.a(mkChapterContentA);
                }
            } else {
                if (mkChapterContentA != null) {
                    this.C1.a(mkChapterContentA);
                }
                this.C1.a(mkChapterContent2);
            }
        }
        if (this.Y1 && (linearLayoutManager = this.D1) != null) {
            linearLayoutManager.scrollToPositionWithOffset(1, -(this.J1 - 1000));
        }
        this.Y1 = false;
        this.C1.m();
        this.A1.setRefreshing(false);
        if (this.V1) {
            int i6 = this.B1 - 1;
            int i7 = this.X1;
            if (i7 < i6) {
                this.X1 = i7 + 1;
            } else {
                a0();
            }
            if (!this.W1) {
                LinearLayoutManager linearLayoutManager2 = this.D1;
                if (linearLayoutManager2 != null) {
                    linearLayoutManager2.scrollToPositionWithOffset(0, -(this.J1 + 1000));
                }
                this.W1 = true;
            }
        } else {
            int i8 = this.B1;
            int i9 = this.X1;
            if (i8 > i9) {
                this.X1 = i9 + 1;
            } else {
                a0();
            }
        }
        this.E0.setIsChangeSiteId(false);
        a(0);
        if (this.isAutoRead) {
            this.z1.a(this.speed);
        }
        this.M1 = this.E0.getVertical_top();
        int i10 = this.M1;
        if (i10 > 0) {
            this.D1.scrollToPositionWithOffset(0, -i10);
            this.E0.setVertical_top(-1);
        }
        if (!this.x1 && (getTaskSourceType() > 0 || getTaskCacheType() > 0)) {
            showMenuPanel();
            this.x1 = true;
        }
        N();
        j(this.currentChpaterId);
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity, com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        this.I1 = com.amgcyo.cuttadon.utils.otherutils.h.R();
        this.X1 = this.currentChpaterId;
        this.Z1 = com.amgcyo.cuttadon.utils.otherutils.h.e(1);
        if (this.z1 == null) {
            showMessage(com.amgcyo.cuttadon.f.o.d(R.string.error_params));
            finish();
        } else {
            Y();
            d0();
            loadData();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    protected void l(int i2) {
        AutoPollRecyclerView autoPollRecyclerView = this.z1;
        if (autoPollRecyclerView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) autoPollRecyclerView.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, i2);
        this.z1.setLayoutParams(layoutParams);
    }

    protected void loadData() {
        this.Y1 = false;
        String str = "tempCurrentChpaterId:" + this.X1;
        obtainPresenter().b(Message.a(this, new Object[]{true, this.E0}));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.f
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        switch (view.getId()) {
            case R.id.labeltextview /* 2131297831 */:
                e("position_reward_ad_video");
                break;
            case R.id.tv_chapter_content /* 2131298624 */:
            case R.id.tv_chapter_title /* 2131298627 */:
                showMenuPanel();
                break;
            case R.id.tv_close /* 2131298633 */:
                finish();
                break;
        }
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        ChapterAlignTextView chapterAlignTextView;
        if (this.isAutoRead || this.C1 == null || (chapterAlignTextView = this.P1) == null || chapterAlignTextView.getHeight() <= 0 || this.totalPage <= 0 || this.z1 == null) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (i2 == 24 || i2 == 25) {
            boolean zA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("is_open_volume", false);
            int height = (this.P1.getHeight() / this.totalPage) / 2;
            if (i2 != 24) {
                if (i2 == 25 && zA) {
                    this.z1.smoothScrollBy(this.Q1, height);
                    return true;
                }
            } else if (zA) {
                this.z1.smoothScrollBy(this.Q1, -height);
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.isAutoRead) {
            return super.onKeyUp(i2, keyEvent);
        }
        boolean zA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("is_open_volume", false);
        return (i2 == 25 || i2 == 24) ? zA : super.onKeyUp(i2, keyEvent);
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity, com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.E0 == null) {
            return;
        }
        try {
            String str = "状态：" + this.E0.getUpdated();
            this.k1 = y().get(this.currentChpaterId).getName();
            if (z().a(this.currentChpaterId, System.currentTimeMillis() / 1000, this.E0.getUpdated(), this.E0.getBook_id(), 0, this.J1, this.k1) > 0) {
                String str2 = "onPause页面停止时，保存章节信息成功,章节id：" + this.currentChpaterId + " tempY: " + this.J1;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        me.jessyan.art.d.f.a().a(new MkCommentEvent(), "tag_bookshelf__operate");
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("shelf_book", this.E0.getBook_id());
    }

    @Override // com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        if (this.currentChpaterId == 0) {
            this.A1.setRefreshing(false);
            showMessage("已经是第一章了");
        } else {
            if (this.f2276v == 0) {
                return;
            }
            c0();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void pauseAutoRead(boolean z2) {
        AutoPollRecyclerView autoPollRecyclerView;
        super.pauseAutoRead(z2);
        if (this.C1 == null || (autoPollRecyclerView = this.z1) == null) {
            return;
        }
        if (z2) {
            autoPollRecyclerView.b();
        } else {
            autoPollRecyclerView.a(this.speed);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void showTtsEngine(boolean z2) {
        V();
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void startAutoRead(int i2, int i3, boolean z2) {
        super.startAutoRead(i2, i3, z2);
        if (this.C1 == null || this.z1 == null) {
            return;
        }
        String str = "hideMenuPanel：" + z2;
        if (z2) {
            hideMenuPanel(false);
        }
        this.isAutoRead = true;
        this.speed = i3;
        setMenuState(6);
        this.z1.a(i3);
        T();
    }

    @Override // com.amgcyo.cuttadon.g.i
    public void subMitrecordTime(int i2) {
        if (this.f2276v == 0 || this.f2277w == null || this.E0 == null || com.amgcyo.cuttadon.utils.otherutils.g.j() == null || !me.jessyan.art.f.f.c(this.f2277w)) {
            return;
        }
        String str = "是否语音朗读：" + this.Q0 + " 是否自动阅读：" + this.isAutoRead;
        if (this.Q0 || this.isAutoRead) {
            return;
        }
        String str2 = "book_id: " + this.E0.getBook_id() + " site_id: " + this.E0.getReading_site_id() + " readTime: " + i2 + "  chapter_path: " + this.O0;
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(obtainPresenter().f3247w)) {
            try {
                this.M0 = y().get(this.currentChpaterId);
                this.O0 = this.M0.getPath();
                this.N0 = this.M0.getUrl();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (com.amgcyo.cuttadon.utils.otherutils.h.P0()) {
            obtainPresenter().i(Message.a(this, new Object[]{Integer.valueOf(this.E0.getBook_id()), this.O0, this.E0.getReading_site_id(), Integer.valueOf(i2), 906, Integer.valueOf(this.E0.getForm())}));
        }
    }

    public /* synthetic */ void a(TextView textView, TextView textView2) {
        com.amgcyo.cuttadon.utils.otherutils.k kVar = this.W0;
        if (kVar != null) {
            if (textView2 != null) {
                textView2.setTextColor(kVar.b);
                textView2.setText(com.amgcyo.cuttadon.f.o.d(R.string.read_wait_update));
            }
            if (textView != null) {
                textView.setText("正在请求章节...");
                textView.setTextColor(this.W0.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull RecyclerView recyclerView) {
        int i2;
        TextView textView;
        if (this.f2276v == 0 || this.D1 == null || y() == null) {
            return;
        }
        this.Q1 = this.D1.findFirstVisibleItemPosition();
        View viewFindViewByPosition = this.D1.findViewByPosition(this.Q1);
        if (viewFindViewByPosition == null) {
            return;
        }
        this.P1 = (ChapterAlignTextView) viewFindViewByPosition.findViewById(R.id.tv_chapter_content);
        if (this.P1 == null) {
            return;
        }
        TextView textView2 = (TextView) viewFindViewByPosition.findViewById(R.id.tv_chapter_title);
        TextView textView3 = this.chapter_name;
        if (textView3 != null && textView2 != null && !textView3.getText().equals(textView2.getText())) {
            this.chapter_name.setText(textView2.getText());
        }
        TextView textView4 = (TextView) viewFindViewByPosition.findViewById(R.id.tv_placeder);
        if (textView4 != null && !TextUtils.isEmpty(textView4.getText())) {
            int i3 = Integer.parseInt(textView4.getText().toString());
            if (this.currentChpaterId != i3) {
                this.currentChpaterId = i3;
                try {
                    this.M0 = y().get(this.currentChpaterId);
                    this.O0 = this.M0.getPath();
                    this.N0 = this.M0.getUrl();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                Q();
                a(this.E0, this.currentChpaterId);
            }
        } else {
            TextView textView5 = this.read_count;
            if (textView5 != null) {
                textView5.setText("正在计算...");
            }
        }
        this.K1 = this.P1.getLineNum();
        this.P1.getLineSpacingExtra();
        this.L1 = this.P1.getLineHeight();
        this.J1 = 0 - viewFindViewByPosition.getTop();
        int height = recyclerView.getHeight();
        this.O1 = this.P1.getLayout();
        this.N1 = this.P1.getText().toString();
        int i4 = this.K1;
        if (i4 <= 0 || (i2 = this.L1) <= 0) {
            return;
        }
        int i5 = this.J1;
        this.curPage = (i5 / height) + 1;
        this.totalPage = i4 / (height / i2);
        int i6 = i5 / i2;
        int i7 = i4 - 5;
        if (this.S1 != i6 && i6 < i7) {
            this.T1 = this.N1.substring(this.O1.getLineStart(i6), this.O1.getLineEnd(i6));
            for (int i8 = 0; i8 < i7 && this.T1.length() < 10; i8++) {
                int i9 = i6 + 1;
                if (i9 >= i7) {
                    break;
                }
                this.T1 = this.N1.substring(this.O1.getLineStart(i9), this.O1.getLineEnd(i9));
            }
            this.S1 = i6;
        }
        int i10 = this.curPage;
        int i11 = this.totalPage;
        if (i10 >= i11) {
            this.curPage = i11;
        }
        if (this.R1 == this.curPage || (textView = this.chapter_page) == null) {
            return;
        }
        textView.setText(String.format(Locale.getDefault(), "第%d/%d页", Integer.valueOf(this.curPage), Integer.valueOf(this.totalPage)));
        this.R1 = this.curPage;
    }

    public /* synthetic */ void a(String str, ObservableEmitter observableEmitter) throws Exception {
        observableEmitter.onNext(g(str));
        observableEmitter.onComplete();
    }
}
