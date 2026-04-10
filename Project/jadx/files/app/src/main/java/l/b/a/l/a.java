package l.b.a.l;

import android.content.Context;
import android.util.TypedValue;
import l.b.a.d;

/* JADX INFO: compiled from: BaseToastStyle.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements d {
    private Context a;

    public a(Context context) {
        this.a = context;
    }

    @Override // l.b.a.d
    public int a() {
        return b();
    }

    protected int b(float f2) {
        return (int) TypedValue.applyDimension(2, f2, this.a.getResources().getDisplayMetrics());
    }

    @Override // l.b.a.d
    public int c() {
        return g();
    }

    @Override // l.b.a.d
    public int e() {
        return 5;
    }

    @Override // l.b.a.d
    public int f() {
        return 30;
    }

    @Override // l.b.a.d
    public int h() {
        return 17;
    }

    @Override // l.b.a.d
    public int j() {
        return 0;
    }

    @Override // l.b.a.d
    public int k() {
        return 0;
    }

    protected int a(float f2) {
        return (int) TypedValue.applyDimension(1, f2, this.a.getResources().getDisplayMetrics());
    }
}
