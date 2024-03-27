package com.example.tracingclient.configuration.interceptor;

import java.io.IOException;
import java.nio.charset.Charset;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

@Slf4j
@Component
public class RequestLoggingInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request,
                                        byte[] body,
                                        ClientHttpRequestExecution execution
    ) throws IOException {
        logRequest(request, body);
        final ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logRequest(final HttpRequest request, byte[] body) {
        var requestMessage = new StringBuilder();

        requestMessage
            .append("REQUEST\n")
            .append("Method = [").append(request.getMethod()).append("]\n")
            .append("Path = [").append(request.getURI()).append("]\n")
            .append("Headers = [").append(request.getHeaders()).append("]\n");
        if (body != null) {
            requestMessage.append("body = [").append(new String(body)).append("]\n");
        }
        log.info(requestMessage.toString());
    }
    private void logResponse(final ClientHttpResponse response) throws IOException {
        final String responseBody = StreamUtils.copyToString(response.getBody(), Charset.defaultCharset());
        var responseMessage = new StringBuilder()
            .append("RESPONSE\n")
            .append("Status code = [").append(response.getStatusCode()).append("]\n")
            .append("Status text = [").append(response.getStatusText()).append("]\n")
            .append("Headers = [").append(response.getHeaders()).append("]\n")
            .append("Body = [").append(responseBody).append("]\n");
        log.info(responseMessage.toString());
    }
}
