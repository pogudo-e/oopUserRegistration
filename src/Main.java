public class Main {
    public static void main(String[] args) {
        Users users = new Users();
        users.addUserM("Adam", "1234");
        users.addUserM("Eva", "4321");
        Presenter presenter = new Presenter(new MyView(), users);

        presenter.onClick();
    }
}