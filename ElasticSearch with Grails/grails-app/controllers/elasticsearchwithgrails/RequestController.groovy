package elasticsearchwithgrails

import grails.converters.JSON
import grails.util.Holders

class RequestController {
    def appContext=Holders.getGrailsApplication().getMainContext()

    def index() {
        println "hii****i=========="
        def returnMsg = appContext.getBean(params.service.toString()).index(params)
        render(returnMsg as JSON)
        return true
    }
}
