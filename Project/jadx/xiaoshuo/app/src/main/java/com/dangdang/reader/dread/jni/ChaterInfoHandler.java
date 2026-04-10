package com.dangdang.reader.dread.jni;

import com.dangdang.reader.dread.format.PageInfo;
import com.dangdang.zframework.log.LogM;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class ChaterInfoHandler implements Serializable {
    private static final long serialVersionUID = 1;
    private List<PageInfo> pageInfos = new ArrayList();
    private List<ALabelInfo> labelInfos = new ArrayList(1);
    private int weightedTextCount = 0;

    public int getFirstElementIndex() {
        if (this.pageInfos.size() <= 0) {
            return 0;
        }
        try {
            return this.pageInfos.get(0).getStartIndex();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<ALabelInfo> getLabelInfos() {
        return this.labelInfos;
    }

    public ALabelInfo getLableInfoByAnchor(String str) {
        int size = this.labelInfos.size();
        for (int i = 0; i < size; i++) {
            ALabelInfo aLabelInfo = this.labelInfos.get(i);
            if (aLabelInfo.isSame(str)) {
                return aLabelInfo;
            }
        }
        return null;
    }

    public int getLastElementIndex() {
        int size = this.pageInfos.size();
        if (size > 0) {
            try {
                return this.pageInfos.get(size - 1).getEndIndex();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int getPageIndexByAnchor(String str) {
        int size = this.labelInfos.size();
        for (int i = 0; i < size; i++) {
            ALabelInfo aLabelInfo = this.labelInfos.get(i);
            if (aLabelInfo.isSame(str)) {
                return aLabelInfo.getPageIndex();
            }
        }
        return 0;
    }

    public int getPageIndexByElementIndex(int i) {
        int size = this.pageInfos.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.pageInfos.get(i2).hasContain(i)) {
                return i2;
            }
        }
        return 0;
    }

    public PageInfo getPageInfo(int i) {
        int i2 = i - 1;
        if (i2 >= 0) {
            try {
                if (i2 < this.pageInfos.size()) {
                    return this.pageInfos.get(i2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<PageInfo> getPageInfos() {
        return this.pageInfos;
    }

    public int getWeightedTextCount() {
        return this.weightedTextCount;
    }

    public void printLog(String str) {
        LogM.i(getClass().getSimpleName(), str);
    }

    public void reset() {
        this.pageInfos.clear();
        this.labelInfos.clear();
    }

    public void setAnchorInfo(int i, int i2, int i3, String str) {
        ALabelInfo aLabelInfo = new ALabelInfo();
        aLabelInfo.setStartIndex(i);
        aLabelInfo.setEndIndex(i2);
        aLabelInfo.setPageIndex(i3);
        aLabelInfo.setAnchor(str);
        this.labelInfos.add(aLabelInfo);
    }

    public void setPageRange(int i, int i2) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setStartIndex(i);
        pageInfo.setEndIndex(i2);
        this.pageInfos.add(pageInfo);
    }

    public void setWeightedTextCount(int i) {
        this.weightedTextCount = i;
    }
}
