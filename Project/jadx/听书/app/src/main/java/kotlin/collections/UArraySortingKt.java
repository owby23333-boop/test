package kotlin.collections;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UArraySorting.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u0014\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0016\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0018\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", TtmlNode.LEFT, TtmlNode.RIGHT, "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UArraySortingKt {
    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m1091partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte bM711getw2LRezQ = UByteArray.m711getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = bM711getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m711getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m711getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte bM711getw2LRezQ2 = UByteArray.m711getw2LRezQ(bArr, i);
                UByteArray.m716setVurrAj0(bArr, i, UByteArray.m711getw2LRezQ(bArr, i2));
                UByteArray.m716setVurrAj0(bArr, i2, bM711getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m1095quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int iM1091partition4UcCI2c = m1091partition4UcCI2c(bArr, i, i2);
        int i3 = iM1091partition4UcCI2c - 1;
        if (i < i3) {
            m1095quickSort4UcCI2c(bArr, i, i3);
        }
        if (iM1091partition4UcCI2c < i2) {
            m1095quickSort4UcCI2c(bArr, iM1091partition4UcCI2c, i2);
        }
    }

    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m1092partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short sM974getMh2AYeg = UShortArray.m974getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int iM974getMh2AYeg = UShortArray.m974getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = sM974getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(iM974getMh2AYeg, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m974getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short sM974getMh2AYeg2 = UShortArray.m974getMh2AYeg(sArr, i);
                UShortArray.m979set01HTLdE(sArr, i, UShortArray.m974getMh2AYeg(sArr, i2));
                UShortArray.m979set01HTLdE(sArr, i2, sM974getMh2AYeg2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m1096quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int iM1092partitionAa5vz7o = m1092partitionAa5vz7o(sArr, i, i2);
        int i3 = iM1092partitionAa5vz7o - 1;
        if (i < i3) {
            m1096quickSortAa5vz7o(sArr, i, i3);
        }
        if (iM1092partitionAa5vz7o < i2) {
            m1096quickSortAa5vz7o(sArr, iM1092partitionAa5vz7o, i2);
        }
    }

    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m1093partitionoBK06Vg(int[] iArr, int i, int i2) {
        int iM790getpVg5ArA = UIntArray.m790getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compareUnsigned(UIntArray.m790getpVg5ArA(iArr, i), iM790getpVg5ArA) < 0) {
                i++;
            }
            while (Integer.compareUnsigned(UIntArray.m790getpVg5ArA(iArr, i2), iM790getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int iM790getpVg5ArA2 = UIntArray.m790getpVg5ArA(iArr, i);
                UIntArray.m795setVXSXFK8(iArr, i, UIntArray.m790getpVg5ArA(iArr, i2));
                UIntArray.m795setVXSXFK8(iArr, i2, iM790getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m1097quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int iM1093partitionoBK06Vg = m1093partitionoBK06Vg(iArr, i, i2);
        int i3 = iM1093partitionoBK06Vg - 1;
        if (i < i3) {
            m1097quickSortoBK06Vg(iArr, i, i3);
        }
        if (iM1093partitionoBK06Vg < i2) {
            m1097quickSortoBK06Vg(iArr, iM1093partitionoBK06Vg, i2);
        }
    }

    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m1090partitionnroSd4(long[] jArr, int i, int i2) {
        long jM869getsVKNKU = ULongArray.m869getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compareUnsigned(ULongArray.m869getsVKNKU(jArr, i), jM869getsVKNKU) < 0) {
                i++;
            }
            while (Long.compareUnsigned(ULongArray.m869getsVKNKU(jArr, i2), jM869getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long jM869getsVKNKU2 = ULongArray.m869getsVKNKU(jArr, i);
                ULongArray.m874setk8EXiF4(jArr, i, ULongArray.m869getsVKNKU(jArr, i2));
                ULongArray.m874setk8EXiF4(jArr, i2, jM869getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m1094quickSortnroSd4(long[] jArr, int i, int i2) {
        int iM1090partitionnroSd4 = m1090partitionnroSd4(jArr, i, i2);
        int i3 = iM1090partitionnroSd4 - 1;
        if (i < i3) {
            m1094quickSortnroSd4(jArr, i, i3);
        }
        if (iM1090partitionnroSd4 < i2) {
            m1094quickSortnroSd4(jArr, iM1090partitionnroSd4, i2);
        }
    }

    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m1099sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1095quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m1100sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1096quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m1101sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1097quickSortoBK06Vg(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m1098sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1094quickSortnroSd4(array, i, i2 - 1);
    }
}
