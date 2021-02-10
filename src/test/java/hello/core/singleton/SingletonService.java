package hello.core.singleton;

public class SingletonService {


    // 1. static 영역에 객체를 1개만 만든다.
    private static final SingletonService instance =  new SingletonService();

    public static SingletonService getInstance(){
        return  instance;
    }

    private SingletonService(){

    }

    public void login(){
        System.out.println("싱글턴 객체 생성");
    }
}
