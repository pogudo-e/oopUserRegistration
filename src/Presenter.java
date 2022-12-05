public class Presenter {
    private View view;
    private Model model;

    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
    }
    public void onClick(){
        Boolean b = true;
        int i = 0;
        while (b) {
            if (i < 1){
                System.out.println("Список команд:\n1: Добавить пользователя\n2: Показать зарегистированных пользователей\n0: Выход");
                i++;
            } else {
                System.out.println("\n____________\n1: Добавить пользователя\n2: Показать зарегистированных пользователей\n0: Выход");
            }
            model.setText(view.getText());
            b = model.execute();
        }


    }
}
