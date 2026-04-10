package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.reader.domain.document.Anchor;
import com.duokan.reader.domain.document.CharAnchor;
import com.duokan.reader.domain.document.PointAnchor;
import com.duokan.reader.domain.document.RangeAnchor;
import com.yuewen.bc;
import com.yuewen.iw2;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class EpubCharAnchor extends CharAnchor implements bc.a {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long mAtomIndex;
    private String mBookRevision;
    private long mByteOffset;
    protected long mCachedChapterPageIndex;
    private WeakReference<EpubTypesettingContext> mCachedIndexContextReference;
    private String mChapterId;
    private long mChapterIndex;
    private boolean mIsCalibrated;
    private String mKernelVersion;
    private long mParaIndex;

    public EpubCharAnchor(long j, long j2, long j3) {
        this(j, j2, j3, "", "", -1L, "");
    }

    public static EpubCharAnchor valueOf(String str) {
        try {
            return valueOf(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean calibrate(com.duokan.kernel.epublib.DkeBook r15) {
        /*
            r14 = this;
            boolean r0 = r14.mIsCalibrated
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            boolean r0 = r14.getIsStrong()
            if (r0 != 0) goto Ld
            return r1
        Ld:
            boolean r0 = r14.getIsPermanent()
            if (r0 != 0) goto L14
            return r1
        L14:
            java.lang.String r0 = r14.mKernelVersion
            com.yuewen.qx0 r2 = com.yuewen.qx0.f()
            java.lang.String r2 = r2.g()
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L25
            return r1
        L25:
            long r2 = r14.mChapterIndex
            long[] r0 = r15.getChapterOffsetRange(r2)
            r2 = r0[r1]
            r4 = 1
            r12 = r0[r4]
            int r0 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r0 < 0) goto L35
            return r1
        L35:
            long r10 = r14.mChapterIndex
            long r8 = r14.mByteOffset
            r5 = r15
            r6 = r10
            com.duokan.kernel.DkFlowPosition[] r0 = r5.getFlowPositionRange(r6, r8, r10, r12)
            r1 = r0[r1]
            long r2 = r1.mChapterIndex
            r5 = 0
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 != 0) goto L84
            long r7 = r1.mParaIndex
            int r7 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r7 != 0) goto L84
            long r7 = r1.mAtomIndex
            int r7 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r7 != 0) goto L84
            r0 = r0[r4]
            long r7 = r0.mChapterIndex
            int r7 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r7 != 0) goto L84
            long r7 = r0.mParaIndex
            int r7 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r7 != 0) goto L84
            long r7 = r0.mAtomIndex
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 != 0) goto L84
            long r10 = r14.mChapterIndex
            r8 = 0
            long r12 = r14.mByteOffset
            r5 = r15
            r6 = r10
            com.duokan.kernel.DkFlowPosition[] r15 = r5.getFlowPositionRange(r6, r8, r10, r12)
            r15 = r15[r4]
            long r0 = r15.mChapterIndex
            r14.mChapterIndex = r0
            long r0 = r15.mParaIndex
            r14.mParaIndex = r0
            long r0 = r15.mAtomIndex
            r14.mAtomIndex = r0
            goto L8e
        L84:
            r14.mChapterIndex = r2
            long r2 = r1.mParaIndex
            r14.mParaIndex = r2
            long r0 = r1.mAtomIndex
            r14.mAtomIndex = r0
        L8e:
            com.yuewen.qx0 r15 = com.yuewen.qx0.f()
            java.lang.String r15 = r15.g()
            r14.mKernelVersion = r15
            r14.mIsCalibrated = r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.epub.EpubCharAnchor.calibrate(com.duokan.kernel.epublib.DkeBook):boolean");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EpubCharAnchor)) {
            return false;
        }
        EpubCharAnchor epubCharAnchor = (EpubCharAnchor) obj;
        return this.mChapterIndex == epubCharAnchor.mChapterIndex && this.mParaIndex == epubCharAnchor.mParaIndex && this.mAtomIndex == epubCharAnchor.mAtomIndex;
    }

    @Override // com.duokan.reader.domain.document.CharAnchor
    public long getAtomIndex() {
        return this.mAtomIndex;
    }

    public String getBookRevision() {
        return this.mBookRevision;
    }

    @Override // com.duokan.reader.domain.document.CharAnchor
    public long getByteOffset() {
        return this.mByteOffset;
    }

    public EpubTypesettingContext getCachedIndexContextReference() {
        WeakReference<EpubTypesettingContext> weakReference = this.mCachedIndexContextReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.duokan.reader.domain.document.CharAnchor
    public String getChapterId() {
        return this.mChapterId;
    }

    @Override // com.duokan.reader.domain.document.CharAnchor
    public long getChapterIndex() {
        return this.mChapterIndex;
    }

    public long getChapterPageIndex() {
        return this.mCachedChapterPageIndex;
    }

    public DkFlowPosition getDkFlowPosition(DkeBook dkeBook) {
        return new DkFlowPosition(this.mChapterIndex, this.mParaIndex, this.mAtomIndex);
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean getIsCalibrated() {
        return this.mIsCalibrated;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean getIsPermanent() {
        return this.mByteOffset >= 0;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean getIsValid() {
        return true;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean getIsWeak() {
        return false;
    }

    public String getKernelVersion() {
        return this.mKernelVersion;
    }

    @Override // com.duokan.reader.domain.document.CharAnchor
    public long getParaIndex() {
        return this.mParaIndex;
    }

    public String getSimpleString() {
        return "EpubCharAnchor{mChapterIndex=" + this.mChapterIndex + ", mParaIndex=" + this.mParaIndex + ", mAtomIndex=" + this.mAtomIndex + '}';
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean isAfter(Anchor anchor) {
        if (anchor instanceof RangeAnchor) {
            return isAfterOrEqual(((RangeAnchor) anchor).getEndAnchor());
        }
        EpubCharAnchor epubCharAnchor = (EpubCharAnchor) anchor;
        long j = this.mChapterIndex;
        long j2 = epubCharAnchor.mChapterIndex;
        if (j > j2) {
            return true;
        }
        if (j != j2 || this.mParaIndex <= epubCharAnchor.mParaIndex) {
            return j == j2 && this.mParaIndex == epubCharAnchor.mParaIndex && this.mAtomIndex > epubCharAnchor.mAtomIndex;
        }
        return true;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean isBefore(Anchor anchor) {
        if (anchor instanceof RangeAnchor) {
            return isBefore(((RangeAnchor) anchor).getStartAnchor());
        }
        if (!(anchor instanceof EpubCharAnchor)) {
            return false;
        }
        EpubCharAnchor epubCharAnchor = (EpubCharAnchor) anchor;
        long j = this.mChapterIndex;
        long j2 = epubCharAnchor.mChapterIndex;
        if (j < j2) {
            return true;
        }
        if (j != j2 || this.mParaIndex >= epubCharAnchor.mParaIndex) {
            return j == j2 && this.mParaIndex == epubCharAnchor.mParaIndex && this.mAtomIndex < epubCharAnchor.mAtomIndex;
        }
        return true;
    }

    public boolean isFirstPage() {
        return this.mChapterIndex == 0 && this.mAtomIndex == 0 && this.mParaIndex == 0;
    }

    public boolean isPrefacePage() {
        return this.mChapterIndex == 0 && (this.mAtomIndex < 0 || this.mParaIndex < 0);
    }

    @Override // com.yuewen.bc.a
    public PointAnchor parsePointAnchor(JSONObject jSONObject) {
        return valueOf(jSONObject);
    }

    public void setCachedIndexContextReference(EpubTypesettingContext epubTypesettingContext) {
        this.mCachedIndexContextReference = new WeakReference<>(epubTypesettingContext);
    }

    public void setChapterId(String str) {
        this.mChapterId = str;
    }

    public void setChapterIndex(long j) {
        this.mChapterIndex = j;
    }

    @Override // com.duokan.reader.domain.document.PointAnchor
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("chapter_index", getChapterIndex());
            jSONObject.put("para_index", getParaIndex());
            jSONObject.put("atom_index", getAtomIndex());
            jSONObject.put(iw2.t, getBookRevision());
            jSONObject.put("chapter_id", getChapterId());
            jSONObject.put("byte_offset", getByteOffset());
            jSONObject.put("kernel_version", getKernelVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return toJson().toString();
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean waitForStrong() {
        return true;
    }

    public EpubCharAnchor(long j, long j2, long j3, String str, String str2, long j4, String str3) {
        this.mIsCalibrated = false;
        this.mCachedChapterPageIndex = -1L;
        this.mCachedIndexContextReference = null;
        this.mChapterIndex = j;
        this.mParaIndex = j2;
        this.mAtomIndex = j3;
        this.mBookRevision = str;
        this.mChapterId = str2;
        this.mByteOffset = j4;
        this.mKernelVersion = str3;
    }

    @Override // com.duokan.reader.domain.document.Anchor
    public boolean waitForStrong(long j) {
        return true;
    }

    public static EpubCharAnchor valueOf(JSONObject jSONObject) {
        try {
            return new EpubCharAnchor(jSONObject.optLong("chapter_index", 0L), jSONObject.optLong("para_index", 0L), jSONObject.optLong("atom_index", 0L), jSONObject.optString(iw2.t), jSONObject.optString("chapter_id"), jSONObject.optLong("byte_offset", -1L), jSONObject.optString("kernel_version"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
