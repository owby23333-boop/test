package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private Set<String> aOX = new HashSet();
    private Set<String> aOY = new HashSet();

    public final synchronized void a(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.aOX.add(str);
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
                    this.aOY.add(str2);
                }
            }
        }
    }

    public final synchronized String[] LE() {
        Set<String> set;
        set = this.aOX;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public final synchronized String[] Lt() {
        Set<String> set;
        set = this.aOY;
        return (String[]) set.toArray(new String[set.size()]);
    }
}
