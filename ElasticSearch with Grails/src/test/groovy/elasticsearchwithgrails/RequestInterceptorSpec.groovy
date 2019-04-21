package elasticsearchwithgrails

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class RequestInterceptorSpec extends Specification implements InterceptorUnitTest<RequestInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test request interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"request")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
