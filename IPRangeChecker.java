import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

/**
 * Created by zybinskiy.dmitriy on 07.07.2016.
 */
public class IPRangeChecker {
    public static void main(String[] args) {
        try {
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String x=reader.readLine();
            String y=reader.readLine();
            long start = host2long(x);
            long end = host2long(y);
            for (long i=start; i<=end; i++) {
                System.out.println(long2dotted(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static long ip2long(InetAddress ip) {
        long l=0;
        byte[] addr = ip.getAddress();
        if (addr.length == 4) { //IPV4
            for (int i=0;i<4;++i) {
                l += (((long)addr[i] &0xFF) << 8*(3-i));
            }
        } else { //IPV6
            return 0;  // I dont know how to deal with these
        }
        return l;
    }


    public static long host2long(String host) {
        long ip=0;
        if (!Character.isDigit(host.charAt(0))) return -1;
        int[] addr = ip2intarray(host);
        if (addr == null) return -1;
        for (int i=0;i<addr.length;++i) {
            ip += ((long)(addr[i]>=0 ? addr[i] : 0)) << 8*(3-i);
        }
        return ip;
    }

    public static int[] ip2intarray(String host) {
        int[] address = {-1,-1,-1,-1};
        int i=0;
        StringTokenizer tokens = new StringTokenizer(host,".");
        if (tokens.countTokens() > 4) return null;
        while (tokens.hasMoreTokens()) {
            try {
                address[i++] = Integer.parseInt(tokens.nextToken()) & 0xFF;
            } catch(NumberFormatException nfe) {
                return null;
            }
        }
        return address;
    }

    public static String long2dotted(long address) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0, shift = 24; i < 4; i++, shift -= 8) {
            long value = (address >> shift) & 0xff;
            sb.append(value);
            if (i != 3) {
                sb.append('.');
            }
        }
        return sb.toString();
    }

}
