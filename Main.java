import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("1 - демонстрационное дерево");
        System.out.println("2 - ввести дерево вручную");
        System.out.print("Выбор: ");
        int choice = in.nextInt();

        NTree tree = (choice == 2) ? readTree(in) : buildDemoTree();

        System.out.println("\nДерево:");
        tree.print();

        BranchFinder finder = new BranchFinder();
        finder.find(tree.getRoot());
        printResult(finder);
    }

    private static NTree readTree(Scanner in) {
        System.out.print("Значение корня: ");
        NTree tree = new NTree(in.nextInt());

        System.out.print("Количество рёбер: ");
        int edges = in.nextInt();

        System.out.println("Введите рёбра (родитель потомок):");
        for (int i = 0; i < edges; i++) {
            int parent = in.nextInt();
            int child = in.nextInt();
            if (!tree.addChild(parent, child)) {
                System.out.println("Ошибка: родителя нет или потомок уже существует. Ребро пропущено.");
            }
        }
        return tree;
    }

    private static NTree buildDemoTree() {
        NTree tree = new NTree(1);
        int[][] edges = {
                {1, 2}, {1, 3}, {1, 4},
                {2, 5}, {2, 6},
                {3, 7},
                {4, 8}, {4, 11},
                {6, 9}, {6, 10}
        };
        for (int[] e : edges) {
            tree.addChild(e[0], e[1]);
        }
        return tree;
    }

    private static void printResult(BranchFinder finder) {
        MyList<MyList<Integer>> branches = finder.getBestBranches();
        System.out.println("\nМаксимальное число ветвлений: " + finder.getMaxBranchings());
        System.out.println("Ветви с максимальным числом ветвлений (" + branches.size() + "):");
        for (int i = 0; i < branches.size(); i++) {
            MyList<Integer> branch = branches.get(i);
            StringBuilder line = new StringBuilder("  ");
            for (int j = 0; j < branch.size(); j++) {
                if (j > 0) {
                    line.append(" -> ");
                }
                line.append(branch.get(j));
            }
            System.out.println(line);
        }
    }
}
