package message.queues;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import java.util.List;

public class Receive implements RequestHandler<SQSEvent, Void> {
    private static final String QUEUE_NAME = "QueueA";

    public static void main(String[] args) {
//        final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
//        String queueUrl = sqs.getQueueUrl(QUEUE_NAME).getQueueUrl();

//        // receive messages from the queue
//        List<Message> messages = sqs.receiveMessage(queueUrl).getMessages();
//
//        System.out.println(messages.get(0).getBody());
//
//        // delete messages from the queue
//        for (Message m : messages) {
//            sqs.deleteMessage(queueUrl, m.getReceiptHandle());
//        }
    }

    @Override
    public Void handleRequest(SQSEvent event, Context context)
    {
        for(SQSEvent.SQSMessage msg : event.getRecords()){
            System.out.println(new String(msg.getBody()));
        }
        return null;
    }
}
