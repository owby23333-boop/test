package com.amgcyo.cuttadon.activity.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.user.MkRequireActivity;
import com.amgcyo.cuttadon.adapter.other.j;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.comic.SearchHotkeyBean;
import com.amgcyo.cuttadon.api.entity.other.MkAutoKeyword;
import com.amgcyo.cuttadon.api.presenter.SearchPresenter;
import com.amgcyo.cuttadon.f.n;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.utils.otherutils.h;
import com.amgcyo.cuttadon.utils.otherutils.j0;
import com.amgcyo.cuttadon.utils.otherutils.r;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.u;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import com.amgcyo.cuttadon.view.otherview.AutoLinearLayoutManager;
import com.amgcyo.cuttadon.view.otherview.ProgressWheel;
import com.amgcyo.cuttadon.view.otherview.WanyiwanView;
import com.amgcyo.cuttadon.view.xtablayout.XTabLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import me.jessyan.art.base.d;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkSearchActivity extends BaseTitleBarActivity<SearchPresenter> {
    List<MkAutoKeyword> A0;

    @BindView(R.id.fl_ad)
    AdFrameLayout adFrameLayout;

    @BindView(R.id.et_search)
    EditText et_search;

    @BindView(R.id.img_change)
    ImageView img_change;

    @BindView(R.id.iv_cancel)
    ImageView iv_cancel;

    @BindView(R.id.ll_history)
    LinearLayout ll_history;

    @BindView(R.id.ll_toBookNull)
    LinearLayout ll_toBookNull;

    @BindView(R.id.lv_auto_list)
    RecyclerView lv_auto_list;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    Comparator f2779p0;

    @BindView(R.id.progress_wheel)
    ProgressWheel progress_wheel;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private String f2780q0;

    @BindView(R.id.rv_history_search)
    RecyclerView rv_history_search;

    @BindView(R.id.rv_hot_search)
    RecyclerView rv_hot_search;

    @BindView(R.id.tb_select)
    XTabLayout tb_select;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private com.amgcyo.cuttadon.adapter.other.e f2784u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private List<SearchHotkeyBean> f2785v0;

    @BindView(R.id.view_line)
    View view_line;

    @BindView(R.id.vp_classify)
    ViewPager vp_classify;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    com.amgcyo.cuttadon.b.d.a f2786w0;

    @BindView(R.id.wanyiwanview)
    WanyiwanView wanyiwanview;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    j f2788y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    com.amgcyo.cuttadon.b.d.b f2789z0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private List<String> f2777n0 = new ArrayList();

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private List<SearchHotkeyBean> f2778o0 = new ArrayList();

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f2781r0 = 1;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    String[] f2782s0 = {"小说 ", "漫画 "};

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private List<Fragment> f2783t0 = new ArrayList();

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private boolean f2787x0 = false;
    private Handler B0 = new Handler(Looper.getMainLooper());

    class a implements Observer<String> {
        a() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(String str) {
            if (TextUtils.isEmpty(str)) {
                MkSearchActivity mkSearchActivity = MkSearchActivity.this;
                mkSearchActivity.a(mkSearchActivity.progress_wheel, mkSearchActivity.iv_cancel, mkSearchActivity.lv_auto_list, mkSearchActivity.vp_classify, mkSearchActivity.tb_select, mkSearchActivity.view_line, mkSearchActivity.ll_toBookNull);
                MkSearchActivity mkSearchActivity2 = MkSearchActivity.this;
                mkSearchActivity2.b(mkSearchActivity2.ll_history, mkSearchActivity2.adFrameLayout);
                if (MkSearchActivity.this.f2784u0 != null) {
                    MkSearchActivity.this.f2784u0.a(MkSearchActivity.this.vp_classify);
                    return;
                }
                return;
            }
            MkSearchActivity mkSearchActivity3 = MkSearchActivity.this;
            mkSearchActivity3.b(mkSearchActivity3.iv_cancel);
            String str2 = "是否点击了键盘的搜索按钮：" + MkSearchActivity.this.f2787x0;
            if (MkSearchActivity.this.f2787x0) {
                return;
            }
            MkSearchActivity.this.o();
            String str3 = "textChanges:" + str;
            MkSearchActivity mkSearchActivity4 = MkSearchActivity.this;
            mkSearchActivity4.b(mkSearchActivity4.progress_wheel);
            ((SearchPresenter) ((BaseTitleBarActivity) MkSearchActivity.this).f2276v).a(Message.a(MkSearchActivity.this, new Object[]{str, Integer.valueOf(com.amgcyo.cuttadon.utils.otherutils.g.j0() ? 1 : 0)}));
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        P p2 = this.f2276v;
        if (p2 == 0 || ((SearchPresenter) p2).f3316v == null || ((SearchPresenter) p2).f3316v.isDisposed()) {
            return;
        }
        ((SearchPresenter) this.f2276v).f3316v.dispose();
        ProgressWheel progressWheel = this.progress_wheel;
        if (progressWheel != null) {
            progressWheel.setVisibility(8);
        }
    }

    private void p() {
        this.lv_auto_list.setLayoutManager(new AutoLinearLayoutManager(this.f2277w));
        this.f2786w0 = new com.amgcyo.cuttadon.b.d.a();
        this.lv_auto_list.setAdapter(this.f2786w0);
        this.f2786w0.a(new d.a() { // from class: com.amgcyo.cuttadon.activity.search.b
            @Override // me.jessyan.art.base.d.a
            public final void a(View view, int i2, Object obj, int i3) {
                this.a.a(view, i2, obj, i3);
            }
        });
        this.et_search.requestFocus();
        this.et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.amgcyo.cuttadon.activity.search.e
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return this.a.a(textView, i2, keyEvent);
            }
        });
        setEditTextStringChange();
    }

    private void q() {
        com.amgcyo.cuttadon.b.d.b bVar;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2777n0) || (bVar = this.f2789z0) == null) {
            return;
        }
        bVar.b((Collection) this.f2777n0);
    }

    private void r() {
        this.f2787x0 = true;
        this.et_search.setText(this.f2780q0);
        this.et_search.setSelection(this.f2780q0.length());
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public void cleanAutoCompleteData() {
        com.amgcyo.cuttadon.b.d.a aVar = this.f2786w0;
        if (aVar == null || com.amgcyo.cuttadon.utils.otherutils.g.a(aVar.b())) {
            return;
        }
        this.f2786w0.a();
    }

    public void cleanHistory() {
        h.g("");
        this.f2777n0.clear();
        com.amgcyo.cuttadon.b.d.b bVar = this.f2789z0;
        if (bVar != null) {
            bVar.b((Collection) this.f2777n0);
        }
        com.amgcyo.cuttadon.utils.otherutils.g.c((Activity) this);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (message.f21197s == 825) {
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(this.A0)) {
                this.A0.clear();
                this.A0 = null;
            }
            this.A0 = (List) message.f21202x;
            this.progress_wheel.setVisibility(8);
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.A0)) {
                showMessage("暂无推荐");
                b(this.ll_history);
                a(this.vp_classify, this.tb_select, this.view_line, this.lv_auto_list, this.ll_toBookNull);
                this.f2786w0.a();
                return;
            }
            b(this.lv_auto_list);
            a(this.vp_classify, this.tb_select, this.view_line, this.ll_history, this.ll_toBookNull);
            this.f2786w0.a(this.A0);
            this.f2786w0.notifyDataSetChanged();
        }
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        this.f2781r0 = 1;
        if (intent != null) {
            this.f2781r0 = intent.getIntExtra("form", 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("类型是：");
        sb.append(this.f2781r0);
        sb.append(" ：");
        sb.append(this.f2781r0 == 3 ? "漫画" : "小说");
        sb.toString();
        this.rv_hot_search.setLayoutManager(new GridLayoutManager(this.f2277w, 2));
        this.f2788y0 = new j();
        this.rv_hot_search.setAdapter(this.f2788y0);
        this.f2788y0.a(new BaseQuickAdapter.g() { // from class: com.amgcyo.cuttadon.activity.search.c
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.f2800s.a(baseQuickAdapter, view, i2);
            }
        });
        this.f2779p0 = new j0();
        String strA = com.amgcyo.cuttadon.utils.comic.d.a("hot_keyword", "");
        if (!TextUtils.isEmpty(strA)) {
            this.f2785v0 = r.b(strA, SearchHotkeyBean.class);
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2785v0)) {
                this.f2778o0 = com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2785v0, 8);
                Collections.sort(this.f2778o0, this.f2779p0);
                a(this.f2778o0);
            }
        }
        this.rv_history_search.setLayoutManager(new LinearLayoutManager(this.f2277w));
        this.f2789z0 = new com.amgcyo.cuttadon.b.d.b();
        this.rv_history_search.setAdapter(this.f2789z0);
        this.f2789z0.a(new BaseQuickAdapter.g() { // from class: com.amgcyo.cuttadon.activity.search.f
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.f2802s.b(baseQuickAdapter, view, i2);
            }
        });
        initSearchHistory();
        p();
        NormalAdParams normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a("position_search", "csj_new_position_lists");
        if (normalAdParamsA != null) {
            normalAdParamsA.setSelfAdPosition(n.f3712z);
            this.adFrameLayout.b(normalAdParamsA);
        }
        this.wanyiwanview.a(this.G, n.f3707u, this, 3);
    }

    public void initSearchHistory() {
        String strN0 = h.n0();
        if (!TextUtils.isEmpty(strN0)) {
            ArrayList arrayList = new ArrayList();
            String[] strArrSplit = strN0.split(",");
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                if (i2 < 8) {
                    arrayList.add(strArrSplit[i2]);
                }
            }
            this.f2777n0 = arrayList;
        }
        if (this.f2777n0.size() > 0) {
            q();
        }
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_search;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    public /* synthetic */ void n() {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2785v0)) {
            showMessage("暂无更多数据!");
            return;
        }
        this.f2778o0 = com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2785v0, 8);
        Collections.sort(this.f2778o0, this.f2779p0);
        a(this.f2778o0);
        this.img_change.clearAnimation();
        x0.c().a("[SEARCH]点击换一换");
    }

    @OnClick({R.id.iv_cancel, R.id.iv_delete_his, R.id.tv_cancel, R.id.ll_hot_search, R.id.tv_toBookCity})
    public void onClick(View view) {
        if (BaseTitleBarActivity.v()) {
            o.d(R.string.operating_busy);
        }
        switch (view.getId()) {
            case R.id.iv_cancel /* 2131297161 */:
                a(this.iv_cancel);
                cleanAutoCompleteData();
                this.et_search.setText("");
                setClickSearch(false);
                if (this.B0 == null) {
                    this.B0 = new Handler(Looper.getMainLooper());
                }
                com.amgcyo.cuttadon.utils.otherutils.g.a(this.et_search);
                break;
            case R.id.iv_delete_his /* 2131297167 */:
                cleanHistory();
                x0.c().a("[SEARCH]点击清除搜索历史");
                break;
            case R.id.ll_hot_search /* 2131297938 */:
                this.img_change.startAnimation(u.a(a()));
                if (this.B0 == null) {
                    this.B0 = new Handler(Looper.getMainLooper());
                }
                this.B0.postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.search.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2801s.n();
                    }
                }, 400L);
                break;
            case R.id.tv_cancel /* 2131298620 */:
                if (this.vp_classify.getVisibility() == 0 || this.ll_toBookNull.getVisibility() == 0) {
                    a(this.vp_classify, this.tb_select, this.view_line, this.lv_auto_list, this.ll_toBookNull);
                    b(this.ll_history, this.wanyiwanview);
                    com.amgcyo.cuttadon.adapter.other.e eVar = this.f2784u0;
                    if (eVar != null) {
                        eVar.a(this.vp_classify);
                        x0.c().a("[SEARCH]有搜索结果时取消搜索");
                    }
                } else {
                    com.amgcyo.cuttadon.utils.otherutils.g.c((Activity) this);
                    r0.a((Activity) a());
                    x0.c().a("[SEARCH]关闭搜索页面");
                }
                break;
            case R.id.tv_toBookCity /* 2131298852 */:
                r0.startActivity(this.f2277w, MkRequireActivity.class);
                break;
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        o();
    }

    public void saveHistory(String str) {
        String strN0 = h.n0();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (strN0.contains(str)) {
            strN0 = strN0.replace(str + ",", "");
        }
        if (!this.f2777n0.contains(str)) {
            a(str, strN0);
        } else {
            this.f2777n0.remove(str);
            a(str, strN0);
        }
    }

    public void setClickSearch(boolean z2) {
        this.f2787x0 = z2;
    }

    public void setEditTextStringChange() {
        com.amgcyo.cuttadon.j.g.d.a(this.et_search).debounce(900L, TimeUnit.MILLISECONDS).distinctUntilChanged(new BiPredicate() { // from class: com.amgcyo.cuttadon.activity.search.a
            @Override // io.reactivex.functions.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return MkSearchActivity.b((String) obj, (String) obj2);
            }
        }).switchMap(new Function() { // from class: com.amgcyo.cuttadon.activity.search.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return Observable.just((String) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.computation()).subscribe(new a());
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public SearchPresenter obtainPresenter() {
        return new SearchPresenter(me.jessyan.art.f.e.a(this));
    }

    private void c(int i2) {
        o();
        com.amgcyo.cuttadon.utils.otherutils.g.c((Activity) this);
        if (this.f2783t0.size() > 0) {
            this.f2783t0.clear();
        }
        if (com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
            this.f2782s0 = new String[]{"小说 "};
            this.f2783t0.add(com.amgcyo.cuttadon.e.a.c.b(this.f2780q0, 1));
            b(this.vp_classify);
            a(this.tb_select, this.view_line);
        } else {
            if (1 == i2) {
                this.f2782s0 = new String[]{"小说 ", "漫画 "};
                this.f2783t0.add(com.amgcyo.cuttadon.e.a.c.b(this.f2780q0, 1));
                this.f2783t0.add(com.amgcyo.cuttadon.e.a.c.b(this.f2780q0, 3));
            } else {
                this.f2782s0 = new String[]{"漫画 ", "小说 "};
                this.f2783t0.add(com.amgcyo.cuttadon.e.a.c.b(this.f2780q0, 3));
                this.f2783t0.add(com.amgcyo.cuttadon.e.a.c.b(this.f2780q0, 1));
            }
            b(this.tb_select, this.vp_classify, this.view_line);
        }
        this.f2784u0 = new com.amgcyo.cuttadon.adapter.other.e(getSupportFragmentManager(), this.f2782s0, this.f2783t0);
        this.vp_classify.setOffscreenPageLimit(this.f2782s0.length);
        this.vp_classify.setAdapter(this.f2784u0);
        if (!com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
            this.tb_select.setupWithViewPager(this.vp_classify);
        }
        a(this.lv_auto_list, this.ll_history, this.wanyiwanview);
        this.f2787x0 = true;
        ((SearchPresenter) this.f2276v).e(Message.a(this, new Object[]{this.f2780q0, Integer.valueOf(i2)}));
        x0.c().a(this.f2780q0, i2, "[SEARCH]开始搜索");
    }

    public /* synthetic */ void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        SearchHotkeyBean item;
        j jVar = this.f2788y0;
        if (jVar == null || (item = jVar.getItem(i2)) == null) {
            return;
        }
        String keyWord = item.getKeyWord();
        saveHistory(keyWord);
        this.f2780q0 = keyWord;
        r();
        String str = "item.getType():" + item.getType();
        c(item.getType());
        x0.c().a(this.f2780q0, item.getType(), "[SEARCH]点击热门搜索");
    }

    public /* synthetic */ void b(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        com.amgcyo.cuttadon.b.d.b bVar = this.f2789z0;
        if (bVar == null || this.f2276v == 0) {
            return;
        }
        this.f2780q0 = bVar.getItem(i2);
        r();
        String str = "isClickSearch:" + this.f2787x0;
        c(this.f2781r0);
        x0.c().a(this.f2780q0, this.f2781r0, "[SEARCH]点击历史搜索条目");
    }

    static /* synthetic */ boolean b(String str, String str2) throws Exception {
        return str.compareToIgnoreCase(str2) == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    public /* synthetic */ void a(View view, int i2, Object obj, int i3) {
        MkAutoKeyword mkAutoKeyword;
        int i4;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.A0) || (mkAutoKeyword = this.A0.get(i3)) == null) {
            return;
        }
        if (mkAutoKeyword.getType() == 2) {
            int form = mkAutoKeyword.getForm();
            r0.a(this.f2277w, mkAutoKeyword.getBook_id(), form);
            i4 = form;
        } else {
            ?? J0 = com.amgcyo.cuttadon.utils.otherutils.g.j0();
            r0.a(this.f2277w, mkAutoKeyword.getName(), (int) J0);
            i4 = J0;
        }
        x0.c().a(mkAutoKeyword.getName(), i4, "[SEARCH]点击自动提示结果条目");
    }

    public /* synthetic */ boolean a(TextView textView, int i2, KeyEvent keyEvent) {
        if (i2 != 3) {
            return false;
        }
        String string = this.et_search.getText().toString();
        if (!TextUtils.isEmpty(string)) {
            saveHistory(string);
            this.f2780q0 = string;
            com.amgcyo.cuttadon.adapter.other.e eVar = this.f2784u0;
            if (eVar != null) {
                eVar.a(this.vp_classify);
            }
            c(this.f2781r0);
            return true;
        }
        showMessage("搜索内容不能为空");
        return true;
    }

    private void a(List<SearchHotkeyBean> list) {
        j jVar;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(list) || (jVar = this.f2788y0) == null) {
            return;
        }
        jVar.b((Collection) list);
    }

    private void a(String str, String str2) {
        this.f2777n0.add(0, str);
        if (this.f2777n0.size() > 10) {
            this.f2777n0.remove(r0.size() - 1);
        }
        q();
        h.g(str + "," + str2);
    }
}
