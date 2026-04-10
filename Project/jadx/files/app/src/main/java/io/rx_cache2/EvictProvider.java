package io.rx_cache2;

/* JADX INFO: loaded from: classes3.dex */
public class EvictProvider {
    private final boolean evict;

    public EvictProvider(boolean z2) {
        this.evict = z2;
    }

    public boolean evict() {
        return this.evict;
    }
}
