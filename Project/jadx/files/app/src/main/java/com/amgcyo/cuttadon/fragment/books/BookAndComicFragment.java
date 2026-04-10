package com.amgcyo.cuttadon.fragment.books;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.shelf.BookShelfCleanaupActivity;
import com.amgcyo.cuttadon.activity.user.MkRequireActivity;
import com.amgcyo.cuttadon.api.entity.other.DnsResult;
import com.amgcyo.cuttadon.api.entity.other.ShelfSortBean;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.view.dialog.q1;
import com.amgcyo.cuttadon.view.dialog.t0;
import com.amgcyo.cuttadon.view.otherview.n;
import com.amgcyo.cuttadon.view.xtablayout.XTabLayout;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BookAndComicFragment extends com.amgcyo.cuttadon.fragment.base.a implements n.a, com.amgcyo.cuttadon.d.a {
    private List<Fragment> G = new ArrayList();
    private int H = 0;
    private com.amgcyo.cuttadon.view.otherview.n I;
    private q1 J;
    private com.amgcyo.cuttadon.view.dialog.t0 K;
    private String L;
    private String M;
    private int N;
    private int O;

    @BindView(R.id.iv_colse_notice)
    ImageView iv_colse_notice;

    @BindView(R.id.iv_laba)
    ImageView iv_laba;

    @BindView(R.id.ll_bar)
    LinearLayout llBar;

    @BindView(R.id.ll_notice)
    LinearLayout ll_notice;

    @BindView(R.id.rl_head)
    RelativeLayout rl_head;

    @BindView(R.id.tb_select)
    XTabLayout tb_select;

    @BindView(R.id.tv_notice)
    TextView tv_notice;

    @BindView(R.id.tv_sologon)
    ImageView tv_sologon;

    @BindView(R.id.vp_classify)
    ViewPager vp_classify;

    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            MkBookshelfFragment mkBookshelfFragment;
            BookAndComicFragment.this.H = 1;
            if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) BookAndComicFragment.this.G) || (mkBookshelfFragment = (MkBookshelfFragment) BookAndComicFragment.this.G.get(i2)) == null) {
                return;
            }
            BookAndComicFragment.this.H = mkBookshelfFragment.O;
            if (3 == BookAndComicFragment.this.H) {
                com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[TAB]3");
            } else {
                com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[TAB]1");
            }
        }
    }

    private void m() {
    }

    private void o() {
        if (TextUtils.isEmpty(this.M) || !this.M.startsWith("http")) {
            return;
        }
        com.amgcyo.cuttadon.f.o.a(this.f3725t, this.N, this.M);
    }

    private void p() {
        String strD = com.amgcyo.cuttadon.utils.otherutils.g0.a().d("notice_title");
        final String strD2 = com.amgcyo.cuttadon.utils.otherutils.g0.a().d("notice_url");
        if (!TextUtils.isEmpty(strD) && !TextUtils.isEmpty(strD2)) {
            b(this.ll_notice);
            this.tv_notice.setText(strD);
            this.tv_notice.setSelected(true);
            this.tv_notice.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.fragment.books.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f3814s.b(strD2, view);
                }
            });
            this.iv_colse_notice.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.fragment.books.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f3810s.d(view);
                }
            });
            return;
        }
        final String strC0 = com.amgcyo.cuttadon.utils.otherutils.h.C0();
        if (TextUtils.isEmpty(strC0)) {
            this.tv_notice.setSelected(false);
            a(this.ll_notice, this.tv_notice);
            return;
        }
        b(this.ll_notice);
        String strReplace = strC0.replace("https:", "").replace("http:", "").replace("/", "");
        this.tv_notice.setSelected(true);
        this.tv_notice.setAutoLinkMask(15);
        int iB = com.amgcyo.cuttadon.f.o.b(R.color.a2a9b2);
        this.tv_notice.setTextColor(iB);
        this.iv_colse_notice.setColorFilter(iB);
        this.iv_laba.setColorFilter(iB);
        SpannableString spannableString = new SpannableString("App唯一官方网站: " + strReplace);
        spannableString.setSpan(new URLSpan(strReplace), 11, spannableString.length(), 33);
        this.tv_notice.setText(spannableString);
        com.amgcyo.cuttadon.f.o.b(this.tv_notice);
        this.tv_notice.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.fragment.books.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3820s.a(strC0, view);
            }
        });
        this.iv_colse_notice.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.fragment.books.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3818s.c(view);
            }
        });
    }

    @Override // me.jessyan.art.base.f.i
    public int a() {
        return R.layout.fragment_book_and_comic;
    }

    public /* synthetic */ void c(int i2) {
        com.amgcyo.cuttadon.view.showcaseview.f fVar = new com.amgcyo.cuttadon.view.showcaseview.f(getActivity());
        FragmentActivity activity = getActivity();
        XTabLayout xTabLayout = this.tb_select;
        fVar.a(com.amgcyo.cuttadon.f.o.a(activity, xTabLayout, "点击“小说”或“漫画”可以切换收藏哦\n赶快试试吧~", new com.amgcyo.cuttadon.view.showcaseview.i.d(xTabLayout.getWidth(), this.rl_head.getHeight()), 30, 1, 30, new t0(this, i2)));
        fVar.b();
    }

    @Override // com.amgcyo.cuttadon.view.otherview.n.a
    public void d() {
        this.J = new q1(this.f3725t);
        this.J.show();
        this.J.a(new q1.a() { // from class: com.amgcyo.cuttadon.fragment.books.b
            @Override // com.amgcyo.cuttadon.view.dialog.q1.a
            public final void a(ShelfSortBean shelfSortBean) {
                me.jessyan.art.d.f.a().a(new MkCommentEvent(32767), "comic_tag_sort_shelf");
            }
        });
        this.J.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.amgcyo.cuttadon.fragment.books.e
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f3807s.b(dialogInterface);
            }
        });
    }

    @Override // com.amgcyo.cuttadon.view.otherview.n.a
    public void e() {
        com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, MkRequireActivity.class);
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        String[] strArr;
        final int iA;
        super.f();
        this.H = 1;
        MkBookshelfFragment mkBookshelfFragmentD = MkBookshelfFragment.d(1);
        MkBookshelfFragment mkBookshelfFragmentD2 = MkBookshelfFragment.d(3);
        if (com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
            this.G.add(mkBookshelfFragmentD);
            strArr = new String[]{""};
            this.H = 1;
        } else {
            this.G.add(mkBookshelfFragmentD);
            this.G.add(mkBookshelfFragmentD2);
            strArr = new String[]{"小说 ", "漫画 "};
            this.H = 1;
        }
        this.vp_classify.setOffscreenPageLimit(strArr.length);
        this.vp_classify.setAdapter(new com.amgcyo.cuttadon.adapter.other.e(getChildFragmentManager(), strArr, this.G));
        this.vp_classify.addOnPageChangeListener(new a());
        if (com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
            this.tb_select.setVisibility(8);
            this.tv_sologon.setVisibility(0);
        } else {
            this.tb_select.setupWithViewPager(this.vp_classify);
            this.tv_sologon.setVisibility(8);
            this.tb_select.setVisibility(0);
        }
        if (!com.amgcyo.cuttadon.utils.otherutils.g.j0() && (iA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("shelf_guider", 0)) < 1) {
            this.tb_select.post(new Runnable() { // from class: com.amgcyo.cuttadon.fragment.books.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3802s.c(iA);
                }
            });
        }
        a(this.ll_notice);
        new com.amgcyo.cuttadon.d.b(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "ns1.nmgrygc.com");
    }

    @Override // me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
    }

    public /* synthetic */ void l() {
        com.amgcyo.cuttadon.f.o.a(this.f3725t, this.N, this.M);
    }

    @Override // me.jessyan.art.base.f.i
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.llBar);
    }

    @OnClick({R.id.iv_menu, R.id.iv_search})
    public void onClick(View view) {
        Context context;
        if (com.amgcyo.cuttadon.fragment.base.a.n()) {
            com.amgcyo.cuttadon.f.o.d(R.string.operating_busy);
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_menu) {
            if (this.I == null) {
                this.I = new com.amgcyo.cuttadon.view.otherview.n(this.f3725t);
                this.I.a(this);
            }
            this.I.showAsDropDown(this.rl_head, 0, 0, 85);
            return;
        }
        if (id == R.id.iv_search && (context = this.f3725t) != null) {
            com.amgcyo.cuttadon.utils.otherutils.r0.c(context, this.H);
            String str = "search_" + this.H;
            com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[SHELF]搜索");
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.amgcyo.cuttadon.d.a
    public void processFinish(@NonNull DnsResult dnsResult) {
        try {
            dnsResult.toString();
            String msg = dnsResult.getMsg();
            if (TextUtils.isEmpty(msg)) {
                throw new Exception("dnsresult txtRecord is null ");
            }
            int code = dnsResult.getCode();
            if (100 != code) {
                throw new Exception("dnsresult error code:" + code);
            }
            String domain = dnsResult.getDomain();
            if ("ns1.nmgrygc.com".equals(domain)) {
                this.L = msg;
                new com.amgcyo.cuttadon.d.b(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "ns2.nmgrygc.com");
                return;
            }
            if ("ns2.nmgrygc.com".equals(domain)) {
                String[] strArrSplit = msg.split("\\|");
                String str = "分割长度：" + strArrSplit.length;
                if (strArrSplit.length >= 2) {
                    this.M = strArrSplit[0];
                    this.N = Integer.valueOf(strArrSplit[1]).intValue();
                    this.O = Integer.valueOf(strArrSplit[2]).intValue();
                }
                m();
            }
        } catch (Exception unused) {
            m();
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        this.D = z2;
    }

    @Override // com.amgcyo.cuttadon.view.otherview.n.a
    public void b(int i2) {
        me.jessyan.art.d.f.a().a(new MkCommentEvent(i2), "comic_tag_sort_shelf");
    }

    public /* synthetic */ void b(DialogInterface dialogInterface) {
        this.J = null;
    }

    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.K = null;
    }

    @Override // com.amgcyo.cuttadon.view.otherview.n.a
    public void b() {
        this.K = new com.amgcyo.cuttadon.view.dialog.t0(this.f3725t);
        this.K.show();
        this.K.a(new t0.a() { // from class: com.amgcyo.cuttadon.fragment.books.i
            @Override // com.amgcyo.cuttadon.view.dialog.t0.a
            public final void onClick(int i2) {
                me.jessyan.art.d.f.a().a(new MkCommentEvent(i2), "tag_restore_data");
            }
        });
        this.K.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.amgcyo.cuttadon.fragment.books.j
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f3816s.a(dialogInterface);
            }
        });
    }

    public /* synthetic */ void a(View view) {
        o();
    }

    public /* synthetic */ void a(String str, View view) {
        com.amgcyo.cuttadon.f.o.a(this.f3725t, str, R.string.website_copy_suc);
        com.amgcyo.cuttadon.view.webview.b.startActivity(this.f3725t, str);
    }

    @Override // com.amgcyo.cuttadon.view.otherview.n.a
    public void c() {
        Intent intent = new Intent(this.f3725t, (Class<?>) BookShelfCleanaupActivity.class);
        intent.putExtra("form", 1);
        intent.putExtra("type_id", 10);
        this.f3725t.startActivity(intent);
    }

    public /* synthetic */ void d(View view) {
        this.tv_notice.setSelected(false);
        a(this.ll_notice, this.tv_notice);
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("notice_title", "");
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("notice_url", "");
    }

    public /* synthetic */ void b(View view) {
        this.tv_notice.setSelected(false);
        a(this.ll_notice, this.tv_notice);
    }

    public /* synthetic */ void b(String str, View view) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.amgcyo.cuttadon.f.o.a(this.f3725t, this.N, str);
    }

    public /* synthetic */ void c(View view) {
        this.tv_notice.setSelected(false);
        a(this.ll_notice, this.tv_notice);
    }
}
