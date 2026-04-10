package com.duokan.reader.domain.document.sbk;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class SbkSinglePageAnchor extends SbkPageAnchor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private SbkCharAnchor mEndAnchor;
    private CountDownLatch mGoStrong;
    private boolean mIsWeak;
    protected final long mPageOffset;
    protected final SbkSinglePageAnchor mRefAnchor;
    protected final long mRefAtomIndex;
    protected final long mRefChapterIndex;
    protected final long mRefParaIndex;
    private SbkCharAnchor mStartAnchor;
    private final SbkTypesettingContext mTypesettingContext;

    public SbkSinglePageAnchor(SbkTypesettingContext sbkTypesettingContext, SbkSinglePageAnchor sbkSinglePageAnchor, long j) {
        this.mIsWeak = true;
        this.mStartAnchor = null;
        this.mEndAnchor = null;
        this.mGoStrong = null;
        this.mTypesettingContext = sbkTypesettingContext;
        if (sbkSinglePageAnchor.getIsStrong()) {
            this.mRefAnchor = null;
            this.mRefChapterIndex = sbkSinglePageAnchor.getStartAnchor().getChapterIndex();
            this.mRefParaIndex = sbkSinglePageAnchor.getStartAnchor().getParaIndex();
            this.mRefAtomIndex = sbkSinglePageAnchor.getStartAnchor().getAtomIndex();
            this.mPageOffset = j;
            return;
        }
        this.mRefAnchor = sbkSinglePageAnchor;
        this.mRefChapterIndex = sbkSinglePageAnchor.mRefChapterIndex;
        this.mRefParaIndex = sbkSinglePageAnchor.mRefParaIndex;
        this.mRefAtomIndex = sbkSinglePageAnchor.mRefAtomIndex;
        this.mPageOffset = sbkSinglePageAnchor.mPageOffset + j;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean getIsValid() {
        if (this.mIsWeak) {
            return this.mTypesettingContext.f18917a;
        }
        return true;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean getIsWeak() {
        return this.mIsWeak;
    }

    public SbkTypesettingContext getTypesettingContext() {
        return this.mTypesettingContext;
    }

    public void goStrong(SbkCharAnchor sbkCharAnchor, SbkCharAnchor sbkCharAnchor2) {
        this.mStartAnchor = sbkCharAnchor;
        this.mEndAnchor = sbkCharAnchor2;
        this.mIsWeak = false;
        synchronized (this) {
            CountDownLatch countDownLatch = this.mGoStrong;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean waitForStrong() {
        if (!this.mIsWeak) {
            return true;
        }
        synchronized (this) {
            if (!this.mIsWeak) {
                return true;
            }
            if (this.mGoStrong == null) {
                this.mGoStrong = new CountDownLatch(1);
            }
            while (this.mIsWeak) {
                SbkTypesettingContext sbkTypesettingContext = this.mTypesettingContext;
                if (!sbkTypesettingContext.f18917a || sbkTypesettingContext.e()) {
                    break;
                }
                try {
                    this.mGoStrong.await(1L, TimeUnit.SECONDS);
                } catch (InterruptedException unused) {
                }
            }
            return !this.mIsWeak;
        }
    }

    @Override // com.duokan.reader.domain.document.sbk.SbkPageAnchor, com.duokan.reader.domain.document.RangeAnchor
    public SbkCharAnchor getEndAnchor() {
        if (waitForStrong()) {
            return this.mEndAnchor;
        }
        return null;
    }

    @Override // com.duokan.reader.domain.document.sbk.SbkPageAnchor, com.duokan.reader.domain.document.RangeAnchor
    public SbkCharAnchor getStartAnchor() {
        if (waitForStrong()) {
            return this.mStartAnchor;
        }
        return null;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean waitForStrong(long j) {
        SbkTypesettingContext sbkTypesettingContext;
        if (!this.mIsWeak) {
            return true;
        }
        synchronized (this) {
            if (!this.mIsWeak) {
                return true;
            }
            if (this.mGoStrong == null) {
                this.mGoStrong = new CountDownLatch(1);
            }
            do {
                try {
                    this.mGoStrong.await(j, TimeUnit.MILLISECONDS);
                } catch (InterruptedException unused) {
                }
                if (!this.mIsWeak) {
                    break;
                }
                sbkTypesettingContext = this.mTypesettingContext;
                if (!sbkTypesettingContext.f18917a) {
                    break;
                }
            } while (!sbkTypesettingContext.e());
            return !this.mIsWeak;
        }
    }

    public SbkSinglePageAnchor(SbkTypesettingContext sbkTypesettingContext, long j, long j2, long j3, long j4) {
        this.mIsWeak = true;
        this.mStartAnchor = null;
        this.mEndAnchor = null;
        this.mGoStrong = null;
        this.mTypesettingContext = sbkTypesettingContext;
        this.mRefAnchor = null;
        this.mRefChapterIndex = j;
        this.mRefParaIndex = j2;
        this.mRefAtomIndex = j3;
        this.mPageOffset = j4;
    }
}
