package xiao.ze.demo.utils;

/**
 * @author xiaoze
 * @date 2019/1/26
 */
public class Utils {
    public static String getStr(String[] strArr){
        StringBuffer sb = new StringBuffer();
        for(String req:strArr){
            sb.append(req).append("|");
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}
