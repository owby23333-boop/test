package com.duokan.reader.domain.document.txt;

import com.yuewen.qt1;
import com.yuewen.u64;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class TxtSinglePageAnchor extends TxtPageAnchor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long PER_MAX_WAIT_TIME = 500;
    private static final String TAG = "TxtSinglePageAnchor";
    private TxtCharAnchor mEndAnchor;
    private CountDownLatch mGoStrong;
    private boolean mIsWeak;
    protected final long mPageOffset;
    protected final boolean mRefAbsOffset;
    protected final TxtSinglePageAnchor mRefAnchor;
    protected final long mRefByteOffset;
    private TxtCharAnchor mStartAnchor;
    private final u64 mTypesettingContext;
    private long remainWaitTime;

    public TxtSinglePageAnchor(u64 u64Var, TxtSinglePageAnchor txtSinglePageAnchor, long j) {
        this.mIsWeak = true;
        this.mStartAnchor = null;
        this.mEndAnchor = null;
        this.mGoStrong = null;
        this.remainWaitTime = 2000L;
        this.mTypesettingContext = u64Var;
        if (txtSinglePageAnchor.getIsStrong()) {
            this.mRefAnchor = null;
            this.mRefByteOffset = txtSinglePageAnchor.getStartAnchor().getByteOffset();
            this.mRefAbsOffset = true;
            this.mPageOffset = j;
            return;
        }
        this.mRefAnchor = txtSinglePageAnchor;
        this.mRefByteOffset = txtSinglePageAnchor.mRefByteOffset;
        this.mRefAbsOffset = txtSinglePageAnchor.mRefAbsOffset;
        this.mPageOffset = txtSinglePageAnchor.mPageOffset + j;
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

    public u64 getTypesettingContext() {
        return this.mTypesettingContext;
    }

    public void goStrong(TxtCharAnchor txtCharAnchor, TxtCharAnchor txtCharAnchor2) {
        this.mStartAnchor = txtCharAnchor;
        this.mEndAnchor = txtCharAnchor2;
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
        return waitForStrong(500L);
    }

    @Override // com.duokan.reader.domain.document.txt.TxtPageAnchor, com.duokan.reader.domain.document.RangeAnchor
    public TxtCharAnchor getEndAnchor() {
        if (waitForStrong()) {
            return this.mEndAnchor;
        }
        return null;
    }

    @Override // com.duokan.reader.domain.document.txt.TxtPageAnchor, com.duokan.reader.domain.document.RangeAnchor
    public TxtCharAnchor getStartAnchor() {
        if (waitForStrong()) {
            return this.mStartAnchor;
        }
        return null;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean waitForStrong(long j) {
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
            long jCurrentTimeMillis = 0;
            if (this.remainWaitTime <= 0) {
                return !this.mIsWeak;
            }
            long jMax = Math.max(100L, Math.min(j, 500L));
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            while (this.mIsWeak) {
                u64 u64Var = this.mTypesettingContext;
                if (!u64Var.f18917a || u64Var.e() || jCurrentTimeMillis >= jMax) {
                    break;
                }
                try {
                    this.mGoStrong.await(100L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException unused) {
                }
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            }
            if (jCurrentTimeMillis >= jMax) {
                qt1.i(TAG, hashCode() + " txt single wait for full, time(ms) = " + jMax);
                this.remainWaitTime = this.remainWaitTime - jMax;
            }
            qt1.a(TAG, hashCode() + " txt single wait for, time(ms) = " + jCurrentTimeMillis);
            return !this.mIsWeak;
        }
    }

    public TxtSinglePageAnchor(u64 u64Var, long j, boolean z, long j2) {
        this.mIsWeak = true;
        this.mStartAnchor = null;
        this.mEndAnchor = null;
        this.mGoStrong = null;
        this.remainWaitTime = 2000L;
        this.mTypesettingContext = u64Var;
        this.mRefAnchor = null;
        this.mRefByteOffset = j;
        this.mRefAbsOffset = z;
        this.mPageOffset = j2;
    }
}
