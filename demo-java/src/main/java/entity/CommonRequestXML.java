package entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by chenxi.chen on 2014/06/19/下午4:31.
 */
public class CommonRequestXML {
    private String SequenceId;
    private String ThirdPartyId;
    private String ThirdPartyKey;
    private String DealId;
    private String OrderId;

    @XmlElement(name="SequenceId")
    public String getSequenceId() {
        return SequenceId;
    }

    public void setSequenceId(String sequenceId) {
        SequenceId = sequenceId;
    }

    @XmlElement(name="ThirdpartyId")
    public String getThirdPartyId() {
        return ThirdPartyId;
    }

    public void setThirdPartyId(String thirdPartyId) {
        ThirdPartyId = thirdPartyId;
    }

    @XmlElement(name="ThirdpartyKey")
    public String getThirdPartyKey() {
        return ThirdPartyKey;
    }

    public void setThirdPartyKey(String thirdPartyKey) {
        ThirdPartyKey = thirdPartyKey;
    }

    @XmlElement(name="DealId")
    public String getDealId() {
        return DealId;
    }

    public void setDealId(String dealId) {
        DealId = dealId;
    }


    @XmlElement(name="OrderId")
    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

}
