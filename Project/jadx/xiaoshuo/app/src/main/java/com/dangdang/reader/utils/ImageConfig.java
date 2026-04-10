package com.dangdang.reader.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class ImageConfig {
    public static final String IMAGE_SIZE_AA = "210X300";
    private static final String IMAGE_SIZE_AA_FLAG = "aa";
    public static final String IMAGE_SIZE_BB = "182X260";
    private static final String IMAGE_SIZE_BB_FLAG = "bb";
    public static final String IMAGE_SIZE_CC = "168X240";
    private static final String IMAGE_SIZE_CC_FLAG = "cc";
    public static final String IMAGE_SIZE_DD = "126X180";
    private static final String IMAGE_SIZE_DD_FLAG = "dd";
    public static final String IMAGE_SIZE_EE = "112X160";
    private static final String IMAGE_SIZE_EE_FLAG = "ee";
    public static final String IMAGE_SIZE_FF = "98X140";
    private static final String IMAGE_SIZE_FF_FLAG = "ff";
    public static final String IMAGE_SIZE_GG = "84X120";
    private static final String IMAGE_SIZE_GG_FLAG = "gg";
    public static final String IMAGE_SIZE_HH = "70X100";
    private static final String IMAGE_SIZE_HH_FLAG = "hh";
    public static final String IMAGE_SIZE_II = "280X400";
    private static final String IMAGE_SIZE_II_FLAG = "ii";
    public static final String IMAGE_SIZE_JJ = "252X360";
    private static final String IMAGE_SIZE_JJ_FLAG = "jj";
    public static final String IMAGE_SIZE_KK = "154X220";
    private static final String IMAGE_SIZE_KK_FLAG = "kk";
    public static final String IMAGE_SIZE_LL = "140X200";
    private static final String IMAGE_SIZE_LL_FLAG = "ll";
    private static List<String> PAPER_IAMGE_FLAGS = null;
    private static List<String> PAPER_IMAGE_SIZES = null;
    public static final String PAPER_IMAGE_SIZE_B = "200X200";
    private static final String PAPER_IMAGE_SIZE_B_FLAG = "b";
    public static final String PAPER_IMAGE_SIZE_E = "500X500";
    private static final String PAPER_IMAGE_SIZE_E_FLAG = "e";
    public static final String PAPER_IMAGE_SIZE_W = "350X350";
    private static final String PAPER_IMAGE_SIZE_W_FLAG = "w";
    private static List<String> SIZES = new ArrayList();
    private static List<String> FLAGS = new ArrayList();

    static {
        SIZES.add(IMAGE_SIZE_AA);
        FLAGS.add(IMAGE_SIZE_AA_FLAG);
        SIZES.add(IMAGE_SIZE_BB);
        FLAGS.add(IMAGE_SIZE_BB_FLAG);
        SIZES.add(IMAGE_SIZE_CC);
        FLAGS.add(IMAGE_SIZE_CC_FLAG);
        SIZES.add(IMAGE_SIZE_DD);
        FLAGS.add(IMAGE_SIZE_DD_FLAG);
        SIZES.add(IMAGE_SIZE_EE);
        FLAGS.add(IMAGE_SIZE_EE_FLAG);
        SIZES.add(IMAGE_SIZE_FF);
        FLAGS.add(IMAGE_SIZE_FF_FLAG);
        SIZES.add(IMAGE_SIZE_GG);
        FLAGS.add(IMAGE_SIZE_GG_FLAG);
        SIZES.add(IMAGE_SIZE_HH);
        FLAGS.add(IMAGE_SIZE_HH_FLAG);
        SIZES.add(IMAGE_SIZE_II);
        FLAGS.add("ii");
        SIZES.add(IMAGE_SIZE_JJ);
        FLAGS.add(IMAGE_SIZE_JJ_FLAG);
        SIZES.add(IMAGE_SIZE_KK);
        FLAGS.add(IMAGE_SIZE_KK_FLAG);
        SIZES.add(IMAGE_SIZE_LL);
        FLAGS.add(IMAGE_SIZE_LL_FLAG);
        PAPER_IMAGE_SIZES = new ArrayList();
        PAPER_IAMGE_FLAGS = new ArrayList();
        PAPER_IMAGE_SIZES.add(PAPER_IMAGE_SIZE_B);
        PAPER_IAMGE_FLAGS.add("b");
        PAPER_IMAGE_SIZES.add(PAPER_IMAGE_SIZE_W);
        PAPER_IAMGE_FLAGS.add(PAPER_IMAGE_SIZE_W_FLAG);
        PAPER_IMAGE_SIZES.add(PAPER_IMAGE_SIZE_E);
        PAPER_IAMGE_FLAGS.add(PAPER_IMAGE_SIZE_E_FLAG);
    }

    public static String getBookCoverBySize(String str, String str2) {
        int iIndexOf;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (iIndexOf = SIZES.indexOf(str2)) < 0) {
            return str;
        }
        return str.replaceFirst("_[\\w]{0,9}_cover", "_" + FLAGS.get(iIndexOf) + "_cover");
    }

    public static String getPaperBookCoverBySize(String str, String str2) {
        int iIndexOf;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (iIndexOf = PAPER_IMAGE_SIZES.indexOf(str2)) < 0) {
            return str;
        }
        return str.replaceFirst("_[\\w]", "_" + PAPER_IAMGE_FLAGS.get(iIndexOf));
    }
}
