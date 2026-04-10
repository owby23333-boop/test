package com.kwad.sdk.crash.a;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private Set<String> aqH = new HashSet();
    private Set<String> aqI = new HashSet();

    public final synchronized void a(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.aqH.add(str);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (strArr2 != null && strArr2.length > 0) {
            for (String str2 : strArr2) {
                if (!TextUtils.isEmpty(str2)) {
                    this.aqI.add(str2);
                }
            }
        }
    }

    public final synchronized String[] zL() {
        return (String[]) this.aqI.toArray(new String[this.aqI.size()]);
    }

    public final synchronized String[] zX() {
        return (String[]) this.aqH.toArray(new String[this.aqH.size()]);
    }
}
