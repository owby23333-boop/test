package net.oauth.signature.pem;

import java.io.IOException;
import java.security.spec.RSAPrivateCrtKeySpec;

/* JADX INFO: loaded from: classes9.dex */
public class PKCS1EncodedKeySpec {
    private RSAPrivateCrtKeySpec keySpec;

    public PKCS1EncodedKeySpec(byte[] bArr) throws IOException {
        decode(bArr);
    }

    private void decode(byte[] bArr) throws IOException {
        Asn1Object asn1Object = new DerParser(bArr).read();
        if (asn1Object.getType() != 16) {
            throw new IOException("Invalid DER: not a sequence");
        }
        DerParser parser = asn1Object.getParser();
        parser.read();
        this.keySpec = new RSAPrivateCrtKeySpec(parser.read().getInteger(), parser.read().getInteger(), parser.read().getInteger(), parser.read().getInteger(), parser.read().getInteger(), parser.read().getInteger(), parser.read().getInteger(), parser.read().getInteger());
    }

    public RSAPrivateCrtKeySpec getKeySpec() {
        return this.keySpec;
    }
}
