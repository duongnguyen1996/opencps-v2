//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.02.14 at 11:11:50 AM ICT 
//


package org.opencps.api.v21.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaymentConfig" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="govAgencyCode">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="govAgencyName">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="govAgencyTaxNo">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="1000"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="invoiceTemplateNo">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="invoiceIssueNo">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="invoiceLastNo">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="bankInfo">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="epaymentConfig">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="invoiceForm">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "paymentConfig"
})
@XmlRootElement(name = "PaymentConfigList")
public class PaymentConfigList {

    @XmlElement(name = "PaymentConfig", required = true)
    protected List<PaymentConfigList.PaymentConfig> paymentConfig;

    /**
     * Gets the value of the paymentConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentConfigList.PaymentConfig }
     * 
     * 
     */
    public List<PaymentConfigList.PaymentConfig> getPaymentConfig() {
        if (paymentConfig == null) {
            paymentConfig = new ArrayList<PaymentConfigList.PaymentConfig>();
        }
        return this.paymentConfig;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="govAgencyCode">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="govAgencyName">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="govAgencyTaxNo">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="1000"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="invoiceTemplateNo">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="invoiceIssueNo">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="invoiceLastNo">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="bankInfo">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="epaymentConfig">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="invoiceForm">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "govAgencyCode",
        "govAgencyName",
        "govAgencyTaxNo",
        "invoiceTemplateNo",
        "invoiceIssueNo",
        "invoiceLastNo",
        "bankInfo",
        "epaymentConfig",
        "invoiceForm"
    })
    public static class PaymentConfig {

        @XmlElement(required = true)
        protected String govAgencyCode;
        @XmlElement(required = true)
        protected String govAgencyName;
        @XmlElement(required = true)
        protected String govAgencyTaxNo;
        @XmlElement(required = true)
        protected String invoiceTemplateNo;
        @XmlElement(required = true)
        protected String invoiceIssueNo;
        @XmlElement(required = true)
        protected String invoiceLastNo;
        @XmlElement(required = true)
        protected String bankInfo;
        @XmlElement(required = true)
        protected String epaymentConfig;
        @XmlElement(required = true)
        protected String invoiceForm;

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
         * Gets the value of the invoiceLastNo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInvoiceLastNo() {
            return invoiceLastNo;
        }

        /**
         * Sets the value of the invoiceLastNo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInvoiceLastNo(String value) {
            this.invoiceLastNo = value;
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
         * Gets the value of the epaymentConfig property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEpaymentConfig() {
            return epaymentConfig;
        }

        /**
         * Sets the value of the epaymentConfig property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEpaymentConfig(String value) {
            this.epaymentConfig = value;
        }

        /**
         * Gets the value of the invoiceForm property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInvoiceForm() {
            return invoiceForm;
        }

        /**
         * Sets the value of the invoiceForm property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInvoiceForm(String value) {
            this.invoiceForm = value;
        }

    }

}
