package me.jessyan.art.b;

import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.jessyan.art.base.QDTCProtect;

/* JADX INFO: compiled from: MkAES.java */
/* JADX INFO: loaded from: classes.dex */
@QDTCProtect
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f21143c;
    private SecretKeySpec a;
    private IvParameterSpec b;

    private c() {
        this.a = null;
        try {
            this.a = new SecretKeySpec("Pxga!h*e4@T8xfOm".getBytes("ASCII"), "AES");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        this.b = new IvParameterSpec("E&z!EHGLd$fli*8R".getBytes());
    }

    public static c a() {
        if (f21143c == null) {
            synchronized (c.class) {
                if (f21143c == null) {
                    f21143c = new c();
                }
            }
        }
        return f21143c;
    }

    private byte[] b(String str, SecretKey secretKey, IvParameterSpec ivParameterSpec, byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance(str);
            cipher.init(1, secretKey, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String a(byte[] bArr) {
        return b.a(b("AES/CBC/PKCS5Padding", this.a, this.b, bArr));
    }

    public String a(String str) {
        try {
            return new String(a("AES/CBC/PKCS5Padding", this.a, this.b, a.b(str)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private byte[] a(String str, SecretKey secretKey, IvParameterSpec ivParameterSpec, byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance(str);
            cipher.init(2, secretKey, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
