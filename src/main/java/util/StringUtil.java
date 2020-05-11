package util;

class StringUtil{
    /**
     * 首字母大写
     */
    public static String capitalize(String str){
        if(str == null || "".equals(str)){
            return str;
        }
        if(str.length() == 1){
            return str.toUpperCase();
        } else{
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }
}
