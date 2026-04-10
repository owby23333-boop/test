package com.duokan.reader.domain.cloud;

import com.yuewen.gh0;
import com.yuewen.tl4;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Date;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DkCloudAnnotation extends DkCloudItem {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final String mAnnotationId;
    private final String mBookRevision;
    private final Date mCreationDate;
    private final gh0 mEndPos;
    private final String mKernelVersion;
    private final Date mModifiedDate;
    private final String mSample;
    private final gh0 mStartPos;

    public class a implements Comparator<DkCloudAnnotation> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(DkCloudAnnotation dkCloudAnnotation, DkCloudAnnotation dkCloudAnnotation2) {
            gh0 startPos = dkCloudAnnotation.getStartPos();
            gh0 startPos2 = dkCloudAnnotation2.getStartPos();
            if (startPos == null || !startPos.g(startPos2)) {
                return (startPos == null || !startPos.f(startPos2)) ? 0 : 1;
            }
            return -1;
        }
    }

    public DkCloudAnnotation(String str, String str2, String str3, long j, Date date, Date date2, gh0 gh0Var, gh0 gh0Var2, String str4) {
        super(j);
        this.mBookRevision = str;
        this.mKernelVersion = str2;
        this.mAnnotationId = str3;
        this.mCreationDate = date;
        this.mModifiedDate = date2;
        this.mStartPos = gh0Var;
        this.mEndPos = gh0Var2;
        this.mSample = str4;
    }

    public static Comparator<DkCloudAnnotation> createComparator() {
        return new a();
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public void fillXmlNode(Node node) {
        xmlInsertDate(node, "CreateTime", this.mCreationDate);
        xmlInsertDate(node, "LastModifyTime", this.mModifiedDate);
        if (this.mEndPos == null) {
            xmlInsertRefPos(node, "RefPos", this.mStartPos);
        } else {
            xmlInsertRefPos(node, "BeginRefPos", this.mStartPos);
            xmlInsertRefPos(node, "EndRefPos", this.mEndPos);
        }
        tl4.j(node, "DataID", this.mAnnotationId);
        tl4.j(node, "RefContent", this.mSample);
    }

    public String getBookRevision() {
        return this.mBookRevision;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public String getCloudId() {
        return this.mAnnotationId;
    }

    public Date getCreationDate() {
        return this.mCreationDate;
    }

    public gh0 getEndPos() {
        return this.mEndPos;
    }

    public String getKernelVersion() {
        return this.mKernelVersion;
    }

    public Date getModifiedDate() {
        return this.mModifiedDate;
    }

    public String getSample() {
        return this.mSample;
    }

    public gh0 getStartPos() {
        return this.mStartPos;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public DkCloudItem merge(DkCloudItem dkCloudItem) {
        DkCloudAnnotation dkCloudAnnotation = (DkCloudAnnotation) dkCloudItem;
        return getCloudVersion() != dkCloudItem.getCloudVersion() ? getCloudVersion() > dkCloudAnnotation.getCloudVersion() ? this : dkCloudAnnotation : getModifiedDate().after(dkCloudAnnotation.getModifiedDate()) ? this : dkCloudAnnotation;
    }

    public DkCloudAnnotation(String str, String str2, Node node, long j) throws DOMException, ParseException {
        super(node, j);
        this.mBookRevision = str;
        this.mKernelVersion = str2;
        this.mAnnotationId = tl4.g(node, "DataID");
        Date dateXmlOptDate = xmlOptDate(node, "CreateTime", new Date(0L));
        this.mCreationDate = dateXmlOptDate;
        this.mModifiedDate = xmlOptDate(node, "LastModifyTime", dateXmlOptDate);
        if (tl4.h(node, "RefPos")) {
            this.mStartPos = xmlGetRefPos(node, "RefPos");
            this.mEndPos = null;
        } else {
            this.mStartPos = xmlGetRefPos(node, "BeginRefPos");
            this.mEndPos = xmlGetRefPos(node, "EndRefPos");
        }
        this.mSample = tl4.g(node, "RefContent");
    }
}
