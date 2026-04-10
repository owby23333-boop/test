package com.amgcyo.cuttadon.view.readermenu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity;
import com.amgcyo.cuttadon.utils.otherutils.a0;
import com.amgcyo.cuttadon.utils.otherutils.k;
import com.amgcyo.cuttadon.view.readermenu.ReaderMenuMain;
import com.fatcatfat.io.R;
import com.gyf.immersionbar.f;
import org.simple.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public class ReaderNewPanel extends RelativeLayout implements com.amgcyo.cuttadon.g.d {
    private View A;
    private View B;
    private int C;
    private Uri D;
    private int[] E;
    private ContentObserver F;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f5388s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private FrameLayout f5389t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ReaderMenuMain f5390u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ReaderMenuVoice f5391v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ReaderMenuAnim f5392w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ReaderMenuLockTime f5393x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ReaderMenuAutoRead f5394y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private View f5395z;

    class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z2) {
            ReaderNewPanel.this.a();
        }
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f5396s;

        b(boolean z2) {
            this.f5396s = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5396s) {
                ReaderNewPanel.this.setState(1);
            }
            ReaderNewPanel.this.setVisibility(4);
            ReaderNewPanel.this.a(0);
        }
    }

    public ReaderNewPanel(@NonNull Context context) {
        this(context, null);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.mk_view_reader_panel, (ViewGroup) this, true);
        this.f5389t = (FrameLayout) findViewById(R.id.layout_menuContainer);
        this.f5395z = findViewById(R.id.leftPaddingView);
        this.A = findViewById(R.id.rightPaddingView);
        this.B = findViewById(R.id.bottomPaddingView);
        this.E = a0.b();
        if (this.E == null) {
            this.E = new int[]{0, 0};
        }
        this.D = a0.a();
        this.C = f.a((Activity) getActivity());
        setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.readermenu.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5407s.a(view);
            }
        });
        h();
    }

    private void c() {
        a(2);
        if (this.f5392w == null) {
            this.f5392w = new ReaderMenuAnim(getContext());
        }
        b(this.f5392w);
        this.f5392w.b();
    }

    private void d() {
        a(2);
        if (this.f5394y == null) {
            this.f5394y = new ReaderMenuAutoRead(getContext());
        }
        b(this.f5394y);
        this.f5394y.b();
    }

    private void e() {
        a(2);
        if (this.f5393x == null) {
            this.f5393x = new ReaderMenuLockTime(getContext());
        }
        b(this.f5393x);
        this.f5393x.b();
    }

    private void f() {
        a(1);
        if (this.f5390u == null) {
            this.f5390u = new ReaderMenuMain(getContext());
            this.f5390u.setListener(new ReaderMenuMain.f() { // from class: com.amgcyo.cuttadon.view.readermenu.c
                @Override // com.amgcyo.cuttadon.view.readermenu.ReaderMenuMain.f
                public final void a(k kVar) {
                    this.a.a(kVar);
                }
            });
        }
        b(this.f5390u);
        this.f5390u.c();
    }

    private void g() {
        a(2);
        if (this.f5391v == null) {
            this.f5391v = new ReaderMenuVoice(getContext());
        }
        b(this.f5391v);
        this.f5391v.d();
    }

    private MkNovelBaseReaderActivity getActivity() {
        return (MkNovelBaseReaderActivity) getContext();
    }

    @SuppressLint({"CheckResult"})
    private void h() {
        EventBus.getDefault().register(this);
    }

    public void b() {
        setVisibility(0);
        a();
        int i2 = this.f5388s;
        if (i2 == 1) {
            f();
            return;
        }
        if (i2 == 3) {
            g();
            return;
        }
        if (i2 == 8) {
            e();
        } else if (i2 == 5) {
            c();
        } else {
            if (i2 != 6) {
                return;
            }
            d();
        }
    }

    public ReaderMenuMain getReaderMenuMain() {
        if (this.f5390u == null) {
            this.f5390u = new ReaderMenuMain(getContext());
        }
        return this.f5390u;
    }

    public ReaderMenuVoice getReaderMenuVoice() {
        return this.f5391v;
    }

    public int getState() {
        return this.f5388s;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getContext().getContentResolver().registerContentObserver(this.D, true, this.F);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().getContentResolver().unregisterContentObserver(this.F);
    }

    public void setState(int i2) {
        this.f5388s = i2;
    }

    public ReaderNewPanel(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5388s = 1;
        this.F = new a(new Handler());
        a(context);
    }

    private void b(View view) {
        this.f5389t.removeAllViews();
        this.f5389t.addView(view, new ViewGroup.LayoutParams(-1, -1));
        view.measure(0, 0);
    }

    public /* synthetic */ void a(View view) {
        getActivity().hideMenuPanel(true);
    }

    public void a(int i2) {
        ((MkNovelBaseReaderActivity) getContext()).applyFullscreen(i2);
    }

    public void a(boolean z2) {
        if (getVisibility() != 0) {
            if (z2) {
                setState(1);
                return;
            }
            return;
        }
        if (this.f5389t.getChildCount() == 0) {
            new b(z2).run();
            return;
        }
        View childAt = this.f5389t.getChildAt(0);
        if (childAt instanceof ReaderMenuMain) {
            this.f5390u.a(new b(z2));
            return;
        }
        if (childAt instanceof ReaderMenuVoice) {
            this.f5391v.a(new b(z2));
            return;
        }
        if (childAt instanceof ReaderMenuAnim) {
            this.f5392w.a(new b(z2));
        } else if (childAt instanceof ReaderMenuAutoRead) {
            this.f5394y.a(new b(z2));
        } else if (childAt instanceof ReaderMenuLockTime) {
            this.f5393x.a(new b(z2));
        }
    }

    public void a() {
        int i2 = getActivity().bottom_adHeight;
        boolean zB = f.b(getContext());
        boolean zIsInMultiWindowMode = Build.VERSION.SDK_INT >= 24 ? ((Activity) getContext()).isInMultiWindowMode() : false;
        MkNovelBaseReaderActivity mkNovelBaseReaderActivity = (MkNovelBaseReaderActivity) getContext();
        String str = "isInMultiWindow:" + zIsInMultiWindowMode;
        k readerColorStyle = mkNovelBaseReaderActivity.getReaderColorStyle();
        if (zIsInMultiWindowMode) {
            ViewGroup.LayoutParams layoutParams = this.f5395z.getLayoutParams();
            layoutParams.width = 0;
            this.f5395z.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.A.getLayoutParams();
            layoutParams2.width = 0;
            this.A.setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = this.B.getLayoutParams();
            layoutParams3.height = 0;
            this.B.setLayoutParams(layoutParams3);
        } else if (mkNovelBaseReaderActivity.isPortrait()) {
            int i3 = mkNovelBaseReaderActivity.readBottomSwitch;
            ViewGroup.LayoutParams layoutParams4 = this.f5395z.getLayoutParams();
            layoutParams4.width = 0;
            this.f5395z.setLayoutParams(layoutParams4);
            ViewGroup.LayoutParams layoutParams5 = this.A.getLayoutParams();
            layoutParams5.width = 0;
            this.A.setLayoutParams(layoutParams5);
            String str2 = i3 + " hasNavigationBar:" + zB;
            ViewGroup.LayoutParams layoutParams6 = this.B.getLayoutParams();
            if (zB) {
                if (i2 <= 0 || i3 == 0) {
                    i2 = this.C;
                }
            } else if (i3 == 0) {
                i2 = 0;
            }
            layoutParams6.height = i2;
            this.B.setLayoutParams(layoutParams6);
        } else {
            ViewGroup.LayoutParams layoutParams7 = this.B.getLayoutParams();
            layoutParams7.height = 0;
            this.B.setLayoutParams(layoutParams7);
            ViewGroup.LayoutParams layoutParams8 = this.f5395z.getLayoutParams();
            layoutParams8.width = this.E[1];
            this.f5395z.setLayoutParams(layoutParams8);
            ViewGroup.LayoutParams layoutParams9 = this.A.getLayoutParams();
            if (zB) {
                layoutParams9.width = this.C;
            } else {
                layoutParams9.width = 0;
            }
            this.A.setLayoutParams(layoutParams9);
        }
        if (readerColorStyle != null) {
            this.f5395z.setBackgroundColor(readerColorStyle.f4406j);
            this.A.setBackgroundColor(readerColorStyle.f4406j);
            this.B.setBackgroundColor(readerColorStyle.f4406j);
            if (Build.VERSION.SDK_INT >= 21) {
                getActivity().getWindow().setNavigationBarColor(readerColorStyle.f4406j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar) {
        if (kVar != null) {
            this.f5395z.setBackgroundColor(kVar.f4406j);
            this.A.setBackgroundColor(kVar.f4406j);
            this.B.setBackgroundColor(kVar.f4406j);
            if (Build.VERSION.SDK_INT >= 21) {
                getActivity().getWindow().setNavigationBarColor(kVar.f4406j);
            }
        }
    }
}
