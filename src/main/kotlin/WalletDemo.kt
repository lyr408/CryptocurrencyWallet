import org.web3j.crypto.Bip39Wallet
import org.web3j.crypto.Credentials
import org.web3j.crypto.WalletUtils
import org.web3j.protocol.Web3j
import org.web3j.tx.Transfer
import org.web3j.utils.Convert
import java.io.File
import java.math.BigDecimal


const val walletPath = "./wallet"
const val password = "lyr"

fun main() {
    //create wallet
    val wallet = createWallet()

    //create a public and private key, and address
    val credentials = WalletUtils.loadBip39Credentials(password, wallet.mnemonic)

    //transfer 1 eth
    transferMoney(credentials, Web3jFactory.buildWeb3j(NetworkType.ETH_MAIN), "hello.eth", 1.0)
}

fun createWallet(): Bip39Wallet = WalletUtils.generateBip39Wallet(password, File(walletPath))

fun transferMoney(credentials: Credentials, web3j: Web3j, addressOrEnsName: String, value: Double) {
    val transactionReceipt = Transfer.sendFunds(
        web3j, credentials, addressOrEnsName,
        BigDecimal.valueOf(value), Convert.Unit.ETHER
    ).send()

    println(transactionReceipt.isStatusOK)
}

