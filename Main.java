import config.Database;
import repositories.TodoListRepositoryDbImpl;
import repositories.TodoListRepositoryImpl;
import services.TodoListServiceImpl;
import views.TodoListTerminalView;
import views.TodoListView;



public class Main {
    public static void main(String[] args) {
        Database database = new Database("my_database", "root","", "localhost","3306");
        database.setup();

        TodoListRepositoryDbImpl todoListRepository = new TodoListRepositoryDbImpl(database);
        TodoListServiceImpl todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListTerminalView(todoListService);
        todoListView.run();
    }
}