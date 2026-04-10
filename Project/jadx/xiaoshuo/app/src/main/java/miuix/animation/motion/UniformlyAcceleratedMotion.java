package miuix.animation.motion;

import miuix.animation.function.Differentiable;
import miuix.animation.function.Parabolic;

/* JADX INFO: loaded from: classes8.dex */
public class UniformlyAcceleratedMotion extends BaseMotion implements Motion {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f21157a;
    private Differentiable function;

    public UniformlyAcceleratedMotion(double d) {
        this.f21157a = d;
    }

    @Override // miuix.animation.motion.BaseMotion
    public void onInitialVChanged() {
        super.onInitialVChanged();
        this.function = null;
    }

    @Override // miuix.animation.motion.BaseMotion
    public void onInitialXChanged() {
        super.onInitialXChanged();
        this.function = null;
    }

    @Override // miuix.animation.motion.Motion
    public Differentiable solve() {
        if (this.function == null) {
            this.function = new Parabolic(this.f21157a / 2.0d, getInitialV(), getInitialX());
        }
        return this.function;
    }
}
