
package study.library.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getBookResponse", namespace = "http://service.library.study/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getBookResponse", namespace = "http://service.library.study/")
public class GetBookResponse {

    @XmlElement(name = "return", namespace = "")
    private study.library.model.Book _return;

    /**
     * 
     * @return
     *     returns Book
     */
    public study.library.model.Book getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(study.library.model.Book _return) {
        this._return = _return;
    }

}
