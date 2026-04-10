package miuix.animation.easing;

import com.yuewen.w51;
import miuix.animation.motion.DurationMotion;
import miuix.animation.motion.Motion;
import miuix.animation.motion.UniformlyAcceleratedMotion;

/* JADX INFO: loaded from: classes8.dex */
public class QuadOutEasing implements SimpleEasing {
    private final double duration;

    public QuadOutEasing() {
        this(1.0d);
    }

    @Override // miuix.animation.easing.SimpleEasing
    public final double duration() {
        return this.duration;
    }

    @Override // miuix.animation.FolmeEase
    public Motion newMotion() {
        double d = this.duration;
        return new DurationMotion(new UniformlyAcceleratedMotion((-2.0d) / (d * d)), this.duration, true);
    }

    @Override // miuix.animation.easing.SimpleEasing
    public double startSpeed() {
        return 2.0d / this.duration;
    }

    public String toString() {
        return "QuadOut(" + this.duration + ")";
    }

    public QuadOutEasing(double d) {
        if (d <= w51.l) {
            throw new IllegalArgumentException("duration must be positive");
        }
        this.duration = d;
    }
}
