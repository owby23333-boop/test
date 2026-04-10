package com.umeng.analytics.filter;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: SmartDict.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static final String b = "Ă";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MessageDigest f19425c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19427e;
    private final String a = "MD5";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<Object> f19426d = new HashSet();

    public d(boolean z2, String str) {
        int i2 = 0;
        this.f19427e = false;
        this.f19427e = z2;
        try {
            this.f19425c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        if (str != null) {
            if (!z2) {
                String[] strArrSplit = str.split(b);
                int length = strArrSplit.length;
                while (i2 < length) {
                    this.f19426d.add(strArrSplit[i2]);
                    i2++;
                }
                return;
            }
            try {
                byte[] bArrDecode = Base64.decode(str.getBytes(), 0);
                while (i2 < bArrDecode.length / 4) {
                    int i3 = i2 * 4;
                    this.f19426d.add(Integer.valueOf(((bArrDecode[i3 + 0] & 255) << 24) + ((bArrDecode[i3 + 1] & 255) << 16) + ((bArrDecode[i3 + 2] & 255) << 8) + (bArrDecode[i3 + 3] & 255)));
                    i2++;
                }
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            }
        }
    }

    private Integer c(String str) {
        try {
            this.f19425c.update(str.getBytes());
            byte[] bArrDigest = this.f19425c.digest();
            return Integer.valueOf(((bArrDigest[0] & 255) << 24) + ((bArrDigest[1] & 255) << 16) + ((bArrDigest[2] & 255) << 8) + (bArrDigest[3] & 255));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean a(String str) {
        return this.f19427e ? this.f19426d.contains(c(str)) : this.f19426d.contains(str);
    }

    public void b(String str) {
        if (this.f19427e) {
            this.f19426d.add(c(str));
        } else {
            this.f19426d.add(str);
        }
    }

    public String toString() {
        if (!this.f19427e) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : this.f19426d) {
                if (sb.length() > 0) {
                    sb.append(b);
                }
                sb.append(obj.toString());
            }
            return sb.toString();
        }
        byte[] bArr = new byte[this.f19426d.size() * 4];
        Iterator<Object> it = this.f19426d.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            int i3 = i2 + 1;
            bArr[i2] = (byte) (((-16777216) & iIntValue) >> 24);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((16711680 & iIntValue) >> 16);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((65280 & iIntValue) >> 8);
            i2 = i5 + 1;
            bArr[i5] = (byte) (iIntValue & 255);
        }
        return new String(Base64.encode(bArr, 0));
    }

    public void a() {
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = this.f19426d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (sb.length() > 0) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }
}
