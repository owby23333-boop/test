package com.yuewen.openapi.crypro;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes8.dex */
public class EasyEncrypt {
    public static final String KEY = "Q9*11q^REaDer%Bs1&#@[";
    public static String MD5_KEY;

    public static class DecryptResult {
        public byte[] data;
        public int index;
    }

    public static DecryptResult Decrypt(byte[] bArr, int i, int i2, String str) {
        int length = str.length();
        DecryptResult decryptResult = new DecryptResult();
        decryptResult.data = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (i2 >= length) {
                i2 = 0;
            }
            byte bCharAt = (byte) str.charAt(i2);
            i2++;
            byte b2 = bArr[i3];
            decryptResult.data[i3] = (byte) (bCharAt ^ ((byte) (((b2 & 240) >> 4) | ((b2 & Ascii.SI) << 4))));
        }
        decryptResult.index = i2;
        return decryptResult;
    }

    public static byte[] Encrypt(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            if (i2 >= 21) {
                i2 = 0;
            }
            int i3 = i2 + 1;
            byte bCharAt = (byte) (((byte) KEY.charAt(i2)) ^ bArr[i]);
            bArr2[i] = (byte) (((bCharAt & 240) >> 4) | ((bCharAt & Ascii.SI) << 4));
            i++;
            i2 = i3;
        }
        return bArr2;
    }

    public static String enCodeMd5Key() {
        char c = (char) 181;
        char c2 = (char) 214;
        return xorString(new char[]{(char) MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, (char) 184, c, c2, (char) 183, (char) 195, (char) 201, (char) 188, c, c2, (char) MediaPlayer.MEDIA_PLAYER_OPTION_REND_FIRST_FRAME_TIME, (char) 238, (char) 218, (char) 166, (char) MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, (char) 192}, 150);
    }

    public static String getMd5Key() {
        if (TextUtils.isEmpty(MD5_KEY)) {
            MD5_KEY = enCodeMd5Key();
        }
        return MD5_KEY;
    }

    public static String xorString(char[] cArr, int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < cArr.length) {
            char c = (char) (cArr[i2] ^ i);
            i2++;
            sb.append(c);
        }
        return sb.toString();
    }

    public static byte[] Decrypt(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            if (i2 >= 21) {
                i2 = 0;
            }
            int i3 = i2 + 1;
            byte bCharAt = (byte) KEY.charAt(i2);
            byte b2 = bArr[i];
            bArr2[i] = (byte) (bCharAt ^ ((byte) (((b2 & 240) >> 4) | ((b2 & Ascii.SI) << 4))));
            i++;
            i2 = i3;
        }
        return bArr2;
    }
}
