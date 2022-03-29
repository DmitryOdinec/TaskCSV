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
		mapString.put("5555", "5555,land\n1412,CN\n1387,IN\n333,USA\n271,INA");
		for(Map.Entry<String, String> entry : mapString.entrySet()) {
			String C = entry.getKey();
			String S = entry.getValue();
			int result = solution(S, C);
			System.out.println("result=" + result);
		}
		
	}
	/**
	 * method for finding the maximum number in a given column (column name - string) 
	 * @param S - CSV
	 * @param C - column name
	 * @return result - maximum number
	 */
	public static int solution(String S, String C) {
		int result = 0;
		if(S.isEmpty() || C.isEmpty()) {
			return result;
		}
		//find number of column with data to search for the maximum 
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
	/**
	 * method for finding the maximum number in a given column (by column number) 
	 * @param S - CSV
	 * @param numbColumn - column number
	 * @return  - maximum number
	 */
	public static int findMaxValue(String S, int numbColumn) {
		int result = 0;
		if(S.isEmpty()) {
			return result;
		}
		//write all table records to an array 
		String [] sSplitToArr = S.split("\n");
		//in each element of the array, in a row, we will select an element by the number numbColumn 
		TreeSet<Integer> valuesColumn = new TreeSet<Integer>();
		for(int i = 1; i < sSplitToArr.length; i++) {
		//for(String elementArr : sSplitToArr) {
			String valueInColumn = sSplitToArr[i].split(",")[numbColumn].trim();
			//String valueInColumn = elementArr.split(",")[numbColumn].trim();
			try {
			   valuesColumn.add(Integer.parseInt(valueInColumn));
			}
			catch (NumberFormatException e) {
			   //continue;
			}
		}
		//take last element of treeset 
		if(!valuesColumn.isEmpty()) {
			result = valuesColumn.last();
		}
		return result;
	}
}
