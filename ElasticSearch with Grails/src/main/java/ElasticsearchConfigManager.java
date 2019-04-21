import grails.util.Holders;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.ClusterAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.health.ClusterHealthStatus;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

import static org.grails.taglib.encoder.OutputEncodingStack.log;

/**
 * Created by rubyshrestha on 4/20/19.
 */
public class ElasticsearchConfigManager {
    public static TransportClient elasticsearchClient;

    public static void getElasticsearchClient(){
        String esHost=Holders.getGrailsApplication().getConfig().get("elasticsearch.host").toString();
        System.out.println("esHost = " + esHost);
        try{
            Settings settings = Settings.builder()
                    .put("client.transport.sniff", true).build();
            elasticsearchClient = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName(esHost), 9300));
        }catch (Exception e){
            e.printStackTrace();
            log.error("Elasticsearch client cannot be created");
        }
    }

    public static String getSearchIndexHealth(String index){
        try{
            ClusterAdminClient clusterAdminClient = elasticsearchClient.admin().cluster();
            ClusterHealthResponse healths = clusterAdminClient.prepareHealth(index).get();
            ClusterHealthStatus indexHealth= healths.getStatus();
            System.out.println(indexHealth);
            System.out.println(indexHealth.toString().equalsIgnoreCase("red"));
            return indexHealth.toString();
        }catch(Exception e){
            log.error("Exception Occurred while getting search index ("+index+") health");
            e.printStackTrace();
            return "red";
        }

    }
}
