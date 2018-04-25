
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 
 * 趨勢
 * @author linbrian
 *
 */
public class clock {
	public static int solution(String S, String T) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date s = sdf.parse(S);
		Date t = sdf.parse(T);
		long dif = t.getTime()-s.getTime();
		long diffSeconds = dif/1000%60;
		int resultCount=0;
		List<Character> li = new ArrayList<Character>();
		String[] result = new String[Integer.valueOf((int)diffSeconds)+1];
		result[0]=S;
		for(int i=1 ; i< result.length ; i++){
				Date d1 = sdf.parse(result[0]);
				Date d = new Date(d1.getTime()+((i)*1000));
				result[i]=sdf.format(d);
		}
		for(int i=0 ; i < result.length ; i++){
			String[] str = result[i].split(":");
			for(int j = 0 ; j < str.length ; j++){
				char[] c = str[j].toCharArray();
				int k=0;
				while(k<2){
					if(li.contains(c[k])){
						k++;
						continue;
					}else{
						li.add(c[k]);
					}
					k++;
				}
			}
			if(li.size()<=2){
				resultCount++;
			}
			li.clear();
		}
		return resultCount;
        // write your code in Java SE 8
    }
	public static void main(String[] args){
		try {
			int a=solution("15:15:00","15:15:12");
			System.out.println(a);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
