package com.duokan.core.sys;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/duokan/core/sys/DeviceSource;", "", com.xiaomi.onetrack.b.a.d, "", "(Ljava/lang/String;II)V", "getLevel", "()I", "UN_KNOWN", "DEFAULT", "NATIVE_RANDOM", "NETWORK", "NATIVE_RANDOM_NETWORK", "NATIVE_SYSTEM", "DkReaderBase_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum DeviceSource {
    UN_KNOWN(0),
    DEFAULT(1),
    NATIVE_RANDOM(2),
    NETWORK(3),
    NATIVE_RANDOM_NETWORK(4),
    NATIVE_SYSTEM(5);

    private final int level;

    DeviceSource(int i) {
        this.level = i;
    }

    public final int getLevel() {
        return this.level;
    }
}
