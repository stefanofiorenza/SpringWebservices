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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeliveryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliveryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="riferimentoPratica" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="esitoDeliveryCodice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="esitoDeliveryDescrizione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryType", propOrder = {
    "riferimentoPratica",
    "esitoDeliveryCodice",
    "esitoDeliveryDescrizione"
})
public class DeliveryType {

    @XmlElement(required = true)
    protected String riferimentoPratica;
    protected int esitoDeliveryCodice;
    @XmlElement(required = true)
    protected String esitoDeliveryDescrizione;

    /**
     * Gets the value of the riferimentoPratica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRiferimentoPratica() {
        return riferimentoPratica;
    }

    /**
     * Sets the value of the riferimentoPratica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRiferimentoPratica(String value) {
        this.riferimentoPratica = value;
    }

    /**
     * Gets the value of the esitoDeliveryCodice property.
     * 
     */
    public int getEsitoDeliveryCodice() {
        return esitoDeliveryCodice;
    }

    /**
     * Sets the value of the esitoDeliveryCodice property.
     * 
     */
    public void setEsitoDeliveryCodice(int value) {
        this.esitoDeliveryCodice = value;
    }

    /**
     * Gets the value of the esitoDeliveryDescrizione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsitoDeliveryDescrizione() {
        return esitoDeliveryDescrizione;
    }

    /**
     * Sets the value of the esitoDeliveryDescrizione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsitoDeliveryDescrizione(String value) {
        this.esitoDeliveryDescrizione = value;
    }

}