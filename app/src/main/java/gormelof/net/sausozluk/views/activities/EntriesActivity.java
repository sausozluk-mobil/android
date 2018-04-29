package gormelof.net.sausozluk.views.activities;

import android.os.Bundle;
import android.widget.TextView;

import gormelof.net.sausozluk.R;
import gormelof.net.sausozluk.api.ApiService;
import gormelof.net.sausozluk.api.ServiceGenerator;
import gormelof.net.sausozluk.entities.response.api.ApiResponse;
import gormelof.net.sausozluk.entities.response.entries.TopicEntriesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntriesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entries);

        final TextView tvTopicTitle = findViewById(R.id.tv_activity_entries_topic_title);

        Bundle bundle = getIntent().getExtras();
        int topicId = bundle.getInt("TOPIC_ID");

        ApiService apiService = ServiceGenerator.createService(ApiService.class);
        Call<ApiResponse<TopicEntriesResponse>> entriesCall = apiService.getTopicEntries(topicId,1);
        entriesCall.enqueue(new Callback<ApiResponse<TopicEntriesResponse>>() {
            @Override
            public void onResponse(Call<ApiResponse<TopicEntriesResponse>> call, Response<ApiResponse<TopicEntriesResponse>> response) {

                if (response.isSuccessful()) {

                    tvTopicTitle.setText(response.body().getData().getTitle());

                } else {

                }

            }

            @Override
            public void onFailure(Call<ApiResponse<TopicEntriesResponse>> call, Throwable t) {

            }
        });

    }
}
