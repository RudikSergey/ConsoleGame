package ru.console;

public class Node {
    private String data; //храним вопрос, либо ответ
    private Node parent; //родитель
    private Node leftNode;//да
    private Node rightNode;//нет
    private boolean flag; //проверяем содержит узел дочерние узлы или нет

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Node(String data, Node parent) {
        this.data = data;
        this.parent = parent;
        this.flag = true;
    }

    public void setNode(Node leftNode, Node rightNode) {
        this.setLeftNode(leftNode);
        this.setRightNode(rightNode);
        this.flag = false;
    }
}
