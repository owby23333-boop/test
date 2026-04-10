package io.rx_cache2;

/* JADX INFO: loaded from: classes3.dex */
public final class Reply<T> {
    private final T data;
    private final boolean isEncrypted;
    private final Source source;

    public Reply(T t2, Source source, boolean z2) {
        this.data = t2;
        this.source = source;
        this.isEncrypted = z2;
    }

    public T getData() {
        return this.data;
    }

    public Source getSource() {
        return this.source;
    }

    public boolean isEncrypted() {
        return this.isEncrypted;
    }

    public String toString() {
        return "Reply{data=" + this.data + ", source=" + this.source + ", isEncrypted=" + this.isEncrypted + '}';
    }
}
