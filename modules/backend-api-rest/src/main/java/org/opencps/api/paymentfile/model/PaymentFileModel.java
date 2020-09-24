//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.03 at 04:30:11 PM ICT 
//


package org.opencps.api.paymentfile.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentFileModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentFileModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modifiedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referenceUid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="govAgencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="govAgencyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="applicantName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="applicantIdNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isNew" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="paymentFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advanceAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feeAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentAmount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="paymentNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="epaymentProfile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentStatus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="paymentMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confirmDatetime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confirmPayload" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confirmFileType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confirmFileSize" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="confirmNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="approveDatetime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="govAgencyTaxNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceTemplateNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceIssueNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoicePayload" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="einvoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentFileModel", propOrder = {
    "createDate",
    "modifiedDate",
    "referenceUid",
    "govAgencyCode",
    "govAgencyName",
    "applicantName",
    "applicantIdNo",
    "isNew",
    "paymentFee",
    "advanceAmount",
    "feeAmount",
    "serviceAmount",
    "shipAmount",
    "paymentAmount",
    "paymentNote",
    "bankInfo",
    "epaymentProfile",
    "paymentStatus",
    "paymentMethod",
    "confirmDatetime",
    "confirmPayload",
    "confirmFileType",
    "confirmFileSize",
    "confirmNote",
    "approveDatetime",
    "accountUserName",
    "govAgencyTaxNo",
    "invoiceTemplateNo",
    "invoiceIssueNo",
    "invoiceNo",
    "invoicePayload",
    "einvoice",
    "paymentFileId",
    "address",
    "orderId"
})
@XmlRootElement(name = "PaymentFileModel")
public class PaymentFileModel {

    protected String createDate;
    protected String modifiedDate;
    protected String referenceUid;
    protected String govAgencyCode;
    protected String govAgencyName;
    protected String applicantName;
    protected String applicantIdNo;
    protected Integer isNew;
    protected String paymentFee;
    protected Long advanceAmount;
    protected Long feeAmount;
    protected Long serviceAmount;
    protected Long shipAmount;
    protected Long paymentAmount;
    protected String paymentNote;
    protected String bankInfo;
    protected String epaymentProfile;
    protected Integer paymentStatus;
    protected String paymentMethod;
    protected String confirmDatetime;
    protected String confirmPayload;
    protected String confirmFileType;
    protected Long confirmFileSize;
    protected String confirmNote;
    protected String approveDatetime;
    protected String accountUserName;
    protected String govAgencyTaxNo;
    protected String invoiceTemplateNo;
    protected String invoiceIssueNo;
    protected String invoiceNo;
    protected String invoicePayload;
    protected String einvoice;
    protected Long paymentFileId;
    protected String address;
    protected String orderId;


