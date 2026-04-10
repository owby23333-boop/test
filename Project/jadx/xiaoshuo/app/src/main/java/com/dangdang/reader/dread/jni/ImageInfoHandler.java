package com.dangdang.reader.dread.jni;

import com.dangdang.reader.dread.jni.BaseJniWarp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class ImageInfoHandler {
    private List<ImageInfo> mImageInfos = new ArrayList();

    public class ImageInfo {
        public String imageFile;
        public BaseJniWarp.ERect rect = new BaseJniWarp.ERect(0.0f, 0.0f, 0.0f, 0.0f);

        public ImageInfo() {
        }
    }

    public List<ImageInfo> getImageInfos() {
        return this.mImageInfos;
    }

    public void setImageCount(int i) {
    }

    public void setImageInfo(double d, double d2, double d3, double d4, String str) {
        ImageInfo imageInfo = new ImageInfo();
        BaseJniWarp.ERect eRect = imageInfo.rect;
        eRect.left = (float) d;
        eRect.right = (float) d3;
        eRect.top = (float) d2;
        eRect.bottom = (float) d4;
        imageInfo.imageFile = str;
        this.mImageInfos.add(imageInfo);
    }
}
