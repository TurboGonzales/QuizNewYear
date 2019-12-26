package by.bsuir.QuizNewYear.view_models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.bsuir.QuizNewYear.dto.CurrentQuestion;
import by.bsuir.QuizNewYear.dto.Question;

public class TestViewModel extends ViewModel {

    private MutableLiveData<CurrentQuestion> currentQuestion = new MutableLiveData<>();
    private List<Integer> userAnswersIndexesList = new ArrayList<>();

    public MutableLiveData<CurrentQuestion> getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question question, int index) {
        this.currentQuestion.setValue(
                new CurrentQuestion(question, index)
        );
    }

    public List<Integer> getUserAnswersIndexesList() {
        return userAnswersIndexesList;
    }

    public void setUserAnswerIndexForQuestion(Integer answerIndex) {
        int questionIndex = this.currentQuestion.getValue().getCurrentQuestionIndex();
        userAnswersIndexesList.set(questionIndex, answerIndex);
    }

    public void clearUserAnswersIndexesList(Integer listSize) {
        userAnswersIndexesList = new ArrayList<>(Collections.nCopies(listSize, -1));
    }

}
