package dd.reito.httpTest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// アノテーション
@SpringBootApplication
class HttpTestApplication

fun main(args: Array<String>) {
//	Routeみたいなものなのでいじらない。
	runApplication<HttpTestApplication>(*args)
}
