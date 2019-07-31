//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.01 at 05:22:36 PM ICT 
//


package org.opencps.api.dossiertemplate.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="dossierTemplateId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="createDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modifiedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="templateName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="templateNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newFormScript" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dossierParts" type="{}DossierTemplatePartDataModel" maxOccurs="unbounded" minOccurs="0"/>
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
    "dossierTemplateId",
    "createDate",
    "modifiedDate",
    "templateName",
    "description",
    "templateNo",
    "newFormScript",
    "dossierParts"
})
@XmlRootElement(name = "DossierTemplateDetailModel")
public class DossierTemplateDetailModel {

    protected Long dossierTemplateId;
    protected String createDate;
    protected String modifiedDate;
    protected String templateName;
    protected String description;
    protected String templateNo;
    protected String newFormScript;
    protected List<DossierTemplatePartDataModel> dossierParts;

    /**
     * Gets the value of the dossierTemplateId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDossierTemplateId() {
        return dossierTemplateId;
    }

    /**
     * Sets the value of the dossierTemplateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDossierTemplateId(Long value) {
        this.dossierTemplateId = value;
    }

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
     * Gets the value of the templateName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * Sets the value of the templateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateName(String value) {
        this.templateName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the templateNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateNo() {
        return templateNo;
    }

    /**
     * Sets the value of the templateNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateNo(String value) {
        this.templateNo = value;
    }

    /**
     * Gets the value of the newFormScript property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewFormScript() {
        return newFormScript;
    }

    /**
     * Sets the value of the newFormScript property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewFormScript(String value) {
        this.newFormScript = value;
    }    
    
    /**
     * Gets the value of the dossierParts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dossierParts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDossierParts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DossierTemplatePartDataModel }
     * 
     * 
     */
    public List<DossierTemplatePartDataModel> getDossierParts() {
        if (dossierParts == null) {
            dossierParts = new ArrayList<DossierTemplatePartDataModel>();
        }
        return this.dossierParts;
    }

}
