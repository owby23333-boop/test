package com.dangdang.reader.dread.config;

import java.util.HashSet;

/* JADX INFO: loaded from: classes10.dex */
public enum PageType {
    Common,
    FullScreen,
    FrontCover,
    NoHeader,
    NoFooter,
    Gallery,
    Audio,
    Video,
    CodeInteractive,
    TableInteractive,
    AcrossPage,
    Gif,
    Animation,
    CoverRect,
    Image;

    public static final int Type_AcrossPage = 512;
    public static final int Type_Animation = 2048;
    public static final int Type_Audio = 32;
    public static final int Type_CodeInteractive = 128;
    public static final int Type_Common = 0;
    public static final int Type_CoverRect = 4096;
    public static final int Type_FrontCover = 2;
    public static final int Type_FullScreen = 1;
    public static final int Type_Gallery = 16;
    public static final int Type_Gif = 1024;
    public static final int Type_Image = 8192;
    public static final int Type_NoFooter = 8;
    public static final int Type_NoHeader = 4;
    public static final int Type_TableInteractive = 256;
    public static final int Type_Video = 64;

    public static HashSet<PageType> convert(int i) {
        HashSet<PageType> hashSet = new HashSet<>();
        if ((i & 0) == 0) {
            hashSet.add(Common);
        }
        if ((i & 1) == 1) {
            hashSet.add(FullScreen);
        }
        if ((i & 2) == 2) {
            hashSet.add(FrontCover);
        }
        if ((i & 4) == 4) {
            hashSet.add(NoHeader);
        }
        if ((i & 8) == 8) {
            hashSet.add(NoFooter);
        }
        if ((i & 16) == 16) {
            hashSet.add(Gallery);
        }
        if ((i & 32) == 32) {
            hashSet.add(Audio);
        }
        if ((i & 64) == 64) {
            hashSet.add(Video);
        }
        if ((i & 128) == 128) {
            hashSet.add(CodeInteractive);
        }
        if ((i & 256) == 256) {
            hashSet.add(TableInteractive);
        }
        if ((i & 512) == 512) {
            hashSet.add(AcrossPage);
        }
        if ((i & 1024) == 1024) {
            hashSet.add(Gif);
        }
        if ((i & 2048) == 2048) {
            hashSet.add(Animation);
        }
        if ((i & 4096) == 4096) {
            hashSet.add(CoverRect);
        }
        if ((i & 8192) == 8192) {
            hashSet.add(Image);
        }
        return hashSet;
    }

    public static boolean isGallary(HashSet<PageType> hashSet) {
        if (hashSet == null || hashSet.size() == 0) {
            return false;
        }
        return hashSet.contains(Gallery);
    }

    public static boolean isNoFooter(HashSet<PageType> hashSet) {
        if (hashSet == null || hashSet.size() == 0) {
            return false;
        }
        return hashSet.contains(FullScreen) || hashSet.contains(FrontCover) || hashSet.contains(AcrossPage) || hashSet.contains(NoFooter);
    }

    public static boolean isNoHeader(HashSet<PageType> hashSet) {
        if (hashSet == null || hashSet.size() == 0) {
            return false;
        }
        return hashSet.contains(FullScreen) || hashSet.contains(FrontCover) || hashSet.contains(AcrossPage) || hashSet.contains(NoHeader);
    }
}
