package com.duokan.reader.domain.document.pdf;

import com.yuewen.hh2;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class PdfSinglePageAnchor extends PdfPageAnchor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private PdfCharAnchor mEndAnchor;
    private CountDownLatch mGoStrong;
    private boolean mIsWeak;
    protected final long mPageOffset;
    protected final boolean mRefAbsIndices;
    protected final PdfSinglePageAnchor mRefAnchor;
    protected final long mRefAtomIndex;
    protected final long mRefFixedIndex;
    protected final long mRefNodeIndex;
    private PdfCharAnchor mStartAnchor;
    private final hh2 mTypesettingContext;

    public PdfSinglePageAnchor(hh2 hh2Var, PdfSinglePageAnchor pdfSinglePageAnchor, long j) {
        this.mIsWeak = true;
        this.mStartAnchor = null;
        this.mEndAnchor = null;
        this.mGoStrong = null;
        this.mTypesettingContext = hh2Var;
        if (pdfSinglePageAnchor.getIsStrong()) {
            this.mRefAnchor = null;
            this.mRefFixedIndex = pdfSinglePageAnchor.getStartAnchor().getFixedIndex();
            this.mRefNodeIndex = pdfSinglePageAnchor.getStartAnchor().getNodeIndex();
            this.mRefAtomIndex = pdfSinglePageAnchor.getStartAnchor().getAtomIndex();
            this.mRefAbsIndices = true;
            this.mPageOffset = j;
            return;
        }
        this.mRefAnchor = pdfSinglePageAnchor;
        this.mRefFixedIndex = pdfSinglePageAnchor.mRefFixedIndex;
        this.mRefNodeIndex = pdfSinglePageAnchor.mRefNodeIndex;
        this.mRefAtomIndex = pdfSinglePageAnchor.mRefAtomIndex;
        this.mRefAbsIndices = pdfSinglePageAnchor.mRefAbsIndices;
        this.mPageOffset = pdfSinglePageAnchor.mPageOffset + j;
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

    public hh2 getTypesettingContext() {
        return this.mTypesettingContext;
    }

    public void goStrong(PdfCharAnchor pdfCharAnchor, PdfCharAnchor pdfCharAnchor2) {
        this.mStartAnchor = pdfCharAnchor;
        this.mEndAnchor = pdfCharAnchor2;
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
                hh2 hh2Var = this.mTypesettingContext;
                if (!hh2Var.f18917a || hh2Var.e()) {
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

    @Override // com.duokan.reader.domain.document.pdf.PdfPageAnchor, com.duokan.reader.domain.document.RangeAnchor
    public PdfCharAnchor getEndAnchor() {
        if (waitForStrong()) {
            return this.mEndAnchor;
        }
        return null;
    }

    @Override // com.duokan.reader.domain.document.pdf.PdfPageAnchor, com.duokan.reader.domain.document.RangeAnchor
    public PdfCharAnchor getStartAnchor() {
        if (waitForStrong()) {
            return this.mStartAnchor;
        }
        return null;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean waitForStrong(long j) {
        hh2 hh2Var;
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
                hh2Var = this.mTypesettingContext;
                if (!hh2Var.f18917a) {
                    break;
                }
            } while (!hh2Var.e());
            return !this.mIsWeak;
        }
    }

    public PdfSinglePageAnchor(hh2 hh2Var, long j, long j2, long j3, boolean z, long j4) {
        this.mIsWeak = true;
        this.mStartAnchor = null;
        this.mEndAnchor = null;
        this.mGoStrong = null;
        this.mTypesettingContext = hh2Var;
        this.mRefAnchor = null;
        this.mRefFixedIndex = j;
        this.mRefNodeIndex = j2;
        this.mRefAtomIndex = j3;
        this.mRefAbsIndices = z;
        this.mPageOffset = j4;
    }
}
