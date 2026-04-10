package com.hjq.permissions;

/* JADX INFO: loaded from: classes2.dex */
final class ManifestException extends RuntimeException {
    ManifestException() {
        super("No permissions are registered in the manifest file");
    }

    ManifestException(String str) {
        super(str + ": Permissions are not registered in the manifest file");
    }
}
