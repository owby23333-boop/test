package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
final class g implements c.b<Set<String>> {
    static final g bcN = new g();

    @Override // com.kwad.sdk.utils.a.c.b
    public final String SK() {
        return "StringSet";
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ Set<String> f(byte[] bArr, int i, int i2) {
        return g(bArr, i, i2);
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ byte[] p(Set<String> set) {
        return e(set);
    }

    private g() {
    }

    private static byte[] e(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int iFa = 0;
        int i = 0;
        for (String str : set) {
            if (str == null) {
                iFa += 5;
                iArr[i] = -1;
            } else {
                int iHD = b.hD(str);
                strArr[i] = str;
                iArr[i] = iHD;
                iFa += b.fa(iHD) + iHD;
            }
            i++;
        }
        b bVar = new b(iFa);
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = iArr[i2];
            bVar.eZ(i3);
            if (i3 >= 0) {
                bVar.hC(strArr[i2]);
            }
        }
        return bVar.bbV;
    }

    private static Set<String> g(byte[] bArr, int i, int i2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            b bVar = new b(bArr, i);
            int i3 = i + i2;
            while (bVar.position < i3) {
                linkedHashSet.add(bVar.getString(bVar.Sq()));
            }
            if (bVar.position != i3) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }
}
