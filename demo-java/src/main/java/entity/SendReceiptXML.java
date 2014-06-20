package entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenxi.chen on 2014/06/19/上午11:16.
 */
@XmlRootElement(name="SendReceipt")
public class SendReceiptXML extends CommonRequestXML{

    private String DianpingSerial;
    private String SerialCount;
    private List<String> SerialList;
    private String MobileNo;


    @XmlElement(name="DianpingSerial")
    public String getDianpingSerial() {
        return DianpingSerial;
    }

    public void setDianpingSerial(String dianpingSerial) {
        DianpingSerial = dianpingSerial;
    }

    @XmlElement(name="SerialCount")
    public String getSerialCount() {
        return SerialCount;
    }

    public void setSerialCount(String serialCount) {
        SerialCount = serialCount;
    }

    @XmlElementWrapper(name="SerialList")
    @XmlElement(name="Serial")
    public List<String> getSerialList() {
        return SerialList;
    }

    public void setSerialList(List<String> serialList) {
        SerialList = serialList;
    }

    @XmlElement(name="MobileNo")
    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }


}
