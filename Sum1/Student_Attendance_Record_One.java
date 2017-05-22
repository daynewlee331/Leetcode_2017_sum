package Sum1;

public class Student_Attendance_Record_One {
	public boolean checkRecord(String s) {
		int countA = 0;
		char[] chars = s.toCharArray();
		for(int i = 0; i < chars.length; i ++){
			if(chars[i] == 'A') countA ++;
			if(chars[i] == 'L'){
				if(i + 1 < chars.length && i + 2 < chars.length 
						&& chars[i + 1] == 'L' && chars[i + 2] == 'L') return false;
			}
			if(countA > 1) return false;
		}
		return true;
    }
}
