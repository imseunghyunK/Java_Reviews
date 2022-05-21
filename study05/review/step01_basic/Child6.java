package step01_basic;

public class Child6 {

	static Object[] getDatas() {

		Object[] o = {"String", new Child5()};
		return o;
	}
	
	static void printDatas(Object[] v) {
		System.out.println(v[0] + " " + ((String)v[0]).charAt(2));
		
	}
	static Object[] changeDatas(Object[] v) {
		v[0] = "Encore" + v[0]; 
		return v;
	}
	
	static void changeData2(Child5 v) {
		v.no2 = 1000;
	}
	
	public static void main(String[] args) {
		printDatas( changeDatas( getDatas() ));
		
		Object[] o = getDatas();
		Child5 c = (Child5)o[1];
		System.out.println(c.no + " " + c.no2); 
	

		changeData2(c);
		System.out.println(c.no + " " + c.no2); 
		System.out.println(( (Child5)o[1] ).no2); 
	}

}
