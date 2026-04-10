package cn.bmob.v3.encry.binary;

import cn.bmob.v3.encry.BinaryDecoder;
import cn.bmob.v3.encry.BinaryEncoder;
import cn.bmob.v3.encry.DecoderException;
import cn.bmob.v3.encry.EncoderException;
import com.umeng.analytics.pro.cb;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public class Hex implements BinaryEncoder, BinaryDecoder {
    public static final String DEFAULT_CHARSET_NAME = "UTF-8";
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String charsetName;

    public Hex() {
        this.charsetName = "UTF-8";
    }

    public static byte[] decodeHex(char[] cArr) throws DecoderException {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new DecoderException("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int digit = toDigit(cArr[i2], i2) << 4;
            int i4 = i2 + 1;
            int digit2 = digit | toDigit(cArr[i4], i4);
            i2 = i4 + 1;
            bArr[i3] = (byte) (digit2 & 255);
            i3++;
        }
        return bArr;
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, true);
    }

    public static String encodeHexString(byte[] bArr) {
        return new String(encodeHex(bArr));
    }

    protected static int toDigit(char c2, int i2) throws DecoderException {
        int iDigit = Character.digit(c2, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new DecoderException("Illegal hexadecimal character " + c2 + " at index " + i2);
    }

    @Override // cn.bmob.v3.encry.BinaryDecoder
    public byte[] decode(byte[] bArr) throws DecoderException {
        try {
            return decodeHex(new String(bArr, getCharsetName()).toCharArray());
        } catch (UnsupportedEncodingException e2) {
            throw new DecoderException(e2.getMessage(), e2);
        }
    }

    @Override // cn.bmob.v3.encry.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return StringUtils.getBytesUnchecked(encodeHexString(bArr), getCharsetName());
    }

    public String getCharsetName() {
        return this.charsetName;
    }

    public String toString() {
        return super.toString() + "[charsetName=" + this.charsetName + "]";
    }

    public static char[] encodeHex(byte[] bArr, boolean z2) {
        return encodeHex(bArr, z2 ? DIGITS_LOWER : DIGITS_UPPER);
    }

    public Hex(String str) {
        this.charsetName = str;
    }

    protected static char[] encodeHex(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            cArr2[i2] = cArr[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr2[i4] = cArr[bArr[i3] & cb.f19604m];
        }
        return cArr2;
    }

    @Override // cn.bmob.v3.encry.Decoder
    public Object decode(Object obj) throws DecoderException {
        try {
            return decodeHex(obj instanceof String ? ((String) obj).toCharArray() : (char[]) obj);
        } catch (ClassCastException e2) {
            throw new DecoderException(e2.getMessage(), e2);
        }
    }

    @Override // cn.bmob.v3.encry.Encoder
    public Object encode(Object obj) throws EncoderException {
        try {
            return encodeHex(obj instanceof String ? ((String) obj).getBytes(getCharsetName()) : (byte[]) obj);
        } catch (UnsupportedEncodingException e2) {
            throw new EncoderException(e2.getMessage(), e2);
        } catch (ClassCastException e3) {
            throw new EncoderException(e3.getMessage(), e3);
        }
    }
}
