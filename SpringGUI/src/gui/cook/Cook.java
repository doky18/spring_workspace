package gui.cook;

public class Cook {
	//요리사 객체는 팬 객체에 의존하고 있다
	//Fripan pan;		//요리사가 팬을 가진다
	
	Pan pan;		//1. DI를 구현하기 위해서는 객체가 보유할 자료형은 하위보다는 상위 객체일수록 유연해진다
	
	public Cook() {
		//pan = new Fripan();   //2. 직접 new 연산자로 객체를 생성하지 말라  
									  //new 했기 때문에 Fripan 클래스를 지우면 Pan을 만들었어도 요리사는 영향을 받음
									//but 이렇게 해도 Pan으로 부터 벗어 날 수 없음. 의존성을 약화 시켰을 뿐, 탈피는 ㄴㄴ
	}
	
	public void Cook() {
		pan.heat();
	}
}
