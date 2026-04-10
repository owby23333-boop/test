package com.bytedance.sdk.component.ga.e;

import com.bytedance.sdk.component.ga.xu;
import com.bytedance.sdk.component.ga.zk;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    public static xu e() {
        return new xu() { // from class: com.bytedance.sdk.component.ga.e.bf.1
            private WeakHashMap<String, String> e = new WeakHashMap<>();

            @Override // com.bytedance.sdk.component.ga.xu
            public String bf(zk zkVar) {
                return e(zkVar.e());
            }

            @Override // com.bytedance.sdk.component.ga.xu
            public String e(zk zkVar) {
                return e(zkVar.e() + "#width=" + zkVar.bf() + "#height=" + zkVar.d() + "#scaletype=" + zkVar.tg());
            }

            private String e(String str) {
                String str2 = this.e.get(str);
                if (str2 != null) {
                    return str2;
                }
                String strE = com.bytedance.sdk.component.ga.d.d.d.e(str);
                this.e.put(str, strE);
                return strE;
            }
        };
    }
}
