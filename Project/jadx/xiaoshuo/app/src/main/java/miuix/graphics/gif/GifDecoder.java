package miuix.graphics.gif;

import android.graphics.Bitmap;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Vector;

/* JADX INFO: loaded from: classes7.dex */
public class GifDecoder {
    public static final int MAX_DECODE_SIZE = 1048576;
    protected static final int MAX_STACK_SIZE = 4096;
    public static final int STATUS_DECODE_CANCEL = 3;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    protected int[] act;
    protected int bgColor;
    protected int bgIndex;
    private int[] dest;
    protected Vector<GifFrame> frames;
    protected int[] gct;
    protected boolean gctFlag;
    protected int gctSize;
    private int height;
    protected int ih;
    protected Bitmap image;
    protected BufferedInputStream in;
    protected boolean interlace;
    protected int iw;
    protected int ix;
    protected int iy;
    protected int lastBgColor;
    protected Bitmap lastBitmap;
    protected int[] lct;
    protected boolean lctFlag;
    protected int lctSize;
    protected int lrh;
    protected int lrw;
    protected int lrx;
    protected int lry;
    private long mDecodeBmSize;
    private boolean mDecodeToTheEnd;
    private int mDecodedFrames;
    private int mStartFrame;
    protected int pixelAspect;
    protected byte[] pixelStack;
    protected byte[] pixels;
    protected short[] prefix;
    protected int status;
    protected byte[] suffix;
    protected int transIndex;
    private int width;
    private long mMaxDecodeSize = 1048576;
    protected int loopCount = 1;
    protected byte[] block = new byte[256];
    protected int blockSize = 0;
    protected int dispose = 0;
    protected int lastDispose = 0;
    protected boolean transparency = false;
    protected int delay = 0;
    private boolean mCancel = false;
    private boolean calledOnce = false;

    public static class GifFrame {
        public int delay;
        public Bitmap image;

        public GifFrame(Bitmap bitmap, int i) {
            this.image = bitmap;
            this.delay = i;
        }

        public void recycle() {
            Bitmap bitmap = this.image;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.image.recycle();
        }
    }

    public static boolean isGifStream(InputStream inputStream) {
        int oneByte;
        if (inputStream == null) {
            return false;
        }
        String str = "";
        for (int i = 0; i < 6 && (oneByte = readOneByte(inputStream)) != -1; i++) {
            str = str + ((char) oneByte);
        }
        return str.startsWith("GIF");
    }

    public static int readOneByte(InputStream inputStream) {
        try {
            return inputStream.read();
        } catch (Exception unused) {
            return -1;
        }
    }

