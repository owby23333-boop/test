package com.amgcyo.cuttadon.view.comic.comictoast;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: ZToast.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static a f4535f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f4536g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f4537h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f4538i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f4539j = 60;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f4540k;
    private Activity a;
    private ToastLayout b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ViewGroup f4541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f4543e;

    public a(Activity activity, String str, long j2) {
        this.a = activity;
        this.f4542d = str;
        this.f4543e = j2;
    }

    public static void a(int i2) {
        f4537h = i2;
    }

    public static void b(int i2) {
        f4536g = i2;
    }

    public static a a(Activity activity, String str, long j2) {
        f4535f = new a(activity, str, j2);
        return f4535f;
    }

    public void a() {
        Activity activity = this.a;
        if (activity != null) {
            RelativeLayout relativeLayout = (RelativeLayout) activity.findViewById(R.id.rl_toast);
            if (relativeLayout == null) {
                this.b = new ToastLayout(this.a);
                a(this.b);
                Activity activity2 = this.a;
                activity2.addContentView(this.b, new RelativeLayout.LayoutParams(-1, ToastLayout.a(activity2, f4539j)));
            } else {
                this.b = (ToastLayout) relativeLayout.getParent();
            }
            this.b.setContent(this.f4542d);
            this.b.a(this.f4543e);
            return;
        }
        ViewGroup viewGroup = this.f4541c;
        if (viewGroup != null) {
            RelativeLayout relativeLayout2 = (RelativeLayout) viewGroup.findViewById(R.id.rl_toast);
            if (relativeLayout2 == null) {
                this.b = new ToastLayout(this.f4541c.getContext());
                a(this.b);
                ViewGroup viewGroup2 = this.f4541c;
                viewGroup2.addView(this.b, new RelativeLayout.LayoutParams(-1, ToastLayout.a(viewGroup2.getContext(), f4539j)));
            } else {
                this.b = (ToastLayout) relativeLayout2.getParent();
            }
            this.b.setContent(this.f4542d);
            this.b.a(this.f4543e);
        }
    }

    private void a(ToastLayout toastLayout) {
        int i2 = f4536g;
        if (i2 != 0) {
            toastLayout.setTextColor(i2);
        }
        int i3 = f4537h;
        if (i3 != 0) {
            toastLayout.setBgColor(i3);
        }
        int i4 = f4540k;
        if (i4 != 0) {
            toastLayout.setIcon(i4);
        }
        toastLayout.setIconVisible(f4538i);
        toastLayout.setHeight(f4539j);
    }
}
