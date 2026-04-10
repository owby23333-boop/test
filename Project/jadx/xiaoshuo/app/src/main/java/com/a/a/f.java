package com.a.a;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class f extends X509Certificate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final X509Certificate f1617a;

    public f(X509Certificate x509Certificate) {
        this.f1617a = x509Certificate;
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() throws CertificateNotYetValidException, CertificateExpiredException {
        this.f1617a.checkValidity();
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        return this.f1617a.getBasicConstraints();
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        return this.f1617a.getCriticalExtensionOIDs();
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() {
        return this.f1617a.getEncoded();
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        return this.f1617a.getExtensionValue(str);
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        return this.f1617a.getIssuerDN();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        return this.f1617a.getIssuerUniqueID();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        return this.f1617a.getKeyUsage();
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        return this.f1617a.getNonCriticalExtensionOIDs();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        return this.f1617a.getNotAfter();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        return this.f1617a.getNotBefore();
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        return this.f1617a.getPublicKey();
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        return this.f1617a.getSerialNumber();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        return this.f1617a.getSigAlgName();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        return this.f1617a.getSigAlgOID();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        return this.f1617a.getSigAlgParams();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        return this.f1617a.getSignature();
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        return this.f1617a.getSubjectDN();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        return this.f1617a.getSubjectUniqueID();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() {
        return this.f1617a.getTBSCertificate();
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        return this.f1617a.getVersion();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        return this.f1617a.hasUnsupportedCriticalExtension();
    }

    @Override // java.security.cert.Certificate
    public String toString() {
        return this.f1617a.toString();
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        this.f1617a.verify(publicKey);
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) throws CertificateNotYetValidException, CertificateExpiredException {
        this.f1617a.checkValidity(date);
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        this.f1617a.verify(publicKey, str);
    }
}
