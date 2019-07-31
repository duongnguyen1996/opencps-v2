//
//This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
//See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
//Any modifications to this file will be lost upon recompilation of the source schema. 
//Generated on: 2017.11.18 at 10:22:43 AM ICT 
//


package org.opencps.api.dossieraction.model;

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
*         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
*         &lt;element name="data" type="{}DossierActionNextActionModel" maxOccurs="unbounded" minOccurs="0"/>
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
 "checkInput",
 "users",
 "stepCode",
 "stepName",
 "stepDueDate",
 "stepOverdue",
 "total",
 "data"
})
@XmlRootElement(name = "data")
public class DossierNextActionResultsModel {

 protected Integer checkInput;
 protected List<DossierActionNextActiontoUser> users;
 protected String stepCode;
 protected String stepName;
 protected long stepDueDate;
 protected String stepOverdue;
 protected Integer total;
 protected List<DossierNextActionModel> data;

 /**
  * Gets the value of the total property.
  * 
  * @return
  *     possible object is
  *     {@link Integer }
  *     
  */
 public Integer getTotal() {
     return total;
 }

 /**
  * Sets the value of the total property.
  * 
  * @param value
  *     allowed object is
  *     {@link Integer }
  *     
  */
 public void setTotal(Integer value) {
     this.total = value;
 }

 /**
  * Gets the value of the checkInput property.
  * 
  * @return
  *     possible object is
  *     {@link Integer }
  *     
  */
 public Integer getCheckInput() {
     return checkInput;
 }

 /**
  * Sets the value of the checkInput property.
  * 
  * @param value
  *     allowed object is
  *     {@link Integer }
  *     
  */
 public void setCheckInput(Integer value) {
     this.checkInput = value;
 }
 
 /**
  * Gets the value of the data property.
  * 
  * <p>
  * This accessor method returns a reference to the live list,
  * not a snapshot. Therefore any modification you make to the
  * returned list will be present inside the JAXB object.
  * This is why there is not a <CODE>set</CODE> method for the data property.
  * 
  * <p>
  * For example, to add a new item, do as follows:
  * <pre>
  *    getData().add(newItem);
  * </pre>
  * 
  * 
  * <p>
  * Objects of the following type(s) are allowed in the list
  * {@link DossierActionNextActionModel }
  * 
  * 
  */
 public List<DossierNextActionModel> getData() {
     if (data == null) {
         data = new ArrayList<DossierNextActionModel>();
     }
     return this.data;
 }

	public List<DossierActionNextActiontoUser> getUsers() {
		return users;
	}

	public void setUsers(List<DossierActionNextActiontoUser> users) {
		this.users = users;
	}
 
	public String getStepCode() {
		return stepCode;
	}
	public void setStepCode(String value) {
		this.stepCode = value;
	}
	public String getStepName() {
		return stepName;
	}
	public void setStepName(String value) {
		this.stepName = value;
	}
	public long getStepDueDate() {
		return stepDueDate;
	}
	public void setStepDueDate(long value) {
		this.stepDueDate = value;
	}
	public String getStepOverdue() {
		return stepOverdue;
	}
	public void setStepOverdue(String value) {
		this.stepOverdue = value;
	}
	
}
