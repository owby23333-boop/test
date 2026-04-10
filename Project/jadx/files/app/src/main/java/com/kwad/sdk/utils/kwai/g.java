package com.kwad.sdk.utils.kwai;

import com.kwad.sdk.utils.kwai.c;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class g implements c.b<Set<String>> {
    static final g aBz = new g();

    private g() {
    }

    private static byte[] c(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int iCg = 0;
        int i2 = 0;
        for (String str : set) {
            if (str == null) {
                iCg += 5;
                iArr[i2] = -1;
            } else {
                int iEH = b.eH(str);
                strArr[i2] = str;
                iArr[i2] = iEH;
                iCg += b.cg(iEH) + iEH;
            }
            i2++;
        }
        b bVar = new b(iCg);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = iArr[i3];
            bVar.cf(i4);
            if (i4 >= 0) {
                bVar.eG(strArr[i3]);
            }
        }
        return bVar.aAG;
    }

    private static Set<String> h(byte[] bArr, int i2, int i3) {
        int i4;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i3 > 0) {
            b bVar = new b(bArr, i2);
            int i5 = i2 + i3;
            while (true) {
                i4 = bVar.position;
                if (i4 >= i5) {
                    break;
                }
                linkedHashSet.add(bVar.getString(bVar.EY()));
            }
            if (i4 != i5) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    @Override // com.kwad.sdk.utils.kwai.c.b
    public final String Fs() {
        return "StringSet";
    }

    @Override // com.kwad.sdk.utils.kwai.c.b
    public final /* synthetic */ Set<String> g(byte[] bArr, int i2, int i3) {
        return h(bArr, i2, i3);
    }

    @Override // com.kwad.sdk.utils.kwai.c.b
    public final /* synthetic */ byte[] i(Set<String> set) {
        return c(set);
    }
}
