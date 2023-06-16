package ru.console;

public class MainClass {
    public static void main(String[] args) {
        GameTree startGame = new GameTree();
        startGame.start(startGame);
    }
}
