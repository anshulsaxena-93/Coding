import java.util.regex.Matcher; 
import java.util.regex.Pattern;
class Solution {
    
    public String validIPAddress(String IP) {
        
        //Valid 172.16.254.1
        //Invalid 172.16.254.01
        //Invalid 172.16..1
        //Regex for (0-255\\.){3}(0-255)
        String rIPv4 = "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        
        Pattern p1 = Pattern.compile(rIPv4);
        Matcher m1 = p1.matcher(IP); 
        if(m1.matches()){
            return "IPv4";
        }
        
        //Valid 2001:0db8:85a3:0000:0000:8a2e:0370:7334
        //Valid 2001:db8:85a3:0:0:8A2E:0370:7334
        //Invalid 2001:0db8:85a3::8A2E:0370:7334
        //Invalid 02001:0db8:85a3:0000:0000:8a2e:0370:7334
        String rIPv6 = "(([0-9a-fA-F]{1,4})\\:){7}([0-9a-fA-F]{1,4})";
        
        Pattern p2 = Pattern.compile(rIPv6);
        Matcher m2 = p2.matcher(IP); 
        if(m2.matches()){
            return "IPv6";
        }
        
        return "Neither";
    }
}    
