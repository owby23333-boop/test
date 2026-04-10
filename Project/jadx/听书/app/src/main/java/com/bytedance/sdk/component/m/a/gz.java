package com.bytedance.sdk.component.m.a;

import com.bytedance.sdk.component.m.io;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends z {
    private String dl;
    private int g;
    private Throwable z;

    @Override // com.bytedance.sdk.component.m.a.fo
    public String z() {
        return "failed";
    }

    public gz(int i, String str, Throwable th) {
        this.g = i;
        this.dl = str;
        this.z = th;
    }

    @Override // com.bytedance.sdk.component.m.a.fo
    public void z(com.bytedance.sdk.component.m.dl.dl dlVar) {
        dlVar.z(new com.bytedance.sdk.component.m.dl.z(this.g, this.dl, this.z));
        String strLs = dlVar.ls();
        Map<String, List<com.bytedance.sdk.component.m.dl.dl>> mapE = dlVar.wp().e();
        List<com.bytedance.sdk.component.m.dl.dl> list = mapE.get(strLs);
        if (list == null) {
            g(dlVar);
            return;
        }
        synchronized (list) {
            Iterator<com.bytedance.sdk.component.m.dl.dl> it = list.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
            list.clear();
            mapE.remove(strLs);
        }
    }

    private void g(com.bytedance.sdk.component.m.dl.dl dlVar) {
        io ioVarDl = dlVar.dl();
        if (ioVarDl != null) {
            ioVarDl.onFailed(this.g, this.dl, this.z);
        }
    }
}
