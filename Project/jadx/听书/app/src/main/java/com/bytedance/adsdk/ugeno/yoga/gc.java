package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: loaded from: classes2.dex */
public enum gc {
    COLUMN(0),
    COLUMN_REVERSE(1),
    ROW(2),
    ROW_REVERSE(3);

    private final int gc;

    gc(int i) {
        this.gc = i;
    }

    public int z() {
        return this.gc;
    }

    public static gc z(int i) {
        if (i == 0) {
            return COLUMN;
        }
        if (i == 1) {
            return COLUMN_REVERSE;
        }
        if (i == 2) {
            return ROW;
        }
        if (i == 3) {
            return ROW_REVERSE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }

    public static gc z(String str) {
        str.hashCode();
        switch (str) {
            case "column_reverse":
                return COLUMN_REVERSE;
            case "column":
                return COLUMN;
            case "row_reverse":
                return ROW_REVERSE;
            case "row":
                return ROW;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(str)));
        }
    }
}
