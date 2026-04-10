package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class Rect {
    public int bottom;
    public int left;
    public int right;

    /* JADX INFO: renamed from: top, reason: collision with root package name */
    public int f52top;

    public int width() {
        return this.right - this.left;
    }

    public int height() {
        return this.bottom - this.f52top;
    }
}
