package com.amgcyo.cuttadon.view.readermenu;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.amgcyo.cuttadon.activity.read.MkFontListActivity;
import com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity;
import com.amgcyo.cuttadon.activity.read.MkNovelSettingActivity;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.f.s.a;
import com.amgcyo.cuttadon.utils.event.NightModelEvent;
import com.amgcyo.cuttadon.utils.otherutils.c0;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.k0;
import com.amgcyo.cuttadon.utils.otherutils.m;
import com.amgcyo.cuttadon.utils.otherutils.q;
import com.amgcyo.cuttadon.utils.otherutils.t;
import com.amgcyo.cuttadon.utils.otherutils.w0;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import com.amgcyo.cuttadon.view.lightview.PageBgSelectorView;
import com.amgcyo.cuttadon.view.read.anim.PageAnimation;
import com.amgcyo.cuttadon.view.read.page.PageMode;
import com.amgcyo.cuttadon.view.read.page.PageView;
import com.amgcyo.cuttadon.view.read.page.k;
import com.amgcyo.cuttadon.view.showcaseview.h;
import com.amgcyo.cuttadon.widget.ui.HProgressBarWithNumber;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class ReaderMenuMain extends RelativeLayout implements View.OnClickListener, com.amgcyo.cuttadon.g.d, PageBgSelectorView.a {
    private ImageView A;
    private ImageView B;
    private ImageView C;
    private ImageView D;
    View E;
    View F;
    private SeekBar G;
    private SeekBar H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private TextView N;
    private HProgressBarWithNumber O;
    private LinearLayout P;
    private k Q;
    private boolean R;
    private boolean S;
    private PageBgSelectorView T;
    private PageBgSelectorView U;
    private PageBgSelectorView V;
    private PageBgSelectorView W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private PageBgSelectorView f5358a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private TextView f5359b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private TextView f5360c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private TextView f5361d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private TextView f5362e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private long f5363f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private LinearLayout f5364g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    NightModelEvent f5365h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    f f5366i0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ReaderNewTitle f5367s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private LinearLayout f5368t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private LinearLayout f5369u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private LinearLayout f5370v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private LinearLayout f5371w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private LinearLayout f5372x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private LinearLayout f5373y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private RelativeLayout f5374z;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            ((MkNovelBaseReaderActivity) ReaderMenuMain.this.getContext()).applyProgress(seekBar.getProgress());
            ReaderMenuMain.this.b();
        }
    }

    class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            if (z2) {
                ReaderMenuMain.this.Q.b(false);
                ReaderMenuMain.this.a(i2, false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            ReaderMenuMain.this.Q.d(seekBar.getProgress());
            ReaderMenuMain.this.Q.b(false);
            ReaderMenuMain.this.k();
        }
    }

    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            try {
                if (23 == ReaderMenuMain.this.getActivity().getTaskSourceType()) {
                    ReaderMenuMain.this.f5367s.d();
                } else if (24 == ReaderMenuMain.this.getActivity().getTaskCacheType()) {
                    String str = "类型：" + ReaderMenuMain.this.getActivity().getTaskCacheType();
                    ReaderMenuMain.this.f5367s.c();
                } else {
                    ReaderMenuMain.this.f5367s.b();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (g0.a().a("tip_read_top_showcase", false)) {
                ReaderMenuMain.this.d();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    class e implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Runnable f5377s;

        e(Runnable runnable) {
            this.f5377s = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5377s.run();
            MkNovelBaseReaderActivity mkNovelBaseReaderActivity = (MkNovelBaseReaderActivity) ReaderMenuMain.this.getContext();
            if (mkNovelBaseReaderActivity == null) {
                return;
            }
            mkNovelBaseReaderActivity.refreshTopBottomTipStatus();
            if (ReaderMenuMain.this.f5367s != null) {
                ReaderMenuMain.this.f5367s.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public interface f {
        void a(com.amgcyo.cuttadon.utils.otherutils.k kVar);
    }

    public ReaderMenuMain(Context context) {
        this(context, null);
    }

    private void e() {
        this.N.setText(String.valueOf(m()));
    }

    private void f() {
        this.N.setText(String.valueOf(l()));
    }

    private synchronized void g() {
        MkNovelBaseReaderActivity mkNovelBaseReaderActivity = (MkNovelBaseReaderActivity) getContext();
        if (mkNovelBaseReaderActivity == null) {
            return;
        }
        mkNovelBaseReaderActivity.startSourcePopup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MkNovelBaseReaderActivity getActivity() {
        return (MkNovelBaseReaderActivity) getContext();
    }

    private void h() {
        MkNovelBaseReaderActivity mkNovelBaseReaderActivity = (MkNovelBaseReaderActivity) getContext();
        if (mkNovelBaseReaderActivity == null) {
            return;
        }
        mkNovelBaseReaderActivity.applyNextChapterClick();
    }

    private void i() {
        MkNovelBaseReaderActivity mkNovelBaseReaderActivity = (MkNovelBaseReaderActivity) getContext();
        if (mkNovelBaseReaderActivity == null) {
            return;
        }
        mkNovelBaseReaderActivity.applyPreChapterClick();
    }

    private void j() {
        this.T.setSelect(false);
        this.U.setSelect(false);
        this.V.setSelect(false);
        this.W.setSelect(false);
        this.f5358a0.setSelect(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.S = this.Q.g();
        if (this.S) {
            o.a(this.M, getActivity().getResources().getDrawable(R.drawable.ld_checked));
        } else {
            o.a(this.M, getActivity().getResources().getDrawable(R.drawable.ld_unchecked));
        }
    }

    private int l() {
        int iB = this.Q.b(getContext()) - 1;
        if (iB < 0) {
            iB = 0;
        }
        if (iB <= 10) {
            o.b("字体已是最小值");
            iB = 10;
        }
        a(iB, 0);
        return iB;
    }

    private int m() {
        int iB = this.Q.b(getContext());
        String str = "fontSizeNew: " + iB;
        int i2 = iB + 1;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 >= 60) {
            o.b("字体已是最大值");
            i2 = 60;
        }
        String str2 = "textSizeIndex: " + i2;
        a(i2, 0);
        return i2;
    }

    private void n() {
        MkNovelBaseReaderActivity mkNovelBaseReaderActivity = (MkNovelBaseReaderActivity) getContext();
        if (g.h0()) {
            this.f5358a0.setAlpha(1.0f);
            this.f5358a0.setSelect(false);
            String strI = k.c(getContext()).i();
            g.e(false);
            mkNovelBaseReaderActivity.applyColorStyle(strI);
        } else {
            g.e(true);
            mkNovelBaseReaderActivity.applyColorStyle("night");
            this.f5358a0.setAlpha(0.5f);
            this.f5358a0.setSelect(true);
        }
        f fVar = this.f5366i0;
        if (fVar != null) {
            fVar.a(mkNovelBaseReaderActivity.getReaderColorStyle());
        }
        if (this.f5365h0 == null) {
            this.f5365h0 = new NightModelEvent();
        }
        b();
    }

    private void o() {
        getActivity().startAutoRead(this.Q.b(), this.Q.c(), true);
    }

    private void p() {
        MkNovelBaseReaderActivity mkNovelBaseReaderActivity = (MkNovelBaseReaderActivity) getContext();
        if (mkNovelBaseReaderActivity == null || mkNovelBaseReaderActivity.getBook() == null) {
            return;
        }
        mkNovelBaseReaderActivity.startCatalog();
    }

    public LinearLayout getLl_download() {
        return this.P;
    }

    public HProgressBarWithNumber getProgressBar() {
        return this.O;
    }

    public ReaderNewTitle getReaderTitleView() {
        return this.f5367s;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getActivity() == null || q.a()) {
            return;
        }
        int id = view.getId();
        switch (id) {
            case R.id.tv_anim_auto /* 2131298589 */:
                o();
                break;
            case R.id.tv_anim_fg /* 2131298590 */:
                a(PageMode.COVER.ordinal(), view);
                break;
            case R.id.tv_anim_fz /* 2131298591 */:
                a(PageMode.SIMULATION.ordinal(), view);
                break;
            case R.id.tv_anim_sx /* 2131298592 */:
                a(PageMode.SCROLL.ordinal(), view);
                break;
            case R.id.tv_eyemode /* 2131298689 */:
                this.R = !this.R;
                g.d(this.R);
                getActivity().setEye_protection_viewStatus(this.R);
                if (!this.R) {
                    o.a(this.L, getActivity().getResources().getDrawable(R.drawable.show_eyemodel));
                } else {
                    o.a(this.L, getActivity().getResources().getDrawable(R.drawable.hide_eyemodel));
                }
                break;
            case R.id.tv_font_add /* 2131298711 */:
                e();
                break;
            case R.id.tv_font_cut /* 2131298712 */:
                f();
                break;
            case R.id.tv_sys_ld /* 2131298827 */:
                k kVar = this.Q;
                if (kVar == null) {
                    return;
                }
                this.S = true ^ this.S;
                kVar.b(this.S);
                getActivity().setSystemBrightnessModeType(this.S);
                k();
                a(this.Q.f(), this.S);
                break;
            case R.id.tv_typefont /* 2131298868 */:
                getActivity().startActivity(new Intent(getContext(), (Class<?>) MkFontListActivity.class));
                getActivity().hideMenuPanel(true);
                break;
        }
        if (id == R.id.menu_chapter) {
            p();
            x0.c().a("[READ]点击目录");
            return;
        }
        if (id == R.id.tv_setting) {
            a();
            return;
        }
        if (id == R.id.menu_brightness) {
            n();
            x0.c().a("[READ]切换夜间");
            return;
        }
        if (id == R.id.menu_setting) {
            if (this.f5364g0.getVisibility() == 8) {
                this.f5364g0.clearAnimation();
                t.a(this.f5364g0, 3, this.f5373y.getHeight());
                o.a(this.A, R.drawable.icon_shezhi_selected);
                this.f5374z.setVisibility(8);
                this.f5372x.setVisibility(8);
            } else {
                t.a(this.f5372x, 3, this.f5373y.getHeight());
                t.a(this.f5374z, 3, this.f5373y.getHeight());
                o.a(this.A, R.drawable.icon_shezhi);
                this.f5364g0.setVisibility(8);
            }
            x0.c().a("[READ]设置");
            return;
        }
        if (id == R.id.textView_preChapter) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f5363f0 < 500) {
                return;
            }
            this.f5363f0 = jCurrentTimeMillis;
            i();
            return;
        }
        if (id != R.id.textView_nextChapter) {
            if (id == R.id.toggleButton_mode) {
                g();
                x0.c().a("[READ]换源");
                return;
            }
            return;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (jCurrentTimeMillis2 - this.f5363f0 < 500) {
            return;
        }
        this.f5363f0 = jCurrentTimeMillis2;
        h();
    }

    public void setListener(f fVar) {
        this.f5366i0 = fVar;
    }

    public ReaderMenuMain(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5363f0 = 0L;
        a(context);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.view.readermenu.ReaderMenuMain.b():void");
    }

    public void c() {
        this.f5367s.setTranslationY(-r0.getMeasuredHeight());
        this.f5367s.animate().translationY(0.0f).setListener(new c());
        this.f5368t.setTranslationY(r0.getMeasuredHeight());
        this.f5368t.animate().translationY(0.0f).setListener(new d());
        this.f5374z.setScaleX(0.0f);
        this.f5374z.setScaleY(0.0f);
        this.f5374z.animate().scaleX(1.0f).scaleY(1.0f);
        b();
    }

    public void d() {
        new h().a(300L);
        com.amgcyo.cuttadon.view.showcaseview.f fVar = new com.amgcyo.cuttadon.view.showcaseview.f(getActivity(), "tip_read_bottom_showcase");
        fVar.a(o.a(getActivity(), this.f5371w, "字体大小，阅读背景，字体，\n翻页模式全部在这里哦~", new com.amgcyo.cuttadon.view.showcaseview.i.a(), 30, 1, 30, null));
        fVar.b();
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.mk_view_menu_main, (ViewGroup) this, true);
        this.f5367s = (ReaderNewTitle) findViewById(R.id.readerTitleView);
        this.f5368t = (LinearLayout) findViewById(R.id.layout_toolBar);
        this.f5371w = (LinearLayout) findViewById(R.id.menu_setting);
        this.f5372x = (LinearLayout) findViewById(R.id.menu_main);
        this.C = (ImageView) findViewById(R.id.img_line);
        this.f5373y = (LinearLayout) findViewById(R.id.ll_bottom);
        this.f5369u = (LinearLayout) findViewById(R.id.ll_font_set);
        this.f5370v = (LinearLayout) findViewById(R.id.ll_anim);
        this.f5364g0 = (LinearLayout) findViewById(R.id.menu_set);
        this.O = (HProgressBarWithNumber) findViewById(R.id.pb_download_pregress);
        this.P = (LinearLayout) findViewById(R.id.ll_download);
        this.f5374z = (RelativeLayout) findViewById(R.id.toggleButton_mode);
        this.K = (TextView) findViewById(R.id.tv_day_night);
        this.A = (ImageView) findViewById(R.id.iv_seting);
        this.B = (ImageView) findViewById(R.id.img_day_night);
        this.D = (ImageView) findViewById(R.id.img_category);
        this.E = findViewById(R.id.view_line);
        this.F = findViewById(R.id.view_line1);
        this.J = (TextView) findViewById(R.id.tv_tts_name);
        ((TextView) findViewById(R.id.tv_setting)).setOnClickListener(this);
        this.I = (TextView) findViewById(R.id.textView_percent);
        this.G = (SeekBar) findViewById(R.id.seekBar_readProgress);
        this.H = (SeekBar) findViewById(R.id.sb_light);
        this.f5359b0 = (TextView) findViewById(R.id.tv_anim_fz);
        this.f5360c0 = (TextView) findViewById(R.id.tv_anim_fg);
        this.f5361d0 = (TextView) findViewById(R.id.tv_anim_sx);
        this.f5362e0 = (TextView) findViewById(R.id.tv_anim_auto);
        w0.a(this, this.f5359b0, this.f5360c0, this.f5361d0, this.f5362e0);
        this.T = (PageBgSelectorView) findViewById(R.id.pbv_white);
        this.U = (PageBgSelectorView) findViewById(R.id.pbv_yellow);
        this.V = (PageBgSelectorView) findViewById(R.id.pbv_blue);
        this.W = (PageBgSelectorView) findViewById(R.id.pbv_green);
        this.f5358a0 = (PageBgSelectorView) findViewById(R.id.pbv_night);
        this.T.setListener(this);
        this.U.setListener(this);
        this.V.setListener(this);
        this.W.setListener(this);
        this.f5358a0.setListener(this);
        this.N = (TextView) findViewById(R.id.tv_font_size);
        this.L = (TextView) findViewById(R.id.tv_eyemode);
        this.L.setOnClickListener(this);
        this.M = (TextView) findViewById(R.id.tv_sys_ld);
        this.M.setOnClickListener(this);
        findViewById(R.id.tv_font_add).setOnClickListener(this);
        findViewById(R.id.tv_font_cut).setOnClickListener(this);
        findViewById(R.id.tv_typefont).setOnClickListener(this);
        findViewById(R.id.menu_chapter).setOnClickListener(this);
        findViewById(R.id.menu_brightness).setOnClickListener(this);
        findViewById(R.id.menu_setting).setOnClickListener(this);
        findViewById(R.id.textView_preChapter).setOnClickListener(this);
        findViewById(R.id.textView_nextChapter).setOnClickListener(this);
        this.f5374z.setOnClickListener(this);
        this.G.setOnSeekBarChangeListener(new a());
        this.H.setOnSeekBarChangeListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, boolean z2) {
        if (z2) {
            this.H.setProgress(c0.c(getActivity()));
            c0.b(getActivity(), -1);
        } else {
            this.H.setProgress(i2);
            c0.c(getActivity(), i2);
        }
    }

    public void a(Runnable runnable) {
        this.f5367s.setTranslationY(0.0f);
        this.f5367s.animate().translationY(-this.f5367s.getMeasuredHeight()).setListener(null);
        this.f5368t.setTranslationY(0.0f);
        this.f5368t.animate().translationY(this.f5368t.getMeasuredHeight()).setListener(new e(runnable));
        this.f5374z.setScaleX(1.0f);
        this.f5374z.setScaleY(1.0f);
        this.f5374z.animate().scaleX(0.0f).scaleY(0.0f);
        this.f5364g0.setVisibility(8);
        this.f5374z.setVisibility(0);
        this.f5372x.setVisibility(0);
        o.a(this.A, R.drawable.icon_shezhi);
    }

    public void a() {
        if (getActivity() == null) {
            return;
        }
        com.amgcyo.cuttadon.f.s.a.c((FragmentActivity) getActivity()).startActivityForResult(new Intent(getActivity(), (Class<?>) MkNovelSettingActivity.class), new a.InterfaceC0088a() { // from class: com.amgcyo.cuttadon.view.readermenu.a
            @Override // com.amgcyo.cuttadon.f.s.a.InterfaceC0088a
            public final void a(int i2, Intent intent) {
                this.a.a(i2, intent);
            }
        });
    }

    public /* synthetic */ void a(int i2, Intent intent) {
        PageView pageView = getActivity().getPageView();
        if (pageView != null) {
            PageAnimation pageAnimation = pageView.getmPageAnim();
            if (pageAnimation instanceof com.amgcyo.cuttadon.view.read.anim.c) {
                boolean zA = g0.a().a("is_allclicknext", false);
                String str = "fullPageMode：" + zA;
                ((com.amgcyo.cuttadon.view.read.anim.c) pageAnimation).a(zA);
            }
        }
        getActivity().applyKeepOn(g0.a().a("is_screen_keep_on", false));
    }

    private void a(int i2, View view) {
        a(view);
        this.Q.a(PageMode.values()[i2]);
        this.Q.a(i2);
        if (i2 > 5) {
            i2 = 0;
        }
        getActivity().applyAnim(i2);
    }

    private void a(int i2, int i3) {
        this.Q.f(i2);
        this.Q.g(i3);
        ((MkNovelBaseReaderActivity) getContext()).applyFontSize(i2);
    }

    @Override // com.amgcyo.cuttadon.view.lightview.PageBgSelectorView.a
    public void a(PageBgSelectorView pageBgSelectorView, boolean z2) {
        if (this.Q == null) {
        }
        j();
        if (z2) {
            pageBgSelectorView.setSelect(true);
            g.e(false);
            switch (pageBgSelectorView.getId()) {
                case R.id.pbv_blue /* 2131298149 */:
                    a("jade");
                    break;
                case R.id.pbv_green /* 2131298150 */:
                    a("plum");
                    break;
                case R.id.pbv_night /* 2131298151 */:
                    g.e(true);
                    a("night");
                    break;
                case R.id.pbv_white /* 2131298152 */:
                    a("white");
                    break;
                case R.id.pbv_yellow /* 2131298153 */:
                    a("linen");
                    break;
            }
        }
    }

    private void a(String str) {
        if (!g.h0()) {
            this.Q.c(str);
        }
        g.e("night".equals(str));
        MkNovelBaseReaderActivity activity = getActivity();
        activity.applyColorStyle(str);
        b();
        f fVar = this.f5366i0;
        if (fVar != null) {
            fVar.a(activity.getReaderColorStyle());
        }
    }

    private void a(MkNovelBaseReaderActivity mkNovelBaseReaderActivity) {
        Drawable drawableA;
        com.amgcyo.cuttadon.utils.otherutils.k readerColorStyle = mkNovelBaseReaderActivity.getReaderColorStyle();
        this.f5367s.a(readerColorStyle);
        this.f5367s.setBackgroundColor(readerColorStyle.f4406j);
        m.a(this.f5368t, readerColorStyle);
        Drawable drawableA2 = m.a(this.f5374z.getBackground(), readerColorStyle.f4408l);
        if (drawableA2 != null) {
            this.f5374z.setBackground(drawableA2);
        }
        for (int i2 = 0; i2 < this.f5369u.getChildCount(); i2++) {
            View childAt = this.f5369u.getChildAt(i2);
            if ((childAt instanceof TextView) && childAt.getBackground() != null && (drawableA = m.a(childAt.getBackground(), readerColorStyle.f4410n)) != null) {
                childAt.setBackground(drawableA);
            }
        }
        this.J.setTextColor(readerColorStyle.f4403g);
        this.D.setColorFilter(readerColorStyle.a);
        this.B.setColorFilter(readerColorStyle.a);
        this.A.setColorFilter(readerColorStyle.a);
        this.E.setBackgroundColor(readerColorStyle.f4409m);
        this.F.setBackgroundColor(readerColorStyle.f4409m);
        this.C.setBackgroundColor(readerColorStyle.f4409m);
        int i3 = readerColorStyle.a;
        int i4 = readerColorStyle.f4409m;
        for (int i5 = 0; i5 < this.f5370v.getChildCount(); i5++) {
            View childAt2 = this.f5370v.getChildAt(i5);
            if ((childAt2 instanceof TextView) && childAt2.getBackground() != null) {
                childAt2.setBackground(k0.a().a(getActivity(), i3, i4, getResources().getDimensionPixelSize(R.dimen.dimen20dp)));
            }
        }
        int iA = this.Q.a();
        if (iA == 1) {
            a(this.f5360c0);
        } else if (iA == 2) {
            a(this.f5361d0);
        } else if (iA != 3) {
            a(this.f5359b0);
        }
    }

    private void a(View view) {
        this.f5359b0.setEnabled(true);
        this.f5360c0.setEnabled(true);
        this.f5361d0.setEnabled(true);
        this.f5362e0.setEnabled(true);
        view.setEnabled(false);
    }
}
