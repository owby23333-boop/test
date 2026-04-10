package cn.kuaipan.android.http.multipart;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.util.EncodingUtils;

/* JADX INFO: loaded from: classes.dex */
public class FilePart extends PartBase {
    public static final String DEFAULT_CHARSET = "ISO-8859-1";
    public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
    public static final String DEFAULT_TRANSFER_ENCODING = "binary";
    protected static final String FILE_NAME = "; filename=";
    private static final byte[] FILE_NAME_BYTES = EncodingUtils.getAsciiBytes(FILE_NAME);
    private PartSource source;

    public FilePart(String str, PartSource partSource, String str2, String str3) {
        super(str, str2 == null ? DEFAULT_CONTENT_TYPE : str2, str3 == null ? "ISO-8859-1" : str3, "binary");
        if (partSource == null) {
            throw new IllegalArgumentException("Source may not be null");
        }
        this.source = partSource;
    }

    public PartSource getSource() {
        return this.source;
    }

    @Override // cn.kuaipan.android.http.multipart.Part
    public long lengthOfData() {
        return this.source.getLength();
    }

    @Override // cn.kuaipan.android.http.multipart.Part
    public void sendData(OutputStream outputStream) throws IOException {
        if (lengthOfData() == 0) {
            Log.d("FilePart", "No data to send.");
            return;
        }
        byte[] bArr = new byte[4096];
        InputStream inputStreamCreateInputStream = this.source.createInputStream();
        while (true) {
            try {
                int i = inputStreamCreateInputStream.read(bArr);
                if (i < 0) {
                    return;
                } else {
                    outputStream.write(bArr, 0, i);
                }
            } finally {
                inputStreamCreateInputStream.close();
            }
        }
    }

    @Override // cn.kuaipan.android.http.multipart.Part
    public void sendDispositionHeader(OutputStream outputStream) throws IOException {
        super.sendDispositionHeader(outputStream);
        String fileName = this.source.getFileName();
        if (fileName != null) {
            outputStream.write(FILE_NAME_BYTES);
            byte[] bArr = Part.QUOTE_BYTES;
            outputStream.write(bArr);
            outputStream.write(EncodingUtils.getAsciiBytes(fileName));
            outputStream.write(bArr);
        }
    }

    public FilePart(String str, PartSource partSource) {
        this(str, partSource, (String) null, (String) null);
    }

    public FilePart(String str, File file) throws FileNotFoundException {
        this(str, new FilePartSource(file), (String) null, (String) null);
    }

    public FilePart(String str, File file, String str2, String str3) throws FileNotFoundException {
        this(str, new FilePartSource(file), str2, str3);
    }

    public FilePart(String str, String str2, File file) throws FileNotFoundException {
        this(str, new FilePartSource(str2, file), (String) null, (String) null);
    }

    public FilePart(String str, String str2, File file, String str3, String str4) throws FileNotFoundException {
        this(str, new FilePartSource(str2, file), str3, str4);
    }

    public FilePart(String str, String str2, byte[] bArr) {
        this(str, new ByteArrayPartSource(str2, bArr), (String) null, (String) null);
    }

    public FilePart(String str, String str2, byte[] bArr, String str3, String str4) {
        this(str, new ByteArrayPartSource(str2, bArr), str3, str4);
    }
}
