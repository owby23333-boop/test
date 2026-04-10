package com.bytedance.sdk.component.adexpress.dynamic.dl;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class fo {
    public float g;
    public float z;

    public fo(float f, float f2) {
        this.z = f;
        this.g = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            fo foVar = (fo) obj;
            if (Float.compare(foVar.z, this.z) == 0 && Float.compare(foVar.g, this.g) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.z), Float.valueOf(this.g)});
    }
}
