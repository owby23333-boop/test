package miuix.animation.function;

/* JADX INFO: loaded from: classes8.dex */
public class FreeDamping implements Differentiable {
    private final double c;
    private final double d;
    private Function derivative;
    private final double g;
    private final double p;

    public FreeDamping(double d, double d2, double d3, double d4) {
        this.c = d;
        this.d = d2;
        this.p = d3;
        this.g = d4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ double lambda$derivative$0(double d) {
        return (this.c * Math.exp((-this.p) * d)) + (this.g / this.p);
    }

    @Override // miuix.animation.function.Differentiable, miuix.animation.function.Function
    public double apply(double d) {
        double d2 = this.c;
        double d3 = this.p;
        return ((-(d2 / d3)) * Math.exp((-d3) * d)) + ((this.g / this.p) * d) + this.d;
    }

    @Override // miuix.animation.function.Differentiable
    public Function derivative() {
        if (this.derivative == null) {
            this.derivative = new Function() { // from class: com.yuewen.o71
                @Override // miuix.animation.function.Function
                public final double apply(double d) {
                    return this.f15223a.lambda$derivative$0(d);
                }
            };
        }
        return this.derivative;
    }
}
