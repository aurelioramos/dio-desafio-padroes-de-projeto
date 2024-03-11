import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class UserManager  {
  
  private static final List<User> users = new ArrayList<>();
  
  private UserManager(){
    super();
  }
  
    // TODO: Implementar o padrão Singleton para garantir que haja apenas uma instância do gerenciador de usuários
    public static void addUser(String name) {
        User user = new User(users.size() + 1, name);
        users.add(user);

    }

    public static void listUsers() {
        
        for(User user:users) {
            System.out.println(String.format("%d - %s",user.getId(),user.getName()));
        }
    }
  
}

class DesafioSingleton {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha após a leitura do número

        for (int i = 1; i <= quantity; i++) {
            String name = scanner.nextLine();
            UserManager.addUser(name);
        }

        UserManager.listUsers();
    }
}