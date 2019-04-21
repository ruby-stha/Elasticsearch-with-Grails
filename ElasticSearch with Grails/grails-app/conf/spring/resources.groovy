// Place your Spring DSL code here
import ElasticsearchConfigManager
import elasticsearchwithgrails.AccountsService

beans = {
    elasticsearchConfigManager(ElasticsearchConfigManager){}
    accounts(AccountsService){}
}
