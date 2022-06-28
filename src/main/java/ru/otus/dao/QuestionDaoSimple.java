package ru.otus.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.otus.domain.Question;

import org.springframework.beans.factory.annotation.Value;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.List;
@Lazy
@PropertySource("classpath:application.properties")
@Component
public class QuestionDaoSimple implements QuestionDao {

  private List<Question> questions;

  public QuestionDaoSimple(@Value("${questions.file}") String path) throws FileNotFoundException {
    List<Question> questions = new CsvToBeanBuilder<Question>
        (new FileReader(path)).withType(Question.class)
        .build()
        .parse();
    this.questions= questions;
  }

  @Override
  public List<Question> getList() {
    return questions;
  }

  @Override
  public Question getQuestion(int id) {
    return questions.get(id);
  }

}
