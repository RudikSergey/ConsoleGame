package ru.console;

import java.util.Scanner;

public class GameTree {
    private final Node root;
    private final Scanner scanner;
    private Node currentNode;

    public GameTree() {//создание родительского нода
        this.scanner = new Scanner(System.in);
        this.root = new Node("Это животное живет на суше", null);
        Node cat = new Node("Кот", root);
        Node whale = new Node("Кит", root);
        this.root.setNode(cat, whale);
        this.currentNode = root;
    }

    public void start(GameTree gameTree) {
        System.out.println("Загадай животное, а я попробую угадать.");
        while (true) {
            boolean response = askQuestion(currentNode);
            if (response && !currentNode.isFlag()) {
                currentNode = currentNode.getLeftNode();
            } else if (response && currentNode.isFlag()) {
                System.out.println("Сыграем еще раз? (Да/Нет)");
                String checkCondition = getInputWithValidation("да", "нет");
                if (checkCondition.equalsIgnoreCase("да")) {
                    currentNode = root;
                } else if (checkCondition.equalsIgnoreCase("нет")) {
                    break;
                }
            } else if (!response && !currentNode.isFlag()) {
                currentNode = currentNode.getRightNode();
            } else if (!response && currentNode.isFlag()) {
                System.out.println("Какое животное ты загадал:");
                String animal = scanner.nextLine();
                System.out.println("Чем " + animal + " отличается от " + currentNode.getData()+":");
                String question = scanner.nextLine();
                gameTree.insertAnimal(question, animal);

                System.out.println("Сыграем еще раз? (Да/Нет)");
                String playAgainResponse = getInputWithValidation("Да", "Нет");
                if (playAgainResponse.equalsIgnoreCase("да")) {
                    currentNode = root;
                } else if (playAgainResponse.equalsIgnoreCase("нет")) {
                    break;
                }
            }
        }
        System.exit(0);
    }

    private void insertAnimal(String question, String response) {
        String temp = currentNode.getData();
        currentNode.setData(question);
        Node left = new Node(response, currentNode);
        Node right = new Node(temp, currentNode);
        currentNode.setNode(left, right);
    }

    private boolean askQuestion(Node currentNode) {
        if (currentNode.isFlag()) {
            System.out.println("Вы загадали " + currentNode.getData() + "? (Да/Нет)");
        } else {
            System.out.println(currentNode.getData()+"? (Да/Нет)");
        }
        String response = getInputWithValidation("да", "нет");
        return response.equalsIgnoreCase("да");
    }

    private String getInputWithValidation(String option1, String option2) {
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase(option1) || input.equalsIgnoreCase(option2)) {
                break;
            } else {
                System.out.println("Ответ должен быть \"" + option1 + "\" или \"" + option2 + "\".");
            }
        }
        return input;
    }
}
