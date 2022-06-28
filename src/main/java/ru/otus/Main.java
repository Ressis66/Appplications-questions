package ru.otus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import ru.otus.domain.Question;
import ru.otus.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.PropertySource;
import ru.otus.service.QuestionService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;


@ComponentScan
public class Main {



  public static void main(String[] args) throws IOException {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(Main.class);
    QuestionService service = context.getBean(QuestionService.class);
    service.initTestingService();
  }
}
