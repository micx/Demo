package entity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by chenxi.chen on 2014/06/19/下午1:33.
 */
public class ObjectToXMLUtils {

    public static String getXMLString(Object object,Class clazz) {
        JAXBContext context;
        try {
            StringWriter writer = new StringWriter();
            context = JAXBContext.newInstance(clazz);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            mar.setProperty(Marshaller.JAXB_ENCODING, "GBK");
            mar.marshal(object, writer);
            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
