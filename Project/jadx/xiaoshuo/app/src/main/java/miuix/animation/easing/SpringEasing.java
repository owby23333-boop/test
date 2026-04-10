package miuix.animation.easing;

import com.yuewen.w51;
import miuix.animation.motion.DampedHarmonicMotion;
import miuix.animation.motion.Motion;

/* JADX INFO: loaded from: classes8.dex */
public class SpringEasing implements PhysicalEasing {
    private final double omega;
    private final double zeta;

    public SpringEasing(double d, double d2) {
        if (d < w51.l) {
            throw new IllegalArgumentException("damping must not be negative");
        }
        if (d2 < w51.l) {
            throw new IllegalArgumentException("response must not be negative");
        }
        this.zeta = d;
        this.omega = 6.283185307179586d / d2;
    }

    public final double getOmega() {
        return this.omega;
    }

    public final double getZeta() {
        return this.zeta;
    }

    @Override // miuix.animation.FolmeEase
    public Motion newMotion() {
        return newMotion(w51.l);
    }

    public String toString() {
        return "Spring(" + this.zeta + ", " + this.omega + ")";
    }

    public Motion newMotion(double d) {
        return new DampedHarmonicMotion(this.zeta, this.omega, d, w51.l);
    }
}
