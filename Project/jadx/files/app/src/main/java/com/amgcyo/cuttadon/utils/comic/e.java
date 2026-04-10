package com.amgcyo.cuttadon.utils.comic;

import android.os.CountDownTimer;
import com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity;
import com.amgcyo.cuttadon.utils.otherutils.n;

/* JADX INFO: compiled from: ReadAutoScrollHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private a a;
    public MkComicsBaseReaderActivity b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4366f = 100;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4367g = 10;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4368h = 16000;

    /* JADX INFO: compiled from: ReadAutoScrollHelper.java */
    class a extends CountDownTimer {
        public a(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            MkComicsBaseReaderActivity mkComicsBaseReaderActivity = e.this.b;
            if (mkComicsBaseReaderActivity != null) {
                mkComicsBaseReaderActivity.isFinishing();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            MkComicsBaseReaderActivity mkComicsBaseReaderActivity = e.this.b;
            if (mkComicsBaseReaderActivity == null || mkComicsBaseReaderActivity.isFinishing()) {
                return;
            }
            e eVar = e.this;
            if (!eVar.f4364d) {
                eVar.b.scroll(eVar.f4366f);
                return;
            }
            eVar.f4363c += eVar.f4367g;
            int i2 = eVar.f4363c;
            int i3 = eVar.f4368h;
            if (i2 == i3 || i2 > i3) {
                e eVar2 = e.this;
                eVar2.f4363c = 0;
                eVar2.b.scroll(eVar2.f4366f);
            }
        }
    }

    public e(MkComicsBaseReaderActivity mkComicsBaseReaderActivity, int i2) {
        this.b = mkComicsBaseReaderActivity;
        a(i2);
    }

    public void a(boolean z2) {
        this.f4364d = z2;
        this.f4363c = 0;
        this.a = new a(System.currentTimeMillis(), this.f4367g);
        this.a.start();
        this.f4365e = true;
    }

    public void b() {
        this.f4365e = false;
        a aVar = this.a;
        if (aVar != null) {
            aVar.cancel();
            this.a = null;
        }
    }

    public boolean a() {
        return this.f4365e;
    }

    public void a(int i2) {
        this.f4368h = i2;
        this.f4366f = (int) ((n.a(this.b) * this.f4367g) / i2);
        if (this.f4366f == 0) {
            this.f4366f = 1;
        }
    }
}
