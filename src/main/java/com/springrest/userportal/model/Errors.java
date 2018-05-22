package com.springrest.userportal.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Errors",
        propOrder = {"errors"}
)
@XmlRootElement(
        name = "Errors"
)
public class Errors implements Serializable {

    private static final long serialVersionUID = 1L;
    @XmlElement(
            name = "Error"
    )
    protected List<Error> errors;

    public Errors() {
    }

    public List<Error> getErrors() {
        if (this.errors == null) {
            this.errors = new ArrayList();
        }

        return this.errors;
    }

    public Errors(List<Error> error) {
        this.errors = error;
    }
}
