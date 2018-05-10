import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
public class WidgetApp {

    public int[] prisonForPrincesses( int[] prisons, int[] princesses, int entrance )
    {
        int i = 0, j = 0;
        Boolean flag=true;
        HashMap<Integer,Integer> prisonMap = new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> princessMap = new HashMap<Integer, Integer>();
        int counter = 1, biscuit = 1, result[] = new int[princesses.length];
        for( i=0;i < prisons.length;i++ ){
            prisonMap.put(counter,prisons[i]);
            counter++;
        }
        counter = 1;
        for( j=0;j < princesses.length;j++ ){
            princessMap.put(counter, princesses[j]);
            counter++;
        }

        int princessNumber = 1;
        int prisonNumber = 1;

        while (biscuit != 0) {
            while (prisonNumber <= prisons.length) {
                if (princessMap.get(princessNumber) == prisonMap.get(prisonNumber)) {
                    prisonMap.put(prisonNumber, 0);
                    princessMap.put(princessNumber, prisonNumber);
                    princessNumber++;
                    prisonNumber = 1;
                    if (princessNumber > princesses.length) {
                        biscuit = 0;
                        flag = false;
                        break;
                    }
                } else if (princessMap.get(princessNumber) < prisonMap.get(prisonNumber)) {
                    prisonMap.put(prisonNumber, 0);
                    princessMap.put(princessNumber, prisonNumber);
                    princessNumber++;
                    prisonNumber = 1;
                    if (princessNumber > princesses.length) {
                        biscuit = 0;
                        flag = false;
                        break;
                    }
                } else {
                    prisonNumber++;
                }

            }
            if (flag.equals(true)) {
                princessMap.put(princessNumber, -1);
                princessNumber++;
                prisonNumber = 1;
                if (princessNumber > princesses.length) {
                    biscuit = 0;
                    flag = false;
                    break;
                }
            }
        }
        Set set1 = princessMap.entrySet();
        Iterator iterator1 = set1.iterator();
        int k = 0;
        while (iterator1.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator1.next();
            System.out.println("Key is " + mentry.getKey() + " Value is " + mentry.getValue());
            princesses[k] = (int) mentry.getValue();
            k++;
        }
        return princesses;

    }


    public static void main(String[] args){
        int prisons [] = {1, 3, 2, 2};
        int princesses [] = {1, 1, 3, 2, 1};
        int entrance = 2;
        int result[] = new int[20];
        WidgetApp object = new WidgetApp();
        result = object.prisonForPrincesses(prisons, princesses, entrance);
        System.out.print( "Princess mapping  " );
        for ( int p =0;p < princesses.length;p++){
            System.out.print(  result[p] );
            System.out.print(" ");
        }
    }
}
