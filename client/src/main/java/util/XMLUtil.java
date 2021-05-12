package util;

public class XMLUtil {

    public static String generateTag(String tag,String content){
        return String.format("<%s>%s</%s>",tag,content,tag);
    }

}
