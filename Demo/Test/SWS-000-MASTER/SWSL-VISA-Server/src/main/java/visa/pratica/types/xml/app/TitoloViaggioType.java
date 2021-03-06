//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.21 at 12:38:52 PM EEST 
//


package visa.pratica.types.xml.app;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TitoloViaggioType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TitoloViaggioType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroTitoloViaggio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataEmissioneTitoloViaggio" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="dataScadenzaTitoloViaggio" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="validitaStatiSchengen" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statoEmissione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TitoloViaggioType", propOrder = {
    "numeroTitoloViaggio",
    "dataEmissioneTitoloViaggio",
    "dataScadenzaTitoloViaggio",
    "validitaStatiSchengen",
    "statoEmissione"
})
public class TitoloViaggioType {

    @XmlElement(required = true)
    protected String numeroTitoloViaggio;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataEmissioneTitoloViaggio;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataScadenzaTitoloViaggio;
    @XmlElement(required = true)
    protected String validitaStatiSchengen;
    @XmlElement(required = true)
    protected String statoEmissione;

    /**
     * Gets the value of the numeroTitoloViaggio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroTitoloViaggio() {
        return numeroTitoloViaggio;
    }

    /**
     * Sets the value of the numeroTitoloViaggio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroTitoloViaggio(String value) {
        this.numeroTitoloViaggio = value;
    }

    /**
     * Gets the value of the dataEmissioneTitoloViaggio property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataEmissioneTitoloViaggio() {
        return dataEmissioneTitoloViaggio;
    }

    /**
     * Sets the value of the dataEmissioneTitoloViaggio property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataEmissioneTitoloViaggio(XMLGregorianCalendar value) {
        this.dataEmissioneTitoloViaggio = value;
    }

    /**
     * Gets the value of the dataScadenzaTitoloViaggio property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataScadenzaTitoloViaggio() {
        return dataScadenzaTitoloViaggio;
    }

    /**
     * Sets the value of the dataScadenzaTitoloViaggio property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataScadenzaTitoloViaggio(XMLGregorianCalendar value) {
        this.dataScadenzaTitoloViaggio = value;
    }

    /**
     * Gets the value of the validitaStatiSchengen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValiditaStatiSchengen() {
        return validitaStatiSchengen;
    }

    /**
     * Sets the value of the validitaStatiSchengen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValiditaStatiSchengen(String value) {
        this.validitaStatiSchengen = value;
    }

    /**
     * Gets the value of the statoEmissione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatoEmissione() {
        return statoEmissione;
    }

    /**
     * Sets the value of the statoEmissione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatoEmissione(String value) {
        this.statoEmissione = value;
    }

}
