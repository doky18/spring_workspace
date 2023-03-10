//어플리케이션에서 사용할 모든 객체들(bean)은 
//개발자가 JAVA 코드 내에서 직접 new 하지 않고
//외부 조력자인 bean container 가 bean을 생성하여 주입하는 방식으로 개발해야 유지보수성이 높아짐
//어플리케이션에서 사용될 모든 bean들의 명단을 작성해놓으면 Spring이 알아서 객체를 생성하고 주입을 해줌
//우리는 html과 xml 중 xml을 사용하기로 함
//html : 데이터가 어떻게 보여질지
//xml : 데이터를 어떻게 표현할지

package gui.spring.context;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import gui.school.Student;
import gui.view.JoinForm;

public class AppContext {

    public AppContext() {
    	//이 객체는, 지정된 xml을 읽어들여, 전체 어플리케이션에서 사용될
    	//빈들을 관리해주는 컨테이너 객체이다...
    	ClassPathXmlApplicationContext context=null;
    	context = new ClassPathXmlApplicationContext("gui/spring/context/config.xml");
    																		//new 하고 싶은 객체들이 올라와있음 
    	
    	//context가 컨테이너에 모아놓은 빈들 중 필요한게 있다면 개발자는 꺼내올 수 있다.
    	JoinForm joinForm=(JoinForm)context.getBean("joinForm");
    	//joinForm.create();
    	
    	
    	//학생 꺼내서 사용하기
    	Student student = (Student)context.getBean("student");
    	student.goSchool();
    	student.haveLunch();
    	student.endStudy();
    }

    public static void main(String[] args) {
        new AppContext();
    }
}

