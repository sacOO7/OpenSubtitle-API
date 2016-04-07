
import org.apache.xmlrpc.XmlRpcException;

import java.io.IOException;

public class Main {

    public static void main( String[] args ) throws IOException, XmlRpcException {
        OpenSubtitle openSubtitle=new OpenSubtitle();
        openSubtitle.login();
        openSubtitle.ServerInfo();
        openSubtitle.logOut();
    }
}

