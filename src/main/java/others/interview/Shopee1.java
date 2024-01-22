package others.interview;

/**
 * @author enyi.lr
 * @version $Id: Shopee1.java, v 0.1 2020‐01‐18 12:45 AM enyi.lr Exp $$
 */
public class Shopee1 {
    public String reverse(String s){
        String[] s1 = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            char[] chars = s1[i].toCharArray();
            StringBuilder builder = new StringBuilder();
            for (int i1 = chars.length-1; i1 >= 0; i1--) {
                builder.append(chars[i1]);
            }
            stringBuilder.append(builder.toString()).append(" ");
        }
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }

    public static void main(String[] args) {
        Shopee1 shopee1 = new Shopee1();
        String i_love_shopee = shopee1.reverse("I love shopee");
        System.out.println(i_love_shopee);

    }
}