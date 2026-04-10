package com.bytedance.adsdk.lottie.d;

import androidx.webkit.ProxyConfig;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ga {
    public static final ga e = new ga("COMPOSITION");
    private final List<String> bf;
    private vn d;

    public ga(String... strArr) {
        this.bf = Arrays.asList(strArr);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int bf(String str, int i) {
        if (bf(str)) {
            return 0;
        }
        if (this.bf.get(i).equals("**")) {
            return (i != this.bf.size() - 1 && this.bf.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean d(String str, int i) {
        if (i >= this.bf.size()) {
            return false;
        }
        boolean z = i == this.bf.size() - 1;
        String str2 = this.bf.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.bf.size() + (-2) && bf())) && (str2.equals(str) || str2.equals(ProxyConfig.MATCH_ALL_SCHEMES));
        }
        if (!z && this.bf.get(i + 1).equals(str)) {
            return i == this.bf.size() + (-2) || (i == this.bf.size() + (-3) && bf());
        }
        if (z) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.bf.size() - 1) {
            return false;
        }
        return this.bf.get(i2).equals(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ga e(String str) {
        ga gaVar = new ga(this);
        gaVar.bf.add(str);
        return gaVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ga gaVar = (ga) obj;
        if (!this.bf.equals(gaVar.bf)) {
            return false;
        }
        vn vnVar = this.d;
        vn vnVar2 = gaVar.d;
        return vnVar != null ? vnVar.equals(vnVar2) : vnVar2 == null;
    }

    public int hashCode() {
        int iHashCode = this.bf.hashCode() * 31;
        vn vnVar = this.d;
        return iHashCode + (vnVar != null ? vnVar.hashCode() : 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean tg(String str, int i) {
        return "__container".equals(str) || i < this.bf.size() - 1 || this.bf.get(i).equals("**");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.bf);
        sb.append(",resolved=");
        sb.append(this.d != null);
        sb.append('}');
        return sb.toString();
    }

    private ga(ga gaVar) {
        this.bf = new ArrayList(gaVar.bf);
        this.d = gaVar.d;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ga e(vn vnVar) {
        ga gaVar = new ga(this);
        gaVar.d = vnVar;
        return gaVar;
    }

    private boolean bf(String str) {
        return "__container".equals(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public vn e() {
        return this.d;
    }

    private boolean bf() {
        return this.bf.get(r0.size() - 1).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean e(String str, int i) {
        if (bf(str)) {
            return true;
        }
        if (i >= this.bf.size()) {
            return false;
        }
        return this.bf.get(i).equals(str) || this.bf.get(i).equals("**") || this.bf.get(i).equals(ProxyConfig.MATCH_ALL_SCHEMES);
    }
}
