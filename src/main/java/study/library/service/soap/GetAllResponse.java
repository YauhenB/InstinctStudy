
package study.library.service.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAllResponse", namespace = "http://service.library.study/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllResponse", namespace = "http://service.library.study/")
public class GetAllResponse {

    @XmlElement(name = "return", namespace = "")
    private List<study.library.model.User> _return;

    /**
     * 
     * @return
     *     returns List<User>
     */
    public List<study.library.model.User> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<study.library.model.User> _return) {
        this._return = _return;
    }

}
