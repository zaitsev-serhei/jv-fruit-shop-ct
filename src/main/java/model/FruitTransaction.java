package model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(){

    }

    public FruitTransaction(String inputLine) {
        String[] inputData = inputLine.split(",");
        this.operation = Operation.valueOf(inputData[0]);
        this.fruit = inputData[1];
        this.quantity = Integer.getInteger(inputData[2]);
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }
    }

    public List<FruitTransaction> fruitTransactionList(List<String> inputStringData) {
        List<FruitTransaction> transactionList = new ArrayList<>();
        //a regex rule for input Strings from file with limit to 4(four) digits for number
        String regexRule = "^[b|p|r|s].+[apple|banana].\\d{0,4}";
        Pattern pattern = Pattern.compile(regexRule);
        for (String inputStr: inputStringData) {
            Matcher matcher = pattern.matcher(inputStr);
            if (matcher.matches()) {
                FruitTransaction fruitTransaction = new FruitTransaction(inputStr);
                transactionList.add(fruitTransaction);
            }
            System.out.println("Incorrect data input. Check the formatting");
        }
        return transactionList;
    }
}


