package miuix.animation.function;

import com.yuewen.w51;

/* JADX INFO: loaded from: classes8.dex */
public class Polynomial implements Differentiable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double[] f21146a;
    private Function derivative;

    public Polynomial(int i, double... dArr) {
        int i2 = 1;
        int i3 = i + 1;
        if (dArr.length != i3) {
            throw new IllegalArgumentException("params must have a length of " + i3);
        }
        if (dArr[0] != w51.l) {
            this.f21146a = dArr;
            return;
        }
        while (i2 < dArr.length && dArr[i2] == w51.l) {
            i2++;
        }
        i2 = i2 == dArr.length ? i2 - 1 : i2;
        double[] dArr2 = new double[dArr.length - i2];
        this.f21146a = dArr2;
        System.arraycopy(dArr, i2, dArr2, 0, dArr2.length);
    }

    @Override // miuix.animation.function.Differentiable, miuix.animation.function.Function
    public double apply(double d) {
        double d2 = this.f21146a[0];
        int i = 1;
        while (true) {
            double[] dArr = this.f21146a;
            if (i >= dArr.length) {
                return d2;
            }
            d2 = (d2 * d) + dArr[i];
            i++;
        }
    }

    @Override // miuix.animation.function.Differentiable
    public Function derivative() {
        if (this.derivative == null) {
            double[] dArr = this.f21146a;
            if (dArr.length == 1) {
                this.derivative = Constant.ZERO;
            } else {
                int length = dArr.length - 1;
                double[] dArr2 = new double[length];
                for (int i = 0; i < length; i++) {
                    dArr2[i] = ((double) (length - i)) * this.f21146a[i];
                }
                this.derivative = new Polynomial(length - 1, dArr2);
            }
        }
        return this.derivative;
    }
}
