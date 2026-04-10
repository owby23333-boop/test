package com.gyf.immersionbar;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.gyf.immersionbar.e;

/* JADX INFO: compiled from: ImmersionBar.java */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(19)
public final class f implements g {
    private int A;
    private int B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Activity f16391s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ViewGroup f16392t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ViewGroup f16393u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f16394v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private b f16395w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private a f16396x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f16397y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f16398z;

    private void a() {
        View viewFindViewById = this.f16392t.findViewById(c.a);
        b bVar = this.f16395w;
        if (!bVar.f16387w || !bVar.f16388x) {
            d.a().b(this);
            viewFindViewById.setVisibility(8);
        } else if (viewFindViewById != null) {
            d.a().a(this);
            d.a().a(this.f16391s.getApplication());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            r5 = this;
            android.view.ViewGroup r0 = r5.f16392t
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r1)
            boolean r0 = a(r0)
            r1 = 0
            if (r0 == 0) goto L14
            r5.a(r1, r1, r1, r1)
            return
        L14:
            com.gyf.immersionbar.b r0 = r5.f16395w
            boolean r0 = r0.f16385u
            if (r0 == 0) goto L26
            int r0 = r5.B
            r2 = 4
            if (r0 != r2) goto L26
            com.gyf.immersionbar.a r0 = r5.f16396x
            int r0 = r0.c()
            goto L27
        L26:
            r0 = 0
        L27:
            com.gyf.immersionbar.b r2 = r5.f16395w
            boolean r2 = r2.f16386v
            if (r2 == 0) goto L36
            com.gyf.immersionbar.a r0 = r5.f16396x
            int r0 = r0.c()
            int r2 = r5.A
            int r0 = r0 + r2
        L36:
            com.gyf.immersionbar.a r2 = r5.f16396x
            boolean r2 = r2.d()
            if (r2 == 0) goto L86
            com.gyf.immersionbar.b r2 = r5.f16395w
            boolean r3 = r2.f16387w
            if (r3 == 0) goto L86
            boolean r3 = r2.f16388x
            if (r3 == 0) goto L86
            boolean r2 = r2.f16383s
            if (r2 != 0) goto L64
            com.gyf.immersionbar.a r2 = r5.f16396x
            boolean r2 = r2.e()
            if (r2 == 0) goto L5d
            com.gyf.immersionbar.a r2 = r5.f16396x
            int r2 = r2.a()
            r3 = r2
            r2 = 0
            goto L66
        L5d:
            com.gyf.immersionbar.a r2 = r5.f16396x
            int r2 = r2.b()
            goto L65
        L64:
            r2 = 0
        L65:
            r3 = 0
        L66:
            com.gyf.immersionbar.b r4 = r5.f16395w
            boolean r4 = r4.f16384t
            if (r4 == 0) goto L77
            com.gyf.immersionbar.a r4 = r5.f16396x
            boolean r4 = r4.e()
            if (r4 == 0) goto L75
            goto L87
        L75:
            r2 = 0
            goto L88
        L77:
            com.gyf.immersionbar.a r4 = r5.f16396x
            boolean r4 = r4.e()
            if (r4 != 0) goto L88
            com.gyf.immersionbar.a r2 = r5.f16396x
            int r2 = r2.b()
            goto L88
        L86:
            r2 = 0
        L87:
            r3 = 0
        L88:
            r5.a(r1, r0, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.immersionbar.f.b():void");
    }

    private void c() {
        b();
        if (this.f16394v || !OSUtils.isEMUI3_x()) {
            return;
        }
        a();
    }

    Activity getActivity() {
        return this.f16391s;
    }

    @Override // java.lang.Runnable
    public void run() {
        c();
    }

    @Override // com.gyf.immersionbar.i
    public void a(boolean z2, NavigationBarType navigationBarType) {
        View viewFindViewById = this.f16392t.findViewById(c.a);
        if (viewFindViewById != null) {
            this.f16396x = new a(this.f16391s);
            int paddingBottom = this.f16393u.getPaddingBottom();
            int paddingRight = this.f16393u.getPaddingRight();
            if (!z2) {
                viewFindViewById.setVisibility(8);
            } else {
                viewFindViewById.setVisibility(0);
                if (!a(this.f16392t.findViewById(R.id.content))) {
                    if (this.f16397y == 0) {
                        this.f16397y = this.f16396x.a();
                    }
                    if (this.f16398z == 0) {
                        this.f16398z = this.f16396x.b();
                    }
                    if (!this.f16395w.f16384t) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewFindViewById.getLayoutParams();
                        if (this.f16396x.e()) {
                            layoutParams.gravity = 80;
                            paddingBottom = this.f16397y;
                            layoutParams.height = paddingBottom;
                            if (this.f16395w.f16383s) {
                                paddingBottom = 0;
                            }
                            paddingRight = 0;
                        } else {
                            layoutParams.gravity = GravityCompat.END;
                            int i2 = this.f16398z;
                            layoutParams.width = i2;
                            if (this.f16395w.f16383s) {
                                i2 = 0;
                            }
                            paddingRight = i2;
                            paddingBottom = 0;
                        }
                        viewFindViewById.setLayoutParams(layoutParams);
                    }
                }
                a(0, this.f16393u.getPaddingTop(), paddingRight, paddingBottom);
            }
            paddingBottom = 0;
            paddingRight = 0;
            a(0, this.f16393u.getPaddingTop(), paddingRight, paddingBottom);
        }
    }

    @TargetApi(14)
    public static boolean b(@NonNull Context context) {
        return a(context) > 0;
    }

    @TargetApi(14)
    public static int b(@NonNull Activity activity) {
        return new a(activity).c();
    }

    private void a(int i2, int i3, int i4, int i5) {
        ViewGroup viewGroup = this.f16393u;
        if (viewGroup != null) {
            viewGroup.setPadding(i2, i3, i4, i5);
        }
    }

    public static boolean a(View view) {
        if (view == null) {
            return false;
        }
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (((childAt instanceof DrawerLayout) && a(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    @TargetApi(14)
    public static int a(@NonNull Activity activity) {
        return new a(activity).a();
    }

    @TargetApi(14)
    public static int a(@NonNull Context context) {
        e.a aVarA = e.a(context);
        if (!aVarA.a || aVarA.b) {
            return a.b(context);
        }
        return 0;
    }
}
