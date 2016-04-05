package controller;

import com.thoughtworks.xstream.XStream;
import customer.Application;
import org.junit.Assert;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public abstract class AbstractControllerIntegrationTest {

    public List<HttpMessageConverter< ?>> configureMessageConverters() {
        HttpMessageConverter<?> converter1 = new MappingJackson2HttpMessageConverter();
        HttpMessageConverter<?> converter2 = createXmlHttpMessageConverter();

        return Arrays.asList(converter1, converter2);
    }

    private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
        MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();

        XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
        xmlConverter.setMarshaller(xstreamMarshaller);
        xmlConverter.setUnmarshaller(xstreamMarshaller);

        xstreamMarshaller.setAutodetectAnnotations(true);

        return xmlConverter;
    }

    public PrepareHttpBodyRequestCallback prepareHttpRequest(Object object) {
        return new PrepareHttpBodyRequestCallback(object);
    }

    public AssertHttpStatusResponseConverter verifyResponse(HttpStatus httpStatus) {
        return new AssertHttpStatusResponseConverter(httpStatus);
    }

    /**
     * {@link RequestCallback} implementation.
     */
    private class PrepareHttpBodyRequestCallback implements RequestCallback {

        private final Object object;

        private PrepareHttpBodyRequestCallback(Object object) {
            this.object = object;
        }

        @Override
        public void doWithRequest(ClientHttpRequest clientHttpRequest) throws IOException {
            XStream xstream = new XStream();

            clientHttpRequest.getHeaders().put("Content-Type", Arrays.asList("application/xml"));

            byte[]bytes = xstream.toXML(object).getBytes();
            clientHttpRequest.getBody().write(bytes);
        }
    }

    /**
     * {@link ResponseExtractor} implementation.
     */
    private class AssertHttpStatusResponseConverter implements ResponseExtractor<Object> {

        private final HttpStatus httpStatus;

        private AssertHttpStatusResponseConverter(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
        }

        @Override
        public Object extractData(ClientHttpResponse clientHttpResponse) throws IOException {
            Assert.assertEquals(httpStatus, clientHttpResponse.getStatusCode());
            return null;
        }
    }


}
