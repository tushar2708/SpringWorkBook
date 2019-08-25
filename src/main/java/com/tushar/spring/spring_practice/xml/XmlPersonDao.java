package com.tushar.spring.spring_practice.xml;

// If a bean is managed via XML, following annotations aren't needed
//@Component
public class XmlPersonDao {

    //    @Autowired
    XmlJdbcConnection xmlJdbcConnection;


    public XmlJdbcConnection getXmlJdbcConnection() {
        return xmlJdbcConnection;
    }

    public void setXmlJdbcConnection(XmlJdbcConnection xmlJdbcConnection) {
        this.xmlJdbcConnection = xmlJdbcConnection;
    }
}
