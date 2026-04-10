package miuix.animation.function;

/* JADX INFO: loaded from: classes8.dex */
public class Exponential implements Differentiable {
    public static final Exponential EXP = new Exponential();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f21144a;
    private Function derivative;
    private final boolean isExp;
    private final double k;

    private Exponential() {
        this(1.0d, 2.718281828459045d);
        this.derivative = this;
    }

    @Override // miuix.animation.function.Differentiable, miuix.animation.function.Function
    public double apply(double d) {
        return this.k * (this.isExp ? Math.pow(this.f21144a, d) : Math.exp(d));
    }

    @Override // miuix.animation.function.Differentiable
    public Function derivative() {
        if (this.derivative == null) {
            this.derivative = this.isExp ? new Exponential(this.k, 2.718281828459045d) : new Exponential(this.k * Math.log(this.f21144a), this.f21144a);
        }
        return this.derivative;
    }

    public Exponential(double d) {
        this(1.0d, d);
    }

    public Exponential(double d, double d2) {
        this.k = d;
        this.f21144a = d2;
        this.isExp = d2 == 2.718281828459045d;
    }
}
