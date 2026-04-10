package com.yuewen;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes12.dex */
public abstract class n94 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pattern f14796a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<n94> f14797a = new ArrayList();

        public a a(String str) {
            this.f14797a.add(new zf2(str));
            return this;
        }

        public a b(String str, String str2) {
            this.f14797a.add(new c73(str, str2));
            return this;
        }

        public String c(String str) {
            for (n94 n94Var : this.f14797a) {
                Matcher matcherB = n94Var.b(str);
                if (matcherB.find()) {
                    return n94Var.a(matcherB);
                }
            }
            return str;
        }
    }

    public abstract String a(Matcher matcher);

    public Matcher b(String str) {
        return this.f14796a.matcher(str);
    }

    public n94 c(String str) {
        this.f14796a = Pattern.compile(str);
        return this;
    }
}
