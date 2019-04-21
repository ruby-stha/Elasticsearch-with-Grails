package elasticsearchwithgrails

import org.grails.web.json.JSONObject


class RequestInterceptor {
    def elasticsearchConfigManager

    RequestInterceptor() {
        matchAll()
    }

    boolean before() {
        def req=request.JSON
        log.info("Request JSON Body:::${req}")
        params.putAll(req)
        log.info("Parameters::::${params}")
        if (params.get("service")==null || !params.get("service") instanceof String){
            render(new JSONObject().put("error", "true").put("message", "Index name not available or invalid!"))
            return false
        }
        if (elasticsearchConfigManager.getSearchIndexHealth(params.get("service").toString()).equalsIgnoreCase("red")){
            render(new JSONObject().put("error", "true").put("message", "Index currently not active!"))
            return false
        }
        return true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
