package com.realdolmen.course.exceptions;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FaultBean
{
    private String internalCode;
    @XmlAttribute(name = "notFound")
    public String getInternalCode(){
        return internalCode;
    }
    public void setInternalCode(String ic) {
        this.internalCode = ic;
    }
}
