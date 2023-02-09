package gui.school;

public class Student2 {
	
	Bell bell; 	//의존성 약화를 위해 상위 개체 이용
	
	//생성자 주입도 주입으로 인정된다   -> new 따윈 없다
	public Student2(Bell bell) {		//생성자
		this.bell=bell;	
	
	}
		public void goSchool() {
			//System.out.println("♪♩♬");
			bell.ring();
			System.out.println("등교");
		}
		public void startStudy() {
			//System.out.println("♪♩♬");
			bell.ring();
			System.out.println("수업 시작");
		}
		public void endStudy() {
			//System.out.println("♪♩♬");
			bell.ring();
			System.out.println("수업 종료");
		}
		public void haveLunch() {
			//System.out.println("♪♩♬");
			bell.ring();
			System.out.println("점심 식사");
		}
		public void startStudy2() {
			//System.out.println("♪♩♬");
			bell.ring();
			System.out.println("오후 수업");
		}
		public void goHome() {
			//System.out.println("♪♩♬");
			bell.ring();
			System.out.println("하교");
		}
}
