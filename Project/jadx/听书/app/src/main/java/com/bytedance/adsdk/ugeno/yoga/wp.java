package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: loaded from: classes2.dex */
public class wp extends YogaNodeJNIBase {
    protected void finalize() throws Throwable {
        try {
            i();
        } finally {
            super.finalize();
        }
    }

    public void i() {
        if (this.z != 0) {
            long j = this.z;
            this.z = 0L;
            YogaNative.jni_YGNodeFinalizeJNI(j);
        }
    }
}
