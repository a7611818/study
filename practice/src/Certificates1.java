import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Certificates1 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://appi.huaguilife.cn");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.connect();
        Certificate[] certs = conn.getServerCertificates();     //会拿到完整的证书链
//        X509Certificate cert = (X509Certificate)certs[ 0 ];     //cert[0]是证书链的最下层
        for (Certificate cert : certs) {
            X509Certificate cert1 = (X509Certificate)cert;
            System.out.println("序号：" + cert1.getSerialNumber());
            System.out.println("颁发给：" + cert1.getSubjectDN().getName());
            System.out.println("颁发者：" + cert1.getIssuerDN().getName());
            System.out.println("起始：" + cert1.getNotBefore());
            System.out.println("过期：" + cert1.getNotAfter());
            System.out.println("算法：" + cert1.getSigAlgName());
        }
//        System.out.println( "序号："  + cert.getSerialNumber());
//        System.out.println( "颁发给："  + cert.getSubjectDN().getName());
//        System.out.println( "颁发者："  + cert.getIssuerDN().getName());
//        System.out.println( "起始："  + cert.getNotBefore());
//        System.out.println( "过期："  + cert.getNotAfter());
//        System.out.println( "算法："  + cert.getSigAlgName());
//        System.out.println( "指纹："  + getThumbPrint(cert));
        conn.disconnect();
    }

}