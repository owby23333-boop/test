package miuix.animation.function;

/* JADX INFO: loaded from: classes8.dex */
public class InverseProportional implements Differentiable {
    private Function derivative;
    private final double k;

    public InverseProportional(double d) {
        this.k = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ double lambda$derivative$0(double d) {
        return ((-this.k) / d) / d;
    }

    @Override // miuix.animation.function.Differentiable, miuix.animation.function.Function
    public double apply(double d) {
        return this.k / d;
    }

    @Override // miuix.animation.function.Differentiable
    public Function derivative() {
        if (this.derivative == null) {
            this.derivative = new Function() { // from class: com.yuewen.oo1
                @Override // miuix.animation.function.Function
                public final double apply(double d) {
                    return this.f15683a.lambda$derivative$0(d);
                }
            };
        }
        return this.derivative;
    }
}
