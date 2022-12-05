import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Users implements Model, Iterable, Iterator<User> {

    private List<User> usersList;

    int i = 0;
    private String [] data;
    private String inputData;

    public Users() {
        this.usersList = new ArrayList<User>();
    }

    private void printUserList(){
        for(int i=0;i<usersList.size();i++){
            System.out.println(usersList.get(i).getLogin()+ ": " + usersList.get(i).getPassword());
        }
    }
    private Boolean addUser(){
        if (data[0] != "1"){
            if(data.length < 2){
                return false;
            }
        }
        this.usersList.add(new User( data[1],data[2]));
        return true;
    }
    public void addUserM(String name, String pass){
        this.usersList.add(new User( name,pass));
    }
    public User get(int i){
        return usersList.get(i);
    }

    private String[] getDataFromText(){
        data = inputData.split("\\s+");
        return data;
    }
    private Boolean Command(){
        Boolean runProgram = true;
            switch (data[0]) {
                case ("1"):
                    if (addUser() == true) {
                        System.out.println("Успешно добавлено");
                    }else {
                        System.out.println("Ошибка ввода! Формат ввода: 1 [name] [password]");
                    }
                    break;
                case ("2"):
                    System.out.println("Список всех пользователей: ");
                    printUserList();
                    break;
                case ("0"):
                    runProgram = false;
                    break;
            }
        return runProgram;
    }

    @Override
    public void setText(String s) {
        inputData = s;
    }

    @Override
    public Boolean execute() {
        getDataFromText();
        if (Command()){
            return true;
        }
        return false;
    }
    @Override
    public Iterator iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return i < usersList.size();
    }

    @Override
    public User next() {
        return usersList.get(i++);
    }
}
