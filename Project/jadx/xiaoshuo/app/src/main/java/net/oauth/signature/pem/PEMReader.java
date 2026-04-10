package net.oauth.signature.pem;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.oauth.signature.OAuthSignatureMethod;

/* JADX INFO: loaded from: classes9.dex */
public class PEMReader {
    private static final String BEGIN_MARKER = "-----BEGIN ";
    public static final String CERTIFICATE_X509_MARKER = "-----BEGIN CERTIFICATE-----";
    public static final String PRIVATE_PKCS1_MARKER = "-----BEGIN RSA PRIVATE KEY-----";
    public static final String PRIVATE_PKCS8_MARKER = "-----BEGIN PRIVATE KEY-----";
    public static final String PUBLIC_X509_MARKER = "-----BEGIN PUBLIC KEY-----";
    private String beginMarker;
    private byte[] derBytes;
    private InputStream stream;

    public PEMReader(InputStream inputStream) throws IOException {
        this.stream = inputStream;
        readFile();
    }

    private byte[] readBytes(BufferedReader bufferedReader, String str) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                throw new IOException("Invalid PEM file: No end marker");
            }
            if (line.indexOf(str) != -1) {
                return OAuthSignatureMethod.decodeBase64(stringBuffer.toString());
            }
            stringBuffer.append(line.trim());
        }
    }

    public String getBeginMarker() {
        return this.beginMarker;
    }

    public byte[] getDerBytes() {
        return this.derBytes;
    }

    public void readFile() throws IOException {
        String line;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.stream));
        do {
            try {
                line = bufferedReader.readLine();
                if (line == null) {
                    throw new IOException("Invalid PEM file: no begin marker");
                }
            } finally {
                bufferedReader.close();
            }
        } while (line.indexOf(BEGIN_MARKER) == -1);
        String strTrim = line.trim();
        this.beginMarker = strTrim;
        this.derBytes = readBytes(bufferedReader, strTrim.replace("BEGIN", "END"));
    }

    public PEMReader(byte[] bArr) throws IOException {
        this(new ByteArrayInputStream(bArr));
    }

    public PEMReader(String str) throws IOException {
        this(new FileInputStream(str));
    }
}
