import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
public class WidgetApp {
    static int princessNumber = 1;
    static int prisonNumber = 1;
    HashMap<Integer,Integer> prisonMap = new HashMap<Integer, Integer>();
    HashMap<Integer,Integer> princessMap = new HashMap<Integer, Integer>();
    public int[] prisonForPrincesses(int[] prisons, int[] princesses, int entrance)
    {
        int i = 0, j = 0;
        Boolean flag=true;

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



          while( biscuit != 0 ) {
              while( prisonNumber <= prisons.length) {
                  if (princessMap.get( princessNumber ) == prisonMap.get( prisonNumber ) ) {
                      prisonMap.put(1, 0);
                      princessMap.put(princessNumber, 1);
                      princessNumber++;
                      prisonNumber = 1;
                      if ( princessNumber > princesses.length){
                          biscuit = 0;
                          flag = false;
                          break;
                      }
                  }else if( princessNumber < princesses.length ){  // check if there is any other prison with capacity that can fit this princess
                        int count = prisonNumber + 1;
                        princessNumber = putPrinceInsidePrison( count , princessNumber );
//                      while (  count <= prisonMap.size() )
//                      {
//                          if( princessMap.get( princessNumber ) == prisonMap.get( count ) ){
//                              princessMap.put(princessNumber, count);
//                              prisonMap.put(count,0);
//                              princessNumber++;
//                              break;
//                          }
//                          count++;
//                      }
                  }

                  else if ( princessMap.get( princessNumber ) == entrance && prisonMap.get( prisonNumber ) == entrance ){     //check for prison i.e close to entrance
                      princessMap.put(princessNumber, prisonNumber);
                      prisonMap.put( prisonNumber,0);
                      princessNumber++;
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
        while (iterator1.hasNext()){
            Map.Entry mentry = (Map.Entry)iterator1.next();
            System.out.println( "Key is " +mentry.getKey() + " Value is " +mentry.getValue() );
            princesses[k] = (int) mentry.getValue();
            k++;
        }
        return princesses;

    }


    public static void main(String[] args){
        int prisons [] = {1,2,3,3,2,1};
        int princesses [] = {1,1,1,1,1,1};
        int entrance = 3;
        int result[] = new int[princesses.length];
        WidgetApp object = new WidgetApp();
        result = object.prisonForPrincesses(prisons, princesses, entrance);
        System.out.print( "Princess mapping  " );
        for ( int p =0;p < princesses.length;p++){
            System.out.print(  result[p] );
            System.out.print(" ");
        }
    }

    public int putPrinceInsidePrison( int count, int princessNumber ){  //check if there is any other prison with capacity that can fit this princess
        while (  count <= prisonMap.size() )
        {
            if( princessMap.get( princessNumber ) == prisonMap.get( count ) ){
                princessMap.put(princessNumber, count);
                prisonMap.put(count,0);
                princessNumber++;
                break;
            }
            count++;
        }
        return princessNumber;
    }
}
