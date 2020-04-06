import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3 5 7
 */
public class Main {

    public int ipToInt(String ip){
        String[] nums = ip.split("\\.");
        if (nums.length!=4) return 0;
        int result = (Integer.parseInt(nums[0])<<24)
                + (Integer.parseInt(nums[1])<<16)
                + (Integer.parseInt(nums[2])<<8)
                + Integer.parseInt(nums[3]);
        return result;
    }

    public String intToIp(int num){

        String ip = ((num >> 24) & 255) + "." + ((num >> 16) & 255) + "."
                + ((num >> 8) & 255) + "." + (num & 255);
        return ip;
    }

    public static void main(String[] args) {
        Main main = new Main();
        try {
            InetAddress ip = Inet4Address.getLocalHost();
            System.out.println(ip.getHostAddress());
            int num = main.ipToInt(ip.getHostAddress());
            System.out.println(num);
            System.out.println(main.intToIp(num));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}