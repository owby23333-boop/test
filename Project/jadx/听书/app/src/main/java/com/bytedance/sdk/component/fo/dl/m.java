package com.bytedance.sdk.component.fo.dl;

import com.bytedance.sdk.component.g.z.fo;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.v;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class m implements fo {
    private int z;

    public void z(int i) {
        this.z = i;
    }

    @Override // com.bytedance.sdk.component.g.z.fo
    public ls z(fo.z zVar) throws IOException {
        IOException iOException;
        v vVarZ = zVar.z();
        if (e.z().z(this.z).g() != null) {
            e.z().z(this.z).g().gc();
        }
        String string = vVarZ.g().toString();
        String strZ = e.z().z(this.z).z(string);
        if (!string.equals(strZ)) {
            vVarZ = vVarZ.e().z(strZ).g();
        }
        ls lsVarZ = null;
        try {
            iOException = null;
            lsVarZ = zVar.z(vVarZ);
        } catch (Exception e) {
            iOException = new IOException(e.getMessage());
            e.z().z(this.z).z(vVarZ, e);
        }
        e.z().z(this.z).z(vVarZ, lsVarZ);
        if (iOException == null) {
            return lsVarZ == null ? zVar.z(vVarZ) : lsVarZ;
        }
        throw iOException;
    }
}
