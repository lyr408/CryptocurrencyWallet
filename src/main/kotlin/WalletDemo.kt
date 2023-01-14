import org.web3j.crypto.*
import java.io.File

const val walletPath = "./wallet"
const val password = "lyr"

fun main() {
    val wallet = createWallet()
    //create a public and private key, and address
    val credentials = WalletUtils.loadBip39Credentials(password, wallet.mnemonic)

    System.err.println(credentials.address)
    System.err.println(credentials.ecKeyPair?.publicKey.toString() +" "+wallet.mnemonic)

}

fun createWallet(): Bip39Wallet = WalletUtils.generateBip39Wallet(password, File(walletPath))
