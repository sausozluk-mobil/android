package gormelof.net.sausozluk.entities.response.random;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import gormelof.net.sausozluk.entities.Entry;
import gormelof.net.sausozluk.entities.Topic;

public class RandomResponse {

    @SerializedName("entry")
    @Expose
    private Entry entry;

    @SerializedName("topic")
    @Expose
    private Topic topic;

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}

