package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionParser {
    List<FruitTransaction> parseTransaction(String input);
}
