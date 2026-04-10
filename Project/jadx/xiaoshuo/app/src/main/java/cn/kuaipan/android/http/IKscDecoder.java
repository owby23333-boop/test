package cn.kuaipan.android.http;

import java.util.zip.DataFormatException;

/* JADX INFO: loaded from: classes.dex */
public interface IKscDecoder extends Cloneable {
    boolean canEnd();

    IKscDecoder clone();

    void end();

    void fillData(byte[] bArr, int i, int i2);

    void init();

    int needFill();

    int readDecodeData(byte[] bArr, int i, int i2) throws DataFormatException;

    void skip(long j);

    boolean supportRepeat();
}
