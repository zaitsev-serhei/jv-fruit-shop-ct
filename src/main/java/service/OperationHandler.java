package service;

import model.FruitTransaction;

public interface OperationHandler {
    void executeOperation(FruitTransaction transaction);
}