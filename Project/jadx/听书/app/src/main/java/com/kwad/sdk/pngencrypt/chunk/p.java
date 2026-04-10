package com.kwad.sdk.pngencrypt.chunk;

/* JADX INFO: loaded from: classes4.dex */
public abstract class p extends PngChunk {
    protected p(String str, com.kwad.sdk.pngencrypt.k kVar) {
        super(str, kVar);
    }

    public int hashCode() {
        return (this.aoB == null ? 0 : this.aoB.hashCode()) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.aoB == null) {
            if (pVar.aoB != null) {
                return false;
            }
        } else if (!this.aoB.equals(pVar.aoB)) {
            return false;
        }
        return true;
    }
}
