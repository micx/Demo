package entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenxi.chen on 2014/06/19/下午1:57.
 */
@XmlRootElement(name="VerifyReceipt")
public class VerifyReceiptXML extends CommonRequestXML{


    private List<String> SerialList;

    @XmlElementWrapper(name="SerialList")
    @XmlElement(name="Serial")
    public List<String> getSerialList() {
        return SerialList;
    }

    public void setSerialList(List<String> serialList) {
        SerialList = serialList;
    }

}
