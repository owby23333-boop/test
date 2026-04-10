package miuix.animation.physics;

/* JADX INFO: loaded from: classes8.dex */
public class SpringOperator implements PhysicsOperator {
    double[] params;

    @Override // miuix.animation.physics.PhysicsOperator
    public void getParameters(double[] dArr, double[] dArr2) {
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr.length >= 3 ? dArr[2] : 1.0d;
        dArr2[0] = Math.pow(6.283185307179586d / d2, 2.0d) * d3;
        dArr2[1] = Math.min(((d * 12.566370614359172d) * d3) / d2, 60.0d);
    }

    @Deprecated
    public double updateVelocity(double d, float f, float... fArr) {
        if (this.params == null) {
            return d;
        }
        double[] dArr = new double[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            dArr[i] = fArr[i];
        }
        double[] dArr2 = this.params;
        return updateVelocity(d, dArr2[0], dArr2[1], f, dArr);
    }

    @Override // miuix.animation.physics.PhysicsOperator
    public double updateVelocity(double d, double d2, double d3, double d4, double... dArr) {
        return (d * (1.0d - (d3 * d4))) + ((double) ((float) (d2 * (dArr[0] - dArr[1]) * d4)));
    }
}
