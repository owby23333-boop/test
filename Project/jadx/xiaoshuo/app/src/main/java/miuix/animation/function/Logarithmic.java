package miuix.animation.function;

/* JADX INFO: loaded from: classes8.dex */
public class Logarithmic implements Differentiable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f21145a;
    private Function derivative;
    private final boolean isLn;
    private final double k;

    public Logarithmic(double d) {
        this(1.0d, d);
    }

    @Override // miuix.animation.function.Differentiable, miuix.animation.function.Function
    public double apply(double d) {
        return this.isLn ? this.k * Math.log(d) : (this.k * Math.log(d)) / Math.log(this.f21145a);
    }

    @Override // miuix.animation.function.Differentiable
    public Function derivative() {
        if (this.derivative == null) {
            this.derivative = new InverseProportional(this.isLn ? this.k : this.k / Math.log(this.f21145a));
        }
        return this.derivative;
    }

    public Logarithmic(double d, double d2) {
        this.k = d;
        this.f21145a = d2;
        this.isLn = d2 == 2.718281828459045d;
    }
}
