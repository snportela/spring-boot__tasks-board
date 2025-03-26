package com.example.taskBoard.exceptions;

public class NotFoundException extends BusinessException {
  public NotFoundException() { super("Resource not found."); }
}
