package com.bytedance.sdk.component.d.bf.e.ga;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class wu {
    private final e tg = new e();
    private static final int[] e = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 2042, 1018, 1019, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 115, MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
    private static final byte[] bf = {Ascii.CR, Ascii.ETB, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.CAN, Ascii.RS, Ascii.FS, Ascii.FS, Ascii.RS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.RS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, 6, 10, 10, Ascii.FF, Ascii.CR, 6, 8, Ascii.VT, 10, 10, 8, Ascii.VT, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, Ascii.SI, 6, Ascii.FF, 10, Ascii.CR, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, Ascii.CR, 19, Ascii.CR, Ascii.SO, 6, Ascii.SI, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, Ascii.SI, Ascii.VT, Ascii.SO, Ascii.CR, Ascii.FS, Ascii.DC4, Ascii.SYN, Ascii.DC4, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.CAN, Ascii.ETB, Ascii.CAN, Ascii.CAN, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.CAN, Ascii.SYN, Ascii.NAK, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.CAN, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.NAK, Ascii.SYN, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SUB, Ascii.SUB, Ascii.DC4, 19, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.EM, Ascii.SUB, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.CAN, Ascii.EM, 19, Ascii.NAK, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.ESC, Ascii.CAN, Ascii.NAK, Ascii.NAK, Ascii.SUB, Ascii.SUB, Ascii.FS, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.DC4, Ascii.CAN, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.NAK, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.EM, Ascii.EM, Ascii.CAN, Ascii.CAN, Ascii.SUB, Ascii.ETB, Ascii.SUB, Ascii.ESC, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.FS, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.SUB};
    private static final wu d = new wu();

    private wu() {
        bf();
    }

    private void bf() {
        int i = 0;
        while (true) {
            byte[] bArr = bf;
            if (i >= bArr.length) {
                return;
            }
            e(i, e[i], bArr[i]);
            i++;
        }
    }

    public static wu e() {
        return d;
    }

    public void e(com.bytedance.sdk.component.d.e.vn vnVar, com.bytedance.sdk.component.d.e.tg tgVar) throws IOException {
        long j = 0;
        int i = 0;
        for (int i2 = 0; i2 < vnVar.p(); i2++) {
            int iE = vnVar.e(i2) & 255;
            int i3 = e[iE];
            byte b2 = bf[iE];
            j = (j << b2) | ((long) i3);
            i += b2;
            while (i >= 8) {
                i -= 8;
                tgVar.zk((int) (j >> i));
            }
        }
        if (i > 0) {
            tgVar.zk((int) ((j << (8 - i)) | ((long) (255 >>> i))));
        }
    }

    public static final class e {
        final int bf;
        final int d;
        final e[] e;

        public e() {
            this.e = new e[256];
            this.bf = 0;
            this.d = 0;
        }

        public e(int i, int i2) {
            this.e = null;
            this.bf = i;
            int i3 = i2 & 7;
            this.d = i3 == 0 ? 8 : i3;
        }
    }

    public int e(com.bytedance.sdk.component.d.e.vn vnVar) {
        long j = 0;
        for (int i = 0; i < vnVar.p(); i++) {
            j += (long) bf[vnVar.e(i) & 255];
        }
        return (int) ((j + 7) >> 3);
    }

    public byte[] e(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        e eVar = this.tg;
        int i = 0;
        int i2 = 0;
        for (byte b2 : bArr) {
            i = (i << 8) | (b2 & 255);
            i2 += 8;
            while (i2 >= 8) {
                eVar = eVar.e[(i >>> (i2 - 8)) & 255];
                if (eVar.e == null) {
                    byteArrayOutputStream.write(eVar.bf);
                    i2 -= eVar.d;
                    eVar = this.tg;
                } else {
                    i2 -= 8;
                }
            }
        }
        while (i2 > 0) {
            e eVar2 = eVar.e[(i << (8 - i2)) & 255];
            if (eVar2.e != null || eVar2.d > i2) {
                break;
            }
            byteArrayOutputStream.write(eVar2.bf);
            i2 -= eVar2.d;
            eVar = this.tg;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void e(int i, int i2, byte b2) {
        e eVar = new e(i, b2);
        e eVar2 = this.tg;
        while (b2 > 8) {
            b2 = (byte) (b2 - 8);
            int i3 = (i2 >>> b2) & 255;
            e[] eVarArr = eVar2.e;
            if (eVarArr != null) {
                if (eVarArr[i3] == null) {
                    eVarArr[i3] = new e();
                }
                eVar2 = eVar2.e[i3];
            } else {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
        }
        int i4 = 8 - b2;
        int i5 = (i2 << i4) & 255;
        int i6 = 1 << i4;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            eVar2.e[i7] = eVar;
        }
    }
}
