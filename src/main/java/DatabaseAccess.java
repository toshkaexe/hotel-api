import java.util.concurrent.Semaphore;

public class DatabaseAccess {
    private Semaphore semaphore;
    private static DatabaseAccess instance;

    private DatabaseAccess(int maxConnections) {
        semaphore = new Semaphore(maxConnections, true); // Определяем семафор с максимальным количеством соединений
    }

    public static DatabaseAccess getInstance(int maxConnections) {
        if (instance == null) {
            instance = new DatabaseAccess(maxConnections);
        }
        return instance;
    }
    public void queryDatabase() {
        try {
            semaphore.acquire(); // Запрашиваем разрешение на доступ
            System.out.println("Поток " + Thread.currentThread().getName() + " получил доступ к базе данных");
            // Здесь выполняется код обращения к базе данных
            Thread.sleep(2000); // Имитация обращения к базе данных
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Поток " + Thread.currentThread().getName() + " завершил доступ к базе данных");
            semaphore.release(); // Освобождаем разрешение
        }
    }

    public static void main(String[] args) {
        final int MAX_CONNECTIONS = 3;
        DatabaseAccess database = DatabaseAccess.getInstance(MAX_CONNECTIONS);

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                database.queryDatabase();
            });
            thread.start();
        }
    }
}
