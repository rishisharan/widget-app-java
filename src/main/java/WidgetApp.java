import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
public class WidgetApp {

    public int[] prisonForPrincesses(int[] prisons, int[] princesses, int entrance)
    {
        int i = 0, j = 0;
        Boolean flag = true;
        int prisonsThatAccomodate[] = new int[prisons.length];
        HashMap<Integer,Integer> prisonMap = new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> princessMap = new HashMap<Integer, Integer>();
        int counter = 1, biscuit = 1;
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
        int tempPrisonNumber= 1;
        int[] keys = new int[10];
        int h=0;
        int prisonlimit = prisons.length;
        int key  =1;
        Map<String, Integer> keyAndCount = new HashMap<>();
          while( biscuit != 0 ) {
              while( prisonNumber <= prisons.length ) {
                  if (princessMap.get(princessNumber) == prisonMap.get(prisonNumber))
                  {
                      while ( key <= prisonlimit ) {
                          if (prisonMap.get(prisonNumber) == prisonMap.get(tempPrisonNumber)) {
                              for (int keyValues : prisonMap.keySet()) {

                                      keys[h] = tempPrisonNumber;

                                      h++;
                                      key++;
                                  }

                              }
                              System.out.println("Keys are " + keys[0] + "  " + keys[1]);
                          }
                          tempPrisonNumber++;


//                      while ( h < prisonMap.size()){
//                          if(prisonMap.get(prisonNumber) == prisonMap.get(tempPrisonNumber)){
//                              keys[h] = tempPrisonNumber;
//                              tempPrisonNumber++;
//                              prisonNumber++;
//                              h++;
//                          }
//                          System.out.print("Keys are "+ keys[0] + "  " +keys[1] );
//                      }


//
//                      checkIfAnyOtherPlaceExists(prisons[], prisonMap.get( prisonNumber ));
//                      for ( int s =0 ; s < prisons.length ; s++){
//                          if( prisons[i] == prisonCapacity){
//                              prisonsThatAccomodate[s] =
//                          }
//                      }
//










                      prisonMap.put(prisonNumber, 0);
                      princessMap.put(princessNumber, prisonNumber);
                      princessNumber++;
                      prisonNumber = 1;
                      if ( princessNumber > princesses.length){
                          biscuit = 0;
                          flag = false;
                          break;
                      }
                  }
                  else if( princessMap.get( princessNumber ) < prisonMap.get(prisonNumber) ){
                      prisonMap.put( prisonNumber, 0 );
                      princessMap.put(princessNumber, prisonNumber);
                      princessNumber++;
                      prisonNumber = 1;
                      if ( princessNumber > princesses.length){
                          biscuit = 0;
                          flag = false;
                          break;
                      }
                  }
                  else{
                      prisonNumber++;
                  }

              }
              if( flag.equals(true)) {
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
//        while (iterator1.hasNext()){
//            Map.Entry mentry = (Map.Entry)iterator1.next();
//            System.out.println( "Key is " +mentry.getKey() + " Value is " +mentry.getValue() );
//            princesses[k] = (int) mentry.getValue();
//            k++;
//        }
        return princesses;

    }

//    public boolean checkIfAnyOtherPlaceExists(int[] prisons, int prisonCapacity){
//
//        int prisonsThatAccomodate[] = new int[prisons.length];
//        for ( int i =0 ; i < prisons.length ; i++){
//            if( prisons[i] == prisonCapacity){
//               prisonsThatAccomodate[i] =
//            }
//        }
//        return true;
//    }


    public static void main(String[] args){
        int prisons [] = {1,2,3,3,2,1};
        int princesses [] = {1,1,1,1,1,1};
        int entrance = 2;
        int result[] = new int[princesses.length];
        WidgetApp object = new WidgetApp();
        result = object.prisonForPrincesses(prisons, princesses, entrance);
        System.out.print( "Princess mapping  " );
        for ( int p =0;p < princesses.length;p++){
            System.out.print(  result[p] );
            System.out.print(" ");
        }
    }
}
