package com.yuewen;

import com.duokan.kernel.epublib.DkeResourceStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class jr0 implements DkeResourceStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final my0 f13045a;

    public jr0(my0 my0Var) {
        this.f13045a = my0Var;
    }

    @Override // com.duokan.kernel.epublib.DkeResourceStream
    public void close() {
        this.f13045a.close();
    }

    @Override // com.duokan.kernel.epublib.DkeResourceStream
    public long getLength() {
        return this.f13045a.getLength();
    }

    @Override // com.duokan.kernel.epublib.DkeResourceStream
    public boolean isLowQuality() {
        return this.f13045a.isLowQuality();
    }

    @Override // com.duokan.kernel.epublib.DkeResourceStream
    public boolean isOpen() {
        return this.f13045a.isOpen();
    }

    @Override // com.duokan.kernel.epublib.DkeResourceStream
    public int read(ByteBuffer byteBuffer, long j) {
        return this.f13045a.read(byteBuffer, j);
    }

    @Override // com.duokan.kernel.epublib.DkeResourceStream
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DkeResourceStream m914clone() {
        return new jr0(this.f13045a.clone());
    }
}
