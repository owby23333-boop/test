package com.google.zxing.datamatrix.decoder;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.zxing.FormatException;
import com.tencent.smtt.sdk.TbsListener;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
final class DecodedBitStreamParser {
    private static final char[] a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] b = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f16184c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f16185d = b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char[] f16186e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    private enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[Mode.values().length];

        static {
            try {
                a[Mode.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static com.google.zxing.common.d a(byte[] bArr) throws FormatException {
        com.google.zxing.common.c cVar = new com.google.zxing.common.c(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        Mode modeA = Mode.ASCII_ENCODE;
        do {
            if (modeA == Mode.ASCII_ENCODE) {
                modeA = a(cVar, sb, sb2);
            } else {
                int i2 = a.a[modeA.ordinal()];
                if (i2 == 1) {
                    b(cVar, sb);
                } else if (i2 == 2) {
                    d(cVar, sb);
                } else if (i2 == 3) {
                    a(cVar, sb);
                } else if (i2 == 4) {
                    c(cVar, sb);
                } else {
                    if (i2 != 5) {
                        throw FormatException.f();
                    }
                    a(cVar, sb, arrayList);
                }
                modeA = Mode.ASCII_ENCODE;
            }
            if (modeA == Mode.PAD_ENCODE) {
                break;
            }
        } while (cVar.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String string = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new com.google.zxing.common.d(bArr, string, arrayList, null);
    }

    private static void b(com.google.zxing.common.c cVar, StringBuilder sb) throws FormatException {
        int iA;
        int[] iArr = new int[3];
        boolean z2 = false;
        int i2 = 0;
        while (cVar.a() != 8 && (iA = cVar.a(8)) != 254) {
            a(iA, cVar.a(8), iArr);
            boolean z3 = z2;
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = b;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z3) {
                                    sb.append((char) (c2 + 128));
                                    z3 = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i4 != 30) {
                                    throw FormatException.f();
                                }
                                z3 = true;
                            }
                            i2 = 0;
                        } else {
                            if (i2 != 3) {
                                throw FormatException.f();
                            }
                            if (z3) {
                                sb.append((char) (i4 + TbsListener.ErrorCode.EXCEED_INCR_UPDATE));
                                z3 = false;
                                i2 = 0;
                            } else {
                                sb.append((char) (i4 + 96));
                                i2 = 0;
                            }
                        }
                    } else if (z3) {
                        sb.append((char) (i4 + 128));
                        z3 = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr2 = a;
                    if (i4 >= cArr2.length) {
                        throw FormatException.f();
                    }
                    char c3 = cArr2[i4];
                    if (z3) {
                        sb.append((char) (c3 + 128));
                        z3 = false;
                    } else {
                        sb.append(c3);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            } else {
                z2 = z3;
            }
        }
    }

    private static void c(com.google.zxing.common.c cVar, StringBuilder sb) {
        while (cVar.a() > 16) {
            for (int i2 = 0; i2 < 4; i2++) {
                int iA = cVar.a(6);
                if (iA == 31) {
                    int iB = 8 - cVar.b();
                    if (iB != 8) {
                        cVar.a(iB);
                        return;
                    }
                    return;
                }
                if ((iA & 32) == 0) {
                    iA |= 64;
                }
                sb.append((char) iA);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void d(com.google.zxing.common.c cVar, StringBuilder sb) throws FormatException {
        int iA;
        int[] iArr = new int[3];
        boolean z2 = false;
        int i2 = 0;
        while (cVar.a() != 8 && (iA = cVar.a(8)) != 254) {
            a(iA, cVar.a(8), iArr);
            boolean z3 = z2;
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = f16185d;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z3) {
                                    sb.append((char) (c2 + 128));
                                    z3 = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i4 != 30) {
                                    throw FormatException.f();
                                }
                                z3 = true;
                            }
                            i2 = 0;
                        } else {
                            if (i2 != 3) {
                                throw FormatException.f();
                            }
                            char[] cArr2 = f16186e;
                            if (i4 >= cArr2.length) {
                                throw FormatException.f();
                            }
                            char c3 = cArr2[i4];
                            if (z3) {
                                sb.append((char) (c3 + 128));
                                z3 = false;
                                i2 = 0;
                            } else {
                                sb.append(c3);
                                i2 = 0;
                            }
                        }
                    } else if (z3) {
                        sb.append((char) (i4 + 128));
                        z3 = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr3 = f16184c;
                    if (i4 >= cArr3.length) {
                        throw FormatException.f();
                    }
                    char c4 = cArr3[i4];
                    if (z3) {
                        sb.append((char) (c4 + 128));
                        z3 = false;
                    } else {
                        sb.append(c4);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            } else {
                z2 = z3;
            }
        }
    }

    private static Mode a(com.google.zxing.common.c cVar, StringBuilder sb, StringBuilder sb2) throws FormatException {
        boolean z2 = false;
        do {
            int iA = cVar.a(8);
            if (iA == 0) {
                throw FormatException.f();
            }
            if (iA > 128) {
                if (iA != 129) {
                    if (iA <= 229) {
                        int i2 = iA - 130;
                        if (i2 < 10) {
                            sb.append('0');
                        }
                        sb.append(i2);
                    } else {
                        switch (iA) {
                            case TbsListener.ErrorCode.RENAME_SUCCESS /* 230 */:
                                return Mode.C40_ENCODE;
                            case TbsListener.ErrorCode.RENAME_FAIL /* 231 */:
                                return Mode.BASE256_ENCODE;
                            case TbsListener.ErrorCode.INSTALL_SUCCESS_AND_RELEASE_LOCK /* 232 */:
                                sb.append((char) 29);
                                break;
                            case TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS /* 233 */:
                            case TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS /* 234 */:
                            case TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID /* 241 */:
                                break;
                            case TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL /* 235 */:
                                z2 = true;
                                break;
                            case TbsListener.ErrorCode.TPATCH_INSTALL_SUCCESS /* 236 */:
                                sb.append("[)>\u001e05\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS /* 237 */:
                                sb.append("[)>\u001e06\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case TbsListener.ErrorCode.TPATCH_FAIL /* 238 */:
                                return Mode.ANSIX12_ENCODE;
                            case TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL /* 239 */:
                                return Mode.TEXT_ENCODE;
                            case TbsListener.ErrorCode.TPATCH_VERSION_FAILED /* 240 */:
                                return Mode.EDIFACT_ENCODE;
                            default:
                                if (iA != 254 || cVar.a() != 0) {
                                    throw FormatException.f();
                                }
                                break;
                        }
                    }
                } else {
                    return Mode.PAD_ENCODE;
                }
            } else {
                if (z2) {
                    iA += 128;
                }
                sb.append((char) (iA - 1));
                return Mode.ASCII_ENCODE;
            }
        } while (cVar.a() > 0);
        return Mode.ASCII_ENCODE;
    }

    private static void a(com.google.zxing.common.c cVar, StringBuilder sb) throws FormatException {
        int iA;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (iA = cVar.a(8)) != 254) {
            a(iA, cVar.a(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i3 == 0) {
                    sb.append('\r');
                } else if (i3 == 1) {
                    sb.append('*');
                } else if (i3 == 2) {
                    sb.append('>');
                } else if (i3 == 3) {
                    sb.append(' ');
                } else if (i3 < 14) {
                    sb.append((char) (i3 + 44));
                } else if (i3 < 40) {
                    sb.append((char) (i3 + 51));
                } else {
                    throw FormatException.f();
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void a(int i2, int i3, int[] iArr) {
        int i4 = ((i2 << 8) + i3) - 1;
        int i5 = i4 / 1600;
        iArr[0] = i5;
        int i6 = i4 - (i5 * 1600);
        int i7 = i6 / 40;
        iArr[1] = i7;
        iArr[2] = i6 - (i7 * 40);
    }

    private static void a(com.google.zxing.common.c cVar, StringBuilder sb, Collection<byte[]> collection) throws FormatException {
        int iC = cVar.c() + 1;
        int i2 = iC + 1;
        int iA = a(cVar.a(8), iC);
        if (iA == 0) {
            iA = cVar.a() / 8;
        } else if (iA >= 250) {
            iA = ((iA - 249) * ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + a(cVar.a(8), i2);
            i2++;
        }
        if (iA >= 0) {
            byte[] bArr = new byte[iA];
            int i3 = 0;
            while (i3 < iA) {
                if (cVar.a() >= 8) {
                    bArr[i3] = (byte) a(cVar.a(8), i2);
                    i3++;
                    i2++;
                } else {
                    throw FormatException.f();
                }
            }
            collection.add(bArr);
            try {
                sb.append(new String(bArr, "ISO8859_1"));
                return;
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e2)));
            }
        }
        throw FormatException.f();
    }

    private static int a(int i2, int i3) {
        int i4 = i2 - (((i3 * 149) % 255) + 1);
        return i4 >= 0 ? i4 : i4 + 256;
    }
}
