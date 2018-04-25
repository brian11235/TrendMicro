import java.util.HashMap;
import java.util.Map;
/**
 * 
 * 
 * 趨勢
 * @author linbrian
 *
 */
public class dice {
	public static int solution(int[] A) {
		int resultCount=Integer.MAX_VALUE;
		int tempCount = 0;
		Map<Integer,Integer> diceMap=new HashMap<Integer,Integer>();
		diceMap.put(1, 6);
		diceMap.put(2, 5);
		diceMap.put(3, 4);
		diceMap.put(4, 3);
		diceMap.put(5, 2);
		diceMap.put(6, 1);
		for(int i = 1; i<=6 ; i++){
			for(int j=0 ; j < A.length ; j++){
				if(i==A[j]){
					continue;
				}else if(diceMap.get(i)==A[j]){
					tempCount=tempCount+2;
				}else{
					tempCount++;
				}
			}
			resultCount=Math.min(resultCount, tempCount);
			tempCount=0;
		}
		return resultCount; 
    }
	public static void main(String[] args){
		int[] A={1,1,2,6};
		solution(A);
	}
}
