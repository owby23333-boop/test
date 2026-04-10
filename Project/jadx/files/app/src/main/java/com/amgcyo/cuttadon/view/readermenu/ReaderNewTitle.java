package com.amgcyo.cuttadon.view.readermenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.presenter.CatalogPresenter;
import com.amgcyo.cuttadon.f.n;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.utils.otherutils.a0;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.i0;
import com.amgcyo.cuttadon.utils.otherutils.k;
import com.amgcyo.cuttadon.utils.otherutils.m;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import com.amgcyo.cuttadon.utils.otherutils.z;
import com.amgcyo.cuttadon.view.dialog.v1;
import com.amgcyo.cuttadon.view.showcaseview.MaterialShowcaseView;
import com.amgcyo.cuttadon.view.showcaseview.e;
import com.amgcyo.cuttadon.view.showcaseview.f;
import com.amgcyo.cuttadon.view.showcaseview.h;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class ReaderNewTitle extends LinearLayout implements View.OnClickListener {
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private k E;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ImageView f5398s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ImageView f5399t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private PopupWindow f5400u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private AdFrameLayout f5401v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    ImageView f5402w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    ImageView f5403x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private LinearLayout f5404y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private LinearLayout f5405z;

    class a implements e {
        a(ReaderNewTitle readerNewTitle) {
        }

        @Override // com.amgcyo.cuttadon.view.showcaseview.e
        public void a(MaterialShowcaseView materialShowcaseView) {
        }

        @Override // com.amgcyo.cuttadon.view.showcaseview.e
        public void b(MaterialShowcaseView materialShowcaseView) {
            g0.a().b("tip_read_top_showcase", true);
        }
    }

    class b implements e {
        b(ReaderNewTitle readerNewTitle) {
        }

        @Override // com.amgcyo.cuttadon.view.showcaseview.e
        public void a(MaterialShowcaseView materialShowcaseView) {
        }

        @Override // com.amgcyo.cuttadon.view.showcaseview.e
        public void b(MaterialShowcaseView materialShowcaseView) {
            g0.a().b("tip_read_top_showcase", true);
        }
    }

    class c implements e {
        c() {
        }

        @Override // com.amgcyo.cuttadon.view.showcaseview.e
        public void a(MaterialShowcaseView materialShowcaseView) {
        }

        @Override // com.amgcyo.cuttadon.view.showcaseview.e
        public void b(MaterialShowcaseView materialShowcaseView) {
            ReaderNewTitle.this.g();
        }
    }

    public ReaderNewTitle(Context context) {
        this(context, null);
    }

    private void e() {
        h();
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        ((MkNovelBaseReaderActivity) getContext()).hideMenuPanel(true);
        MkBook book = getActivity().getBook();
        if (book == null) {
            return;
        }
        r0.a(getActivity(), book.getBook_id(), book.getForm());
    }

    private void f() {
        MkBook book;
        if (getActivity() == null || getActivity().isFinishing() || (book = getActivity().getBook()) == null) {
            return;
        }
        r0.c(getActivity(), book);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        MkNovelBaseReaderActivity mkNovelBaseReaderActivity = (MkNovelBaseReaderActivity) getContext();
        if (z.a()) {
            mkNovelBaseReaderActivity.showNotUseDialog();
        } else {
            mkNovelBaseReaderActivity.getDownloadInfo();
        }
    }

    private MkNovelBaseReaderActivity getActivity() {
        return (MkNovelBaseReaderActivity) getContext();
    }

    private void h() {
        PopupWindow popupWindow = this.f5400u;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.f5400u.dismiss();
    }

    private void i() {
        NormalAdParams normalAdParamsA;
        if (g.n0()) {
            if (com.amgcyo.cuttadon.h.a.c.b("position_top_chapter_ad") && (normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a("position_top_chapter_ad", "csj_new_position_lists", 1)) != null) {
                normalAdParamsA.setSelfAdPosition(n.I);
                this.f5401v.b(normalAdParamsA);
            }
            getActivity().setSourceUrlStatus(this.f5402w, this.f5404y, this.A, this.D);
        }
    }

    private void j() {
        l();
    }

    private void k() {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        h();
        ((MkNovelBaseReaderActivity) getContext()).hideMenuPanel(true);
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        o.b(getActivity());
    }

    private void l() {
        if (this.f5400u == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.popup_reader_more, (ViewGroup) null);
            this.f5400u = new PopupWindow(viewInflate, -2, -2, true);
            this.f5400u.setBackgroundDrawable(new ColorDrawable());
            this.f5400u.setOutsideTouchable(true);
            this.f5400u.setAnimationStyle(R.style.pop_add);
            ((CardView) viewInflate.findViewById(R.id.root_cardview)).setCardBackgroundColor(this.E.f4410n);
            TextView textView = (TextView) viewInflate.findViewById(R.id.textView_bookDetail);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.textView_shareBook);
            textView.setTextColor(this.E.f4407k);
            textView2.setTextColor(this.E.f4407k);
            textView2.setOnClickListener(this);
            viewInflate.findViewById(R.id.textView_bookDetail).setOnClickListener(this);
            textView2.setVisibility(0);
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.f5400u.showAtLocation(this, 53, com.amgcyo.cuttadon.utils.otherutils.n.a(getContext(), 16.0f), iArr[1] + getHeight());
    }

    private void m() {
        MkNovelBaseReaderActivity mkNovelBaseReaderActivity = (MkNovelBaseReaderActivity) getContext();
        if (o.a(mkNovelBaseReaderActivity, 2, 1)) {
            if (Build.VERSION.SDK_INT < 23) {
                a(mkNovelBaseReaderActivity);
            } else if (i0.b()) {
                a(mkNovelBaseReaderActivity);
            } else {
                mkNovelBaseReaderActivity.requestIgnoreBatteryOptimizations();
            }
        }
    }

    public void b() {
        if (!g0.a().a("tip_read_top_showcase", false) && g0.a().a("sp.is.open.guider.art", false)) {
            f fVar = new f(getActivity(), "tip_read_top_showcase");
            fVar.a(o.a(getActivity(), this.C, "听书功能点击这里~", new com.amgcyo.cuttadon.view.showcaseview.i.a(), 30, 1, 30, new a(this)));
            fVar.a(o.a(getActivity(), this.B, "点击这里可以缓存书籍哦~", new com.amgcyo.cuttadon.view.showcaseview.i.a(), 30, 1, 30, new b(this)));
            fVar.b();
        }
    }

    public void c() {
        try {
            new h().a(300L);
            f fVar = new f(getActivity());
            fVar.a(o.a(getActivity(), this.B, "点击这里缓存书籍~", new com.amgcyo.cuttadon.view.showcaseview.i.a(), 30, 1, 30, new c()));
            fVar.b();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d() {
    }

    public CatalogPresenter getPresenter() {
        return ((MkNovelBaseReaderActivity) getContext()).getPresenter();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        int id = view.getId();
        MkNovelBaseReaderActivity activity = getActivity();
        if (id == R.id.imageView_back) {
            if (activity != null) {
                activity.onBackPressed();
                return;
            }
            return;
        }
        if (id == R.id.tv_download) {
            if (me.jessyan.art.f.f.c(getContext())) {
                g();
                return;
            } else {
                if (getContext() instanceof BaseTitleBarActivity) {
                    ((BaseTitleBarActivity) getContext()).showMessage("网络错误!");
                    return;
                }
                return;
            }
        }
        if (id == R.id.tv_comment) {
            f();
            x0.c().a("[READ]点击书评");
            return;
        }
        if (id == R.id.imageView_more) {
            j();
            return;
        }
        if (id == R.id.textView_shareBook) {
            k();
            return;
        }
        if (id == R.id.textView_bookDetail) {
            e();
            return;
        }
        if (id != R.id.reader_ab_chapter_url_view) {
            if (id == R.id.tv_tts) {
                m();
                x0.c().a("[READ]点击听书");
                return;
            }
            return;
        }
        if (activity == null || (textView = this.A) == null) {
            return;
        }
        String string = textView.getText().toString();
        if (TextUtils.isEmpty(string) || !com.amgcyo.cuttadon.utils.otherutils.h.T0()) {
            return;
        }
        v1 v1Var = new v1(activity);
        v1Var.show();
        v1Var.a("请确认是否跳转到原网页：<br/> <a href='" + string + "'>" + string + "</a> <br/>进行阅读？<br/><br/><font color='#a2a9b2' size='12px'>免责声明：</font><br/><font color='#a2a9b2' size='12px'>原网页所有内容与本APP无关！请勿泄露你的账号密码等个人隐私信息，请勿相信原网页的广告内容、请勿随意点击原网页链接！</font>", string, "跳转");
    }

    public ReaderNewTitle(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.mk_view_reader_title, (ViewGroup) this, true);
        if (!(Build.VERSION.SDK_INT >= 24 ? ((Activity) getContext()).isInMultiWindowMode() : false)) {
            setPadding(0, a0.a(context), 0, 0);
        }
        setOrientation(1);
        this.f5398s = (ImageView) findViewById(R.id.imageView_back);
        this.f5401v = (AdFrameLayout) findViewById(R.id.ad_top);
        this.f5403x = (ImageView) findViewById(R.id.csj_line);
        this.f5402w = (ImageView) findViewById(R.id.url_line);
        this.f5404y = (LinearLayout) findViewById(R.id.reader_ab_chapter_url_view);
        this.f5405z = (LinearLayout) findViewById(R.id.aby_root);
        this.A = (TextView) findViewById(R.id.reader_ab_chapter_url);
        this.f5398s.setOnClickListener(this);
        this.B = (TextView) findViewById(R.id.tv_download);
        this.B.setOnClickListener(this);
        this.C = (TextView) findViewById(R.id.tv_tts);
        this.D = (TextView) findViewById(R.id.tv_show_ywy);
        boolean zL0 = com.amgcyo.cuttadon.utils.otherutils.h.L0();
        TextView textView = (TextView) findViewById(R.id.tv_comment);
        if (zL0) {
            textView.setVisibility(0);
            textView.setOnClickListener(this);
        } else {
            textView.setVisibility(8);
        }
        this.C.setOnClickListener(this);
        this.f5399t = (ImageView) findViewById(R.id.imageView_more);
        this.f5399t.setOnClickListener(this);
        this.f5404y.setOnClickListener(this);
    }

    public void a(MkNovelBaseReaderActivity mkNovelBaseReaderActivity) {
        mkNovelBaseReaderActivity.showTtsEngineChoiceDialog(g0.a().a("tts_engine_key", 0));
    }

    public void a(k kVar) {
        m.a(this.f5405z, kVar);
        m.a(this.f5404y, kVar);
        m.a(kVar.f4407k, this.f5402w, this.f5403x, this.f5398s, this.f5399t);
        this.E = kVar;
        if (getActivity().is_screen_orientation_landscape) {
            return;
        }
        i();
    }

    public void a() {
        AdFrameLayout adFrameLayout = this.f5401v;
        if (adFrameLayout == null) {
            return;
        }
        o.a((ViewGroup) adFrameLayout);
        this.f5401v.setVisibility(8);
        this.f5401v.removeAllViews();
    }
}
