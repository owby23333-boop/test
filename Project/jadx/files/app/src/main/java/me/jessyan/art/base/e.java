package me.jessyan.art.base;

/* JADX INFO: compiled from: Platform.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static final boolean a = a("com.zhy.autolayout.AutoLayoutInfo");
    public static final boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f21150c;

    static {
        a("android.support.design.widget.Snackbar");
        a("com.bumptech.glide.Glide");
        b = a("org.simple.eventbus.EventBus");
        f21150c = a("org.greenrobot.eventbus.EventBus");
    }

    private static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
