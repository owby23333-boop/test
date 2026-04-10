package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {
    static final byte[] a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    private static final int[] b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private interface Reader {

        public static final class EndOfFileException extends IOException {
            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a() throws IOException;

        int a(byte[] bArr, int i2) throws IOException;

        short b() throws IOException;

        long skip(long j2) throws IOException;
    }

    private static final class a implements Reader {
        private final ByteBuffer a;

        a(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a() throws Reader.EndOfFileException {
            return (b() << 8) | b();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short b() throws Reader.EndOfFileException {
            if (this.a.remaining() >= 1) {
                return (short) (this.a.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j2) {
            int iMin = (int) Math.min(this.a.remaining(), j2);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a(byte[] bArr, int i2) {
            int iMin = Math.min(i2, this.a.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.a.get(bArr, 0, iMin);
            return iMin;
        }
    }

    private static final class b {
        private final ByteBuffer a;

        b(byte[] bArr, int i2) {
            this.a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        void a(ByteOrder byteOrder) {
            this.a.order(byteOrder);
        }

        int b(int i2) {
            if (a(i2, 4)) {
                return this.a.getInt(i2);
            }
            return -1;
        }

        int a() {
            return this.a.remaining();
        }

        short a(int i2) {
            if (a(i2, 2)) {
                return this.a.getShort(i2);
            }
            return (short) -1;
        }

        private boolean a(int i2, int i3) {
            return this.a.remaining() - i2 >= i3;
        }
    }

    private static final class c implements Reader {
        private final InputStream a;

        c(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a() throws IOException {
            return (b() << 8) | b();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short b() throws IOException {
            int i2 = this.a.read();
            if (i2 != -1) {
                return (short) i2;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j2) throws IOException {
            if (j2 < 0) {
                return 0L;
            }
            long j3 = j2;
            while (j3 > 0) {
                long jSkip = this.a.skip(j3);
                if (jSkip <= 0) {
                    if (this.a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j3 -= jSkip;
            }
            return j2 - j3;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a(byte[] bArr, int i2) throws IOException {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2 && (i4 = this.a.read(bArr, i3, i2 - i3)) != -1) {
                i3 += i4;
            }
            if (i3 == 0 && i4 == -1) {
                throw new Reader.EndOfFileException();
            }
            return i3;
        }
    }

    private static int a(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    private static boolean a(int i2) {
        return (i2 & 65496) == 65496 || i2 == 19789 || i2 == 18761;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.x.b bVar) throws IOException {
        com.bumptech.glide.util.k.a(inputStream);
        c cVar = new c(inputStream);
        com.bumptech.glide.util.k.a(bVar);
        return a(cVar, bVar);
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull InputStream inputStream) throws IOException {
        com.bumptech.glide.util.k.a(inputStream);
        return getType(new c(inputStream));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull ByteBuffer byteBuffer) throws IOException {
        com.bumptech.glide.util.k.a(byteBuffer);
        return getType(new a(byteBuffer));
    }

    @NonNull
    private ImageHeaderParser.ImageType getType(Reader reader) throws IOException {
        try {
            int iA = reader.a();
            if (iA == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int iB = (iA << 8) | reader.b();
            if (iB == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int iB2 = (iB << 8) | reader.b();
            if (iB2 == -1991225785) {
                reader.skip(21L);
                try {
                    return reader.b() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (Reader.EndOfFileException unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (iB2 != 1380533830) {
                return a(reader, iB2) ? ImageHeaderParser.ImageType.AVIF : ImageHeaderParser.ImageType.UNKNOWN;
            }
            reader.skip(4L);
            if (((reader.a() << 16) | reader.a()) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int iA2 = (reader.a() << 16) | reader.a();
            if ((iA2 & InputDeviceCompat.SOURCE_ANY) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i2 = iA2 & 255;
            if (i2 != 88) {
                if (i2 == 76) {
                    reader.skip(4L);
                    return (reader.b() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                }
                return ImageHeaderParser.ImageType.WEBP;
            }
            reader.skip(4L);
            short sB = reader.b();
            if ((sB & 2) != 0) {
                return ImageHeaderParser.ImageType.ANIMATED_WEBP;
            }
            if ((sB & 16) != 0) {
                return ImageHeaderParser.ImageType.WEBP_A;
            }
            return ImageHeaderParser.ImageType.WEBP;
        } catch (Reader.EndOfFileException unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.engine.x.b bVar) throws IOException {
        com.bumptech.glide.util.k.a(byteBuffer);
        a aVar = new a(byteBuffer);
        com.bumptech.glide.util.k.a(bVar);
        return a(aVar, bVar);
    }

    private boolean a(Reader reader, int i2) throws IOException {
        if (((reader.a() << 16) | reader.a()) != 1718909296) {
            return false;
        }
        int iA = (reader.a() << 16) | reader.a();
        if (iA == 1635150182 || iA == 1635150195) {
            return true;
        }
        reader.skip(4L);
        int i3 = i2 - 16;
        if (i3 % 4 != 0) {
            return false;
        }
        int i4 = 0;
        for (int i5 = i3; i4 < 5 && i5 > 0; i5 -= 4) {
            int iA2 = (reader.a() << 16) | reader.a();
            if (iA2 == 1635150182 || iA2 == 1635150195) {
                return true;
            }
            i4++;
        }
        return false;
    }

    private int a(Reader reader, com.bumptech.glide.load.engine.x.b bVar) throws IOException {
        try {
            int iA = reader.a();
            if (!a(iA)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    String str = "Parser doesn't handle magic number: " + iA;
                }
                return -1;
            }
            int iA2 = a(reader);
            if (iA2 == -1) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            byte[] bArr = (byte[]) bVar.a(iA2, byte[].class);
            try {
                return a(reader, bArr, iA2);
            } finally {
                bVar.put(bArr);
            }
        } catch (Reader.EndOfFileException unused) {
            return -1;
        }
    }

    private int a(Reader reader, byte[] bArr, int i2) throws IOException {
        int iA = reader.a(bArr, i2);
        if (iA != i2) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                String str = "Unable to read exif segment data, length: " + i2 + ", actually read: " + iA;
            }
            return -1;
        }
        if (a(bArr, i2)) {
            return a(new b(bArr, i2));
        }
        Log.isLoggable("DfltImageHeaderParser", 3);
        return -1;
    }

    private boolean a(byte[] bArr, int i2) {
        boolean z2 = bArr != null && i2 > a.length;
        if (!z2) {
            return z2;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr2 = a;
            if (i3 >= bArr2.length) {
                return z2;
            }
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    private int a(Reader reader) throws IOException {
        short sB;
        int iA;
        long j2;
        long jSkip;
        do {
            short sB2 = reader.b();
            if (sB2 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    String str = "Unknown segmentId=" + ((int) sB2);
                }
                return -1;
            }
            sB = reader.b();
            if (sB == 218) {
                return -1;
            }
            if (sB == 217) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            iA = reader.a() - 2;
            if (sB == 225) {
                return iA;
            }
            j2 = iA;
            jSkip = reader.skip(j2);
        } while (jSkip == j2);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            String str2 = "Unable to skip enough data, type: " + ((int) sB) + ", wanted to skip: " + iA + ", but actually skipped: " + jSkip;
        }
        return -1;
    }

    private static int a(b bVar) {
        ByteOrder byteOrder;
        short sA = bVar.a(6);
        if (sA != 18761) {
            if (sA != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                String str = "Unknown endianness = " + ((int) sA);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.a(byteOrder);
        int iB = bVar.b(10) + 6;
        short sA2 = bVar.a(iB);
        for (int i2 = 0; i2 < sA2; i2++) {
            int iA = a(iB, i2);
            short sA3 = bVar.a(iA);
            if (sA3 == 274) {
                short sA4 = bVar.a(iA + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = bVar.b(iA + 4);
                    if (iB2 < 0) {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                    } else {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            String str2 = "Got tagIndex=" + i2 + " tagType=" + ((int) sA3) + " formatCode=" + ((int) sA4) + " componentCount=" + iB2;
                        }
                        int i3 = iB2 + b[sA4];
                        if (i3 > 4) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                String str3 = "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sA4);
                            }
                        } else {
                            int i4 = iA + 8;
                            if (i4 >= 0 && i4 <= bVar.a()) {
                                if (i3 >= 0 && i3 + i4 <= bVar.a()) {
                                    return bVar.a(i4);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    String str4 = "Illegal number of bytes for TI tag data tagType=" + ((int) sA3);
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                String str5 = "Illegal tagValueOffset=" + i4 + " tagType=" + ((int) sA3);
                            }
                        }
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    String str6 = "Got invalid format code = " + ((int) sA4);
                }
            }
        }
        return -1;
    }
}
