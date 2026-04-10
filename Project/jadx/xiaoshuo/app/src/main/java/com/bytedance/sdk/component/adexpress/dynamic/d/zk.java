package com.bytedance.sdk.component.adexpress.dynamic.d;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class zk {
    public float bf;
    public float e;

    public zk(float f, float f2) {
        this.e = f;
        this.bf = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zk zkVar = (zk) obj;
        return Float.compare(zkVar.e, this.e) == 0 && Float.compare(zkVar.bf, this.bf) == 0;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.e), Float.valueOf(this.bf)});
    }
}
