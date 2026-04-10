package miuix.animation.motion;

import com.yuewen.w51;
import miuix.animation.function.Differentiable;
import miuix.animation.function.FreeDamping;

/* JADX INFO: loaded from: classes8.dex */
public class FreeDampedMotion extends BaseMotion implements Motion {
    private Differentiable function = null;
    private final double g;
    private final double p;

    public FreeDampedMotion(double d, double d2) {
        this.g = d2;
        this.p = d;
    }

    @Override // miuix.animation.motion.Motion
    public double finishTime() {
        return (this.g == w51.l && getInitialV() == w51.l) ? w51.l : super.finishTime();
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
            double initialV = getInitialV() - (this.g / this.p);
            double initialX = getInitialX();
            double d = this.p;
            this.function = new FreeDamping(initialV, initialX + (initialV / d), d, this.g);
        }
        return this.function;
    }

    @Override // miuix.animation.motion.Motion
    public double stopPosition() {
        if (this.g == w51.l) {
            return getInitialX() + (getInitialV() / this.p);
        }
        return Double.POSITIVE_INFINITY;
    }

    @Override // miuix.animation.motion.Motion
    public double stopSpeed() {
        return this.g / this.p;
    }
}
