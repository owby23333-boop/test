package com.kwad.sdk.utils;

/* JADX INFO: loaded from: classes3.dex */
public final class al {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static int a(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i2) {
        ?? r02 = z2;
        if (z3) {
            r02 = (z2 ? 1 : 0) | 2;
        }
        if (z4) {
            r02 = (r02 == true ? 1 : 0) | 4;
        }
        if (z5) {
            r02 = (r02 == true ? 1 : 0) | '\b';
        }
        if (z6) {
            r02 = (r02 == true ? 1 : 0) | 16;
        }
        if (z7) {
            r02 = (r02 == true ? 1 : 0) | ' ';
        }
        return i2 == 2 ? r02 | 64 : r02;
    }
}