    /**
     * Gets the value of the createDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * Sets the value of the createDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateDate(String value) {
        this.createDate = value;
    }

    /**
     * Gets the value of the modifiedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModifiedDate() {
        return modifiedDate;
    }

    /**
     * Sets the value of the modifiedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModifiedDate(String value) {
        this.modifiedDate = value;
    }

    /**
     * Gets the value of the referenceUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceUid() {
        return referenceUid;
    }

    /**
     * Sets the value of the referenceUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceUid(String value) {
        this.referenceUid = value;
    }

    /**
     * Gets the value of the govAgencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGovAgencyCode() {
        return govAgencyCode;
    }

    /**
     * Sets the value of the govAgencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGovAgencyCode(String value) {
        this.govAgencyCode = value;
    }

    /**
     * Gets the value of the govAgencyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGovAgencyName() {
        return govAgencyName;
    }

    /**
     * Sets the value of the govAgencyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGovAgencyName(String value) {
        this.govAgencyName = value;
    }

    /**
     * Gets the value of the applicantName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicantName() {
        return applicantName;
    }

    /**
     * Sets the value of the applicantName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicantName(String value) {
        this.applicantName = value;
    }

    /**
     * Gets the value of the applicantIdNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicantIdNo() {
        return applicantIdNo;
    }

    /**
     * Sets the value of the applicantIdNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicantIdNo(String value) {
        this.applicantIdNo = value;
    }

    /**
     * Gets the value of the isNew property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIsNew() {
        return isNew;
    }

    /**
     * Sets the value of the isNew property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIsNew(Integer value) {
        this.isNew = value;
    }

    /**
     * Gets the value of the paymentFee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentFee() {
        return paymentFee;
    }

    /**
     * Sets the value of the paymentFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentFee(String value) {
        this.paymentFee = value;
    }

    /**
     * Gets the value of the advanceAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getAdvanceAmount() {
        return advanceAmount;
    }

    /**
     * Sets the value of the advanceAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvanceAmount(Long value) {
        this.advanceAmount = value;
    }

    /**
     * Gets the value of the feeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getFeeAmount() {
        return feeAmount;
    }

    /**
     * Sets the value of the feeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeAmount(Long value) {
        this.feeAmount = value;
    }

    /**
     * Gets the value of the serviceAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getServiceAmount() {
        return serviceAmount;
    }

    /**
     * Sets the value of the serviceAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceAmount(Long value) {
        this.serviceAmount = value;
    }

    /**
     * Gets the value of the shipAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getShipAmount() {
        return shipAmount;
    }

    /**
     * Sets the value of the shipAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipAmount(Long value) {
        this.shipAmount = value;
    }

    /**
     * Gets the value of the paymentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * Sets the value of the paymentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPaymentAmount(Long value) {
        this.paymentAmount = value;
    }

    /**
     * Gets the value of the paymentNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentNote() {
        return paymentNote;
    }

    /**
     * Sets the value of the paymentNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentNote(String value) {
        this.paymentNote = value;
    }

    /**
     * Gets the value of the bankInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankInfo() {
        return bankInfo;
    }

    /**
     * Sets the value of the bankInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankInfo(String value) {
        this.bankInfo = value;
    }

    /**
     * Gets the value of the epaymentProfile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEpaymentProfile() {
        return epaymentProfile;
    }

    /**
     * Sets the value of the epaymentProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEpaymentProfile(String value) {
        this.epaymentProfile = value;
    }

    /**
     * Gets the value of the paymentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * Sets the value of the paymentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPaymentStatus(Integer value) {
        this.paymentStatus = value;
    }

    /**
     * Gets the value of the paymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the value of the paymentMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMethod(String value) {
        this.paymentMethod = value;
    }

    /**
     * Gets the value of the confirmDatetime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmDatetime() {
        return confirmDatetime;
    }

    /**
     * Sets the value of the confirmDatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmDatetime(String value) {
        this.confirmDatetime = value;
    }

    /**
     * Gets the value of the confirmPayload property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmPayload() {
        return confirmPayload;
    }

    /**
     * Sets the value of the confirmPayload property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmPayload(String value) {
        this.confirmPayload = value;
    }

    /**
     * Gets the value of the confirmFileType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmFileType() {
        return confirmFileType;
    }

    /**
     * Sets the value of the confirmFileType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmFileType(String value) {
        this.confirmFileType = value;
    }

    /**
     * Gets the value of the confirmFileSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getConfirmFileSize() {
        return confirmFileSize;
    }

    /**
     * Sets the value of the confirmFileSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setConfirmFileSize(Long value) {
        this.confirmFileSize = value;
    }

    /**
     * Gets the value of the confirmNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmNote() {
        return confirmNote;
    }

    /**
     * Sets the value of the confirmNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmNote(String value) {
        this.confirmNote = value;
    }

    /**
     * Gets the value of the approveDatetime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveDatetime() {
        return approveDatetime;
    }

    /**
     * Sets the value of the approveDatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveDatetime(String value) {
        this.approveDatetime = value;
    }

    /**
     * Gets the value of the accountUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountUserName() {
        return accountUserName;
    }

    /**
     * Sets the value of the accountUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountUserName(String value) {
        this.accountUserName = value;
    }

    /**
     * Gets the value of the govAgencyTaxNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGovAgencyTaxNo() {
        return govAgencyTaxNo;
    }

    /**
     * Sets the value of the govAgencyTaxNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGovAgencyTaxNo(String value) {
        this.govAgencyTaxNo = value;
    }

    /**
     * Gets the value of the invoiceTemplateNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceTemplateNo() {
        return invoiceTemplateNo;
    }

    /**
     * Sets the value of the invoiceTemplateNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceTemplateNo(String value) {
        this.invoiceTemplateNo = value;
    }

    /**
     * Gets the value of the invoiceIssueNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceIssueNo() {
        return invoiceIssueNo;
    }

    /**
     * Sets the value of the invoiceIssueNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceIssueNo(String value) {
        this.invoiceIssueNo = value;
    }

    /**
     * Gets the value of the invoiceNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * Sets the value of the invoiceNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceNo(String value) {
        this.invoiceNo = value;
    }

    /**
     * Gets the value of the invoicePayload property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoicePayload() {
        return invoicePayload;
    }

    /**
     * Sets the value of the invoicePayload property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoicePayload(String value) {
        this.invoicePayload = value;
    }

    /**
     * Gets the value of the einvoice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEinvoice() {
        return einvoice;
    }

    /**
     * Sets the value of the einvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEinvoice(String value) {
        this.einvoice = value;
    }

	public Long getPaymentFileId() {
		return paymentFileId;
	}

	public void setPaymentFileId(Long paymentFileId) {
		this.paymentFileId = paymentFileId;
	}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
