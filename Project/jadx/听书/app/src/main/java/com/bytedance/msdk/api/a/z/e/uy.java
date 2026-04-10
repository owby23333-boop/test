package com.bytedance.msdk.api.a.z.e;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class uy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f358a;
    public final int dl;
    public final int e;
    public final int fo;
    public final int g;
    public final int gc;
    public final int gz;
    public final int i;
    public final int kb;
    public final int m;
    public final int uy;
    public final Map<String, Integer> v;
    public final int wp;
    public final int z;

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int f359a;
        protected int dl;
        protected int e;
        protected int fo;
        protected int g;
        protected int gc;
        protected int gz;
        protected int i;
        protected int kb;
        protected int m;
        protected int uy;
        protected Map<String, Integer> v;
        protected int wp;
        protected int z;

        public z(int i) {
            this.v = Collections.emptyMap();
            this.z = i;
            this.v = new HashMap();
        }

        public z z(int i) {
            this.g = i;
            return this;
        }

        public z g(int i) {
            this.fo = i;
            return this;
        }

        public z dl(int i) {
            this.uy = i;
            return this;
        }

        public z a(int i) {
            this.kb = i;
            return this;
        }

        public z gc(int i) {
            this.wp = i;
            return this;
        }

        public z m(int i) {
            this.m = i;
            return this;
        }

        public z e(int i) {
            this.gz = i;
            return this;
        }

        public z gz(int i) {
            this.e = i;
            return this;
        }

        public z fo(int i) {
            this.dl = i;
            return this;
        }

        public z uy(int i) {
            this.f359a = i;
            return this;
        }

        public z kb(int i) {
            this.gc = i;
            return this;
        }

        public z z(Map<String, Integer> map) {
            this.v = new HashMap(map);
            return this;
        }

        public uy z() {
            return new uy(this);
        }
    }

    protected uy(z zVar) {
        this.z = zVar.z;
        this.g = zVar.g;
        this.dl = zVar.dl;
        this.f358a = zVar.f359a;
        this.gc = zVar.gc;
        this.m = zVar.m;
        this.e = zVar.e;
        this.gz = zVar.gz;
        this.v = zVar.v;
        this.fo = zVar.uy;
        this.uy = zVar.kb;
        this.kb = zVar.wp;
        this.wp = zVar.fo;
        this.i = zVar.i;
    }

    public static uy z(com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.a aVar) {
        if (aVar == null) {
            return null;
        }
        z zVar = new z(aVar.z());
        zVar.z(aVar.g()).uy(aVar.a()).fo(aVar.dl()).dl(aVar.fo()).a(aVar.uy()).gc(aVar.kb()).m(aVar.m()).gz(aVar.e()).kb(aVar.gc()).g(aVar.wp()).e(aVar.gz()).z(aVar.i());
        return zVar.z();
    }

    public static com.bytedance.msdk.z.a.g.z z(uy uyVar) {
        if (uyVar != null) {
            return new com.bytedance.msdk.z.a.g.z(uyVar);
        }
        return null;
    }
}
