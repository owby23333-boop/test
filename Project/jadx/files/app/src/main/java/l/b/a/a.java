package l.b.a;

import android.app.Application;
import android.view.View;

/* JADX INFO: compiled from: CustomToast.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends e {
    private final h b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f21030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f21031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f21032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f21033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f21034g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f21035h;

    public a(Application application) {
        super(application);
        this.b = new h(this, application);
    }

    @Override // android.widget.Toast
    public void cancel() {
        this.b.a();
    }

    @Override // android.widget.Toast
    public int getGravity() {
        return this.f21031d;
    }

    @Override // android.widget.Toast
    public float getHorizontalMargin() {
        return this.f21034g;
    }

    @Override // android.widget.Toast
    public float getVerticalMargin() {
        return this.f21035h;
    }

    @Override // android.widget.Toast
    public View getView() {
        return this.f21030c;
    }

    @Override // android.widget.Toast
    public int getXOffset() {
        return this.f21032e;
    }

    @Override // android.widget.Toast
    public int getYOffset() {
        return this.f21033f;
    }

    @Override // android.widget.Toast
    public void setGravity(int i2, int i3, int i4) {
        this.f21031d = i2;
        this.f21032e = i3;
        this.f21033f = i4;
    }

    @Override // android.widget.Toast
    public void setMargin(float f2, float f3) {
        this.f21034g = f2;
        this.f21035h = f3;
    }

    @Override // l.b.a.e, android.widget.Toast
    public void setView(View view) {
        this.f21030c = view;
        a(e.a(view));
    }

    @Override // android.widget.Toast
    public void show() {
        this.b.c();
    }
}
