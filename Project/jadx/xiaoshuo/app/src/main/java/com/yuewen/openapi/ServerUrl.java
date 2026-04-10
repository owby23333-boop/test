package com.yuewen.openapi;

/* JADX INFO: loaded from: classes8.dex */
public class ServerUrl {
    public static final String ADD_BOOKSHELF = "/bookshelf/addbookshelf";
    public static final String ADD_BOOK_READ_PROGRESS = "/process/addprocess";
    public static final String CONFIG = "/index/getsetting";
    public static final String DEBUG_URL = "https://213opensdk.sparta.html5.qq.com";
    public static final String DELETE_BOOKSHELF = "/bookshelf/delbookshelf";
    public static final String GET_BOOKINFO = "/book/getbookinfo";
    public static final String GET_BOOKSHELF_LIST = "/bookshelf/getbookshelflist";
    public static final String GET_BOOK_READ_HISTORY = "/process/getprocesslist";
    public static final String GET_BOOK_READ_PROGRESS = "/process/getbookprocess";
    public static final String GET_CHAPTER_CONTENT = "/chapter/getchaptercontent";
    public static final String GET_CHAPTER_INFO = "/chapter/getchapterinfo";
    public static final String GET_CHAPTER_OUTLINE = "/chapter/getchapterlist";
    public static final String KEY_SEARCH = "/search/searchbykeywords";
    public static final String LOGIN = "/public/login";
    public static final String RELEASE_URL = "https://opensdkapi.qidian.com";
    public static String sBaseUrl = null;
    public static boolean sIsDebug = false;

    static {
        sBaseUrl = sIsDebug ? DEBUG_URL : RELEASE_URL;
    }

    public static String getBaseUrl() {
        return sBaseUrl;
    }
}
