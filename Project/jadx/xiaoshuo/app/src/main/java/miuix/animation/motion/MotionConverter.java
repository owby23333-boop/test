package miuix.animation.motion;

import com.yuewen.w51;
import miuix.animation.function.Differentiable;
import miuix.animation.function.Function;

/* JADX INFO: loaded from: classes8.dex */
public final class MotionConverter implements Motion {
    private Differentiable function;
    private final Motion mMotion;
    private final double mScale;
    private final double mZeroPoint;

    /* JADX INFO: renamed from: miuix.animation.motion.MotionConverter$1, reason: invalid class name */
    public class AnonymousClass1 implements Differentiable {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ double lambda$derivative$0(double d) {
            return MotionConverter.this.mMotion.solve().derivative().apply(d) * MotionConverter.this.mScale;
        }

        @Override // miuix.animation.function.Differentiable, miuix.animation.function.Function
        public double apply(double d) {
            return (MotionConverter.this.mMotion.solve().apply(d) * MotionConverter.this.mScale) + MotionConverter.this.mZeroPoint;
        }

        @Override // miuix.animation.function.Differentiable
        public Function derivative() {
            return new Function() { // from class: miuix.animation.motion.a
                @Override // miuix.animation.function.Function
                public final double apply(double d) {
                    return this.f21158a.lambda$derivative$0(d);
                }
            };
        }
    }

    public MotionConverter(Motion motion, double d, double d2) {
        if (d2 == w51.l) {
            throw new IllegalArgumentException("scale must not be zero");
        }
        this.mMotion = motion;
        this.mZeroPoint = d;
        this.mScale = d2;
    }

    @Override // miuix.animation.motion.Motion
    public double finishTime() {
        return this.mMotion.finishTime();
    }

    @Override // miuix.animation.motion.Motion
    public double getInitialV() {
        return this.mMotion.getInitialV() * this.mScale;
    }

    @Override // miuix.animation.motion.Motion
    public double getInitialX() {
        return this.mScale + this.mZeroPoint;
    }

    @Override // miuix.animation.motion.Motion
    public void setInitialV(double d) {
        this.mMotion.setInitialV(d / this.mScale);
    }

    @Override // miuix.animation.motion.Motion
    public void setInitialX(double d) {
        this.mMotion.setInitialX((d - this.mZeroPoint) / this.mScale);
    }

    @Override // miuix.animation.motion.Motion
    public Differentiable solve() {
        if (this.function == null) {
            this.function = new AnonymousClass1();
        }
        return this.function;
    }

    @Override // miuix.animation.motion.Motion
    public double stopPosition() {
        return (this.mMotion.stopPosition() * this.mScale) + this.mZeroPoint;
    }

    @Override // miuix.animation.motion.Motion
    public double stopSpeed() {
        return this.mMotion.stopSpeed() * this.mScale;
    }
}
