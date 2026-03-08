import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        boolean running = true;

        System.out.println("Bem-vindo ao Gerenciador de Tarefas!");

        while (running) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Concluir Tarefa");
            System.out.println("4. Remover Tarefa");
            System.out.println("5. Sair");
            System.out.print("Opção: ");

            int option = -1;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Título da Tarefa: ");
                    String title = scanner.nextLine();
                    System.out.print("Descrição da Tarefa: ");
                    String description = scanner.nextLine();
                    manager.addTask(title, description);
                    break;
                case 2:
                    manager.listTasks();
                    break;
                case 3:
                    System.out.print("ID da Tarefa a concluir: ");
                    try {
                        int idToComplete = Integer.parseInt(scanner.nextLine());
                        manager.markTaskAsCompleted(idToComplete);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido.");
                    }
                    break;
                case 4:
                    System.out.print("ID da Tarefa a remover: ");
                    try {
                        int idToRemove = Integer.parseInt(scanner.nextLine());
                        manager.removeTask(idToRemove);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido.");
                    }
                    break;
                case 5:
                    running = false;
                    System.out.println("Saindo do Gerenciador de Tarefas. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
