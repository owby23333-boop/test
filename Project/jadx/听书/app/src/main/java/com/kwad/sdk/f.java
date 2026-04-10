package com.kwad.sdk;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    private volatile boolean arX = false;
    private com.kwad.sdk.g.a arY;

    public static f ad(final long j) {
        return d(new com.kwad.sdk.g.a() { // from class: com.kwad.sdk.f.1
            @Override // com.kwad.sdk.g.a
            public final void accept(Object obj) {
                m.aj(j);
            }
        });
    }

    public static f ae(final long j) {
        return d(new com.kwad.sdk.g.a() { // from class: com.kwad.sdk.f.2
            @Override // com.kwad.sdk.g.a
            public final void accept(Object obj) {
                m.ak(j);
            }
        });
    }

    public static f af(final long j) {
        return d(new com.kwad.sdk.g.a() { // from class: com.kwad.sdk.f.3
            @Override // com.kwad.sdk.g.a
            public final void accept(Object obj) {
                m.an(j);
            }
        });
    }

    public static f ag(final long j) {
        return d(new com.kwad.sdk.g.a() { // from class: com.kwad.sdk.f.4
            @Override // com.kwad.sdk.g.a
            public final void accept(Object obj) {
                m.ao(j);
            }
        });
    }

    private static f d(com.kwad.sdk.g.a aVar) {
        return new f(aVar);
    }

    private f(com.kwad.sdk.g.a aVar) {
        this.arY = aVar;
    }

    public final synchronized void report() {
        if (this.arY != null && !this.arX) {
            this.arY.accept(null);
            this.arX = true;
        }
    }
}
