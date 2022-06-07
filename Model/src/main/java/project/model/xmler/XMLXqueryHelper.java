package project.model.xmler;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.stream.StreamResult;
import net.sf.saxon.Configuration;
import net.sf.saxon.query.DynamicQueryContext;
import net.sf.saxon.query.StaticQueryContext;
import net.sf.saxon.query.XQueryExpression;
import net.sf.saxon.trans.XPathException;

public class XMLXqueryHelper {
    public static void xQuery(String outputFile, String queryFile, String method) throws XPathException, IOException {
        Configuration configuration = new Configuration();
        StaticQueryContext staticQueryContext = new StaticQueryContext(configuration);
        XQueryExpression xqueryExpression = staticQueryContext.compileQuery(new FileReader(queryFile));
        DynamicQueryContext dynamicContext = new DynamicQueryContext(configuration);

        Properties props = new Properties();
        props.setProperty(OutputKeys.METHOD, method);
        xqueryExpression.run(dynamicContext, new StreamResult(new File(outputFile)), props);
    }

    public static void xQueryToText(String outputFile, String queryFile) throws XPathException, IOException{
        xQuery(outputFile, queryFile, "text");
    }

    public static void xQueryToHtml(String outputFile, String queryFile) throws XPathException, IOException{
        xQuery(outputFile, queryFile, "html");
    }

    public static void xQueryToXml(String outputFile, String queryFile) throws XPathException, IOException{
        xQuery(outputFile, queryFile, "xml");
    }
}
