package elasticsearchwithgrails

class BootStrap {
    def elasticsearchConfigManager
    def init = { servletContext ->
        elasticsearchConfigManager.getElasticsearchClient()
    }
    def destroy = {
    }
}
