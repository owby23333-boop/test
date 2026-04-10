package androidx.constraintlayout.solver.widgets;

/* JADX INFO: loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f167x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f168y;

    public boolean contains(int i2, int i3) {
        int i4;
        int i5 = this.f167x;
        return i2 >= i5 && i2 < i5 + this.width && i3 >= (i4 = this.f168y) && i3 < i4 + this.height;
    }

    public int getCenterX() {
        return (this.f167x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f168y + this.height) / 2;
    }

    void grow(int i2, int i3) {
        this.f167x -= i2;
        this.f168y -= i3;
        this.width += i2 * 2;
        this.height += i3 * 2;
    }

    boolean intersects(Rectangle rectangle) {
        int i2;
        int i3;
        int i4 = this.f167x;
        int i5 = rectangle.f167x;
        return i4 >= i5 && i4 < i5 + rectangle.width && (i2 = this.f168y) >= (i3 = rectangle.f168y) && i2 < i3 + rectangle.height;
    }

    public void setBounds(int i2, int i3, int i4, int i5) {
        this.f167x = i2;
        this.f168y = i3;
        this.width = i4;
        this.height = i5;
    }
}
