package com.custom_annotations_demo.service;

import com.custom_annotations_demo.annotation.LogExecutionTime;
import com.custom_annotations_demo.annotation.RetryOperation;
import com.custom_annotations_demo.annotation.UpperCase;
import com.custom_annotations_demo.annotation.ValidateNotNull;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @LogExecutionTime // Применяем аннотацию для логирования времени выполнения метода
    public void performOperation() {
        System.out.println("Выполнение операции...");
    }

    public void printName(@UpperCase String name) {
        System.out.println("Имя и фамилия: " + name); // Применяем аннотацию UpperCase для параметра
    }

    public void createUser(@ValidateNotNull String username) {
        System.out.println("Пользователь создан: " + username); // Применяем аннотацию ValidateNotNull
    }

    @RetryOperation(attempts = 5) // Применяем аннотацию RetryOperation для повторных попыток
    public void riskyMethod() {
        if (Math.random() > 0.7) {
            System.out.println("Успешное выполнение!");
        } else {
            throw new RuntimeException("Ошибка выполнения"); // Имитируем ошибку
        }
    }
}
