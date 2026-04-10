package net.oauth.signature.pem;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes9.dex */
class Asn1Object {
    protected final int length;
    protected final int tag;
    protected final int type;
    protected final byte[] value;

    public Asn1Object(int i, int i2, byte[] bArr) {
        this.tag = i;
        this.type = i & 31;
        this.length = i2;
        this.value = bArr;
    }

    public BigInteger getInteger() throws IOException {
        if (this.type == 2) {
            return new BigInteger(this.value);
        }
        throw new IOException("Invalid DER: object is not integer");
    }

    public int getLength() {
        return this.length;
    }

    public DerParser getParser() throws IOException {
        if (isConstructed()) {
            return new DerParser(this.value);
        }
        throw new IOException("Invalid DER: can't parse primitive entity");
    }

    public String getString() throws IOException {
        String str;
        int i = this.type;
        if (i == 12) {
            str = "UTF-8";
        } else if (i != 30) {
            if (i != 18 && i != 19 && i != 21 && i != 22) {
                switch (i) {
                    case 25:
                    case 26:
                    case 27:
                        break;
                    case 28:
                        throw new IOException("Invalid DER: can't handle UCS-4 string");
                    default:
                        throw new IOException("Invalid DER: object is not a string");
                }
            }
            str = "ISO-8859-1";
        } else {
            str = "UTF-16BE";
        }
        return new String(this.value, str);
    }

    public int getType() {
        return this.type;
    }

    public byte[] getValue() {
        return this.value;
    }

    public boolean isConstructed() {
        return (this.tag & 32) == 32;
    }
}
