package miuix.animation.function;

import com.yuewen.w51;

/* JADX INFO: loaded from: classes8.dex */
public class Trigonometric implements Differentiable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f21147a;
    private Function derivative;
    private final double omega;
    private final double phi;
    private final double xStar;

    public Trigonometric(double d, double d2, double d3, double d4) {
        this.f21147a = d;
        this.omega = d2;
        this.phi = d3;
        this.xStar = d4;
    }

    @Override // miuix.animation.function.Differentiable, miuix.animation.function.Function
    public double apply(double d) {
        return (this.f21147a * Math.cos((this.omega * d) + this.phi)) + this.xStar;
    }

    @Override // miuix.animation.function.Differentiable
    public Function derivative() {
        if (this.derivative == null) {
            double d = this.omega;
            this.derivative = new Trigonometric(d * this.f21147a, d, this.phi + 1.5707963267948966d, w51.l);
        }
        return this.derivative;
    }
}
