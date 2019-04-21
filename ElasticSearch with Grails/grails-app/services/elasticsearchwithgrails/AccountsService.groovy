package elasticsearchwithgrails

import grails.gorm.transactions.Transactional
import grails.util.Holders
import org.elasticsearch.action.get.GetResponse

@Transactional
class AccountsService {
//    def elasticsearchConfigManager= Holders.getGrailsApplication().getMainContext().getBean("elasticsearchConfigManager")
    def elasticsearchConfigManager

    def index(params){
        def action=params.get("task")
        return this."${action}"(params)
    }

    def getAccountById(params){
        def indexName=params.get("service")
        def docId=params.get("accountId")
        try{
            GetResponse hit=elasticsearchConfigManager.elasticsearchClient.prepareGet(indexName, "_doc", docId).get()
            println "hit = $hit"
            if (hit!=null){
                return ["accountInfo":hit.getSource()]
            }else{
                return ["error":"true", "message":"No document of id: ${docId} found."]
            }
        }catch (Exception e){
            log.error("Could not get document!")
            e.printStackTrace()
            return ["error":"true", "message":"Could not get document of id: ${docId}."]
        }
    }

    def getAccountSummary(params) {
        return "Account Summary Returned!"
    }
}
