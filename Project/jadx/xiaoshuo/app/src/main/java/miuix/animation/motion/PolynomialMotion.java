package miuix.animation.motion;

import miuix.animation.function.Differentiable;
import miuix.animation.function.Polynomial;

/* JADX INFO: loaded from: classes8.dex */
public final class PolynomialMotion extends BaseMotion implements Motion {
    private final Differentiable function;

    public PolynomialMotion(int i, double... dArr) {
        this.function = new Polynomial(i, dArr);
    }

    @Override // miuix.animation.motion.Motion
    public Differentiable solve() {
        return this.function;
    }

    public PolynomialMotion(Polynomial polynomial) {
        this.function = polynomial;
    }
}
