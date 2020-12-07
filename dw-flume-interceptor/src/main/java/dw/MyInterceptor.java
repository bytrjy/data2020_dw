package dw;


import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;
import java.util.List;
import java.util.Map;


public class MyInterceptor implements Interceptor {
    @Override
    public void initialize() {

    }

    @Override
    public Event intercept(Event event) {

        String s = new String(event.getBody());
        Map<String, String> headers = event.getHeaders();
        if (s.contains("startup")){
          headers.put("logType","startup");
       }else {
           headers.put("logType","event");
       }
        event.setHeaders(headers);
        event.setBody(s.getBytes());
        return event;
    }

    @Override
    public List<Event> intercept(List<Event> list) {
        for (Event event : list) {
            intercept(event);
        }
        return list;
    }

    @Override
    public void close() {

    }
    public static class Builder implements Interceptor.Builder{

        @Override
        public Interceptor build() {
            return new MyInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }
}