    private void requestCancel() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v25, types: [short] */
    /* JADX WARN: Type inference failed for: r2v27 */
    public void decodeBitmapData() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        short s;
        int i6 = this.iw * this.ih;
        byte[] bArr = this.pixels;
        if (bArr == null || bArr.length < i6) {
            this.pixels = new byte[i6];
        }
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[4097];
        }
        int i7 = read();
        int i8 = 1 << i7;
        int i9 = i8 + 1;
        int i10 = i8 + 2;
        int i11 = i7 + 1;
        int i12 = (1 << i11) - 1;
        for (int i13 = 0; i13 < i8; i13++) {
            this.prefix[i13] = 0;
            this.suffix[i13] = (byte) i13;
        }
        int i14 = i11;
        int i15 = i12;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int block = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = -1;
        int i24 = i10;
        while (i16 < i6) {
            if (i17 != 0) {
                i = i11;
                i2 = i9;
                int i25 = i21;
                i3 = i8;
                i4 = i25;
            } else if (i18 < i14) {
                if (block == 0) {
                    block = readBlock();
                    if (block <= 0) {
                        break;
                    } else {
                        i20 = 0;
                    }
                }
                i19 += (this.block[i20] & 255) << i18;
                i18 += 8;
                i20++;
                block--;
            } else {
                int i26 = i19 & i15;
                i19 >>= i14;
                i18 -= i14;
                if (i26 > i24 || i26 == i9) {
                    break;
                }
                if (i26 == i8) {
                    i14 = i11;
                    i24 = i10;
                    i15 = i12;
                    i23 = -1;
                } else if (i23 == -1) {
                    this.pixelStack[i17] = this.suffix[i26];
                    i23 = i26;
                    i21 = i23;
                    i17++;
                    i11 = i11;
                } else {
                    i = i11;
                    if (i26 == i24) {
                        i5 = i26;
                        this.pixelStack[i17] = (byte) i21;
                        s = i23;
                        i17++;
                    } else {
                        i5 = i26;
                        s = i5;
                    }
                    while (s > i8) {
                        this.pixelStack[i17] = this.suffix[s];
                        s = this.prefix[s];
                        i17++;
                        i8 = i8;
                    }
                    i3 = i8;
                    byte[] bArr2 = this.suffix;
                    i4 = bArr2[s] & 255;
                    if (i24 >= 4096) {
                        break;
                    }
                    int i27 = i17 + 1;
                    i2 = i9;
                    byte b2 = (byte) i4;
                    this.pixelStack[i17] = b2;
                    this.prefix[i24] = (short) i23;
                    bArr2[i24] = b2;
                    i24++;
                    if ((i24 & i15) == 0 && i24 < 4096) {
                        i14++;
                        i15 += i24;
                    }
                    i17 = i27;
                    i23 = i5;
                }
            }
            i17--;
            this.pixels[i22] = this.pixelStack[i17];
            i16++;
            i22++;
            i8 = i3;
            i9 = i2;
            i21 = i4;
            i11 = i;
        }
        for (int i28 = i22; i28 < i6; i28++) {
            this.pixels[i28] = 0;
        }
    }

    public boolean err() {
        return this.status != 0;
    }

    public Bitmap getBitmap() {
        return getFrame(0);
    }

    public int getDelay(int i) {
        this.delay = -1;
        int frameCount = getFrameCount();
        if (i >= 0 && i < frameCount) {
            this.delay = this.frames.elementAt(i).delay;
        }
        return this.delay;
    }

    public Bitmap getFrame(int i) {
        int frameCount = getFrameCount();
        if (frameCount <= 0) {
            return null;
        }
        return this.frames.elementAt(i % frameCount).image;
    }

    public int getFrameCount() {
        Vector<GifFrame> vector = this.frames;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public int getHeight() {
        return this.height;
    }

    public int getLoopCount() {
        return this.loopCount;
    }

    public int getRealFrameCount() {
        if (this.mDecodeToTheEnd) {
            return this.mDecodedFrames;
        }
        return 0;
    }

    public int getWidth() {
        return this.width;
    }

    public void init() {
        this.status = 0;
        this.frames = new Vector<>();
        this.gct = null;
        this.lct = null;
    }

    public boolean isDecodeToTheEnd() {
        return this.mDecodeToTheEnd;
    }

    public int read(InputStream inputStream) {
        this.mDecodeToTheEnd = false;
        if (this.calledOnce) {
            throw new IllegalStateException("decoder cannot be called more than once");
        }
        this.calledOnce = true;
        init();
        if (inputStream != null) {
            this.in = new BufferedInputStream(inputStream);
            try {
                readHeader();
                if (!this.mCancel && !err()) {
                    readContents();
                    if (getFrameCount() < 0) {
                        this.status = 1;
                    }
                }
            } catch (OutOfMemoryError unused) {
                this.status = 2;
                recycle();
            }
        } else {
            this.status = 2;
        }
        if (this.mCancel) {
            recycle();
            this.status = 3;
        }
        return this.status;
    }

    public void readBitmap() {
        this.ix = readShort();
        this.iy = readShort();
        this.iw = readShort();
        this.ih = readShort();
        int i = read();
        int i2 = 0;
        boolean z = (i & 128) != 0;
        this.lctFlag = z;
        int i3 = 2 << (i & 7);
        this.lctSize = i3;
        this.interlace = (i & 64) != 0;
        if (z) {
            int[] colorTable = readColorTable(i3);
            this.lct = colorTable;
            this.act = colorTable;
        } else {
            this.act = this.gct;
            if (this.bgIndex == this.transIndex) {
                this.bgColor = 0;
            }
        }
        if (this.transparency) {
            int[] iArr = this.act;
            int i4 = this.transIndex;
            int i5 = iArr[i4];
            iArr[i4] = 0;
            i2 = i5;
        }
        if (this.act == null) {
            this.status = 1;
        }
        if (err()) {
            return;
        }
        decodeBitmapData();
        skip();
        if (err() || this.mCancel) {
            return;
        }
        setPixels();
        if (this.mDecodedFrames >= this.mStartFrame) {
            this.frames.addElement(new GifFrame(this.image, this.delay));
        }
        this.mDecodedFrames++;
        if (this.transparency) {
            this.act[this.transIndex] = i2;
        }
        resetFrame();
    }

    public int readBlock() {
        int i = read();
        this.blockSize = i;
        int i2 = 0;
        if (i > 0) {
            while (true) {
                try {
                    int i3 = this.blockSize;
                    if (i2 >= i3) {
                        break;
                    }
                    int i4 = this.in.read(this.block, i2, i3 - i2);
                    if (i4 == -1) {
                        break;
                    }
                    i2 += i4;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i2 < this.blockSize) {
                this.status = 1;
            }
        }
        return i2;
    }

    public int[] readColorTable(int i) {
        int i2;
        int i3 = i * 3;
        byte[] bArr = new byte[i3];
        try {
            i2 = this.in.read(bArr, 0, i3);
        } catch (Exception e) {
            e.printStackTrace();
            i2 = 0;
        }
        if (i2 < i3) {
            this.status = 1;
            return null;
        }
        int[] iArr = new int[256];
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            iArr[i5] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
            i4 = i7 + 1;
        }
        return iArr;
    }

    public void readContents() {
        this.mDecodedFrames = 0;
        boolean z = false;
        while (!z && !err() && !this.mCancel) {
            int i = read();
            if (i == 33) {
                int i2 = read();
                if (i2 == 1) {
                    skip();
                } else if (i2 == 249) {
                    readGraphicControlExt();
                } else if (i2 == 254) {
                    skip();
                } else if (i2 != 255) {
                    skip();
                } else {
                    readBlock();
                    String str = "";
                    for (int i3 = 0; i3 < 11; i3++) {
                        str = str + ((char) this.block[i3]);
                    }
                    if (str.equals("NETSCAPE2.0")) {
                        readNetscapeExt();
                    } else {
                        skip();
                    }
                }
            } else if (i == 44) {
                int size = this.frames.size();
                readBitmap();
                if (this.frames.size() > size) {
                    this.mDecodeBmSize += (long) (this.image.getRowBytes() * this.image.getHeight());
                }
                if (this.mDecodeBmSize > this.mMaxDecodeSize) {
                    z = true;
                }
            } else if (i != 59) {
                this.status = 1;
            } else {
                this.mDecodeToTheEnd = true;
                z = true;
            }
        }
    }

    public void readGraphicControlExt() {
        read();
        int i = read();
        int i2 = (i & 28) >> 2;
        this.dispose = i2;
        if (i2 == 0) {
            this.dispose = 1;
        }
        this.transparency = (i & 1) != 0;
        int i3 = readShort() * 10;
        this.delay = i3;
        if (i3 <= 0) {
            this.delay = 100;
        }
        this.transIndex = read();
        read();
    }

    public void readHeader() {
        if (this.mCancel) {
            return;
        }
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) read());
        }
        if (!str.startsWith("GIF")) {
            this.status = 1;
            return;
        }
        readLSD();
        if (!this.gctFlag || err()) {
            return;
        }
        int[] colorTable = readColorTable(this.gctSize);
        this.gct = colorTable;
        this.bgColor = colorTable[this.bgIndex];
    }

    public void readLSD() {
        this.width = readShort();
        this.height = readShort();
        int i = read();
        this.gctFlag = (i & 128) != 0;
        this.gctSize = 2 << (i & 7);
        this.bgIndex = read();
        this.pixelAspect = read();
    }

    public void readNetscapeExt() {
        do {
            readBlock();
            byte[] bArr = this.block;
            if (bArr[0] == 1) {
                this.loopCount = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
    }

    public int readShort() {
        return read() | (read() << 8);
    }

    public void recycle() {
        Vector<GifFrame> vector = this.frames;
        if (vector != null) {
            int size = vector.size();
            for (int i = 0; i < size; i++) {
                this.frames.elementAt(i).recycle();
            }
        }
    }

    public void requestCancelDecode() {
        this.mCancel = true;
        requestCancel();
    }

    public void resetFrame() {
        this.lastDispose = this.dispose;
        this.lrx = this.ix;
        this.lry = this.iy;
        this.lrw = this.iw;
        this.lrh = this.ih;
        this.lastBitmap = this.image;
        this.lastBgColor = this.bgColor;
        this.dispose = 0;
        this.transparency = false;
        this.delay = 0;
        this.lct = null;
    }

    public void setMaxDecodeSize(long j) {
        this.mMaxDecodeSize = j;
    }

    public void setPixels() {
        Bitmap bitmap;
        int i;
        if (this.dest == null) {
            this.dest = new int[this.width * this.height];
        }
        int i2 = this.lastDispose;
        int i3 = 0;
        if (i2 > 0) {
            if (i2 == 3) {
                int frameCount = getFrameCount() - 2;
                if (frameCount > 0) {
                    Bitmap frame = getFrame(frameCount - 1);
                    if (!frame.equals(this.lastBitmap)) {
                        this.lastBitmap = frame;
                        int[] iArr = this.dest;
                        int i4 = this.width;
                        frame.getPixels(iArr, 0, i4, 0, 0, i4, this.height);
                    }
                } else {
                    this.lastBitmap = null;
                    this.dest = new int[this.width * this.height];
                }
            }
            if (this.lastBitmap != null && this.lastDispose == 2) {
                int i5 = !this.transparency ? this.lastBgColor : 0;
                int i6 = (this.lry * this.width) + this.lrx;
                for (int i7 = 0; i7 < this.lrh; i7++) {
                    int i8 = this.lrw + i6;
                    for (int i9 = i6; i9 < i8; i9++) {
                        this.dest[i9] = i5;
                    }
                    i6 += this.width;
                }
            }
        }
        int i10 = 8;
        int i11 = 0;
        int i12 = 1;
        while (true) {
            int i13 = this.ih;
            if (i3 >= i13) {
                break;
            }
            if (this.interlace) {
                if (i11 >= i13) {
                    i12++;
                    if (i12 == 2) {
                        i11 = 4;
                    } else if (i12 == 3) {
                        i11 = 2;
                        i10 = 4;
                    } else if (i12 == 4) {
                        i10 = 2;
                        i11 = 1;
                    }
                }
                i = i11 + i10;
            } else {
                i = i11;
                i11 = i3;
            }
            int i14 = i11 + this.iy;
            if (i14 < this.height) {
                int i15 = this.width;
                int i16 = i14 * i15;
                int i17 = this.ix + i16;
                int i18 = this.iw;
                int i19 = i17 + i18;
                if (i16 + i15 < i19) {
                    i19 = i16 + i15;
                }
                int i20 = i18 * i3;
                while (i17 < i19) {
                    int i21 = i20 + 1;
                    int i22 = this.act[this.pixels[i20] & 255];
                    if (i22 != 0) {
                        this.dest[i17] = i22;
                    }
                    i17++;
                    i20 = i21;
                }
            }
            i3++;
            i11 = i;
        }
        if (this.mDecodedFrames <= this.mStartFrame && (bitmap = this.image) != null && !bitmap.isRecycled()) {
            this.image.recycle();
        }
        this.image = Bitmap.createBitmap(this.dest, this.width, this.height, Bitmap.Config.ARGB_8888);
    }

    public void setStartFrame(int i) {
        this.mStartFrame = i;
    }

    public void skip() {
        do {
            readBlock();
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
    }

    public int read() {
        try {
            return this.in.read();
        } catch (Exception unused) {
            this.status = 1;
            return 0;
        }
    }
}
