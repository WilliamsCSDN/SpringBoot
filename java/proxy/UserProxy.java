package proxy;

public class UserProxy implements IUserService{

    private IUserService userService;

    public UserProxy(IUserService userService){
        this.userService = userService;

    }
    @Override
    public void request() {
        long currentTime = System.currentTimeMillis();
        userService.request();
        System.out.println("request cost:" + (System.currentTimeMillis() - currentTime));

    }

    public static void main(String[] args) {
        IUserService userService = new UserServiceImpl();
        UserProxy userProxy = new UserProxy(userService);
        userProxy.request();
    }
}
