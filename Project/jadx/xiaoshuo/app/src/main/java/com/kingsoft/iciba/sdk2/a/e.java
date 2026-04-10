package com.kingsoft.iciba.sdk2.a;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class e {
    private ArrayList ai = new ArrayList();
    private ArrayList aj = new ArrayList();

    public final void a(c cVar, String str) {
        this.ai.add(cVar);
        this.aj.add(str);
    }

    public final c e(int i) {
        if (this.ai.size() > i) {
            return (c) this.ai.get(i);
        }
        return null;
    }

    public final String f(int i) {
        if (this.aj.size() > i) {
            return (String) this.aj.get(i);
        }
        return null;
    }

    public final int size() {
        return this.ai.size();
    }
}
