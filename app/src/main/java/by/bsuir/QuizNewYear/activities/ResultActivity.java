package by.bsuir.QuizNewYear.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import by.bsuir.QuizNewYear.R;
import by.bsuir.QuizNewYear.dto.TestResult;

public class ResultActivity extends AppCompatActivity {

    private TextView tvResult;
    private TextView tvWrongCount;
    private TextView tvUnansweredCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResult = findViewById(R.id.tv_result);
        tvWrongCount = findViewById(R.id.tv_wrong_count);
        tvUnansweredCount = findViewById(R.id.tv_unanswered__count);

        checkTestAndShowResult();
    }

    private void checkTestAndShowResult() {
        TestResult testResult = (TestResult) getIntent()
                .getSerializableExtra("TEST_RESULT");
        int correctAnswersCount = 0;
        int wrongCount = 0;
        int unansweredCount = 0;
        int questionsCount = testResult.getQuestionList().size();

        for (int i = 0; i < questionsCount; i++) {
            int correctAnswerIndex = testResult.getQuestionList().get(i)
                    .getCorrectAnswerIndex();
            int userAnswerIndex = testResult.getUserAnswersIndexesList().get(i);
            if (userAnswerIndex == -1) {
                unansweredCount++;
            } else if (correctAnswerIndex != userAnswerIndex) {
                wrongCount++;
            } else {
                correctAnswersCount++;
            }
        }

        tvResult.setText("Правильно отвечено на "
                        + correctAnswersCount
                        + " из " + questionsCount + " вопросов");
        tvWrongCount.setText("Неправильных ответов: " + wrongCount);
        tvUnansweredCount.setText("Оставлено без ответа: " + unansweredCount);
    }

}
