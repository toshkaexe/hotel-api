package hotel;

import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;

import javax.xml.transform.sax.SAXResult;
import java.util.Arrays;

//Есть два массива строк, нам нужно вернуть TRUE,
// если оба массива представляют собой одну и ту же строку. Иначе вернуть FALSE.
/*
["a", "b"] //FALSE
["a", "c", "b"]


["ab", "c"] //TRUE
["a", "bc"]


a = ["ab", "c"] //FALSE
b = ["ac", "bc"]
*/

public class TwoString  {

    public static class Hello{

    }

    public static void main(String[] args) {
        String[] array1 = {"ab", "c"};
        String[] array2 = {"a", "bc"};
        String[] array3 = {"aa","d"};

        System.out.println("Результат сравнения " + array1[0]+ array1[1]  +" и " + array2[0]+ array2[1] +" " +iStheSameStr(array1, array2));
        System.out.println("Результат сравнения " + array1[0]+ array1[1]  +" и " + array3[0]+ array3[1] +" "+ iStheSameStr(array1, array3));

        String sw ="eeed";
        String sw3 ="eeed";
         int xx= 5;
        System.out.println("BBdddd");
         boolean b1 =true;
         boolean b2 = false;
         if (b1) return;
         System.out.println("BB");

    }
    static boolean iStheSameStr(String[] array1, String[] array2){
        String str1 = String.join("",array1);
        String str2 = String.join("", array2);
        return str1.equals(str2);
    }

}

