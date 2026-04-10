package miuix.animation.motion;

import com.yuewen.w51;
import miuix.animation.function.Differentiable;
import miuix.animation.function.Function;

/* JADX INFO: loaded from: classes8.dex */
public class AndroidDampedHarmonicMotion extends DampedHarmonicMotion implements AndroidMotion {
    private double finishTime;
    private final double g;
    private final double p;
    private final double q;
    private double threshold;
    private final double xStar;

    public AndroidDampedHarmonicMotion(double d, double d2, double d3, double d4) {
        super(d, d2, d3, d4);
        this.p = d * 2.0d * d2;
        double d5 = d2 * d2;
        this.q = d5;
        this.xStar = ((-d4) / d5) + d3;
        this.g = d4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ double lambda$solveFinishTime$0(Differentiable differentiable, double d) {
        double dApply = differentiable.apply(d);
        double dApply2 = differentiable.derivative().apply(d);
        return (((this.q * dApply) * dApply) + (dApply2 * dApply2)) - ((this.g * 2.0d) * (dApply - this.xStar));
    }

    private double solveFinishTime() {
        double d;
        double dFinishTime = super.finishTime();
        if (dFinishTime == w51.l || this.threshold == w51.l) {
            return dFinishTime;
        }
        final Differentiable differentiableSolve = solve();
        if (this.g == w51.l) {
            return (-Math.log(this.threshold)) / this.p;
        }
        Function function = new Function() { // from class: com.yuewen.dc
            @Override // miuix.animation.function.Function
            public final double apply(double d2) {
                return this.f10127a.lambda$solveFinishTime$0(differentiableSolve, d2);
            }
        };
        double dApply = function.apply(w51.l);
        double d2 = this.q;
        double d3 = this.xStar;
        double d4 = d2 * d3 * d3;
        double d5 = (dApply - d4) * this.threshold;
        double dApply2 = function.apply(1.0d);
        double d6 = 0.0d;
        double d7 = 1.0d;
        while (true) {
            d = d4 + d5;
            if (dApply2 <= d) {
                break;
            }
            double d8 = d7 + 1.0d;
            dApply2 = function.apply(d8);
            double d9 = d7;
            d7 = d8;
            d6 = d9;
        }
        do {
            double d10 = (d6 + d7) / 2.0d;
            if (function.apply(d10) > d) {
                d6 = d10;
            } else {
                d7 = d10;
            }
        } while (d7 - d6 >= this.threshold);
        return d7;
    }

    @Override // miuix.animation.motion.DampedHarmonicMotion, miuix.animation.motion.Motion
    public double finishTime() {
        if (Double.isNaN(this.finishTime)) {
            this.finishTime = solveFinishTime();
        }
        return this.finishTime;
    }

    @Override // miuix.animation.motion.DampedHarmonicMotion, miuix.animation.motion.BaseMotion
    public void onInitialVChanged() {
        super.onInitialVChanged();
        this.finishTime = Double.NaN;
    }

    @Override // miuix.animation.motion.DampedHarmonicMotion, miuix.animation.motion.BaseMotion
    public void onInitialXChanged() {
        super.onInitialXChanged();
        this.finishTime = Double.NaN;
    }

    @Override // miuix.animation.motion.AndroidMotion
    public void setThreshold(double d) {
        this.threshold = d;
        this.finishTime = Double.NaN;
    }
}
