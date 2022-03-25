package taskCsv;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class TaskCsv {

	public static void main(String[] args) {
		Map<String, String> mapString = new HashMap<String, String>();
		mapString.put("mass", "uid,sname,mass,single,room,dep\n3,Jon,89,T,12,13\n14,Alex,101,F,18,4");
		mapString.put("pop", "pop,land\n1412,CN\n1387,IN\n333,USA\n271,INA");
		mapString.put("temp", "city,temp2,temp\nMinsk,6,-9\nBrest,4,-7\nGomel,-3,-1");
		for(Map.Entry<String, String> entry : mapString.entrySet()) {
			String C = entry.getKey();
			String S = entry.getValue();
			int result = solution(S, C);
			System.out.println("result=" + result);
		}
		
	}
	/*
	 * метод поиска максимального числа в заданной колонке (имя колонки - строка)
	 */
	public static int solution(String S, String C) {
		int result = 0;
		if(S.isEmpty() || C.isEmpty()) {
			return result;
		}
		//найдем номер колонки с данными для поиска максимального
		String sSplitFirstRow = S.split("\n")[0];
		String [] sSplitToArr = sSplitFirstRow.split(",");
		
		int numbColumn = 0;
		for(String elementArr : sSplitToArr) {
			if(elementArr.equals(C)) {
				result = findMaxValue(S, numbColumn);
				break;
			}
			numbColumn++;
		}
		return result;
	}
	/*
	 * метод поиска  максимального числа в заданной колонке (по номеру колонки)
	 */
	public static int findMaxValue(String S, int numbColumn) {
		int result = 0;
		if(S.isEmpty()) {
			return result;
		}
		//закинем все записи таблицы в массив
		String [] sSplitToArr = S.split("\n");
		//в каждом элементе массива, в строке, будем выбирать элемент по номеру numbColumn
		TreeSet<Integer> valuesColumn = new TreeSet<Integer>();
		for(String elementArr : sSplitToArr) {
			String valueInColumn = elementArr.split(",")[numbColumn].trim();
			try {
			   //преобразуем String в int и будем закидывать в treeset
			   valuesColumn.add(Integer.parseInt(valueInColumn));
			}
			catch (NumberFormatException e) {
			   //continue;
			}
		}
		//возьмем последний элемент treeset
		if(!valuesColumn.isEmpty()) {
			result = valuesColumn.last();
		}
		return result;
	}
}
