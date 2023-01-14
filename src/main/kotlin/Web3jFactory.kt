import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService

object Web3jFactory {

    fun buildWeb3j(url: String) = Web3j.build(HttpService(url))
}